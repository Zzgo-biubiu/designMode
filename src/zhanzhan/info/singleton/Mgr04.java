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
public class Mgr04 {

    private static Mgr04 INSTANCE;

    private Mgr04(){

    }

    //也就是说，当调用这个实例的时候会检查一下是否为空，为空就初始化一个实例，不为空就不初始化
    public static synchronized Mgr04 getInstance(){
        if(INSTANCE == null){
            //模拟访问停顿
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args){
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr04.getInstance().hashCode());
            }).start();
        }
    }

}
