// package src;

import java.util.HashMap;

public class MetroGraph{
    public HashMap<String, HashMap<String, Integer>> map = new HashMap<>(); 

    MetroGraph(){
        // Hardcoded graph 
        // Station name - List of Adjacent stations and distance from it.
        HashMap<String, Integer> n = new HashMap<>();
        n.put("Kharghar", 7);
        map.put( "Uran", new HashMap<>(n));
        n.clear();
        n.put("Uran", 7);
        n.put("Seawoods", 12);
        n.put("Khandeshwar", 3);
        n.put("Belapur", 5);
        map.put( "Kharghar", new HashMap<>(n));
        n.clear();
        n.put("Kharghar", 12);
        n.put("Belapur", 13);
        n.put("Nerul", 6);
        map.put( "Seawoods", new HashMap<>(n));
        n.clear();
        n.put("Kharghar", 3);
        n.put("Belapur", 4);
        map.put( "Khandeshwar", new HashMap<>(n));
        n.clear();
        n.put("Khandeshwar", 4);
        n.put("Kharghar", 5);
        n.put("Seawoods", 13);
        map.put( "Belapur", new HashMap<>(n));
        n.clear();
        n.put("Seawoods", 6);
        n.put("Chembur", 15);
        map.put("Nerul", new HashMap<>(n));
        n.clear();
        n.put("Nerul", 15);
        map.put( "Chembur", new HashMap<>(n));
    }

}