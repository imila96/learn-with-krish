package Emp;

public class Test {
    public static void main(String[] args) {

        
        Employee.Builder builder = new Employee.Builder("Andrew");
        Employee e1 = builder.email("andrew@rmail.com").age(22).mobileNumber(0777777777).build();
        System.out.println("Andrew");
        System.out.println(e1);

        
        Employee.Builder builder1 = new Employee.Builder("Simonds");
        
        Employee e2 = builder1.email("simonds@rmail.com").age(24).mobileNumber(0700000000).build();
        System.out.println("Simonds");
        System.out.println(e2);

        
    }
}
