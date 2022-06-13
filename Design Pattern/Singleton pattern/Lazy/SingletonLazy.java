class SingletonLazy {
    private static volatile SingletonLazy uniqueInstance = null;
    private int data = 0;

    private SingletonLazy(){ }

    private static class SingletonHelper {
        private static final SingletonLazy uniqueInstance = new SingletonLazy();
    }
    public static  SingletonLazy getInstance(){
        return SingletonHelper.uniqueInstance;
    }

    public void setData(int data){
        System.out.println(data);
        this.data = data;
    }

    public int getData() {
        return data;
    }
}