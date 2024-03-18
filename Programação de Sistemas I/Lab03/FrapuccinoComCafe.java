public class FrapuccinoComCafe extends Frapuccino {
    private Cafe cafe;

    public FrapuccinoComCafe(String grao) {
        super();
        this.cafe = new Cafe(grao);
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public double getPreco() {
        return 13.00 + cafe.getPreco();
    }
}