package ppt;

public enum Mano {

    PIEDRA(0),
    PAPEL(1),
    TIJERA(2);

    private int index;

    private Mano(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
