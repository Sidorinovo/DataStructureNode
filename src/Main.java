import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        SidoStack coll = new SidoStack();
        coll.add(1);
        coll.add(2);
        coll.add(3);
        coll.add(4);
        coll.add(4);
        coll.add(4);
        coll.add(4);
        coll.add(5);
        coll.add(6);
        coll.remove(4);
        coll.remove(4);
        coll.remove(4);

        Iterator<Integer> iterator = coll.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println();
    }
}
