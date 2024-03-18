public class Suco extends Fria {
    private String fruta;

    public Suco(String fruta) {
        super("Suco natural de " + fruta);
        this.fruta = fruta;
    }

    @Override
    public double getPreco() {
        switch (fruta.toLowerCase()) {
            case "limão":
            case "laranja":
            case "morango":
            case "maracujá":
            case "abacaxi":
            case "melancia":
                return 15.00;
            default:
                return 0.0;
        }
    }
}