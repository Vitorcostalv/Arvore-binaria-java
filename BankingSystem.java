import java.util.Scanner;

public class BankingSystem {
    private BinaryTree tree;
    private Scanner scanner;

    public BankingSystem() {
        tree = new BinaryTree();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. Cadastrar Conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Verificar Saldo");
            System.out.println("5. Finalizar");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline

            switch (choice) {
                case 1:
                    registerAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void registerAccount() {
        System.out.print("Número da conta: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Saldo inicial: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // Clear the newline

        BankAccount account = new BankAccount(accountNumber, initialBalance);
        tree.insert(account);
        System.out.println("Conta cadastrada com sucesso.");
    }

    private void deposit() {
        System.out.print("Número da conta: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Valor do depósito: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Clear the newline

        BankAccount account = tree.search(accountNumber);
        if (account == null) {
            System.out.println("Conta não encontrada.");
            return;
        }
        account.deposit(amount);
        System.out.println("Depósito realizado com sucesso.");
    }

    private void withdraw() {
        System.out.print("Número da conta: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Valor do saque: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Clear the newline

        BankAccount account = tree.search(accountNumber);
        if (account == null) {
            System.out.println("Conta não encontrada.");
            return;
        }
        account.withdraw(amount);
        System.out.println("Saque realizado com sucesso.");
    }

    private void checkBalance() {
        System.out.print("Número da conta: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Clear the newline

        BankAccount account = tree.search(accountNumber);
        if (account == null) {
            System.out.println("Conta não encontrada.");
            return;
        }
        System.out.println("Saldo: " + account.getBalance());
    }
}
