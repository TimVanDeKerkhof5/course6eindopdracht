/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overlapviewer;

import java.io.File;
import javax.swing.JFileChooser;

/**
 * methode om een bestand te kiezen. returned een filepath.
 * @author Tim
 */
public class kiesBestand {
    //standaard filechooser, een browser openen en een pad returnen.
    String filepath;
    public String getPath(){
        JFileChooser kiesbestand = new JFileChooser();
        int returnValue = kiesbestand.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION){
            File selectedFile = kiesbestand.getSelectedFile();
            System.out.println(selectedFile.getName());
            filepath = selectedFile.getPath();
            System.out.println(filepath);
            
            
        }
        return filepath;
    }
}
