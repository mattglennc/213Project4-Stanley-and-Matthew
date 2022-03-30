package _213project4stanleyandmatthew.project4;

import java.text.DecimalFormat;

public class Order implements Customizable{

    private MenuItem[] menuItems;
    private int numItems;
    public static final int NOT_FOUND = -1;
    private static final int INITIAL_SIZE = 1;
    private static final int GROWTH_FACTOR = 1;

    public Order(){
        this.menuItems = new MenuItem[INITIAL_SIZE];
        this.numItems = 0;
    }

    /**
     * Takes an account and returns its index in the AccountDatabase, returns NOT_FOUND if not found.
     *
     * @param item - the account that needs to be found in the AccountDatabase returning its index
     */
    private int find(MenuItem item) {
        for (int i = 0; i < this.menuItems.length; i++) {
            if (item.equals(this.menuItems[i])) {
                return i;
            }
        }

        return NOT_FOUND;
    }

    private void grow() {
        MenuItem[] newItems = new MenuItem[this.menuItems.length + GROWTH_FACTOR];
        for (int i = 0; i < this.menuItems.length; i++) {
            newItems[i] = this.menuItems[i];
        }
        this.menuItems = newItems;
    }

    public boolean add(Object obj){
        if (this.numItems == this.menuItems.length) {
            grow();
        }
        if (obj instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) obj;
            if (find(menuItem) != NOT_FOUND) {
                int found = find(menuItem);
                this.menuItems[found].update(menuItem.getQuantity());
                return true;
            } else {
                for (int i = 0; i < this.menuItems.length; i++) {
                    if (this.menuItems[i] == null) {
                        this.menuItems[i] = menuItem;
                        this.numItems = this.numItems + 1;
                        return true;
                    }
                }
            }
        }
            return false;
        }


    public boolean remove(Object obj){
        if(obj instanceof MenuItem){
            MenuItem menuItem = (MenuItem)obj;
            int deletionIndex = -1;
            int currentArrIndex = 0;
            for(int i = 0; i < this.menuItems.length; i++){
                if(menuItem.equals(this.menuItems[i])){
                    deletionIndex = i;
                }
            }
            if(deletionIndex == -1){
                return false;
            }
            if(menuItem.getQuantity() < this.menuItems[deletionIndex].getQuantity()){
                this.menuItems[deletionIndex].update(-1 * menuItem.getQuantity());
                return true;
            }
            MenuItem[] newItems = new MenuItem[this.menuItems.length];
            for(int j = 0; j < this.menuItems.length; j++){
                if( j!= deletionIndex){
                    newItems[currentArrIndex] = this.menuItems[j];
                    currentArrIndex = currentArrIndex + 1;
                }
            }
            this.menuItems = newItems;
            this.numItems = this.numItems - 1;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Order) {
            Order o = (Order) obj;
            boolean sameLength = o.numItems == this.numItems;
            if(!sameLength){
                return false;
            }

            for(int i = 0; i < this.menuItems.length; i++){
                if(o.find(this.menuItems[i]) == NOT_FOUND){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public double finalCost(){
        double cost = 0;
        for (int i = 0; i < this.numItems; i++) {
            cost+=(this.menuItems[i].totalPrice);
        }
        return cost;
    }

    public void print() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        for (int i = 0; i < this.numItems; i++) {
            System.out.println(this.menuItems[i].toString());
        }
        System.out.println("--------------");
        System.out.println("TOTAL:$" + decimalFormat.format(finalCost()));
    }


}
