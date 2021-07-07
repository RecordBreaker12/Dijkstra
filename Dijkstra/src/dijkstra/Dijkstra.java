package dijkstra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {
    private final int dist[];
    private final Set<Integer> colocado;
    private final PriorityQueue<No> pq;
    private final int V;
    List<List<No> > adj;
 
    public Dijkstra(int V){
        this.V = V;
        dist = new int[V];
        colocado = new HashSet<>();
        pq = new PriorityQueue<>(V, new No());
    }
 
    public void dij(List<List<No>> adj, int src){
        this.adj = adj;
        
        for (int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        pq.add(new No(src, 0));
        dist[src] = 0;
        
        while (colocado.size() != V) {
            if(pq.isEmpty()){
                return;
            }
            
            int u = pq.remove().no;
            colocado.add(u);
            e_Vizinhos(u);
        }
    }
 
    private void e_Vizinhos(int u){
        int distCanto;
        int distNova;
 
        for (int i = 0; i < adj.get(u).size(); i++) {
            No v = adj.get(u).get(i);
 
            if (!colocado.contains(v.no)) {
                distCanto = v.custo;
                distNova = dist[u] + distCanto;
 
                if (distNova < dist[v.no]){
                    dist[v.no] = distNova;
                }
                
                pq.add(new No(v.no, dist[v.no]));
            }
        }
    }
 
    public static void main(String arg[]){
        int V = 8;
        //Partindo do 7 com 8 elementos totais (0 ao 7)//
        int source = 7;
 
        List<List<No>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            List<No> item = new ArrayList<>();
            adj.add(item);
        }
        
        adj.get(0).add(new No(2, 4));
        adj.get(0).add(new No(3, 6));
        adj.get(1).add(new No(2, 4));
        adj.get(1).add(new No(3, 3));
        adj.get(1).add(new No(5, 2));
        adj.get(1).add(new No(6, 1));
        adj.get(2).add(new No(0, 4));
        adj.get(2).add(new No(1, 4));
        adj.get(2).add(new No(4, 1));
        adj.get(2).add(new No(5, 1));
        adj.get(3).add(new No(0, 6));
        adj.get(3).add(new No(1, 3));
        adj.get(4).add(new No(2, 1));
        adj.get(4).add(new No(6, 3));
        adj.get(5).add(new No(1, 2));
        adj.get(5).add(new No(2, 1));
        adj.get(5).add(new No(6, 8));
        adj.get(5).add(new No(7, 3));
        adj.get(6).add(new No(1, 1));
        adj.get(6).add(new No(4, 3));
        adj.get(6).add(new No(5, 8));
        adj.get(7).add(new No(5, 3));

        Dijkstra dpq = new Dijkstra(V);
        dpq.dij(adj, source);
 
        System.out.println("The shorted path from node :");
        
        for (int i = 0; i < dpq.dist.length; i++){
            System.out.println(source + " to " + i + " is " + dpq.dist[i]);
        }
    }
}
