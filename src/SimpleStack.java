import java.util.Iterator;

public class SimpleStack<T> implements Iterable<T> {

    private Node last;
    private int size;


    private class Node {

        private final T element;
        private Node previousNode;

        private Node(T element) {
            this.element = element;
        }
    }

    public void add(T element) {
        Node newNode = new Node(element);

        newNode.previousNode = last;
        last = newNode;

        size++;
    }

    public T pop(){
        T result = last.element;
        last = last.previousNode;
        return result;
    }

    public T peek(){
        return last.element;
    }

    public void clear(){
        this.last = null;
        this.size = 0;
    }

    public boolean remove(T element) {

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


    private class SidIterator implements java.util.Iterator<T> {

        private SimpleStack<T>.Node node;

        private SidIterator() {
            node = last;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            T result = node.element;

            if (hasNext()) {
                node = node.previousNode;
            }

            return result;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SidIterator();
    }
}
