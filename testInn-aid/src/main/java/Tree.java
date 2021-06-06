public class Tree {
    private Node root;

    public Tree(){
        root=null;
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.getValue()) {
            current.setLeftChild(addRecursive(current.getLeftChild(), value));
        } else if (value > current.getValue()) {
            current.setRightChild(addRecursive(current.getRightChild(), value));
        } else {
            return current;
        }
        return current;
    }

    public void add(int value){
        root=addRecursive(root,value);
    }

    public int countLeaf(Node current) {
        int currCount=0;

        if(current.getLeftChild()!=null){
            currCount+=countLeaf(current.getLeftChild());
        } else if(current.getRightChild()!=null){
            currCount+=countLeaf(current.getRightChild());
        }
        currCount++;
        return currCount;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
