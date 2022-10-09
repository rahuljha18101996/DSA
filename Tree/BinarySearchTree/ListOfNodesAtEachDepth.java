import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* PROBLEM STATEMENT
* Given a binary tree design an algorithm which create a linked list of all the nodes at each depth (e.g, if you have a tree with depth/levels d, you'll have d linked list.)
* 
* Suppose a Tree be like below:
*           6
*        /    \
*     3         9
*    / \       / \
*   1   4     7  10
*    \   \     \     \
*     2   5      8   11
* 
* Output be like:
* [[6],[3,9],[1,4,7,10],[2,5,8,11]]
* 
* Algorithm for the problem
* Step 1: Declare a list of list of node e.g,  List<List<Node>> as list
* Step 2: Create a Queue of Node as queue
* Step 3: Add root of Binary tree to the queue
* Step 4: Iterate until queue is empty (Step 5 - Step 9)
* Step 5: Get current size of queue as size
* Step 6: Create a new list as newList
* Step 7: Iterate size times (Step 8 - Step 9)
* Step 8: Get & Remove front node from the queue and add it to the newList
* Step 9: Add left and right node of the current node if exists to the queue
* return list
* */

public class ListOfNodesAtEachDepth {
    private static void PrintingNodesDepthWise(List<List<Node>> list) {
         for (List<Node> ln : list) {
            for (Node n : ln) {
                System.out.print(n.getData() + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Node>> getList(BinarySearchTree bst) {
        List<List<Node>> list = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(bst.root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> nodes = new LinkedList<>();
            for (int i = 1; i <= size; i++) {
                Node x = queue.poll();
                if (x != null) {
                    nodes.add(x);
                    if (x.getLeftNode() != null) {
                        queue.add(x.getLeftNode());
                    }
                    if (x.getRightNode() != null) {
                        queue.add(x.getRightNode());
                    }
                }
            }
            list.add(nodes);
        }
        return list;
    }
}
