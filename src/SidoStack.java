import java.util.Iterator;

public class SidoStack implements Iterable<Integer> {

    private Node last;
    private int size;


    private static class Node {

        private final int element;
        private Node previousNode;

        private Node(int element) {
            this.element = element;
        }
    }

    public SidoStack() {
        this.last = null;
    }

    public void add(int element) {
        Node newNode = new Node(element);

        newNode.previousNode = last;
        last = newNode;

        size++;
    }

    public boolean remove(int element) {

        if (last.element == element) {
            last = last.previousNode;
            size--;
            return true;
        }

        Node node = last;

        while (node.previousNode != null) {

            if (node.previousNode.element == element) {
                node.previousNode = node.previousNode.previousNode;
                size--;
                return true;
            }

            node = node.previousNode;
        }

        return false;
    }

    public int getSize() {
        return size;
    }


    private class SidIterator implements java.util.Iterator<Integer> {

        private SidoStack.Node node;

        private SidIterator() {
            node = last;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Integer next() {
            int result = node.element;

            if (hasNext()) {
                node = node.previousNode;
            }

            return result;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SidIterator();
    }
}
