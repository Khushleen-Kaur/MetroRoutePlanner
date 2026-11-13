import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// TODO: Isolation station exception
// TODO: Custom Map and dynamic map creation
// TODO: Add estimated time for travel
class Node{
    String station;
    int distance;
    Node(String station, int distance){
        this.station = station;
        this.distance = distance;
    }
}
public class ShotestRoute {
    MetroGraph graph = new MetroGraph();

    public int shotestDistance(String sorce, String destination){
        HashMap<String, Integer> minDistance = new HashMap<>();
        HashMap<String, String> parent = new HashMap<>();
        PriorityQueue<Node>  pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.distance, b.distance)
        );

        for(Map.Entry<String, HashMap<String,Integer>> station : graph.map.entrySet() ){
            minDistance.put(station.getKey(), Integer.MAX_VALUE);
        }
        minDistance.put(sorce, Integer.MAX_VALUE);
        
        pq.offer(new Node(sorce, 0));
        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(current.distance > minDistance.get(current.station)){
                continue;
            }
            for(Map.Entry<String, Integer> neighbour : graph.map.get(current.station).entrySet()){
                if(neighbour.getValue() + current.distance < minDistance.get(neighbour.getKey())){
                    minDistance.put(neighbour.getKey(), neighbour.getValue() + current.distance);
                    parent.put(neighbour.getKey(), current.station);
                    pq.offer(new Node(neighbour.getKey(), neighbour.getValue() + current.distance));
                }
            }
        }
        List<String> route = new ArrayList<>();
        route.add(0, destination);


        while(parent.containsKey(route.get(0)) && !route.get(0).equals(sorce)){
            route.add(0, parent.get(route.get(0)));
        }

        System.out.println("Sorce: " + sorce);
        System.out.println("Destination: " + destination);
        if(route.size() == 1){
            System.out.println("Route don't Exist.");
            System.out.println("Try with other Location.");
        }else{
            System.out.println("Minimum Distance is: " + minDistance.get(destination) + " km");
            System.out.print("Metro route: ");
            int i = 0;
            for(i = 0; i< route.size() - 1 ; i++){
                System.out.print(route.get(i) + " -> ");
            }
            System.out.print(route.get(i));
        }
        return minDistance.get(destination);
    }
    public static void main(String[] args) {
        ShotestRoute s = new ShotestRoute();
        s.shotestDistance("Khandeshwar", "Nerul");
    }
}
