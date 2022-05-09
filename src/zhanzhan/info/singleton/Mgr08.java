package zhanzhan.info.singleton;

/**
 * 枚举单例（完美中的完美），不仅可以解决线程同步，还可以防止反序列化
 * 基本上，掌握01的写法就可以了，不过能够掌握08写法就更棒
 */
public enum Mgr08 {

    INSTANCE;

    public void m(){}

    public static void main(String[] args){
        for(int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr08.INSTANCE.hashCode());
            }).start();
        }
    }

}
