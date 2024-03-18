public class BebidasTest {
    public static void main(String[] args) {

        // Cafés
        Bebida[] pedido1 = new Bebida[]{new Cafe("Bourbon"), new Cafe("Catuaí"), new Cafe("Blend"), new Duplo("Catuaí")};
        double[] precosPedido1 = new double[]{4.5, 6, 5.3, 12}; 

        for(int i = 0; i < pedido1.length; i++)
            if (pedido1[i].getPreco() != precosPedido1[i])
                System.out.println("Calculo incorreto para " + pedido1[i]);
            else
                System.out.println("Bebida " + pedido1[i] + " ok.");

        // Chocolates
        Bebida[] pedido2 = new Bebida[]{new Chocolate(30), new Chocolate(50), new Chocolate(70)};
        double[] precosPedido2 = new double[]{10.5, 12, 14}; 

        for(int i = 0; i < pedido2.length; i++)
            if (pedido2[i].getPreco() != precosPedido2[i])
                System.out.println("Calculo incorreto para " + pedido2[i]);
            else
                System.out.println("Bebida " + pedido2[i] + " ok.");

        // Capuccinos
        Bebida[] pedido3 = new Bebida[]{new Capuccino("Bourbon",30), new Capuccino("Blend",70)};
        double[] precosPedido3 = {17, 21.3};

        for(int i = 0; i < pedido3.length; i++)
            if (pedido3[i].getPreco() != precosPedido3[i])
                System.out.println("Calculo incorreto para " + pedido3[i]);
            else
                System.out.println("Bebida " + pedido3[i] + " ok.");

        // Frapuccino
        Bebida pedido4 = new FrapuccinoComCafe("Blend");
        double precosPedido4 = 18.3;

        if (pedido4.getPreco() != precosPedido4)
            System.out.println("Calculo incorreto para " + pedido4);
        else
            System.out.println("Bebida " + pedido4 + " ok.");
    }
}