import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tree<T> {

    public static class TreeNode<T> {

        private T element;
        private boolean hasParent;
        private List<TreeNode<T>> children;

        public TreeNode(T element) {
            if (element == null) {
                throw new IllegalArgumentException("Cannot insert null value!");
            }

            this.element = element;
            this.children = new ArrayList<>();


        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public List<TreeNode<T>> getChildren() {
            return Collections.unmodifiableList(children);
        }

        public void addChild(TreeNode<T> child) {
            if (child == null) {
                throw new IllegalArgumentException("Cannot insert null value!");
            }

            if (child.hasParent) {
                throw new IllegalArgumentException("Child already adopted!");
            }

            child.hasParent = true;
            this.children.add(child);
        }

        public TreeNode<T> getChild(int index) {
            if (index >= this.children.size() || index < 0) {
                throw new IllegalArgumentException("Index " + index + " is invalid!");
            }

            return this.getChildren().get(index);
        }
    }

    private final TreeNode<T> root;

    public Tree(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot insert null value!");
        }

        this.root = new TreeNode<>(element);
    }

    @SafeVarargs
    public Tree(T element, Tree<T>... children) {
        this(element);

        for (Tree<T> child : children) {
            this.root.addChild(child.root);
        }
    }

    public TreeNode<T> getRoot() {
        return this.root;
    }

    public List<TreeNode<T>> getChildNodes (){
        return this.root.getChildren();
    }
}
