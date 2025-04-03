package tn.esprit.firstspringproject.entities;

public enum TypeChambre{
    SIMPLE(1),
    DOUBLE(2),
    TRIPLE(3);

    private int capacite;

    TypeChambre(int capacite) {
        this.capacite = capacite;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int i) {
        this.capacite = i ;
    }
}
