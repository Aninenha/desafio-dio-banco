package src;
public class Conta implements IConta{
    private static int SEQUENCIAL = 0;
    private static final int AGENCIA_PADRAO = 1;

    protected int agencia;
    protected int numero = SEQUENCIAL;
    protected double saldo;

    private boolean isSaldoSuficiente;

    public double getSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    @Override
    public void sacar(double valor) {
        sacarPrivate(valor);
    }

    @Override
    public void depositar(double valor) {
        depositarPrivate(valor);
    }

    private void depositarPrivate(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        transferirPrivate(valor, contaDestino);
    }

    @Override
    public void imprimirExtrato() {

    }
    
    public Conta() {
        this.agencia = AGENCIA_PADRAO;
        SEQUENCIAL++;
    }

    private void transferirPrivate(double valor, Conta contaDestino) {
        if(this == contaDestino){
            System.out.println("Não é possível transferir para a mesma conta!");
            return;
        }
        verificarSaldoSuficiente(valor);
        if (isSaldoSuficiente) {
            this.saldo -= valor;
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada com sucesso. Saldo atualizado = R$"+saldo);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
    
    private void sacarPrivate(double valor) {
        verificarSaldoSuficiente(valor);
        if (isSaldoSuficiente) {
            this.saldo -= valor;
            System.out.println("Saque relizado com sucesso. Saldo atualizado = R$"+saldo);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    private boolean verificarSaldoSuficiente(double valor) {
        if (valor <= saldo) {
            return isSaldoSuficiente= false;
        } else {
            return isSaldoSuficiente =true;
        }
    }
}
