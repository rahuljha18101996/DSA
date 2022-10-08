import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ADMGraph {
    public List<ADMNode> nodes;
    public int[][] adjacencyMatrix;
    public ADMGraph(ADMNode...nodes) {
        this.nodes = new ArrayList<>();
        this.nodes.addAll(Arrays.asList(nodes));
        this.adjacencyMatrix =  new int[this.nodes.size()][this.nodes.size()];
    }

    public void addNode(ADMNode node) {
        this.nodes.add(node);
    }
    public void fillMatrix() {
        for (var node : this.nodes) {
            for (var adjNode : node.children()) {
                adjacencyMatrix[node.value()][adjNode.value()] = 1;
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < nodes.size(); i++) {
            System.out.printf("\t%d",i);
        }
        System.out.println();
        int counter = 0;
        for (int[] i : adjacencyMatrix) {
            System.out.printf("%d\t",counter++);
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        ADMNode a0 = new ADMNode(0,new ArrayList<>());
        ADMNode a1 = new ADMNode(1,new ArrayList<>());
        ADMNode a2 = new ADMNode(2,new ArrayList<>());
        ADMNode a3 = new ADMNode(3,new ArrayList<>());

        a0.children().add(a1);
        a1.children().add(a2);
        a2.children().add(a0);
        //a2.children().add(a3);
        a3.children().add(a2);

        ADMGraph graph = new ADMGraph(a0,a1,a2,a3);
        graph.fillMatrix();
        graph.printMatrix();
    }
}
