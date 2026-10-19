import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bilheteria bilheteria = new Bilheteria();
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar ingresso");
            System.out.println("2 - Remover ingresso");
            System.out.println("3 - Buscar ingresso por código");
            System.out.println("4 - Listar todos os ingressos");
            System.out.println("5 - Calcular arrecadação total");
            System.out.println("6 - Listar benefícios dos ingressos");
            System.out.println("7 - Finalizar");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 1) {
                System.out.println("Tipo de ingresso: 1 - Comum | 2 - Estudante | 3 - VIP");
                int tipo = Integer.parseInt(scanner.nextLine());

                if (tipo < 1 || tipo > 3) {
                    System.out.println("Tipo inválido.");
                } else {
                    System.out.print("Código: ");
                    int codigo = Integer.parseInt(scanner.nextLine());

                    if (bilheteria.buscarIngresso(codigo) != null) {
                        System.out.println("Já existe um ingresso com esse código.");
                    } else {
                        System.out.print("Nome do evento: ");
                        String nomeEvento = scanner.nextLine();
                        System.out.print("Setor: ");
                        String setor = scanner.nextLine();
                        System.out.print("Valor base: ");
                        double valorBase = Double.parseDouble(scanner.nextLine().replace(",", "."));

                        if (tipo == 1) {
                            bilheteria.adicionarIngresso(new IngressoComum(codigo, nomeEvento, setor, valorBase));
                        } else if (tipo == 2) {
                            System.out.print("Instituição de ensino: ");
                            String instituicaoEnsino = scanner.nextLine();
                            bilheteria.adicionarIngresso(new IngressoEstudante(codigo, nomeEvento, setor, valorBase, instituicaoEnsino));
                        } else {
                            System.out.print("Tem acesso ao backstage? (s/n): ");
                            boolean acessoBackstage = scanner.nextLine().equalsIgnoreCase("s");
                            System.out.print("Número do lounge: ");
                            int numeroLounge = Integer.parseInt(scanner.nextLine());
                            bilheteria.adicionarIngresso(new IngressoVIP(codigo, nomeEvento, setor, valorBase, acessoBackstage, numeroLounge));
                        }
                        System.out.println("Ingresso cadastrado!");
                    }
                }

            } else if (opcao == 2) {
                System.out.print("Código do ingresso que quer remover: ");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (bilheteria.removerIngresso(codigo)) {
                    System.out.println("Ingresso removido!");
                } else {
                    System.out.println("Ingresso não encontrado.");
                }

            } else if (opcao == 3) {
                System.out.print("Código: ");
                Ingresso ingresso = bilheteria.buscarIngresso(Integer.parseInt(scanner.nextLine()));
                if (ingresso == null) {
                    System.out.println("Ingresso não encontrado.");
                } else {
                    System.out.println("\n" + ingresso.exibirInformacoes());
                    System.out.println("Benefícios: " + ingresso.obterBeneficios());
                }

            } else if (opcao == 4) {
                bilheteria.listarIngressos();

            } else if (opcao == 5) {
                System.out.println("Arrecadação total: R$ " + String.format("%.2f", bilheteria.calcularArrecadacaoTotal()));

            } else if (opcao == 6) {
                bilheteria.listarBeneficios();

            } else if (opcao == 7) {
                System.out.println("Programa finalizado.");

            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}