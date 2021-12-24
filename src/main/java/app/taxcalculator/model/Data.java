package app.taxcalculator.model;

public class Data {

    private int s_no;
    private int amount;
    private int item_type;
    private boolean isTaxCalculate;
    private double tax;

    public Data(int s_no, int amount, int item_type) {
        this.s_no = s_no;
        this.amount = amount;
        this.item_type = item_type;
        isTaxCalculate = false;
        tax = 0;
    }

    public Data(int s_no, int amount, int item_type, boolean isTaxCalculate) {
        this.s_no = s_no;
        this.amount = amount;
        this.item_type = item_type;
        this.isTaxCalculate = isTaxCalculate;
    }

    public int getS_no() {
        return s_no;
    }

    public void setS_no(int s_no) {
        this.s_no = s_no;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getItem_type() {
        return item_type;
    }

    public void setItem_type(int item_type) {
        this.item_type = item_type;
    }

    public boolean isTaxCalculate() {
        return isTaxCalculate;
    }

    public void setTaxCalculate(boolean taxCalculate) {
        this.isTaxCalculate = taxCalculate;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
