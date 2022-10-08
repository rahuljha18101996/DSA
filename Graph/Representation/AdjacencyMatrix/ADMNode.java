import java.util.List;
public record ADMNode(int value, List<ADMNode> children) {
    public boolean isAdjacent(ADMNode node) {
        for (ADMNode n : node.children()) {
            if (n == this) return true;
        }
        return false;
    }
}
