public class Soda extends Fria {
    private String sabor;

    public Soda(String sabor) {
        super("Soda italiana sabor " + sabor);
        this.sabor = sabor;
    }

    @Override
    public double getPreco() {
        switch (sabor.toLowerCase()) {
            case "limão siciliano":
            case "framboesa":
            case "maçã verde":
            case "capim limão":
                return 12.00;
            default:
                return 0.0;
        }
    }
}