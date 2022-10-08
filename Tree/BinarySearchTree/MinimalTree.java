public class MinimalTree {
    public static void main(String[] args) {
        int[] dataValues = {1,2,3,4,5,6,7,8,9,10,11};
        BinarySearchTree bst = new BinarySearchTree();
        try {
            addNode(dataValues,0, dataValues.length  - 1,bst);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void addNode(int[] array, int low, int high, BinarySearchTree bst) throws Exception {
        if (low > high) return;

        int mid = (low + high) / 2;
        if (!bst.addNode(array[mid])) {
            throw new Exception("Binary Search Tree Cannot be formed!");
        }
        addNode(array,low,mid - 1,bst);
        addNode(array, mid + 1,high,bst);
    }
}
