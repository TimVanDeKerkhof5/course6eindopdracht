/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overlapviewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Tim
 */
public class overlapMaker {
    static Map<Integer, Integer> overlap1 = new HashMap<>();
    static Map<Integer, Integer> overlap2 = new HashMap<>();
    static Map<Integer, Integer> finaloverlap = new HashMap<>();
    private ArrayList<Gene> export = new ArrayList<>();
    private ArrayList<Gene> geneList = new ArrayList<>();
    private String overlapleft;
    private String overlapmiddle;
    private String overlapRight;
    private int counteroverlap1;
    private int counteroverlap2;
    

   public Map<Integer, Integer> calculateoverlap(String combo1, String combo2){
       counteroverlap1 = 0;
       counteroverlap2 = 0;
       int counter = 0;
       overlap1.clear();
       overlap2.clear();
       
       for(Gene g : geneList){
           
           
           if(g.getInteraction().equals(combo1)){
               overlap1.put(counter,g.getGeneID1()); 
               counteroverlap1 += 1;
           }
           if(g.getInteraction().equals(combo2)){
               overlap2.put(counter,g.getGeneID1());
               counteroverlap2 += 1;
           }
           counter += 1;
       }
       System.out.println(overlap1);
       System.out.println(overlap2);
       (overlap1.values()).retainAll((overlap2.values()));
       System.out.println(overlap1);
       return overlap1;
   }

   //begin getters
    public static Map<Integer, Integer> getOverlap1() {
        return overlap1;
    }

    public static Map<Integer, Integer> getOverlap2() {
        return overlap2;
    }

    public ArrayList<Gene> getExport() {
        return export;
    }

    public String getOverlapleft() {
        return overlapleft;
    }

    public String getOverlapmiddle() {
        return overlapmiddle;
    }

    public String getOverlapRight() {
        return overlapRight;
    }

    public ArrayList<Gene> getGeneList() {
        return geneList;
    }

    public int getCounteroverlap1() {
        return counteroverlap1;
    }

    public int getCounteroverlap2() {
        return counteroverlap2;
    }
    
    
//begin setters
    public static void setOverlap1(Map<Integer, Integer> overlap1) {
        overlapMaker.overlap1 = overlap1;
    }

    public static void setOverlap2(Map<Integer, Integer> overlap2) {
        overlapMaker.overlap2 = overlap2;
    }

    public void setExport(ArrayList<Gene> export) {
        this.export = export;
    }

    public void setOverlapleft(String overlapleft) {
        this.overlapleft = overlapleft;
    }

    public void setOverlapmiddle(String overlapmiddle) {
        this.overlapmiddle = overlapmiddle;
    }

    public void setOverlapRight(String overlapRight) {
        this.overlapRight = overlapRight;
    }

    public void setGeneList(ArrayList<Gene> geneList) {
        this.geneList = geneList;
    }

    public void setCounteroverlap1(int counteroverlap1) {
        this.counteroverlap1 = counteroverlap1;
    }

    public void setCounteroverlap2(int counteroverlap2) {
        this.counteroverlap2 = counteroverlap2;
    }
    
    
  
    
    
}
