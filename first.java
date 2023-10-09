import java.util.*;
public class first {

    static class Node implements Comparable<Node> {
        long u;
        long d;
        public Node(long u, long d) {
            this.u = u;
            this.d = d;
        }
        public int compareTo(Node other) {
            return Long.compare(d, other.d);
        }

        public long getU() {
            return u;
        }

        public void setU(int u) {
            this.u = u;
        }

        public long getD() {
            return d;
        }

        public void setD(int d) {
            this.d = d;
        }
    }

    private static final long INF = Long.MAX_VALUE;


    private static long[] dijkstra(List<List<Edge>> adjList, int start , long[] dist) {
        int n = adjList.size();

        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = (int) curr.u;
            int d = (int) curr.d;
            if (d > dist[u]) {
                continue;
            }
            for (Edge e : adjList.get(u)) {
                int v = (int) e.a2;
                int w = (int) e.a1;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int t = scanner.nextInt();
        int s = scanner.nextInt();
        int k =scanner.nextInt();

        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            adjList.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() ;
            int v = scanner.nextInt() ;
            int w = scanner.nextInt();
            adjList.get(u).add(new Edge(v, w));
            adjList.get(v).add(new Edge(u, w));
        }



        long [] dist = new long[n+10];
        dijkstra(adjList , s , dist);


        boolean w =true;
        for (int i = 0; i < k; i++) {
            if(dist[t]>=dist[scanner.nextInt()])w=false;

        }

        if(w) System.out.println(dist[t]);
        else System.out.println("impossible");


    }



    static class Edge {

        long a1;
        long a2;
        public Edge(int v, int w) {
            this.a2 = v;
            this.a1 = w;
        }

        public long getA1() {
            return a1;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public long getA2() {
            return a2;
        }

        public void setA2(int a2) {
            this.a2 = a2;
        }
    }



}