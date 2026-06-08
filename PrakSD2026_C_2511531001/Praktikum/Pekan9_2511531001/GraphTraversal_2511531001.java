package Pekan9_2511531001;
import java.util.*;
public class GraphTraversal_2511531001 {
	private Map <String, List <String>> graph_1001 = new HashMap <> ();
	
	//Menambahkan edge (graf tak berarah)
	public void addEdge_1001 (String node1_1001, String node2_1001) {
		graph_1001.putIfAbsent(node1_1001, new ArrayList<>());
		graph_1001.putIfAbsent(node2_1001, new ArrayList<>());
		graph_1001.get(node1_1001).add(node2_1001);
		graph_1001.get(node2_1001).add(node1_1001);
	}
	
	//menampilkan graf awal
	public void printGraph_1001() {
		System.out.println("Graf Awal (Adjancency List) : ");
		for (String node_1001 : graph_1001.keySet()) {
			System.out.print(node_1001 + "-> ");
			List<String> neighbors_1001 = graph_1001.get(node_1001);
			System.out.println(String.join(",", neighbors_1001));
		}
		System.out.println();
	}
	
	//DFS rekursif 
	public void dfs_1001 (String start_1001) {
		Set <String> visited_1001 = new HashSet <>();
		System.out.println("Penelusuran DFS : ");
		dfsHelper_1001(start_1001,visited_1001);
		System.out.println();
	}
	
	private void dfsHelper_1001 (String current_1001, Set <String> visited_1001) {
		if (visited_1001.contains(current_1001)) return;
		visited_1001.add(current_1001);
		System.out.print(current_1001 + " ");
		for (String neighbor_1001 : graph_1001.getOrDefault(current_1001, new ArrayList<>())) {
			dfsHelper_1001(neighbor_1001, visited_1001);
		}
	}
	
	private void bfs_1001 (String start_1001) {
		Set<String> visited_1001 = new HashSet <>();
		Queue <String> queue_1001 = new LinkedList<>();
		queue_1001.add(start_1001);
		visited_1001.add(start_1001);
		System.out.println("Penelusuran BFS :");
		while (!queue_1001.isEmpty()) {
			String current_1001 = queue_1001.poll();
			System.out.print(current_1001 + " ");
			for (String neighbot_1001 : graph_1001.getOrDefault(current_1001, new ArrayList<>())) {
				if (!visited_1001.contains(neighbot_1001)) {
					queue_1001.add(neighbot_1001);
					visited_1001.add(neighbot_1001);
				}
			}
		}
		System.out.println();
	}
	//main
	public static void main (String [] Args) {
		GraphTraversal_2511531001 graph_1001 = new GraphTraversal_2511531001();
		
		//contoh graf = A-B, A-C, B-D, B-E
		graph_1001.addEdge_1001("A", "B");
		graph_1001.addEdge_1001("A", "C");
		graph_1001.addEdge_1001("B", "D");
		graph_1001.addEdge_1001("B", "E");
		
		//cetak graph awal
		System.out.println("Graf Awal adalah : ");
		graph_1001.printGraph_1001();
		
		//lakukan penelusuran
		graph_1001.dfs_1001("A");
		graph_1001.bfs_1001("A");
	}
}
