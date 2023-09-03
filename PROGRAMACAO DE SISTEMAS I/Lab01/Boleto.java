import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Boleto {
    private String sacado;
    private double valor;
    private Date dataVencimento;
    private String cedente;
    private int agencia;
    private long conta;
    private boolean pago;
    private double juros;

    public Boleto(String sacado, double valor, String dataVencimento, String cedente, int agencia, long conta) throws ParseException {
        this.sacado = sacado;
        this.valor = valor;
        this.cedente = cedente;
        this.agencia = agencia;
        this.conta = conta;
        this.pago = false;
        this.juros = 0.0;
        this.dataVencimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataVencimento);
    }

    public void pagar() {
        this.pago = true;
    }

    public int calcularAtraso(String dataPagamento) throws ParseException {
        Date dataPagamentoDate = new SimpleDateFormat("dd/MM/yyyy").parse(dataPagamento);
        long diferencaMillis = dataPagamentoDate.getTime() - this.dataVencimento.getTime();

        return (int) (diferencaMillis / (24 * 60 * 60 * 1000));
    }

    public void calcularJuros() throws ParseException {
        int diasAtraso = calcularAtraso(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        if (diasAtraso > 0) {
            double juros = valor * 0.05 + diasAtraso * (valor * 0.001);
            this.juros = juros;
        }
    }

    public double calcularValorAPagar() {
        return (double) valor + juros;
    }

    public void imprimirDados() {
        System.out.println("Sacado: " + sacado);
        System.out.println("Valor: R$ " + valor);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Data de Vencimento: " + dateFormat.format(dataVencimento));
        System.out.println("Cedente: " + cedente);
        System.out.println("Agência: " + agencia);
        System.out.println("Conta: " + conta);
        System.out.println("Status: " + (pago ? "Pago" : "Não Pago"));
        System.out.println("Juros: R$ " + juros);
        System.out.println("Valor Total a Pagar: R$" + calcularValorAPagar() + "\n\n");
    }

    public static void main(String[] args) throws ParseException {
        Boleto boleto = new Boleto("Gabriel Mitelman Tkacz", 1, "07/09/2023", "Universidade Presbiteriana Mackenzie", 123, 45678901);
        boleto.pagar();
        boleto.imprimirDados();
    }
}
