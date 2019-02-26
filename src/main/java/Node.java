import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Node {
    private final int name;
    private Map<Node, Float> adjacentNodes = new HashMap<>();
    private Float distance = Float.MAX_VALUE;


    public Node(int name) {
        this.name = name;
    }

    public void addAdjacentNode(Node node, Float weight) {
        adjacentNodes.put(node, weight);
    }

    public int getName() {
        return name;
    }

    public Map<Node, Float> getAdjacentNodes() {
        return adjacentNodes;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Float getWeightForNode(int name) {
        return adjacentNodes.get(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return getName() == node.getName() &&
                Objects.equals(getAdjacentNodes(), node.getAdjacentNodes()) &&
                Objects.equals(getDistance(), node.getDistance());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getAdjacentNodes(), getDistance());
    }
}
