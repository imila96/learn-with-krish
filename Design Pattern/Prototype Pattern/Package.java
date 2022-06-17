
public abstract class Package implements Cloneable{
	
    private String pizzaType;
    private String pizzaSize;
    

    public Package() {
    }

    public Package(String pizzaType, String pizzaSize) {
        this.pizzaType = pizzaType;
        this.pizzaSize = pizzaSize;
       
    }

    public String getpizzaType() {
        return pizzaType;
    }

    public void setpizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public String getpizzaSize() {
        return pizzaSize;
    }

    public void setpizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Package{" +
                ", pizzaType='" + pizzaType + '\'' +
                ", pizzaSize='" + pizzaSize+ '\'' +
                '}';
    }
}
