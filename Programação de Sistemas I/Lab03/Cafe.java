public class Cafe extends Quente {
    private String grao;

    public Cafe(String grao) {
        super("Café " + grao);
        this.grao = grao;
    }

    public String getGrao() {
        return grao;
    }

    public void setGrao(String grao) {
        this.grao = grao;
    }

    @Override
    public double getPreco() {
        switch (grao.toLowerCase()) {
            case "blend":
                return 5.30;
            case "bourbon":
                return 4.50;
            case "catuaí":
                return 6.00;
            default:
                return 0.0;
        }
    }
}
