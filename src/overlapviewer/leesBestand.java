/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overlapviewer;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * methode om een bestand in te lezen, returned inhoud of header
 * @author Tim
 */
public class leesBestand {
    //een filereader die alles returned in een enkele string, behalve de header, die wordt apart gereturned. alles inclusief exception handling.
    String line;
    String header;
    ArrayList<String> inhoud = new ArrayList<>();
    public ArrayList<String> read(String path){
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            while ((line = in.readLine()) != null){
                if(line.contains("#")){
                    header = line;
                    System.out.println(header);
                }
                else{
                    inhoud.add(line);
                    
                }
        }
        } catch (FileNotFoundException ex) {
            //popup voor een file not found error
            JOptionPane.showMessageDialog(null, "er was een probleem met het openen van de file!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            //popup voor een input/output error
            JOptionPane.showMessageDialog(null, "er was een input/output fout!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
        }
        //fileinhoud returnen in de vorm van een arraylist
        return inhoud; 
        
    }
    public String getTitle(){
        //header van het bestand returnen in de vorm van een string
        return header;
    }
    
}