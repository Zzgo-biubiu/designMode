package zhanzhan.info.strategy;

/**
 * @Author 26357
 * @Date 2022/5/9 13:38
 */
public class CatHeightComparator implements Comparator<Cat>{

    @Override
    public int compare(Cat o1, Cat o2) {
        if(o1.height<o2.height) {
            return -1;
        } else if(o1.height>o2.height) {
            return 1;
        } else {
            return 0;
        }
    }
}
