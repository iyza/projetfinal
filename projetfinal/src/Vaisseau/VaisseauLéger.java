package Vaisseau;

import Déchet.Déchets;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by trevi1732721 on 2018-04-26.
 */
public class VaisseauLéger extends Vaisseau implements Serializable {
    private ArrayList<Déchets> liste = new ArrayList<>();

    public ArrayList<Déchets> getListe() {
        return liste;
    }

    public void setListe(ArrayList<Déchets> liste) {
        this.liste = liste;
    }

    public int getCapacité() {
        return capacité;
    }

    public void setCapacité(int capacité) {
        this.capacité = capacité;
    }

    private int capacité = 10;
}
