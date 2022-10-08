public class Node {
    private int data;
    private Node leftNode;
    private Node rightNode;
    public Node(int data) {
        this.data = data;
        leftNode = null;
        rightNode = null;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public int getData() {
        return data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }
}
