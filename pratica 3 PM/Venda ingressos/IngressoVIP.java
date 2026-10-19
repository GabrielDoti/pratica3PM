public class IngressoVIP extends Ingresso {
    private boolean acessoBackstage;
    private int numeroLounge;

    public IngressoVIP(int codigo, String nomeEvento, String setor, double valorBase, boolean acessoBackstage, int numeroLounge) {
        super(codigo, nomeEvento, setor, valorBase);
        this.acessoBackstage = acessoBackstage;
        this.numeroLounge = numeroLounge;
    }

    @Override
    public double calcularValorFinal() {
        return getValorBase() * 1.8;
    }

    @Override
    public String obterBeneficios() {
        String beneficios = "Acesso ao lounge número " + numeroLounge;
        if (acessoBackstage) {
            beneficios += " + acesso ao backstage";
        }
        return beneficios + ".";
    }

    @Override
    public String exibirInformacoes() {
        String info = super.exibirInformacoes() + "\nTipo: VIP"
                + "\nLounge: " + numeroLounge;
        if (acessoBackstage) {
            info += "\nAcesso ao backstage: Sim";
        }
        info += "\nValor final: R$ " + String.format("%.2f", calcularValorFinal());
        return info;
    }

    public boolean isAcessoBackstage() {
        return acessoBackstage;
    }

    public void setAcessoBackstage(boolean acessoBackstage) {
        this.acessoBackstage = acessoBackstage;
    }

    public int getNumeroLounge() {
        return numeroLounge;
    }

    public void setNumeroLounge(int numeroLounge) {
        this.numeroLounge = numeroLounge;
    }
}