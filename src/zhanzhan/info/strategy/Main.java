package zhanzhan.info.strategy;

import java.util.Arrays;

/**
 * @Author 26357
 * @Date 2022/5/9 13:15
 */
public class Main {

    public static void main(String[] args) {

        Cat[] a = {new Cat(3,3),new Cat(5,5),new Cat(1,1)};


        Sorter sorter = new Sorter();
//        sorter.sort(a,new CatWeightComparator());
        sorter.sort(a,new CatHeightComparator());
        System.out.println(Arrays.toString(a));

    }

}
