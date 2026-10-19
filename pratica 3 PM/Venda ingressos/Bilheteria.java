import java.util.ArrayList;

public class Bilheteria {
    private ArrayList<Ingresso> ingressos;

    public Bilheteria() {
        this.ingressos = new ArrayList<>();
    }

    public void adicionarIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    public boolean removerIngresso(int codigo) {
        for (int i = 0; i < ingressos.size(); i++) {
            if (ingressos.get(i).getCodigo() == codigo) {
                ingressos.remove(i);
                return true;
            }
        }
        return false;
    }

    public Ingresso buscarIngresso(int codigo) {
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getCodigo() == codigo) {
                return ingresso;
            }
        }
        return null;
    }

    public void listarIngressos() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }
        for (Ingresso ingresso : ingressos) {
            System.out.println("\n" + ingresso.exibirInformacoes());
        }
    }

    public double calcularArrecadacaoTotal() {
        double total = 0;
        for (Ingresso ingresso : ingressos) {
            total += ingresso.calcularValorFinal();
        }
        return total;
    }

    public void listarBeneficios() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }
        for (Ingresso ingresso : ingressos) {
            System.out.println("Ingresso " + ingresso.getCodigo() + ": " + ingresso.obterBeneficios());
        }
    }

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }
}