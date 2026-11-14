package PersonalizedMap;

public class Validation {
    PersonalizedGraph graph = new PersonalizedGraph(); 
    public boolean isValid(String station){
        return graph.personalizedMap.containsKey(station);
    }
}
