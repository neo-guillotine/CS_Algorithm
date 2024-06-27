package week16_2406;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        List<Sort> list = new ArrayList<>();

        list.add(new Sort(1,1));
        list.add(new Sort(1,1));
        list.add(new Sort(2,2));
        list.add(new Sort(3,3));
        list.add(new Sort(4,4));
        list.add( new Sort(5,1));
        list.add(new Sort(5,2));


        list.sort((Sort s1, Sort s2)->(s1.time-s2.time));

        System.out.println(list);
        list.sort(Comparator.comparing(Sort::getTime).reversed().thenComparing(Sort::getId));
        System.out.println(list);

    }//main
    static class Sort{
        int time;
        int id;


        Sort(int time, int id){
            this.time= time;
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public int getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "Sort{" +
                    "time=" + time +
                    ", id=" + id +
                    '}';
        }
    }//Sort
}//class
