package Softuniada2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Mafia {

    private static int[][] graph;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        while (!"end".equals(input)) {
            counter++;
            int n = Integer.parseInt(input);
            graph = new int[n][n];
            parent = new int[n];
            while ((input = reader.readLine()).split(" ").length > 1) {
                String[] tokens = input.split(" ");
                int capacity = Integer.parseInt(tokens[1]);
                tokens = tokens[0].split("-");
                int v1 = Integer.parseInt(tokens[0]) - 1;
                int v2 = Integer.parseInt(tokens[1]) - 1;
                graph[v1][v2] = capacity;
                graph[v2][v1] = capacity;
            }
            int maxFlow = findMaxFlow();
            sb.append("Group ").append(counter).append(": ").append(maxFlow).append(System.lineSeparator());
        }
        System.out.print(sb);
    }

    private static int findMaxFlow() {
        for (int i = 0; i < parent.length; i++) parent[i] = -1;
        int maxFlow = 0;
        int start = 0;
        int end = graph.length - 1;
        while (BFS(start, end)) {
            int pathFlow = Integer.MAX_VALUE;
            int currentNode = end;
            while (currentNode != start) {
                int prevNode = parent[currentNode];
                int currentFlow = graph[prevNode][currentNode];
                if (currentFlow > 0 && currentFlow < pathFlow) {
                    pathFlow = currentFlow;
                }
                currentNode = prevNode;
            }
            maxFlow += pathFlow;
            currentNode = end;
            while (currentNode != start) {
                int prevNode = parent[currentNode];
                graph[prevNode][currentNode] -= pathFlow;
                graph[currentNode][prevNode] += pathFlow;
                currentNode = prevNode;
            }
        }
        return maxFlow;
    }

    private static boolean BFS(int start, int end) {
        boolean[] visited = new boolean[graph.length];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int child = 0; child < graph[node].length; child++) {
                if (graph[node][child] > 0 && !visited[child]) {
                    queue.offer(child);
                    parent[child] = node;
                    visited[child] = true;
                }
            }
        }
        return visited[end];
    }
}