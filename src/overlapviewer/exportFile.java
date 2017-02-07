/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overlapviewer;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author Tim
 */
public class exportFile {
    private static final String FILENAME = "C:\\Users\\Tim\\Desktop\\export.txt";
    ArrayList<Gene> genelist = new ArrayList<>();
    BufferedWriter bw = null;
    FileWriter fw = null;
    String header;

    exportFile(ArrayList<Gene> geneList, String header) {
        this.genelist = geneList;
        this.header = header;
    }

    public void exportAll() {
        try {
            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            Collections.sort(genelist);
            bw.write(header + "\n");
            for (Gene g : genelist) {
                String TaxID1 = Integer.toString(g.getTaxID1());
                String TaxID2 = Integer.toString(g.getTaxID2());
                String GeneID1 = Integer.toString(g.getGeneID1());
                String GeneID2 = Integer.toString(g.getGeneID2());
                String accession1 = g.getAccession1();
                String accession2 = g.getAccession2();
                String productName1 = g.getProductName1();
                String productName2 = g.getProductName2();
                String interaction = g.getInteraction();
                String PMID = g.getPMID();
                String timestamp = g.getTimestamp();
                String GeneRif = g.getGeneRif();
                bw.write("\n" + TaxID1 + "\t" + GeneID1 + "\t" + accession1 + "\t" + productName1
                        + "\t" + interaction + "\t" + TaxID2 + "\t" + GeneID2 + "\t" + accession2 + "\t" + productName2
                        + "\t" + PMID + "\t" + timestamp + "\t" + GeneRif);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "er was een input/output error!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "er was een input/output error!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void exportPub() {
        try {
            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            bw.write(header + "\n");
            Collections.sort(genelist);
            for (Gene g : genelist) {
                String TaxID1 = Integer.toString(g.getTaxID1());
                String TaxID2 = Integer.toString(g.getTaxID2());
                String GeneID1 = Integer.toString(g.getGeneID1());
                String GeneID2 = Integer.toString(g.getGeneID2());
                String accession1 = g.getAccession1();
                String accession2 = g.getAccession2();
                String productName1 = g.getProductName1();
                String productName2 = g.getProductName2();
                String interaction = g.getInteraction();
                String PMID = g.getPMID();
                String timestamp = g.getTimestamp();
                String GeneRif = g.getGeneRif();
                if (PMID != "") {
                    bw.write("\n" + TaxID1 + "\t" + GeneID1 + "\t" + accession1 + "\t" + productName1
                            + "\t" + interaction + "\t" + TaxID2 + "\t" + GeneID2 + "\t" + productName2
                            + "\t" + PMID + "\t" + timestamp + "\t" + GeneRif);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "er was een input/output error!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {

                JOptionPane.showMessageDialog(null, "er was een input/output error!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
