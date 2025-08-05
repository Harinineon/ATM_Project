package project.atm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int accountNumber;
    private int pinNumber;
    private double checkingBalance=0;
    private double savingsBalance =0;

    Scanner sc = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public int setAccountNumber(int an){
        accountNumber=an;
        return accountNumber;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public int setPinNumber(int pn){
        pinNumber=pn;
        return pinNumber;
    }
    public int getPinNumber(){
        return pinNumber;
    }
    public double getCheckingBalance(){
        return checkingBalance;
    }
    public double getSavingsBalance(){
        return savingsBalance;
    }

    public double calcCheckingWithdraw(double amt){
        checkingBalance-=amt;
        return checkingBalance;
    }
    public double calcSavingsWithdraw(double amt){
        savingsBalance -=amt;
        return savingsBalance;
    }
    public double calcCheckingDeposit(double amt){
        checkingBalance+=amt;
        return checkingBalance;
    }
    public double calcSavingsDeposit(double amt){
        savingsBalance +=amt;
        return savingsBalance;
    }

    public void getCheckingWithdrawInput(){
        System.out.println("Checking Account Balance: "+moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from Checking Account: ");
        double amt=sc.nextDouble();

        if((checkingBalance-amt)>=0){
            calcCheckingWithdraw(amt);
            System.out.println("New Checking Account Balance: "+moneyFormat.format(checkingBalance)+"\n");
        }
        else{
            System.out.println("Balance is lower!!\n");
        }
    }
    public void getSavingsWithdrawInput(){
        System.out.println("Saving Account Balance: "+moneyFormat.format(savingsBalance));
        System.out.println("Amount you want to withdraw from Checking Account: ");
        double amt=sc.nextDouble();

        if((savingsBalance-amt)>=0){
            calcSavingsWithdraw(amt);
            System.out.println("New Checking Account Balance: "+moneyFormat.format(savingsBalance)+"\n");
        }
        else{
            System.out.println("Balance is lower!!\n");
        }
    }

    public void getCheckingDepositInput(){
        System.out.println("Checking Account Balance: "+moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to deposit to Checking Account: ");
        double amt = sc.nextDouble();

        if((checkingBalance+amt)>=0){
            calcCheckingDeposit(amt);
            System.out.println("New Checking Account Balance: "+moneyFormat.format(checkingBalance)+"\n");
        }
        else{
            System.out.println("Balance cannot be negative!!\n");
        }
    }
    public void getSavingsDepositInput(){
        System.out.println("Savings Account Balance: "+moneyFormat.format(savingsBalance));
        System.out.println("Amount you want to deposit to Savings Account: ");
        double amt = sc.nextDouble();

        if((savingsBalance+amt)>=0){
            calcSavingsDeposit(amt);
            System.out.println("New Savings Account Balance: "+moneyFormat.format(savingsBalance)+"\n");
        }
        else{
            System.out.println("Balance cannot be negative!!\n");
        }
    }
}

