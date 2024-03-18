public abstract class Bebida {
    protected String name;

    public Bebida(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { 
        this.name = name;
    }

    public abstract double getPreco();
}
