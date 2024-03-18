public class Cha extends Quente {
    private String infusao;

    public Cha(String infusao) {
        super("Chá de " + infusao);
        this.infusao = infusao;
    }

    public String getInfusao() {
        return infusao;
    }

    public void setInfusao(String infusao) {
        this.infusao = infusao;
    }

    @Override
    public double getPreco() {
        switch (infusao.toLowerCase()) {
            case "camomila":
                return 8.40;
            case "cidreira":
                return 7.20;
            case "hortelã":
                return 8.70;
            default:
                return 0.0;
        }
    }
}