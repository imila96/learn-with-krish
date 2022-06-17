
import java.util.HashMap;
import java.util.Map;

public class TicketCounter {

    private Map<TicketType, Package> ticketRegistry = new HashMap<>();

    public TicketCounter() {
        this.initialize();
    }

  
    private void initialize() {
        BasicPackage basic
                = new BasicPackage("Thin Crust","Large");

        PremiumPackage premium
                = new PremiumPackage("Mayo Base","Small","Crusty","Coke");

        ticketRegistry.put(TicketType.Basic, basic);
        ticketRegistry.put(TicketType.Supreme, premium);

    }

    public Package getPackage(TicketType ticketType){
        Package pkg = null;
        try {
            pkg = (Package) ticketRegistry.get(ticketType);
        }catch (Exception err){
            System.err.println(err.getMessage());
        }
        return pkg;
    }
}
