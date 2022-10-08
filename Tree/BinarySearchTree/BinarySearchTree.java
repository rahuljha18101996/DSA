public class BinarySearchTree {
    public Node root;
    public BinarySearchTree() {
        root = null;
    }
    public boolean addNode(final int data) {
        Node node = new Node(data);
        if (root == null) {
            System.out.printf("root = %d%n", node.getData());
            root = node;
        }else {
            Node x = root;
            while (!((x.getData() >= data && x.getLeftNode() == null) || (x.getData() < data && x.getRightNode() == null))) {
                if (x.getData() >= data && x.getLeftNode() != null) {
                    x = x.getLeftNode();
                }else if (x.getData() < data && x.getRightNode() != null) {
                    x = x.getRightNode();
                }else {
                    return false;
                }
            }
            if (x.getData() >= data && x.getLeftNode() == null) {
                System.out.printf("%d's left = %d%n",x.getData(), node.getData());
                x.setLeftNode(node);
            }else if (x.getData() < data && x.getRightNode() == null) {
                System.out.printf("%d's right = %d%n",x.getData(), node.getData());
                x.setRightNode(node);
            }else {
                return false;
            }
        }
        return true;
    }
}
