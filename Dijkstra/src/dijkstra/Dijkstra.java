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
    private final int V;//Vertices
    List<List<No>> adj;
 
    public Dijkstra(int V){
        this.V = V;
        dist = new int[V];
        colocado = new HashSet<>();
        pq = new PriorityQueue<>(V, new No());
    }
 
    //Algoritmo de Dijkstra
    public void dij(List<List<No>> adj, int src, String srcName){
        this.adj = adj;
        
        for (int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        //Adicionar ponto de partida para o Queue e alocando 
        //sua distancia como 0
        pq.add(new No(src, srcName, 0));
        dist[src] = 0;
        
        while (colocado.size() != V) {
            if(pq.isEmpty()){
                return;
            }
            
            //remover node de minima distancia
            int u = pq.remove().no;
            
            //adicionar o node com distancia finalizada
            colocado.add(u);
            e_Vizinhos(u);
        }
    }
    
    //Processador dos vizinhos do node passado
    private void e_Vizinhos(int u){
        int distCanto;
        int distNova;
 
        //Para todos os vizinhos de v
        for (int i = 0; i < adj.get(u).size(); i++) {
            No v = adj.get(u).get(i);
            
            //Se o node atual ainda nao foi processado
            if (!colocado.contains(v.no)) {
                distCanto = v.custo;
                distNova = dist[u] + distCanto;
                
                //Se a nova distancia for mais "barata"
                if (distNova < dist[v.no]){
                    dist[v.no] = distNova;
                }
                
                //Adicionar node atual ao Queue
                pq.add(new No(v.no, v.nome, dist[v.no]));
            }
        }
    }
 
    public static void main(String arg[]){
        int V = 20;
        //Partindo do 7 com 8 elementos totais (0 ao 7)//
        int source = 0;
        String sourceName = "Arad";
 
        //Lista de adjacencia
        List<List<No>> adj = new ArrayList<>();
        
        //Inicializar todos os nodes
        for (int i = 0; i < V; i++) {
            List<No> item = new ArrayList<>();
            adj.add(item);
        }
        
        //Inputs de acordo com o grafo ---------------------------------->
        //Arad
        adj.get(0).add(new No(0, "Arad", 0));
        adj.get(0).add(new No(1, "Zerind", 75));
        adj.get(0).add(new No(2, "Sibui", 140));
        adj.get(0).add(new No(3, "Timisoara", 118));
        //Zerind
        adj.get(1).add(new No(1, "Zerind", 0));
        adj.get(1).add(new No(0, "Arad", 75));
        adj.get(1).add(new No(4, "Oradea", 71));
        //Sibui
        adj.get(2).add(new No(2, "Sibui", 0));
        adj.get(2).add(new No(0, "Arad", 140));
        adj.get(2).add(new No(4, "Oradea", 151));
        adj.get(2).add(new No(5, "Fagaras", 99));
        adj.get(2).add(new No(6, "Rimnicu Vilcea", 80));
        //Timisoara
        adj.get(3).add(new No(3, "Timisoara", 0));
        adj.get(3).add(new No(0, "Arad", 118));
        adj.get(3).add(new No(7, "Lugoj", 111));
        //Oradea
        adj.get(4).add(new No(4, "Oradea", 0));
        adj.get(4).add(new No(1, "Zerind", 71));
        adj.get(4).add(new No(2, "Sibui", 151));
        //Fagaras
        adj.get(5).add(new No(5, "Fagaras", 0));
        adj.get(5).add(new No(2, "Sibui", 99));
        adj.get(5).add(new No(8, "Bucharest", 211));
        //Rimnicu Vilcea
        adj.get(6).add(new No(6, "Rimnicu Vilcea", 0));
        adj.get(6).add(new No(2, "Sibui", 80));
        adj.get(6).add(new No(9, "Craiova", 146));
        adj.get(6).add(new No(10, "Pitesti", 97));
        //Lugoj
        adj.get(7).add(new No(7, "Lugoj", 0));
        adj.get(7).add(new No(3, "Timisoara", 111));
        adj.get(7).add(new No(11, "Mehadia", 70));
        //Bucharest
        adj.get(8).add(new No(8, "Bucharest", 0));
        adj.get(8).add(new No(5, "Fagaras", 211));
        adj.get(8).add(new No(10, "Pitesti", 101));
        adj.get(8).add(new No(12, "Giurgiu", 90));
        adj.get(8).add(new No(13, "Urziceni", 85));
        //Craiova
        adj.get(9).add(new No(9, "Craiova", 0));
        adj.get(9).add(new No(6, "Rimnicu Vilcea", 146));
        adj.get(9).add(new No(10, "Pitesti", 138));
        adj.get(9).add(new No(14, "Dobreta", 120));
        //Pitesti
        adj.get(10).add(new No(10, "Pitesti", 0));
        adj.get(10).add(new No(6, "Rimnicu Vilcea", 97));
        adj.get(10).add(new No(8, "Bucharest", 101));
        adj.get(10).add(new No(9, "Pitesti", 138));
        //Mehadia
        adj.get(11).add(new No(11, "Mehadia", 0));
        adj.get(11).add(new No(7, "Lugoj", 70));
        adj.get(11).add(new No(14, "Dobreta", 75));
        //Giurgiu
        adj.get(12).add(new No(12, "Giurgiu", 0));
        adj.get(12).add(new No(8, "Bucharest", 90));
        //Urziceni
        adj.get(13).add(new No(13, "Urziceni", 0));
        adj.get(13).add(new No(8, "Bucharest", 85));
        adj.get(13).add(new No(15, "Vaslui", 142));
        adj.get(13).add(new No(16, "Hirsova", 98));
        //Dobreta
        adj.get(14).add(new No(14, "Dobreta", 0));
        adj.get(14).add(new No(9, "Craiova", 120));
        adj.get(14).add(new No(11, "Mehadia", 75));
        //Vaslui
        adj.get(15).add(new No(15, "Vaslui", 0));
        adj.get(15).add(new No(13, "Urziceni", 142));
        adj.get(15).add(new No(17, "Iasi", 92));
        //Hirsova
        adj.get(16).add(new No(16, "Hirsova", 0));
        adj.get(16).add(new No(13, "Urziceni", 98));
        adj.get(16).add(new No(18, "Eforie", 86));
        //Iasi
        adj.get(17).add(new No(17, "Iasi", 0));
        adj.get(17).add(new No(15, "Vaslui", 92));
        adj.get(17).add(new No(19, "Neamt", 87));
        //Eforie
        adj.get(18).add(new No(18, "Eforie", 0));
        adj.get(18).add(new No(16, "Hirsova", 86));
        //Neamt
        adj.get(19).add(new No(19, "Neamt", 0));
        adj.get(19).add(new No(17, "Iasi", 87));
        

        //Calcular o caminho mais curto a partir do source
        Dijkstra dpq = new Dijkstra(V);
        dpq.dij(adj, source, sourceName);
 
        System.out.println("O caminho mais curto do:");
        
        for (int i = 0; i < dpq.dist.length; i++){
            System.out.println(sourceName + " a " + adj.get(i).get(0).nome + " foi " + dpq.dist[i]);
        }
    }
}
