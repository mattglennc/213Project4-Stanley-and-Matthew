package _213project4stanleyandmatthew.project4;

public class CakeDonut extends Donut{

    private final static double CAKE_DONUT_PRICE = 1.79;

    public CakeDonut(String flavor,int quantity){
        super(flavor,quantity);
        super.totalPrice = this.itemPrice();
    }

    @Override
    public double itemPrice(){
        return CAKE_DONUT_PRICE * super.quantity;
    }

    @Override
    public String getType(){
        return "Cake" + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CakeDonut) {
            CakeDonut cd = (CakeDonut) obj;
            return super.equals(cd);
        }
        return false;
    }

    @Override
    public void update(int updateQuantity){
        super.update(updateQuantity);
    }

    @Override
    public int getQuantity(){
        return super.getQuantity();
    }

    @Override
    public String toString(){
        return "CAKEDONUT::" + super.toString();
    }

}
