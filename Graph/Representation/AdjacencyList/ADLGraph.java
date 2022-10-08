import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ADLGraph {
    public List<ADLNode> nodes;
    public ADLGraph(ADLNode...nodes) {
        this.nodes = new ArrayList<>();
        this.nodes.addAll(Arrays.asList(nodes));
    }

    public void addNode(ADLNode node) {
        this.nodes.add(node);
    }
    public void print() {
        System.out.println("Graph Representation Using Adjacency List:");
        for (var node : this.nodes) {
            System.out.print(node.value() + ": ");
            for (var adjacentNode : node.children()) {
                System.out.print(adjacentNode.value() + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        ADLNode a0 = new ADLNode(0,new ArrayList<>());
        ADLNode a1 = new ADLNode(1,new ArrayList<>());
        ADLNode a2 = new ADLNode(2,new ArrayList<>());
        ADLNode a3 = new ADLNode(3,new ArrayList<>());
        ADLNode a4 = new ADLNode(4,new ArrayList<>());
        ADLNode a5 = new ADLNode(5,new ArrayList<>());
        ADLNode a6 = new ADLNode(6,new ArrayList<>());

        a0.children().add(a1);
        a1.children().add(a2);
        a2.children().add(a0);
        a2.children().add(a3);
        a3.children().add(a2);
        a4.children().add(a6);
        a5.children().add(a4);
        a6.children().add(a5);

        ADLGraph graph = new ADLGraph(a0,a1,a2,a3,a4,a5,a6);
        graph.print();
    }
}
