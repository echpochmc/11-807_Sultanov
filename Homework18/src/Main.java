import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        GenericLinkedList<String> str = new GenericLinkedList<>();
        str.add("abc");
        str.add("qwerty");
        str.add("xzcvxcv");
        String s = str.get(0);


        GenericLinkedList<Integer> l2 = new GenericLinkedList<>();

        //classic using iterator of MyArrayList
        Iterator<String> iter = str.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        //foreach using iterator
        for (String str1 : str) {
            System.out.println(str1.toUpperCase());
        }
    }
}
