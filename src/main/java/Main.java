import array.MyArrayList;

import java.util.Comparator;
import java.util.random.RandomGenerator;

public class Main {

    public static void main(String[] args) {


        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 100; i ++) {
            int element = RandomGenerator.getDefault().nextInt(100);
            list.add(list, element);
        }
        System.out.println(list);

        list.sort(list, Comparator.naturalOrder());
        System.out.println(list);


    }
}
