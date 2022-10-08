import java.util.List;

public record ADLNode(int value, List<ADLNode> children) {
    public boolean isAdjacent(ADLNode node) {
        for (ADLNode n : node.children()) {
            if (n == this) return true;
        }
        return false;
    }
}
