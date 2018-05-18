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
public class Déchets implements Comparable<Déchets>, Serializable {
    private String nom;
    protected int masseVolumique, recyclabe;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getRecyclabe() {
        return recyclabe;
    }

    public void setRecyclabe(int recyclabe) {
        this.recyclabe = recyclabe;
    }

    public int getMasseVolumique() {
        return masseVolumique;
    }

    public void setMasseVolumique(int masseVolumique) {
        this.masseVolumique = masseVolumique;
    }

    @Override
    public int compareTo(Déchets o) {
        return 0;
    }

}
