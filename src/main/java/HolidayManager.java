public class HolidayManager {
    private final ShortestPathManager shortestPathManager;


    // Dependency Injection is cool => https://1024kb.pl/programowanie/java/dependency-injection/
    public HolidayManager(ShortestPathManager shortestPathManager) {
        this.shortestPathManager = shortestPathManager;
    }

    public int getShortestPath(String fileName, int source, int destination) {
        // Load graph from file to Graph object
        // You can also create another class for convert loaded matrix to graph object
        // It's up to you

        Graph graph = null;
        return shortestPathManager.getShortestPath(graph, source, destination);
    }
}
