package project.atm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner sc = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer,Integer> data = new HashMap<>();

    public void getLogin(){
        int x=1;
        while(x==1){
            try{
                data.put(18,1234);
                data.put(22,5678);

                System.out.println("Welcome to the ATM Project!\n");
                System.out.println("Enter your account number:");
                setAccountNumber(sc.nextInt());
                System.out.println("Enter your PIN number:");
                setPinNumber(sc.nextInt());
            } catch (Exception e) {
                System.out.println("Invalid input.\n");
                x=2;
            }
            int an=getAccountNumber();
            int pn=getPinNumber();
            if(data.containsKey(an) && data.get(an)==pn){
                getAccountType();
            }
            else{
                System.out.println("Wrong account number or PIN\n");
            }
        }
    }

    public void getAccountType(){
        System.out.println("\nSelect the account you want to access:");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Savings Account");
        System.out.println("Type 3 - Exit");

        int ch=sc.nextInt();

        switch (ch){
            case 1:
                getChecking();
                break;
            case 2:
                getSavings();
                break;
            case 3:
                System.out.println("Thank you for using this ATM, bye.\n");
                System.exit(1);
                break;
            default:
                System.out.println("Enter a valid choice.");
                getAccountType();
        }
    }

    public void getChecking(){
        System.out.println("Checking Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Back");
        System.out.println("Type 5 - Exit");

        int ch=sc.nextInt();

        switch (ch){
            case 1:
                System.out.println("Checking account balance: "+moneyFormat.format(getCheckingBalance()));
                getChecking();
                break;
            case 2:
                getCheckingWithdrawInput();
                getChecking();
                break;
            case 3:
                getCheckingDepositInput();
                getChecking();
                break;
            case 4:
                getAccountType();
                break;
            case 5:
                System.out.println("Thank you for using this ATM, bye.\n");
                System.exit(1);
                break;
            default:
                System.out.println("Invalid choice.");
                getChecking();
        }
    }

    public void getSavings(){
        System.out.println("Savings Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Back");
        System.out.println("Type 5 - Exit");

        int ch=sc.nextInt();

        switch (ch){
            case 1:
                System.out.println("Savings account balance: "+moneyFormat.format(getSavingsBalance()));
                getSavings();
                break;
            case 2:
                getSavingsWithdrawInput();
                getSavings();
                break;
            case 3:
                getSavingsDepositInput();
                getSavings();
                break;
            case 4:
                getAccountType();
                break;
            case 5:
                System.out.println("Thank you for using this ATM, bye.\n");
                System.exit(1);
                break;
            default:
                System.out.println("Invalid choice.");
                getSavings();
        }
    }
}

