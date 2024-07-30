import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Cliente infoCliente = new Cliente();
        Conta c_Corrente = new ContaCorrente(infoCliente);
        Conta c_Poupanca = new ContaPoupanca(infoCliente);
        byte conta;

        System.out.println("Digite o seu nome: ");
        infoCliente.setNome(scan.nextLine());

        System.out.println("Seja Bem-Vindo " + infoCliente.getNome().toUpperCase() + "!");

        boolean sair = false;
        //menu banco
        do {
            System.out.println("-----------------------------");
            System.out.println("NOSSOS SERVIÇOS");
            System.out.println("1. Consulta de Saldo/Informacoes Conta");
            System.out.println("2. Consulta de Saldo/Informacoes Conta Poupanca");
            System.out.println("3. Depósito");
            System.out.println("4. Saque");
            System.out.println("5. Tranferir");
            System.out.println("6. Sair");
            System.out.println("-----------------------------");

            System.out.print("Digite uma opção: ");
            byte opcao = scan.nextByte();

            switch(opcao) {
                case 1:
                     c_Corrente.imprimirExtrato();
                    break;
                case 2:
                    c_Poupanca.imprimirExtrato();
                    break;
                case 3:
                    System.out.println("Digite 1-Depósito Conta Corrente \n"+
                    "2-Depósito Conta Poupanca: ");
                    conta = scan.nextByte();
                    if(conta == 1){
                        System.out.print("Digite o Valor do Depósito: ");
                        double valorDeposito = scan.nextDouble();
                        c_Corrente.depositar(valorDeposito);
                        break;
                    }else if(conta == 2){
                        System.out.print("Digite o Valor do Depósito: ");
                        double valorDeposito = scan.nextDouble();
                        c_Poupanca.depositar(valorDeposito);
                        break;
                    }else{
                        System.out.println("OPÇÃO INVÁLIDA!");
                    }
                    break;
                case 4:
                    System.out.println("Digite 1-Saque Conta Corrente \n"+
                            "2-Saque Conta Poupanca: ");
                    conta = scan.nextByte();
                    if(conta == 1){
                        System.out.print("Digite o Valor Que Deseja Sacar:");
                        double valorSaque = scan.nextDouble();
                        c_Corrente.sacar(valorSaque);
                        break;
                    }else if(conta == 2){
                        System.out.print("Digite o Valor Que Deseja Sacar:");
                        double valorSaque = scan.nextDouble();
                        c_Poupanca.sacar(valorSaque);
                        break;
                    }else{
                        System.out.println("OPÇÃO INVÁLIDA!");
                    }
                    break;

                case 5:
                    System.out.println("Digite o valor que deseja transferir: ");
                    double valorTranfer = scan.nextDouble();
                    if(valorTranfer > 0 && valorTranfer <= c_Corrente.getSaldo()){
                        c_Corrente.transferir(valorTranfer, c_Poupanca);
                        break;
                }else{
                        System.out.println("Saldo Insuficiente. Tente Novamente!");
                    }
                    break;
                case 6:
                    sair = true;
                    System.out.println("Encerrando seção...");
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
            }


        }while(!sair);

    }

}