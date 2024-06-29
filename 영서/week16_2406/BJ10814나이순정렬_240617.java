package week16_2406;

import java.util.*;

public class BJ10814나이순정렬_240617 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> list = new ArrayList<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            list.add(new Person(age,name,i));
        }
//        list.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getIdx));
        Collections.sort(list);
        for (Person p :list){
            System.out.println(p);
        }
    }//main
    static class Person implements Comparable<Person>{
        int age;
        String name;
        int idx;
        public int getAge() {
            return age;
        }
        public String getName(){
            return name;
        }
        public int getIdx(){
            return idx;
        }
        public Person(int age, String name, int idx){
            this.age=age;
            this.name=name;
            this.idx=idx;
        }
        public String toString(){
            return age+" "+name;
        }

        @Override
        public int compareTo(Person p) {
            int compare = Integer.compare(this.age,p.age);
            if(compare==0){
                return Integer.compare(this.idx,p.idx);
            }else{
                return compare;
            }
        }
    }
}//class