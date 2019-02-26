import org.junit.Assert;
import org.junit.Test;

public class ShortestPathManagerTest {
    
    ShortestPathManager shortestPathManager = new ShortestPathManager(new DijkstraAlgorithm());


    @Test
    public void testFindTheShortestPath() {
        Graph graph = new GraphLoader().loadGraphByFileName("src/test/resources/graph_one");

        int result = shortestPathManager.getShortestPath(graph, 2, 3);

        Assert.assertEquals(17, result);
    }
}
