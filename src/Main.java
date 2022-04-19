import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        SimpleStack<Integer> coll = new SimpleStack<>();
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

        SimpleStack<String> stringColl = new SimpleStack<>();

        stringColl.add("Sido");
        stringColl.add("Sedo");
        stringColl.add("Spido");
        stringColl.add("SidLo");
        stringColl.add("SidMo");

        Iterator<Integer> iterator = coll.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(coll.peek());

        Tree.TreeNode<Integer> node = new Tree.TreeNode<>(13);
        Tree<String> tree = new Tree<>("Sido");


        System.out.println();
    }
}
