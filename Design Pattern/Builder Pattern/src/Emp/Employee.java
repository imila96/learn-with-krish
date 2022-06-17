package Emp;

public class Employee {

    private final String name;
    private final String email;
    private final int age;
    private final int mobileNumber;

    public Employee(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.mobileNumber = builder.mobileNumber;
    }


    static class Builder{

        private String name;
        private String email;
        private int age;
        private int mobileNumber;

        public Builder(String name) {
            this.name = name;
        }
        //return employee to main
        public Employee build() {
            return new Employee(this);
        }

        //for add details of builders variables - START
        public Builder name(String name) {
            this.name = name;

            return this;
        }

        public Builder email(String email) {
            this.email = email;

            return this;
        }

        public Builder age(int age) {
            this.age = age;

            return this;
        }

        public Builder mobileNumber(int mobileNumber) {
            this.mobileNumber = mobileNumber;

            return this;
        }

    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", mobileNumber=" + mobileNumber +
                '}';
    }
}
