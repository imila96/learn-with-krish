
public class Main {
    public static void main(String[] args) {
        TicketCounter ticketCounter = new TicketCounter();

        PremiumPackage b1 = (PremiumPackage) ticketCounter.getPackage(TicketType.Supreme);

       
        System.out.println(b1);

        
        b1.setcheeseType("Mozzarella");
       
        b1.setPreferredBeverage("Pepsi");

      
        System.out.println(b1);

       
        PremiumPackage b2 = (PremiumPackage) ticketCounter.getPackage(TicketType.Supreme);


        System.out.println(b2);
    }
}
