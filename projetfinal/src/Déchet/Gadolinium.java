package Déchet;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.Serializable;

/**
 * Created by trevi1732721 on 2018-04-26.
 */
public class Gadolinium extends Déchets implements Serializable {
    private String nom = "Gadolinium";
    public Gadolinium() {
        Chargement();
    }



    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public int getRecyclabe() {
        return recyclabe;
    }

    @Override
    public void setRecyclabe(int recyclabe) {
        this.recyclabe = recyclabe;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int getMasseVolumique() {
        return masseVolumique;
    }

    public void setMasseVolumique(int masseVolumique) {
        this.masseVolumique = masseVolumique;
    }
    public void Chargement(){
        try {
            File file = new File("Modificateur.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbf.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            Node root = doc.getDocumentElement(); // Référence à l'élément racine
            clean(root);

            masseVolumique = Integer.parseInt(root.getChildNodes().item(3).getChildNodes().item(0).getChildNodes().item(0).getFirstChild().getNodeValue());
            recyclabe = Integer.parseInt(root.getChildNodes().item(3).getChildNodes().item(0).getChildNodes().item(1).getFirstChild().getNodeValue());

        }catch(Exception one){
            System.out.print("Erreur de chargement");
        }
    }
    public static void clean(Node node)
    {
        NodeList childNodes = node.getChildNodes();

        for (int n = childNodes.getLength() - 1; n >= 0; n--)
        {
            Node child = childNodes.item(n);
            short nodeType = child.getNodeType();

            if (nodeType == Node.ELEMENT_NODE)
                clean(child);
            else if (nodeType == Node.TEXT_NODE)
            {
                String trimmedNodeVal = child.getNodeValue().trim();
                if (trimmedNodeVal.length() == 0)
                    node.removeChild(child);
                else
                    child.setNodeValue(trimmedNodeVal);
            }
            else if (nodeType == Node.COMMENT_NODE)
                node.removeChild(child);
        }
    }
}
