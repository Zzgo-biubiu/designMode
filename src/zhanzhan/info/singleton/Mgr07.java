package zhanzhan.info.singleton;

/**
 * @Author 26357
 * @Date 2022/5/9 11:34
 *
 *  更加优雅的写法一：静态内部内的写法
 *
 *
 *
 */
public class Mgr07 {

    private Mgr07(){};

    //这个和01比较就是，不会主动加载，还是一个被动加载的形式
    // 【静态内部类当你外面的类加载的时候，这个静态内部类是不会被加载的，只有当你调用getInstance的时候才会被加载，靠JVM的机制来保证线程安全的】
    // 虚拟机加载类的时候只加载一次，jvm内部保证，所以这个内部类也只加载一次，然后导致INSTANCE也只加载一次
    private static class Mgr07Holder{
        private final static Mgr07 INSTANCE = new Mgr07();
    }


    public static Mgr07 getInstance(){
        return Mgr07Holder.INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
       for(int i=0;i<100;i++){
           new Thread(()->{
               System.out.println(Mgr07.getInstance().hashCode());
           }).start();
       }
    }

}
