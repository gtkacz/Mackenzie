import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gabriel Mitelman Tkacz
 */
public class ConsultorioMedico {
    private static ArrayList<Paciente> pacientes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Listar pacientes");
            System.out.println("2. Buscar por CPF");
            System.out.println("3. Cadastrar novo paciente");
            System.out.println("4. Apagar paciente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listarPacientes();
                    break;
                case 2:
                    buscarPorCPF();
                    break;
                case 3:
                    cadastrarPaciente();
                    break;
                case 4:
                    apagarPaciente();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    private static void listarPacientes() {
        System.out.println("Lista de pacientes:");
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }

    private static void buscarPorCPF() {
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                System.out.println("Paciente encontrado:");
                System.out.println(paciente);
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }

    private static void cadastrarPaciente() {
        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        System.out.print("O paciente possui plano de saúde? (true/false): ");
        boolean possuiPlanoSaude = scanner.nextBoolean();
        scanner.nextLine();
        System.out.print("Digite o número da carteirinha (ou deixe em branco se não possuir): ");
        String numeroCarteirinha = scanner.nextLine();

        try {
            Paciente paciente = new Paciente(nome, cpf, possuiPlanoSaude, numeroCarteirinha);
            pacientes.add(paciente);
            System.out.println("Paciente cadastrado com sucesso.");
        } catch (CPFException e) {
            System.out.println("Erro ao cadastrar paciente: " + e.getMessage());
        }
    }

    private static void apagarPaciente() {
        System.out.print("Digite o CPF do paciente a ser apagado: ");
        String cpf = scanner.nextLine();
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getCpf().equals(cpf)) {
                pacientes.remove(i);
                System.out.println("Paciente apagado com sucesso.");
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }
}
