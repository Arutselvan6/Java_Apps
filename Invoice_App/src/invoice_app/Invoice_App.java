package invoice_app;

import dao.CustomerAccess;
import java.util.Scanner;
import model.Customer;

public class Invoice_App {

    public static final Scanner SCN = new Scanner(System.in);
    
    public static void main(String[] args) {
        int ch=0;
        do{
            System.out.println("\tInvoice Management\n");
            System.out.println("1.Add Customer\n2.View Customer\n3.View All Customers");
            System.out.println("Enter your choice..");
            try{
                ch = SCN.nextInt();
            }
            catch(Exception e){
                System.err.println("Exception while getting Input.."+e);
                break;
            }
            switch(ch){
                case 1:{
                    addCustomer();
                    break;
                }
                case 2:{
                    showCustomer();
                    break;
                }
                case 3:{
                    showAllCustomers();
                    break;
                }
                default:{
                    System.out.println("Invalid Input.");
                }
            }
        }while(ch<=3);
    }
    
    
    public static void addCustomer(){
        try{
            System.out.println("Enter the Customer Details:");
            Customer x = new Customer();
            System.out.println("Name : ");
            x.setC_name(SCN.next());
            System.out.println("Email : ");
            x.setC_email(SCN.next());
            System.out.println("Address : ");
            x.setC_addr(SCN.next());
            System.out.println("Phone No. : ");
            x.setC_phno(SCN.nextLong());
            if(CustomerAccess.addCustomer(x))
                System.out.println("Customer Data added Successfully");            
        }
        catch(Exception e){
            System.err.println("Exception occurred while getting data.."+e);
        }
    }
    public static void showCustomer(){
        try{
            System.out.println("Enter the Customer Name : ");
            String name = SCN.next();
            Customer x = CustomerAccess.viewCustomerByName(name);
            if(x!=null)
                System.out.println("\tCustomer Details:\n"+x);
        }
        catch(Exception e){
            System.err.println("Exception occurred while getting data.."+e);
        }
    }
    public static void showAllCustomers(){
        try{
            Customer[] list = CustomerAccess.viewAllCustomers();
            if(list!=null){
                System.out.println("\tCustomer Details:\n");
                for(Customer x:list){
                    System.out.println(x);
                }
            }
        }
        catch(Exception e){
            System.err.println("Exception occurred while getting data.."+e);
        }
    }
}