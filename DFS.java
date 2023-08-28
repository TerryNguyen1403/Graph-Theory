import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*input
9
9
1
2
1
3
1
5
2
4
3
6
3
7
3
9
5
8
8
9
 */

public class DFS {
    public static void Solution(List<List<Integer>> adjList, boolean []visited, int vertex){
        System.out.print(vertex+ 1 + " ");
        visited[vertex] = true;

        for (int v : adjList.get(vertex)) {
            if (!visited[v]){
                Solution(adjList,visited,v);
            }
        }

    }
    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int numsVertices = sc.nextInt();
        boolean[] visited = new boolean[numsVertices];

        for (int i = 0; i < numsVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        int numsEdges = sc.nextInt();

        for (int i = 0; i < numsEdges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adjList.get(u-1).add(v-1);
            adjList.get(v-1).add(u-1);
        }

        for (int i = 0; i < numsVertices; i++) {
            System.out.print(i + 1 + ": ");
            for (int edge : adjList.get(i)) {
                System.out.print(edge+ 1 + " ");
            }
            System.out.println();
        }

        Solution(adjList,visited, 0);
        sc.close();
    }
}
