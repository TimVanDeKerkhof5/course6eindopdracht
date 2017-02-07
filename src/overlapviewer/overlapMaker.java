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
 * functie die de overlappende genen tussen de 2 selectie bepaald
 * @author Tim
 */
public class overlapMaker {
    //aanmaken van verschillende variabelen voor datamanipulatie
    private Map<Integer, Integer> overlap1 = new HashMap<>();
    private Map<Integer, Integer> overlap2 = new HashMap<>();
    
    private Map<Integer, Integer> overlap11 = new HashMap<>();
    private Map<Integer, Integer> overlap22 = new HashMap<>();
    
    private ArrayList<Gene> export = new ArrayList<>();
    private ArrayList<Gene> geneList = new ArrayList<>();
    private String overlapleft;
    private String overlapmiddle;
    private String overlapRight;
    private int counteroverlap1;
    private int counteroverlap2;
    private int onesize;
    private int twosize;
    

   public Map<Integer, Integer> calculateoverlap(String combo1, String combo2){
       counteroverlap1 = 0;
       counteroverlap2 = 0;
       int counter = 0;
       overlap1.clear();
       overlap2.clear();
       overlap11.clear();
       overlap22.clear();
       
       for(Gene g : geneList){
           
           //de interactie in elk gene object vergelijken met de string in de combobox 1
           if(g.getInteraction().equals(combo1)){
               //wanneer deze overeenkomt, voeg deze toe aan de hashmap overlap1, plus een counter
               overlap1.put(counter,g.getGeneID1()); 
               
               //de counter kan worden gebruikt om later in de genelist een object op te halen op basis 
               //van index
               
               //deze counter wordt gebruikt voor statistieken; de totale overeenkomende overlap van 1
               counteroverlap1 += 1;
           }
           //de interactie in elk gene object vergelijken met de string in de combobox 2
           if(g.getInteraction().equals(combo2)){
               //wanneer deze overeenkomt, voeg deze toe aan de hashmap overlap2, plus een counter
               overlap2.put(counter,g.getGeneID1());
               
               //deze counter wordt gebruikt voor statistieken; de totale overeenkomende overlap van 2
               counteroverlap2 += 1;
           }
           //deze counter wordt gebruikt om objecten uit de genelist te halen op basis van index.
           counter += 1;
       }
       //debugging
       //System.out.println(overlap1);
       //System.out.println(overlap2);
       
       //hier wordt de uiteindelijke overlap bepaald.
       //de hashmap wordt gestript tot alleen de overeenkomstige waardes erin zitten
       //er is gekozen voor een hashmap omdat deze de snelste big O heeft, omdat het een aantal for-loops bespaart tegenover andere datastructuren
       //en er id's meegegeven kunnen worden.
       overlap11 = overlap1;
       overlap22 = overlap2;
       System.out.println("herrie hieronder x 4");
       System.out.println(overlap1.size());
       System.out.println(overlap2.size());
       (overlap1.values()).retainAll((overlap2.values()));
       onesize = overlap1.size();
       System.out.println(onesize);
       
       (overlap22.values()).retainAll((overlap11.values()));
       twosize = overlap22.size();
       System.out.println(twosize);
       //meer debugging
       //System.out.println(overlap1);
       
       //de hashmap returnen
       return overlap1;
   }
   
    public Map<Integer, Integer> getOverlap11() {
        return overlap11;
    }

    //begin getters
    public Map<Integer, Integer> getOverlap22() {
        return overlap22;
    }

    public Map<Integer, Integer> getOverlap1() {
        return overlap1;
    }

    public Map<Integer, Integer> getOverlap2() {
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
    
    public void setOverlap11(Map<Integer, Integer> overlap11) {    
        this.overlap11 = overlap11;
    }

//begin setters
    public void setOverlap22(Map<Integer, Integer> overlap22) {    
        this.overlap22 = overlap22;
    }

    public void setOverlap1(Map<Integer, Integer> overlap1) {
        this.overlap1 = overlap1;
    }

    public void setOverlap2(Map<Integer, Integer> overlap2) {
        this.overlap2 = overlap2;
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
