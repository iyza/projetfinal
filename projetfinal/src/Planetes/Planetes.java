package Planetes;

import java.io.Serializable;

public class Planetes implements Serializable {
    protected int plutonium;
    protected int thulium;
    protected int gadolinium;
    protected int terbium;
    protected int neptunium;

    public int getPlutonium(){return this.plutonium;}
    public int getThulium(){return this.thulium;}
    public int getGadolinium(){return this.gadolinium;}
    public int getTerbium(){return this.terbium;}
    public int getNeptunium(){return this.neptunium;}

}
