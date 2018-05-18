package Planetes;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.Serializable;

public class PlaneteC extends Planetes implements Serializable {
    public PlaneteC(){
        this.plutonium = 60;
        this.thulium = 10;
        this.gadolinium = 20;
        this.terbium = 5;
        this.neptunium = 5;


    }
    public int getPlutonium(){return this.plutonium;}
    public int getThulium(){return this.thulium;}
    public int getGadolinium(){return this.gadolinium;}
    public int getTerbium(){return this.terbium;}
    public int getNeptunium(){return this.neptunium;}
    public void Chargement(){
        try {
            File file = new File("Modificateur.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbf.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            Node root = doc.getDocumentElement(); // Référence à l'élément racine
            clean(root);

            String noeud = root.getChildNodes().item(1).getChildNodes().item(0).getChildNodes().item(2).getFirstChild().getNodeValue();

            this.plutonium =Integer.parseInt(root.getChildNodes().item(1).getChildNodes().item(2).getChildNodes().item(2).getFirstChild().getNodeValue());
            this.thulium = Integer.parseInt(root.getChildNodes().item(1).getChildNodes().item(2).getChildNodes().item(4).getFirstChild().getNodeValue());
            this.gadolinium = Integer.parseInt(root.getChildNodes().item(1).getChildNodes().item(2).getChildNodes().item(0).getFirstChild().getNodeValue());
            this.terbium = Integer.parseInt(root.getChildNodes().item(1).getChildNodes().item(2).getChildNodes().item(3).getFirstChild().getNodeValue());
            this.neptunium = Integer.parseInt(root.getChildNodes().item(1).getChildNodes().item(2).getChildNodes().item(1).getFirstChild().getNodeValue());

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
