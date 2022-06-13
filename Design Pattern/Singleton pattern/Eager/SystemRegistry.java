
class SystemRegistry {

  
    private static SystemRegistry _instance = new SystemRegistry(); // Providing the singleton with an eager initialization

   
    private SystemRegistry() {
        
    }

    public static SystemRegistry getInstance() { // Return the singleton static instance
        
        return _instance;
    }

}