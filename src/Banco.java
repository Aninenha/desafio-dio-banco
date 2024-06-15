package src;

import java.util.Scanner;

public class Banco {
    public Cliente client;
    public Conta conta = new Conta();
    Scanner scan = new Scanner(System.in);

    Conta conta1 = new ContaCorrente();
    Conta conta2 = new ContaCorrente();
    Conta conta3 = new ContaCorrente();
    Conta conta4 = new ContaCorrente();
    Conta conta5 = new ContaCorrente();
    Conta conta6 = new ContaCorrente();

    public Banco() {

        System.out.println("Bem vindo ao banco!");
        System.out.println("Qual seu nome?");
        String nome;
        nome = scan.next();
        System.out.println(nome);
        client = new Cliente(nome);
        System.out.println("Obrigado pela preferência " + nome + "! Qual tipo de conta você deseja abrir?");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        int opcao = scan.nextInt();

        switch (opcao){
            case 1:
                setContaCorrente(this.conta);
                System.out.println("Sua conta corrente foi criada! A sua agência é " + conta.getAgencia() + " e sua conta é " + conta.getNumero() + "!");
                break;
            case 2:
                setContaPoupanca(this.conta);
                System.out.println("Sua conta poupança foi criada! A A sua agência é " + conta.getAgencia() +" e sua conta é " + conta.getNumero() + "!");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        System.out.println("Você deseja fazer alguma operação?");
        System.out.println("1. Sim");
        System.out.println("2. Não");
        int opcao2 = scan.nextInt();

        while (opcao2 != 2) {
            if (opcao2 == 1) {
                System.out.println("Qual operação você deseja realizar?");
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Transferir");
                int opcao3 = scan.nextInt();
                switch (opcao3) {
                    case 1:
                        System.out.println("Quanto você deseja depositar?");
                        double deposito = scan.nextDouble();
                        conta.depositar(deposito);
                        System.out.println("Deposito realizado com sucesso! Seu saldo atual é: R$" + conta.saldo);
                        System.out.println("Deseja realizar mais alguma ação?");
                        System.out.println("1. Sim");
                        System.out.println("2. Não");
                        opcao2 = scan.nextInt();
                        break;
                    case 2:
                        System.out.println("Quanto você deseja sacar?");
                        double saque = scan.nextDouble();
                        if (conta.saldo < saque) {
                            System.out.println("Saldo insuficiente!");
                        } else {
                            conta.sacar(saque);
                            System.out.println("Saque realizado com sucesso! Seu saldo atual é R$" + conta.saldo);
                        }
                        System.out.println("Deseja realizar mais alguma ação?");
                        System.out.println("1. Sim");
                        System.out.println("2. Não");
                        opcao2 = scan.nextInt();
                        break;
                    case 3:
                        System.out.println("Quanto você deseja transferir?");
                        double transferencia = scan.nextDouble();
                        System.out.println("Para qual conta você deseja transferir?");
                        System.out.println("1. conta1");
                        System.out.println("2. conta2");
                        System.out.println("3. conta3");
                        System.out.println("4. conta4");
                        System.out.println("5. conta5");
                        System.out.println("6. conta6");
                        Conta contaDestino = new Conta();
                        int opcao4;
                        opcao4 = scan.nextInt();
                        switch (opcao4) {
                            case 1:
                                contaDestino = conta1;
                                break;
                            case 2:
                                contaDestino = conta2;
                                break;
                            case 3:
                                contaDestino = conta3;
                                break;
                            case 4:
                                contaDestino = conta4;
                                break;
                            case 5:
                                contaDestino = conta5;
                                break;
                            case 6:
                                contaDestino = conta6;
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                return;
                        }
                        conta.transferir(transferencia, contaDestino);
                        if (transferencia > conta.saldo) {
                            System.out.println("Transferencia inválida!");
                        } else {
                            System.out.println("Transferência realizada com sucesso! Seu saldo atual é: R$" + conta.saldo);
                        }
                        System.out.println("Deseja realizar mais alguma ação?");
                        System.out.println("1. Sim");
                        System.out.println("2. Não");
                        opcao2 = scan.nextInt();
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
            else {
                System.out.println("Opção inválida!");
                System.out.println("1. Sim");
                System.out.println("2. Não");
                opcao2 = scan.nextInt();
            }
        }

        System.out.println("Obrigado pela preferência!");


        }


    public void setContaPoupanca(Conta conta) {
        conta = new ContaPoupanca();
    }
    public void setContaCorrente(Conta conta) {
        conta = new ContaCorrente();
    }

    public Conta getConta() {
        return conta;
    }
}

