import java.util.Scanner;

class BankAccount {
    String name;
    private String IBAN = "";
    private float money;

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String iBAN) {
        IBAN = iBAN;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

}

public class Student {

    static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];
        for (int i = 0; i < 3; i++) {
            accounts[i] = new BankAccount();
            System.out.println("Enter client name:");
            accounts[i].name = Sc.nextLine();
            accounts[i].name = Sc.nextLine();
            System.out.println("Enter client IBAN:");
            accounts[i].setIBAN(Sc.nextLine());
            System.out.println("Enter client balance:");
            accounts[i].setMoney(Sc.nextFloat());
        }
        do {

            System.out.println("\n--------------------\n1.Deposit\n2.Withdraw\n3.Check balance");
            switch (Sc.nextInt()) {
                case 1 -> {
                    System.out.println("Enter IBAN:");

                    Sc.nextLine();
                    String SearchIBAN = Sc.nextLine();
                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i].getIBAN().equals(SearchIBAN)) {
                            System.out.println("Enter the amount of money you would like to deposit:");
                            accounts[i].setMoney(accounts[i].getMoney() + Sc.nextFloat());
                            break;
                        }
                    }
                    break;
                }
                case 2 -> {
                    System.out.println("Enter IBAN:");
                    Sc.nextLine();
                    String SearchIBAN = Sc.nextLine();
                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i].getIBAN().equals(SearchIBAN)) {
                            System.out.println("Enter the amount of money you would like to withdraw:");
                            float withdrawMoney = Sc.nextFloat();
                            if (accounts[i].getMoney() - withdrawMoney >= 0) {
                                accounts[i].setMoney(accounts[i].getMoney() - withdrawMoney);
                            } else {
                                System.out.println("No money brah");
                            }
                            break;
                        }
                    }
                    break;
                }
                case 3 -> {
                    System.out.println("Enter IBAN:");
                    String SearchIBAN = Sc.nextLine();
                    SearchIBAN = Sc.nextLine();

                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i].getIBAN().equals(SearchIBAN)) {
                            System.out.println(accounts[i].getMoney());
                            break;
                        }
                    }
                    break;
                }
                default -> System.out.println("broke");
            }

        } while (true);
    }
}