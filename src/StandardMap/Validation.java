package StandardMap;

import java.util.HashMap;

public class Validation {
    public boolean isValid(String station){
        StandardGraph graph = new StandardGraph();
        return graph.map.containsKey(station);
    }
}
