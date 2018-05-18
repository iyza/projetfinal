import Déchet.*;
import Vaisseau.*;
import Planetes.*;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by bajlu1731402 on 2018-04-30.
 */
public class Main implements Serializable {

    private static Planetes planete;
    private static ArrayList<CentreTri> centreTri = new ArrayList<>();
    private static ArrayList<Vaisseau> vaisseau = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Combien de vaisseau voulez vous dans votre simulation?");
        int v = sc.nextInt();
        System.out.println("Combien de centre de tris voulez vous dans votre simulation?");
        int c = sc.nextInt();
        for (int i=0;i<c;i++) {
            centreTri.add(new CentreTri());
        }
        for (int i=0;i<v;i++) {
            int random = (int)(Math.random()*3);
            switch (random) {
                case 0:
                    vaisseau.add(new VaisseauLéger());
                    break;
                case 1:
                    vaisseau.add(new VaisseauMoyen());
                    break;
                case 2:
                    vaisseau.add(new VaisseauLourd());
                    break;
            }
        }
        for (int i=0;i<vaisseau.size();i++) {
            envoyerVaisseau(vaisseau.get(i));
            stop();
            System.out.println("");
        }
    }

    public static void envoyerVaisseau(Vaisseau v) {
        int nbRandom = (int)(Math.random()*5);
        switch (nbRandom) {
            case 0 :
                planete = new PlaneteA();
                System.out.println("Le vaisseau se dirige vers la planete A");
                chargerVaisseau(planete, v);
                break;
            case 1:
                planete = new PlaneteB();
                System.out.println("Le vaisseau se dirige vers la planete B");
                chargerVaisseau(planete, v);
                break;
            case 2:
                planete = new PlaneteC();
                System.out.println("Le vaisseau se dirige vers la planete C");
                chargerVaisseau(planete, v);
                break;
            case 3:
                planete = new PlaneteD();
                System.out.println("Le vaisseau se dirige vers la planete D");
                chargerVaisseau(planete, v);
                break;
            case 4:
                planete = new PlaneteE();
                System.out.println("Le vaisseau se dirige vers la planete E");
                chargerVaisseau(planete, v);
                break;
        }
    }

    private static void chargerVaisseau(Planetes p, Vaisseau v) {
        // les int plutonium, thulium, etc. sont les pourcentages
        int plutonium = p.getPlutonium();
        int thulium = plutonium + p.getThulium();
        int gadolinium = thulium + p.getGadolinium();
        int terbium = gadolinium + p.getTerbium();

        ArrayList<Déchets> liste = new ArrayList<Déchets>();
        for (int i=0;i<v.getCapacité();i++) {
            int nbRandom = (int)(Math.random()*100); // pourcentage
            if (nbRandom < plutonium) { // example: nbRandom = 24, p = PlaneteA. 24 > 20 - ca marche pas
                liste.add(new Plutonium());
                System.out.println("Le vaisseau prend du plutonium");
                stop();
            }
            else if (nbRandom < thulium) { // example: nbRandom = 24, p = PlaneteA. 24 > 40 - le vaisseau prend du thulium
                liste.add(new Thulium());
                System.out.println("Le vaisseau prend du thulium");
                stop();
            }
            else if (nbRandom < gadolinium) {
                liste.add(new Gadolinium());
                System.out.println("Le vaisseau prend du gadolinium");
                stop();
            }
            else if (nbRandom < terbium) {
                liste.add(new Terbium());
                System.out.println("Le vaisseau prend du terbium");
                stop();
            }
            else {
                liste.add(new Neptunium());
                System.out.println("Le vaisseau prend du neptunium");
                stop();
            }
        }
        v.setListe(liste);
        Collections.sort(v.getListe(), new Comparateur());
        CentreTri c = new CentreTri();
        int j = 0;
        for (int i=0;i<centreTri.size();i++) {
            if (centreTri.get(centreTri.size()-1).getFileVaisseau().size() == 5) {
                fin();
            }
            if (centreTri.get(i).getFileVaisseau().size() < 5) {
                c = centreTri.get(i);
                j = i;
                i = centreTri.size()+1;
            }
        }
        déchargerVaisseau(c, v, j);
    }
    public static void Enregistrer(){
        SimpleDateFormat essaie = new SimpleDateFormat("yyyyMMddhhmmss");
        String laDateDuJour = essaie.format(new java.util.Date());

        try {
            ObjectOutputStream sortie = new ObjectOutputStream
                    (new BufferedOutputStream
                            (new FileOutputStream("Simulation_"+laDateDuJour+".dat")));
            System.out.print("oublie pas de rentrer les choses du main a sauvegarder...");
            sortie.close();
        }catch(Exception one){
            System.out.print("N'a pas Enregistrer les résultats");
        }
    }
    private static void déchargerVaisseau(CentreTri c, Vaisseau v, int j){
        c.getFileVaisseau().add(v);
        for (int i=0;i<v.getListe().size();i++) {
            if (v.getListe().get(i) instanceof Plutonium) {
                c.addPluto();
                if (c.getStackPlutonium().size() == 50) {
                    Recycler(c.getStackPlutonium(), new Plutonium(), c, j);
                }
            }
            if (v.getListe().get(i) instanceof Thulium) {
                c.addThuli();
                if (c.getStackThulium().size() == 50) {
                    Recycler(c.getStackThulium(), new Thulium(), c, j);
                }
            }
            if (v.getListe().get(i) instanceof Gadolinium) {
                c.addGado();
                if (c.getStackGadolinium().size() == 50) {
                    Recycler(c.getStackGadolinium(), new Gadolinium(), c, j);
                }
            }
            if (v.getListe().get(i) instanceof Terbium) {
                c.addTerb();
                if (c.getStackTerbium().size() == 50) {
                    Recycler(c.getStackTerbium(), new Terbium(), c, j);
                }
            }
            if (v.getListe().get(i) instanceof Neptunium) {
                c.addNep();
                if (c.getStackNeptunium().size() == 50) {
                    Recycler(c.getStackNeptunium(), new Neptunium(), c, j);
                }
            }
        }
        v.getListe().clear();
        System.out.println("Centre de tri " + (j+1));
        System.out.println("Plutonium : " + c.getStackPlutonium().size());
        System.out.println("Thulium : " + c.getStackThulium().size());
        System.out.println("Gadolinium : " + c.getStackGadolinium().size());
        System.out.println("Terbium : " + c.getStackTerbium().size());
        System.out.println("Neptunium : " + c.getStackNeptunium().size());
    }

    private static void Recycler(Stack s, Déchets d, CentreTri c, int j) {
        for (int i=0;i<(s.size()/(100/d.getRecyclabe()));i++) {
            s.pop();
        }
        if ((j+1)>=centreTri.size()) {
            fin();
        }
        CentreTri cProchain = centreTri.get(j+1);
        noParking(c, cProchain, (j+1));
    }
    private static void noParking(CentreTri centreTri,CentreTri prochainCentreTri, int j){
        Random random = new Random();
        ArrayList<Déchets> list = new ArrayList<>();
        switch (random.nextInt(5 + 1 - 1) + 1)
        {
            case 1:
                for(int i = 0; i < (centreTri.getStackGadolinium().peek().getMasseVolumique()/100)*centreTri.getStackGadolinium().size(); i++)
                {
                    list.add(centreTri.getStackGadolinium().pop());
                }
                centreTri.getFileVaisseau().peek().setListe(list);
                break;
            case 2:
                for(int i = 0; i < (centreTri.getStackNeptunium().peek().getMasseVolumique()/100)*centreTri.getStackNeptunium().size(); i++)
                {
                    list.add(centreTri.getStackNeptunium().pop());
                }
                centreTri.getFileVaisseau().peek().setListe(list);
                break;
            case 3:
                for(int i = 0; i < (centreTri.getStackPlutonium().peek().getMasseVolumique()/100)*centreTri.getStackPlutonium().size(); i++)
                {
                    list.add(centreTri.getStackPlutonium().pop());
                }
                centreTri.getFileVaisseau().peek().setListe(list);
                break;
            case 4:
                for(int i = 0; i < (centreTri.getStackTerbium().peek().getMasseVolumique()/100)*centreTri.getStackTerbium().size(); i++)
                {
                    list.add(centreTri.getStackTerbium().pop());
                }
                centreTri.getFileVaisseau().peek().setListe(list);
                break;
            case 5:
                for(int i = 0; i < (centreTri.getStackThulium().peek().getMasseVolumique()/100)*centreTri.getStackThulium().size(); i++)
                {
                    list.add(centreTri.getStackThulium().pop());
                }
                centreTri.getFileVaisseau().peek().setListe(list);
                break;
        }
        déchargerVaisseau(prochainCentreTri, centreTri.getFileVaisseau().peek(), j);
        prochainCentreTri.getFileVaisseau().add(centreTri.getFileVaisseau().poll());

    }

    private static void fin() {
        for (int i=0;i<centreTri.size();i++) {
            System.out.println("");
            System.out.println("Centre tri " + (i+1));
            System.out.println("Plutonium : " + centreTri.get(i).getStackPlutonium().size());
            System.out.println("Thulium : " + centreTri.get(i).getStackThulium().size());
            System.out.println("Gadolinium : " + centreTri.get(i).getStackGadolinium().size());
            System.out.println("Terbium : " + centreTri.get(i).getStackTerbium().size());
            System.out.println("Neptunium : " + centreTri.get(i).getStackNeptunium().size());
        }
        System.out.println("");
        System.out.println("");
        stop();stop();stop();stop();stop();stop();stop();stop();stop();stop();
        System.out.println("FIN");
        System.exit(0);
    }
    private static void stop() {
        try {
            Thread.sleep(25);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
