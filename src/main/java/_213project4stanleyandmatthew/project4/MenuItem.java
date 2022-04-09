package _213project4stanleyandmatthew.project4;

/**
 * This MenuItem class provides the data fields, constructors and methods to be inherited
 * and implemented by subclasses of MenuItem.
 *
 * @author Matthew Carrascoso & Stanley Chou
 */
public class MenuItem {

    protected int quantity;
    protected double totalPrice;

    /**
     * Constructor to create instance of MenuItem class.
     * @param quantity Integer quantity field associated with this item.
     */
    public MenuItem(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Calculates the item's price.  Because the MenuItem class is an unspecified item on
     * it only returns 0.
     * @return The calculated MenuItem price based on quantity.
     */
    public double itemPrice() {
        return 0;
    }

    /**
     * Changes the quantity and price of MenuItem instance by entered amount.
     * @param updateQuantity Amount by which to change MenuItem quantity.
     */
    public void update(int updateQuantity) {
        this.totalPrice += updateQuantity * (this.totalPrice / quantity);
        this.quantity += updateQuantity;
    }

    /**
     * Returns Integer quantity of MenuItem instance.
     * @return Quantity of MenuItem instance.
     */
    public int getQuantity() {
        return this.quantity;
    }


    /**
     * Returns string representation of MenuItem.
     * @return String representation of MenuItem Instance.
     */
    @Override
    public String toString() {
        return " (" + this.quantity + ")";
    }

}
