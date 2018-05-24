package Softuniada2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DurinsLabyrinth {

    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int[] depths;
    private static int[] lowpoint;
    private static Integer[] parent;
    private static Set<Integer> articulationPoints = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());
        initialize(reader, vertices, edges);
        for (int node = 0; node < vertices; node++) {
            if (!visited[node]) {
                getArticulationPoints(node, 1);
            }
        }
        List<Integer> path = findPath(-1);
        Set<Integer> filteredArtPoints = new HashSet<>();
        for (Integer vertex : path) {
            if (articulationPoints.contains(vertex)) {
                filteredArtPoints.add(vertex);
            }
        }
        Set<Integer> unavoidableRooms = new HashSet<>();
        for (Integer artPoint : filteredArtPoints) {
            if (findPath(artPoint) == null) {
                unavoidableRooms.add(artPoint);
            }
        }
        printResult(path, unavoidableRooms);
    }

    private static void printResult(List<Integer> path, Set<Integer> unavoidableRooms) {
        StringBuilder sb = new StringBuilder();
        long sum = 0;
        for (Integer child : path) {
            if (unavoidableRooms.contains(child)) {
                sb.append(child).append("->");
                sum += child;
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sum);
        System.out.println(sb);
    }

    private static List<Integer> findPath(int taboo) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];
        int[] prev = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            prev[i] = -1;
        }
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (vertex == taboo) {
                continue;
            }
            if (vertex == graph.length - 1) {
                break;
            }
            for (Integer child : graph[vertex]) {
                if (!visited[child]) {
                    prev[child] = vertex;
                    queue.offer(child);
                    visited[child] = true;
                }
            }
        }
        if (prev[graph.length - 1] == -1) {
            return null;
        }
        LinkedList<Integer> path = new LinkedList<>();
        int current = graph.length - 1;
        while (prev[prev[current]] != -1) {
            path.push(prev[current]);
            current = prev[current];
        }
        return path;
    }

    @SuppressWarnings("unchecked")
    private static void initialize(BufferedReader reader, int vertices, int edges) throws IOException {
        graph = new ArrayList[vertices];
        visited = new boolean[graph.length];
        depths = new int[graph.length];
        lowpoint = new int[graph.length];
        parent = new Integer[graph.length];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges; i++) {
            String[] tokens = reader.readLine().split(" ");
            int v1 = Integer.parseInt(tokens[0]);
            int v2 = Integer.parseInt(tokens[1]);
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
    }

    private static void getArticulationPoints(int vertex, int depth) {
        visited[vertex] = true;
        depths[vertex] = depth;
        lowpoint[vertex] = depth;
        int childrenCount = 0;
        boolean isArticulationPoint = false;
        for (Integer child : graph[vertex]) {
            if (!visited[child]) {
                parent[child] = vertex;
                getArticulationPoints(child, depth + 1);
                childrenCount++;
                if (lowpoint[child] >= depths[vertex]) {
                    isArticulationPoint = true;
                }
                lowpoint[vertex] = Math.min(lowpoint[vertex], lowpoint[child]);
            } else if (parent[vertex] != child) {
                lowpoint[vertex] = Math.min(lowpoint[vertex], depths[child]);
            }
        }
        if ((parent[vertex] == null && childrenCount > 1) || (parent[vertex] != null && isArticulationPoint)) {
            articulationPoints.add(vertex);
        }
    }
}