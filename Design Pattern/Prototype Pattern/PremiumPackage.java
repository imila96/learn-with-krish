
public class PremiumPackage extends Package{
    private String cheeseType;
    private String preferredBeverage;

    public PremiumPackage() {
    }

    public PremiumPackage(String pizzaType, String pizzaSize, String cheeseType, String preferredBeverage) {
        super(pizzaType, pizzaSize);
        this.cheeseType = cheeseType;
        
        this.preferredBeverage = preferredBeverage;
    }

    public String getcheeseType() {
        return cheeseType;
    }

    public void setcheeseType(String cheeseType) {
        this.cheeseType = cheeseType;
    }


    public String getPreferredBeverage() {
        return preferredBeverage;
    }

    public void setPreferredBeverage(String preferredBeverage) {
        this.preferredBeverage = preferredBeverage;
    }

    @Override
    public String toString() {
        return "Package{" +
                ", pizzaType='" + getpizzaType() + '\'' +
                ", pizzaSize='" + getpizzaSize() + '\''  +
                ", cheeseType='" + cheeseType + '\'' +
                ", preferredBeverage='" + preferredBeverage + '\'' +
                '}';
    }
}
