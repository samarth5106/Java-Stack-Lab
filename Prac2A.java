import java.util.Scanner;


class Employee{
    void calcSalary(Scanner sc){


    }
}


class manager extends Employee{
    @Override
    void calcSalary(Scanner sc){
        System.out.println("Enter the GST percentage: ");
        double gst=sc.nextDouble();
        double baseSalary=60000;
        double totalSalary=baseSalary-(baseSalary*(gst/100));
        System.out.println("Salary of the Manager is: "+totalSalary);
    }
}


class programmer extends Employee{
    @Override
    void calcSalary(Scanner sc){
        int hr;
        double gst;
        System.out.println("Enter the number of hour the programmer worked: ");
        hr=sc.nextInt();
        System.out.println("Enter the GST: ");
        gst=sc.nextDouble();
        int base;
        System.out.println("Enter the base payment of programmer: ");
        base=sc.nextInt();
        double totalEarnings=base*hr;
        double deduction=totalEarnings*(gst/100);
        double salary=totalEarnings-deduction;


        System.out.println("Salary of the Programmer is: "+salary);
    }
}


public class Prac2A{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Employee mngr=new manager();
        Employee prgmer=new programmer();


        System.out.println("--- Manager Salary Calculation ---");
        mngr.calcSalary(sc);


        System.out.println("\n--- Programmer Salary Calculation ---");
        prgmer.calcSalary(sc);


        sc.close();
    }
}
