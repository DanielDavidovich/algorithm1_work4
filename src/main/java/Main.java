
public class Main {
    public static void main(String[] args) {

        System.out.println("====== Question 1 - DAG ======");
        // גרף לדוגמה A=0, B=1, C=2, D=3
        DAGPathCounter.Graph g = new DAGPathCounter.Graph(4);
        g.addEdge(0, 1); // A -> B
        g.addEdge(0, 2); // A -> C
        g.addEdge(1, 3); // B -> D
        g.addEdge(2, 3); // C -> D
        g.addEdge(1, 2); // B -> C



        int[] paths = g.countPathsToNodes();
        String[] names = {"A", "B", "C", "D"};
        for (int i = 0; i < paths.length; i++) {
            System.out.println("Number of paths to node " + names[i] + ": " + paths[i]);
        }


        System.out.println("====== Question 2 - Coloring ======");


        class ColorArrayDP {

            public static int countEvenRedColorings(int n) {
                int[][] dp = new int[n + 1][2]; // dp[i][0] = even, dp[i][1] = odd
                dp[0][0] = 1; // 0 תאים, מספר זוגי של אדומים (0)

                for (int i = 1; i <= n; i++) {
                    dp[i][0] = 2 * dp[i - 1][0] + dp[i - 1][1]; // כחול/ירוק על זוגי + אדום על אי-זוגי
                    dp[i][1] = 2 * dp[i - 1][1] + dp[i - 1][0]; // כחול/ירוק על אי-זוגי + אדום על זוגי
                }

                return dp[n][0]; // זוגי בלבד
            }
        }

        for (int n = 0; n <= 10; n++) {
            int result = ColorArrayDP.countEvenRedColorings(n);
            System.out.println("Number of valid colorings for n = " + n + ": " + result);
        }

    }
}