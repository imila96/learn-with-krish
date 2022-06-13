public class TestSingletonLazy {
    public static void main(String[] args) {

        SingletonLazy s = SingletonLazy.getInstance();
        s.setData(33);

        System.out.println("First reference: " + s);
        System.out.println("Singleton data value is: " + s.getData());

        SingletonLazy s2 = SingletonLazy.getInstance();
        s.setData(38);

        System.out.println("First reference: " + s2);
        System.out.println("Singleton data value is: " + s2.getData());

    }
}