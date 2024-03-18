public class Chocolate extends Quente {
    private int percentual;

    public Chocolate(int percentual) {
        super("Chocolate " + percentual + "% cacau");
        this.percentual = percentual;
    }

    public int getPercentual() {
        return percentual;
    }

    public void setPercentual(int percentual) {
        this.percentual = percentual;
    }

    @Override
    public double getPreco() {
        switch (percentual) {
            case 30:
                return 10.50;
            case 50:
                return 12.00;
            case 70:
                return 14.00;
            default:
                return 0.0;
        }
    }
}