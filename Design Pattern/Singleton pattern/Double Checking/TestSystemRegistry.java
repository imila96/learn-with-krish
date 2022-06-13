
class TestSystemRegistry {

    public static void main(String[] args) {

        // Create the user 
        SystemRegistry regeditWindow1 = SystemRegistry.getInstance();
        SystemRegistry regeditWindow2 = SystemRegistry.getInstance();

        // Print the active user 
    
        System.out.println("A user is editing the registry file: "  + regeditWindow1); 
        System.out.println("Another user is editing the registry file: " + regeditWindow2);

       
    }
}