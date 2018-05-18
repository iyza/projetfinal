import Déchet.*;
import Vaisseau.*;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CentreTri implements Serializable{
    private Queue<Vaisseau> fileVaisseau = new LinkedList<Vaisseau>();
    private Stack<Plutonium> stackPlutonium = new Stack<>();
    private Stack<Thulium> stackThulium = new Stack<>();
    private Stack<Gadolinium> stackGadolinium = new Stack<>();
    private Stack<Terbium> stackTerbium = new Stack<>();
    private Stack<Neptunium> stackNeptunium = new Stack<>();

    public Queue<Vaisseau> getFileVaisseau() {
        return fileVaisseau;
    }

    public void setFileVaisseau(Queue<Vaisseau> fileVaisseau) {
        this.fileVaisseau = fileVaisseau;
    }

    public Stack<Plutonium> getStackPlutonium() {
        return stackPlutonium;
    }

    public void setStackPlutonium(Stack<Plutonium> stackPlutonium) {
        this.stackPlutonium = stackPlutonium;
    }

    public Stack<Thulium> getStackThulium() {
        return stackThulium;
    }

    public void setStackThulium(Stack<Thulium> stackThulium) {
        this.stackThulium = stackThulium;
    }

    public Stack<Gadolinium> getStackGadolinium() {
        return stackGadolinium;
    }

    public void setStackGadolinium(Stack<Gadolinium> stackGadolinium) {
        this.stackGadolinium = stackGadolinium;
    }

    public Stack<Terbium> getStackTerbium() {
        return stackTerbium;
    }

    public void setStackTerbium(Stack<Terbium> stackTerbium) {
        this.stackTerbium = stackTerbium;
    }

    public Stack<Neptunium> getStackNeptunium() {
        return stackNeptunium;
    }

    public void setStackNeptunium(Stack<Neptunium> stackNeptunium) {
        this.stackNeptunium = stackNeptunium;
    }

    public void addPluto(){this.stackPlutonium.add(new Plutonium());}
    public void addThuli(){this.stackThulium.add(new Thulium());}
    public void addGado(){this.stackGadolinium.add(new Gadolinium());}
    public void addTerb(){this.stackTerbium.add(new Terbium());}
    public void addNep(){this.stackNeptunium.add(new Neptunium());}
}

