package _213project4stanleyandmatthew.project4;

public class StoreOrders implements Customizable {
    private Order[] orders;
    private int numOrders;
    public static final int NOT_FOUND = -1;
    private static final int INITIAL_SIZE = 1;
    private static final int GROWTH_FACTOR = 1;

    public StoreOrders() {
        this.orders = new Order[INITIAL_SIZE];
        this.numOrders = 0;
    }


    /**
     * Takes an account and returns its index in the AccountDatabase, returns NOT_FOUND if not found.
     *
     * @param item - the account that needs to be found in the AccountDatabase returning its index
     */
    private int find(Order order) {
        for (int i = 0; i < this.orders.length; i++) {
            if (order.equals(this.orders[i])) {
                return i;
            }
        }

        return NOT_FOUND;
    }

    private void grow() {
        Order[] newOrders = new Order[this.orders.length + GROWTH_FACTOR];
        for (int i = 0; i < this.orders.length; i++) {
            newOrders[i] = this.orders[i];
        }
        this.orders = newOrders;
    }

    public boolean add(Object obj) {
        if (this.numOrders == this.orders.length) {
            grow();
        }
        if (obj instanceof Order) {
            Order o = (Order) obj;
            for (int i = 0; i < this.orders.length; i++) {
                if (this.orders[i] == null) {
                    this.orders[i] = o;
                    this.numOrders = this.numOrders + 1;
                    return true;
                }
            }
        }
        return false;
    }

    ;


    public boolean remove(Object obj) {
        if (obj instanceof Order) {
            Order order = (Order) obj;
            int deletionIndex = -1;
            int currentArrIndex = 0;
            Order[] newOrders = new Order[this.orders.length];
            for (int i = 0; i < this.orders.length; i++) {
                if (order.equals(this.orders[i])) {
                    deletionIndex = i;
                }
            }
            if (deletionIndex == -1) {
                return false;
            }
            for (int j = 0; j < this.orders.length; j++) {
                if (j != deletionIndex) {
                    newOrders[currentArrIndex] = this.orders[j];
                    currentArrIndex = currentArrIndex + 1;
                }
            }
            this.orders = newOrders;
            this.numOrders = this.numOrders - 1;
            return true;
        }
        return false;
    }

    public void print() {
        System.out.println(this.orders.length);
        for (int i = 0; i < this.numOrders; i++) {
            System.out.println("ORDER #" + (i + 1));
            System.out.println("--------------");
            this.orders[i].print();
            System.out.println(" ");
        }
    }

}
