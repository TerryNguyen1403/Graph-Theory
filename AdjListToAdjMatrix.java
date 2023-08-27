import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjListToAdjMatrix {
    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int numsVertices = sc.nextInt();
        int a[][] = new int[numsVertices][numsVertices];

        for (int i = 0; i < numsVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        int numsEdge = sc.nextInt();

        for (int i = 0; i < numsEdge; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adjList.get(u-1).add(v);
            adjList.get(v-1).add(u);
        }

        System.out.println("Adjacency List: ");

        for (int i = 0; i < numsVertices; i++) {
            System.out.print(i + 1 + ": ");
            for (int edge : adjList.get(i)) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < numsVertices; i++) {
            for (int edge : adjList.get(i)) {
                a[i][edge-1] = 1;
            }
        }

        System.out.println("Adjacency Matrix: ");

        for (int i = 0; i < numsVertices; i++) {
            for (int j = 0; j < numsVertices; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}

