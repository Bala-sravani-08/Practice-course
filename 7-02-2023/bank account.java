import java.util.Scanner;

public class Solution{
  private String name;
  private int accountNo;
  private int balance;
  private static int runningAccountNo = 0;

  public Solution(String name) {
    this.name = name;
    this.accountNo = initializeNumber();
    balance = 0;
  }

  public static int initializeNumber() {
    return runningAccountNo;
  }

  public String getName() {
    return name;
  }

  public int getAccountNo() {
    return accountNo;
  }

  public int getBalance() {
    return balance;
  }

  public void deposit(int amount) {
    balance += amount;
  }

  public void withdraw(int amount) {
    if (balance - amount >= 0) {
      balance -= amount;
    } else {
      System.out.println("Negative Balance Transaction Cancelled");
    }
  }

  public void display() {
    System.out.println(accountNo + " " + name + " " + balance);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int startingAccountNo = sc.nextInt();
    runningAccountNo = startingAccountNo;
    String name = sc.next();
    Solution ba = new Solution(name);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      String action = sc.next();
      if (action.equals("Deposit")) {
        int amount = sc.nextInt();
        ba.deposit(amount);
      } else if (action.equals("Withdraw")) {
        int amount = sc.nextInt();
        ba.withdraw(amount);
      } else if (action.equals("Display")) {
        ba.display();
      }
    }
    sc.close();
  }
}
