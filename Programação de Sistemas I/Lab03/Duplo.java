public class Duplo extends Cafe {
    public Duplo(String grao) {
        super(grao);
        this.name = "Café " + grao + " Duplo";
    }

    @Override
    public double getPreco() {
        return 2 * super.getPreco();
    }
}