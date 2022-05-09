package zhanzhan.info.strategy;

/**
 * @Author 26357
 * @Date 2022/5/9 13:07
 */
public class Cat implements Comparable<Cat>{

    int weight,height;

    public Cat(int weight,int height){
        this.weight=weight;
        this.height=height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(Cat c) {
        if(this.weight<c.weight) {
            return -1;
        } else if(this.weight>c.weight) {
            return 1;
        } else {
            return 0;
        }
    }
}