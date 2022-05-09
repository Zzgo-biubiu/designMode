package zhanzhan.info.singleton;

/**
 * @Author 26357
 * @Date 2022/5/9 11:34
 *
 * lazy loding 懒汉式加载
 * 虽然达到了按需初始化的目的，但却带来了线程不安全的问题
 *
 * 什么安全问题呢？
 *  当第一个线程进入的时候，判断为null,则准备初始化，但是与此同时，初始化还未开始，
 *  但是第二个线程进入，判断也为null,那么就有可能出现连续初始化两个或者多个实例的情况，
 *  所以就会引发问题？那么会引发什么问题呢？【需要处理】那么有没有更好更完善的方式呢？加锁synchronized，但是加锁之后效率会下降
 *
 */
public class Mgr05 {

    private static Mgr05 INSTANCE;

    private Mgr05(){

    }

    //这种加锁方式也不行，主要是判断和锁不是一体化的，那该怎么解决呢？
    public static Mgr05 getInstance(){
        if(INSTANCE == null) {
            synchronized (Mgr05.class) {
                //模拟访问停顿
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args){
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr05.getInstance().hashCode());
            }).start();
        }
    }

}
