package _213project4stanleyandmatthew.project4;

public class Coffee extends MenuItem implements Customizable {

    private int size;
    private final static double SHORT_PRICE = 1.69;
    private final static double SIZE_INCREASE = 0.40;
    private final static double ADD_ON = 0.30;
    private String[] addIns;
    private int numAddIns;
    public static final int NOT_FOUND = -1;
    private static final int INITIAL_SIZE = 0;
    private static final int GROWTH_FACTOR = 1;
    private final static String[] SIZES = {"SHORT", "TALL", "GRANDE", "VENTI"};

    public Coffee(int quantity, int size) {
        super(quantity);
        this.size = size;
        this.addIns = new String[INITIAL_SIZE];
        this.numAddIns = 0;
        super.totalPrice = this.itemPrice();
    }

    public boolean add(Object obj) {
        if (this.numAddIns == this.addIns.length) {
            grow();
        }
        if (obj instanceof String) {
            String addIn = (String) obj;
            if (find(addIn) != NOT_FOUND) {
                return false;
            } else {
                for (int i = 0; i < this.addIns.length; i++) {
                    if (this.addIns[i] == null) {
                        this.addIns[i] = addIn;
                        this.numAddIns = this.numAddIns + 1;
                        this.totalPrice += ADD_ON * this.quantity;
                        return true;
                    }
                }
            }
            return false;
        }

        return false;
    }

    ;

    public boolean remove(Object obj) {
        if (obj instanceof String) {
            String addIn = (String) obj;
            int deletionIndex = -1;
            int currentArrIndex = 0;
            String[] newAddIns = new String[this.addIns.length - GROWTH_FACTOR];
            for (int i = 0; i < this.addIns.length; i++) {
                if (addIn.equals(this.addIns[i])) {
                    deletionIndex = i;
                }
            }
            if (deletionIndex == -1) {
                return false;
            }
            for (int j = 0; j < this.addIns.length; j++) {
                if (j != deletionIndex) {
                    newAddIns[currentArrIndex] = this.addIns[j];
                    currentArrIndex = currentArrIndex + 1;
                }
            }
            this.addIns = newAddIns;
            this.numAddIns = this.numAddIns - 1;
            return true;
        }
        return false;
    }

    private void grow() {
        String[] newAddIns = new String[this.addIns.length + GROWTH_FACTOR];
        for (int i = 0; i < this.addIns.length; i++) {
            newAddIns[i] = this.addIns[i];
        }
        this.addIns = newAddIns;
    }

    @Override
    public double itemPrice() {
        double resultPrice = SHORT_PRICE;
        resultPrice += this.size * SIZE_INCREASE;
        return resultPrice * super.quantity;
    }

    private int find(String addIn) {
        for (int i = 0; i < this.addIns.length; i++) {
            if (addIn.equals(this.addIns[i])) {
                return i;
            }
        }

        return NOT_FOUND;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coffee) {
            Coffee c = (Coffee) obj;
            boolean sameSize = c.size == this.size;
            boolean sameLength = c.numAddIns == this.numAddIns;
            if (!sameLength) {
                return false;
            }
            for (int i = 0; i < this.addIns.length; i++) {
                if (c.find(this.addIns[i]) == NOT_FOUND) {
                    return false;
                }
            }
            return sameSize;
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
        String result = "COFFEE::";
        String sizeString = SIZES[this.size] + "::";
        String addInsString = "ADD-INS:";
        if (this.numAddIns == 0) {
            addInsString = addInsString + "NONE::";
        } else {
            for (int i = 0; i < addIns.length; i++) {
                if (i == addIns.length - 1) {
                    addInsString = addInsString + addIns[i] + "::";
                } else {
                    addInsString = addInsString + addIns[i] + "+";
                }
            }
        }
        return result + sizeString + addInsString + super.toString();
    }

}
