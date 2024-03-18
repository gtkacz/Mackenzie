public class Capuccino extends Quente {
    private Cafe cafe;
    private Chocolate chocolate;

    public Capuccino(String grao, int percentual) {
        super("Capuccino");
        this.cafe = new Cafe(grao);
        this.chocolate = new Chocolate(percentual);
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public Chocolate getChocolate() {
        return chocolate;
    }

    public void setChocolate(Chocolate chocolate) {
        this.chocolate = chocolate;
    }

    @Override
    public double getPreco() {
        return cafe.getPreco() + chocolate.getPreco() + 2.00;
    }
}