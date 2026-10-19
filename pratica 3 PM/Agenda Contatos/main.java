import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Buscar contato por nome");
            System.out.println("4 - Buscar contato por email");
            System.out.println("5 - Buscar contato por telefone");
            System.out.println("6 - Consultar tamanho da agenda");
            System.out.println("7 - Finalizar");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 1) {
                System.out.println("Tipo de contato: 1 - Pessoal | 2 - Profissional | 3 - Emergência");
                int tipo = Integer.parseInt(scanner.nextLine());

                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Telefone: ");
                String telefone = scanner.nextLine();

                if (tipo == 1) {
                    System.out.print("Data de aniversário: ");
                    String dataAniversario = scanner.nextLine();
                    System.out.print("Parentesco: ");
                    String parentesco = scanner.nextLine();
                    agenda.adicionarContato(new ContatoPessoal(nome, email, telefone, dataAniversario, parentesco));
                    System.out.println("Contato adicionado!");
                } else if (tipo == 2) {
                    System.out.print("Empresa: ");
                    String empresa = scanner.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();
                    agenda.adicionarContato(new ContatoProfissional(nome, email, telefone, empresa, cargo));
                    System.out.println("Contato adicionado!");
                } else if (tipo == 3) {
                    System.out.print("Grau de prioridade: ");
                    int grauPrioridade = Integer.parseInt(scanner.nextLine());
                    System.out.print("Observação: ");
                    String observacao = scanner.nextLine();
                    agenda.adicionarContato(new ContatoEmergencia(nome, email, telefone, grauPrioridade, observacao));
                    System.out.println("Contato adicionado!");
                } else {
                    System.out.println("Tipo inválido.");
                }

            } else if (opcao == 2) {
                System.out.print("Nome do contato que quer remover: ");
                String nome = scanner.nextLine();
                Contato contato = agenda.buscarContatoNome(nome);
                if (contato == null) {
                    System.out.println("Contato não encontrado.");
                } else {
                    agenda.removerContato(nome);
                    System.out.println("Contato removido!");
                }

            } else if (opcao == 3) {
                System.out.print("Nome: ");
                Contato contato = agenda.buscarContatoNome(scanner.nextLine());
                if (contato == null) {
                    System.out.println("Contato não encontrado.");
                } else {
                    System.out.println(contato.InfoContato());
                }

            } else if (opcao == 4) {
                System.out.print("Email: ");
                Contato contato = agenda.buscarContatoEmail(scanner.nextLine());
                if (contato == null) {
                    System.out.println("Contato não encontrado.");
                } else {
                    System.out.println(contato.InfoContato());
                }

            } else if (opcao == 5) {
                System.out.print("Telefone: ");
                Contato contato = agenda.buscarContatoTelefone(scanner.nextLine());
                if (contato == null) {
                    System.out.println("Contato não encontrado.");
                } else {
                    System.out.println(contato.InfoContato());
                }

            } else if (opcao == 6) {
                System.out.println("Tamanho da agenda: " + agenda.getNumeroContatos());

            } else if (opcao == 7) {
                System.out.println("Programa finalizado.");

            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}