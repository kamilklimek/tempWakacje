import sun.java2d.loops.GeneralRenderer;

import java.util.*;
import java.util.stream.Collectors;

public class DijkstraAlgorithm implements ShortestPathAlgorithm {
    public int getShortestPath(Graph graph, int source, int destination) {
        Node sourceNode = graph.getNodeByName(source);
        sourceNode.setDistance(0f);

        Set<Node> visitedNodes = new HashSet<>();
        Set<Node> nonVisitedNodes = new HashSet<>();

        nonVisitedNodes.add(sourceNode);

        while (!nonVisitedNodes.isEmpty()) {
            Node currentNode = getMinDistance(nonVisitedNodes);

            nonVisitedNodes.remove(currentNode);

            for (Map.Entry<Node, Float> entryNode : currentNode.getAdjacentNodes().entrySet()) {
                Node node = entryNode.getKey();
                Float weight = entryNode.getValue();

                if (!visitedNodes.contains(node) && weight != Graph.EDGE_NO_EXIST && currentNode.getDistance() + weight < node.getDistance()) {
                    node.setDistance(currentNode.getDistance() + weight);
                    nonVisitedNodes.add(node);
                }

            }

            visitedNodes.add(currentNode);
        }

        List<Float> weights = visitedNodes.stream().map(Node::getDistance).collect(Collectors.toList());

        return getResult(visitedNodes).getDistance().intValue();
    }

    private Node getMinDistance(Set<Node> nonVisitedNodes) {
        return nonVisitedNodes.stream()
                .sorted(Comparator.comparing(Node::getDistance))
                .collect(Collectors.toList())
                .get(0);
    }


    private Node getResult(Set<Node> nonVisitedNodes) {
        return nonVisitedNodes.stream()
                .sorted(Comparator.comparing(Node::getDistance))
                .collect(Collectors.toList())
                .get(1);
    }
}
