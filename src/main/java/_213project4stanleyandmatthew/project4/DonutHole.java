package _213project4stanleyandmatthew.project4;

public class DonutHole extends Donut{

    private final static double DONUT_HOLE_PRICE = 0.39;

    public DonutHole(String flavor, int quantity){
        super(flavor,quantity);
        super.totalPrice = this.itemPrice();
    }

    @Override
    public double itemPrice(){
        return DONUT_HOLE_PRICE * super.quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DonutHole) {
            DonutHole dh = (DonutHole) obj;
            return super.equals(dh);
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
        return "DONUTHOLE::" + super.toString();
    }


}
