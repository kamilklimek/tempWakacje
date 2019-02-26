import java.util.Set;

// It's your container for your graph
// Keep graph as like you wanna
public class Graph {
    public static final int EDGE_NO_EXIST = -1;
    private final Set<Node> nodes;

    public Graph(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public Node getNodeByName(int name) {
        return nodes.stream().filter(n -> n.getName() == name).findFirst().get();
    }
}
