import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;

class Bank_Account{
    int account_number;
    String account_holder;
     String account_Password;
    double Balance;
    Bank_Account(){

    }
  Bank_Account(int no,String str,double bal,String pass){
      account_number=no;
      account_holder=str;
      account_Password=pass;
      Balance=bal;
  }
}
public class Bank {
    public static int no;
    public static String str;
    public static String pass;
    public static double Bal=0.0;
    public static Scanner s=new Scanner(System.in);
    public static Bank_Account Temp=new Bank_Account();
    public static ArrayList<Bank_Account>Data=new ArrayList<Bank_Account>();
    public static void Public(){
        System.out.println("Enter the Account Number:\n");
         no = s.nextInt();
        System.out.println("Enter your correct Password:\n");
         pass=s.next();
    }
    public static void Add(){
        System.out.println("Enter the Account_Name:");
        str=s.next();
        Public();
        for(Bank_Account i:Data){
            if(no==i.account_number){
                System.out.println("Number Already Taken....Re-enter the Number");
                break;
            }
            }
        Data.add(new Bank_Account(no,str,Bal,pass));
        }

    public static void Display() {
        Public();
        System.out.println("1111====="+no+pass);
        for (Bank_Account i : Data) {
            int j=1;
           if(i.account_number==no){
               if(pass.equalsIgnoreCase(i.account_Password)){
                       System.out.println("Account Number:"+i.account_number + " \n"+"Account Holder:" + i.account_holder);
                   } else{
                       System.out.println("re-Enter the correct Password");
                   }
               break;
           }
            if(j==Data.size()){
              System.out.println("no user found");
           }
           j++;
           }
        }
    public static void get_balance() {
      Public();
        for (Bank_Account i : Data) {
            int j=1;
            if(i.account_number==no){
                if(pass.equalsIgnoreCase(i.account_Password)){
                    System.out.println("Account Number:"+i.account_number + "\n"+"Balance" + i.Balance);
                } else{
                    System.out.println("re-Enter the correct Password");
                }
                break;
            }
            if(j==Data.size()){
                System.out.println("no user found");
            }
            j++;
        }

    }
    public static void Deposit(){
       Public();
        for (Bank_Account i : Data) {
            int j=1;
            if(i.account_number==no){
                if(pass.equalsIgnoreCase(i.account_Password)){
                    System.out.println("Enter the Cash to Deposit:\n");
                    double cash=s.nextDouble();
                    i.Balance+=cash;
                    System.out.println("--Successfully Deposited--");
                } else{
                    System.out.println("re-Enter the correct Password");
                }
                break;
            }
            if(j==Data.size()){
                System.out.println("no user found");
            }
            j++;
        }
    }
    public static void widthdraw(){
        Public();
        for (Bank_Account i : Data) {
            int j=1;
            if(i.account_number==no){
                if(pass.equalsIgnoreCase(i.account_Password)){
                    System.out.println("Enter the Cash to Widthdraw:\n");
                    double cash=s.nextDouble();
                    if(cash>i.Balance){
                        System.out.println("Out of Balance");
                    }
                    else {
                        i.Balance -= cash;
                        System.out.println("--Successfully Widthdrawn--");
                    }
                } else{
                    System.out.println("re-Enter the correct Password");
                }
                break;
            }
            if(j==Data.size()){
                System.out.println("no user found");
            }
            j++;
        }
    }
    public static void main(String arg[]){
        while(true) {
            System.out.println("=========Menu=========\n" +
                    "1)Add\n" +
                    "2)Display Details\n" +
                    "3)GetBalance\n" +
                    "4)Deposit\n" +
                    "5)Withdraw\n" +
                    "6)Exit\n"+
                    "======================"
            );
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    Add();
                    break;
                case 2:
                    Display();
                    break;
                case 3:
                    get_balance();
                    break;
                case 4:
                    Deposit();
                    break;
                case 5:
                    widthdraw();
                    break;
                case 6:
                    System.out.println("---ThankYou---");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Re-Enter the Correct choice\n");
            }
        }
    }
}
