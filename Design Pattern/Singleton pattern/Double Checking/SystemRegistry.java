class SystemRegistry {

 
    private volatile static SystemRegistry _instance;

   
    private SystemRegistry() {
        ;
    }

   
    public static SystemRegistry getInstance() {
        
        if (_instance == null) {
           
            synchronized (SystemRegistry.class) {
                if (_instance == null) {
                    
                    _instance = new SystemRegistry();
                }
            }
        }
        // Return the singleton static instance
        return _instance;
    }

  
}