package model;

public class Customer {
    
    private String c_name;
    private String c_email;
    private String c_addr;
    private long c_phno;

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_email() {
        return c_email;
    }

    public void setC_email(String c_email) {
        this.c_email = c_email;
    }

    public String getC_addr() {
        return c_addr;
    }

    public void setC_addr(String c_addr) {
        this.c_addr = c_addr;
    }

    public long getC_phno() {
        return c_phno;
    }

    public void setC_phno(long c_phno) {
        this.c_phno = c_phno;
    }

    @Override
    public String toString() {
        return "Customer{" + "c_name=" + c_name + ", c_email=" + c_email + ", c_addr=" + c_addr + ", c_phno=" + c_phno + '}';
    }
    
}
