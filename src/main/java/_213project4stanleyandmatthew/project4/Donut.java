package _213project4stanleyandmatthew.project4;

public class Donut extends MenuItem{


    private String flavor;

    public Donut(String flavor, int quantity){
        super(quantity);
        this.flavor = flavor;
    }

    @Override
    public double itemPrice(){
        return 0;
    }

    public String getType(){
        return "Donut";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Donut) {
            Donut d = (Donut) obj;
            return d.flavor.equals(this.flavor);
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
        return this.flavor.toUpperCase() + " " + super.toString();
    }
}
