package dao;

import java.sql.*;
import model.Customer;

public class CustomerAccess {

    private static Connection con;
    private static Statement st;
    
    static{
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDB","asd","asd");
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        }
        catch(ClassNotFoundException | SQLException e){
            System.err.println("Exception while connecting to Database..\n"+e);
        }
    }
    
    public static boolean addCustomer(Customer c){
        try{
        st.executeUpdate("insert into customer values('"+c.getC_name()+"','"+c.getC_email()+"','"+c.getC_addr()+"',"+c.getC_phno()+")");
        return true;
        }
        catch(SQLException e){
            System.err.println("Exception while inserting data.."+e);
        }
        return false;
    }
    public static Customer viewCustomerByName(String name){
        try{
            ResultSet rs = st.executeQuery("select * from customer where cname='"+name+"'");
            if(rs.next()){
                Customer x = new Customer();
                x.setC_name(rs.getString(1));
                x.setC_email(rs.getString(2));
                x.setC_addr(rs.getString(3));
                x.setC_phno(rs.getLong(4));
                return x;
            }
        }
        catch(SQLException e){
            System.err.println("Exception while retrieving data.."+e);
        }
        return null;
    }
    public static Customer[] viewAllCustomers(){
        try{
            ResultSet rs = st.executeQuery("select * from customer");
            if(rs!=null){
                rs.last();
                int i=0,ct = rs.getRow();
                Customer[] clist = new Customer[ct];
                rs.beforeFirst();
                while(rs.next()){
                    clist[i] = new Customer();
                    clist[i].setC_name(rs.getString(1));
                    clist[i].setC_email(rs.getString(2));
                    clist[i].setC_addr(rs.getString(3));
                    clist[i].setC_phno(rs.getLong(4));
                    i++;
                }
                return clist;
            }
            else{
                System.out.println("No data found.");
            }
        }
        catch(SQLException e){
            System.err.println("Exception while retrieving data.."+e);
        }
        return null;
    }
}