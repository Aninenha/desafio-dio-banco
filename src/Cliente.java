package src;

public class Cliente {
    private String nome;
    private int agencia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAgencia(Conta conta) {
        return conta.agencia;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }
}
