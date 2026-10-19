import java.util.ArrayList;


public class Agenda {
    private int numero_contatos;
    private ArrayList<Contato> contatos;

    public Agenda() {
        this.numero_contatos = 0;
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
        numero_contatos++;
    }

    public void removerContato(String nome) {
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getNome().equals(nome)) {
                contatos.remove(i);
                numero_contatos--;
                break;
            }
        }
    }

    public Contato buscarContatoNome(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equals(nome)) {
                return contato;
            }
        }
        return null;
    }

    
    public Contato buscarContatoEmail(String email) {
        for (Contato contato : contatos) {
            if (contato.getEmail().equals(email)) {
                return contato;
            }
        }
        return null;
    }

    
    public Contato buscarContatoTelefone(String telefone) {
        for (Contato contato : contatos) {
            if (contato.getTelefone().equals(telefone)) {
                return contato;
            }
        }
        return null;
    }

    public int getNumeroContatos() {
        return numero_contatos;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    
}
