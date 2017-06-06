package model;

public class Invoice {
    
    private int inv_id;
    private String c_name;
    private int item_list[];
    private int item_count;

    public int getInv_id() {
        return inv_id;
    }

    public void setInv_id(int inv_id) {
        this.inv_id = inv_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int[] getItem_list() {
        return item_list;
    }

    public void setItem_list(int[] item_list) {
        this.item_list = item_list;
    }

    public int getItem_count() {
        return item_count;
    }

    public void setItem_count(int item_count) {
        this.item_count = item_count;
    }

    @Override
    public String toString() {
        return "Invoice{" + "inv_id=" + inv_id + ", c_name=" + c_name + ", item_count=" + item_count + '}';
    }
    
    
}
