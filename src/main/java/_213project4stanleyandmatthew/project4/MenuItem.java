package _213project4stanleyandmatthew.project4;

import java.text.DecimalFormat;

public class MenuItem {

    protected int quantity;
    protected double totalPrice;

    public MenuItem(int quantity){
        this.quantity = quantity;
    }

    public double itemPrice(){
        return 0;
    }

    public void update(int updateQuantity){
        this.totalPrice += updateQuantity * (this.totalPrice / quantity);
        this.quantity += updateQuantity;
    }

    public int getQuantity(){
        return this.quantity;
    }

    @Override
    public String toString(){
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String priceString = decimalFormat.format(this.totalPrice);
        return "QUANTITY:" + this.quantity + "::$" + priceString;
    }

}
