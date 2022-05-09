package zhanzhan.info.singleton;

/**
 * @Author 26357
 * @Date 2022/5/9 11:24
 *
 * 这种是属于饿汉式，只要类加载到内存，就实例化一个单例，而且还是线程安全的（比较简单，推荐使用）
 * 唯一缺点：不管用到与否，类装载是就完成实例化（话说你不用，你加载它干啥）
 * 单例模式的使用：先把构造方法设计成私有的，别人new不了，然后再调用getInstance，不管调用多少次，都会保证是这个对象
 */
public class Mgr01 {

    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01(){};

    public static Mgr01 getInstance(){return INSTANCE;}

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);
    }

}
