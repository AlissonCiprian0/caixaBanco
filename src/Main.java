import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void clearScreen() {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        CaixaBanco caixa1 = new CaixaBanco();
        Integer escolha = 0;

        caixa1.setUsuarios();

        while (escolha != 6) {
            System.out.print("\n\nCAIXA ELERÔNICO \n----------------------------------");
            System.out.println("\nMenu");
            System.out.println("1 - Logar");
            System.out.println("2 - Registrar-se");
            System.out.println("3 - Ver saldo");
            System.out.println("4 - Sacar");
            System.out.println("5 - Depositar");
            System.out.println("6 - Sair");

            escolha = scan.nextInt();
            scan.nextLine();

            if (escolha > 2 && escolha != 6 && caixa1.getUsuarioLogado() == -1) {
                System.out.println("Faça login primeiro!");
                TimeUnit.SECONDS.sleep(2);
                clearScreen();
            }
            else {
                switch (escolha) {
                    case 1:
                        clearScreen();
                        System.out.println("Login");
                        System.out.print("CPF: ");

                        String cpf = scan.nextLine();
                        System.out.print("Senha: ");

                        String senha = scan.nextLine();

                        clearScreen();
                        caixa1.logar(cpf, senha);
                        TimeUnit.SECONDS.sleep(2);
                        break;
                    case 2:
                        clearScreen();
                        System.out.println("Registro de usuário");

                        System.out.print("Nome: ");
                        String registraNome = scan.nextLine();

                        System.out.print("CPF: ");
                        String registraCpf = scan.nextLine();

                        System.out.print("Senha: ");
                        String registraSenha = scan.nextLine();

                        clearScreen();
                        caixa1.registra(new Usuario(00.00, registraCpf, registraSenha, registraNome));
                        TimeUnit.SECONDS.sleep(2);
                        break;
                    case 3:
                        clearScreen();
                        caixa1.mostrarSaldo();
                        TimeUnit.SECONDS.sleep(2);
                        break;
                    case 4:
                        clearScreen();
                        System.out.println("Saque");

                        System.out.println("Quanto você quer sacar?");
                        Double valorSaque = scan.nextDouble();
                        caixa1.sacar(valorSaque);
                        TimeUnit.SECONDS.sleep(2);
                        break;
                    case 5:
                        clearScreen();
                        System.out.println("Depósito");

                        System.out.println("Quanto você quer depositar?");
                        Double valorDeposito = scan.nextDouble();
                        caixa1.depositar(valorDeposito);
                        TimeUnit.SECONDS.sleep(2);
                        break;
                    case 6:
                        clearScreen();
                        System.out.println("Até a próxima!");
                        TimeUnit.SECONDS.sleep(2);
                        break;
                }
            }
        }
    }
}
