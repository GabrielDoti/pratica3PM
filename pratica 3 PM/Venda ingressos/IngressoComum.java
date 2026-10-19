public class IngressoComum extends Ingresso {

    public IngressoComum(int codigo, String nomeEvento, String setor, double valorBase) {
        super(codigo, nomeEvento, setor, valorBase);
    }

    @Override
    public double calcularValorFinal() {
        return getValorBase();
    }

    @Override
    public String obterBeneficios() {
        return "Nenhum benefício adicional.";
    }

    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() + "\nTipo: Comum"
                + "\nValor final: R$ " + String.format("%.2f", calcularValorFinal());
    }
}