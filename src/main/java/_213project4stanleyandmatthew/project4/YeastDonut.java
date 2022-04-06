package _213project4stanleyandmatthew.project4;

public class YeastDonut extends Donut {

    private final static double YEAST_DONUT_PRICE = 1.59;

    public YeastDonut(String flavor, int quantity) {
        super(flavor, quantity);
        super.totalPrice = this.itemPrice();
    }

    @Override
    public double itemPrice() {
        return YEAST_DONUT_PRICE * super.quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof YeastDonut) {
            YeastDonut yd = (YeastDonut) obj;
            return super.equals(yd);
        }
        return false;
    }


    @Override
    public void update(int updateQuantity) {
        super.update(updateQuantity);
    }

    @Override
    public int getQuantity() {
        return super.getQuantity();
    }

    @Override
    public String toString() {
        return "Yeast Donut " + super.toString();
    }


}
