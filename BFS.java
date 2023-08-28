import java.util.*;
/* input
10
11
1
2
1
3
1
5
1
10
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
6
7
*/
public class BFS {
    public static void Solution(List<List<Integer>> adjList, boolean[] visited, int vertex){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        visited[vertex] = true;

        while (!queue.isEmpty()){
            int u = queue.peek();
            System.out.print(u + 1 + " ");
            queue.poll();

            for (int v : adjList.get(u)) {
                if (!visited[v]){
                    queue.offer(v);
                    visited[v] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> adjList = new ArrayList<>();

        int numsVertices = sc.nextInt();

        boolean[] visited = new boolean[numsVertices];

        for (int i = 0; i < numsVertices; i++) {
            visited[i] = false;
            adjList.add(new ArrayList<>());
        }

        int numsEdges = sc.nextInt();

        for (int i = 0; i < numsEdges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adjList.get(u-1).add(v-1);
            adjList.get(v-1).add(u-1);
        }

        Solution(adjList, visited, 0);
    }
}
