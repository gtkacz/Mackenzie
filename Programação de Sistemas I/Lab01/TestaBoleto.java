import java.text.ParseException;

public class TestaBoleto {
    public static void main(String[] args) throws ParseException {
        Boleto boleto = new Boleto("Antonio Ferrreira", 3000, "06/04/2023", "ACME Corp. Inc.", 123, 45678901);

        boleto.imprimirDados();

        System.out.println("Pagando o boleto 5 dias após o vencimento:");

        int diasAtraso = boleto.calcularAtraso("11/04/2023");

        if (diasAtraso > 0) {
            System.out.println("Dias de Atraso: " + diasAtraso);
            boleto.calcularJuros();
            boleto.pagar();
        }

        boleto.imprimirDados();
    }
}
