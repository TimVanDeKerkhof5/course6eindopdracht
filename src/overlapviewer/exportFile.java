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
 * functie om op 2 manieren een bestand te exporteren.
 *
 * @author Tim
 */
public class exportFile {

    //filename, hardcoded, pas deze aan om het pad te veranderen.
    private static final String FILENAME = "C:\\Users\\Tim\\Desktop\\export.txt";
    //arraylist om de overlapgenen op te slaan en te exporteren
    ArrayList<Gene> genelist = new ArrayList<>();
    //writer aanmaken
    BufferedWriter bw = null;
    FileWriter fw = null;
    //string aanmaken om header op te slaan
    String header;

    exportFile(ArrayList<Gene> geneList, String header) {
        this.genelist = geneList;
        this.header = header;
    }

    /**
     * functie om alle overlappende genen te exporteren.
     */
    public void exportAll() {
        try {
            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            //genelist sorteren op basis van GeneID1 (comparable interface
            Collections.sort(genelist);
            //het schrijven van de header

            try {
                //wanneer de lijst leeg is, throw de custom exception om export te voorkomen
                if (genelist.isEmpty()) {
                    throw new geneListEmptyException();
                } else {
                    bw.write(header + "\n");
                    for (Gene g : genelist) {
                        //alle informatie in variabelen zetten, voor beter overzicht
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
                        //informatie naar het bestand schrijven
                        bw.write("\n" + TaxID1 + "\t" + GeneID1 + "\t" + accession1 + "\t" + productName1
                                + "\t" + interaction + "\t" + TaxID2 + "\t" + GeneID2 + "\t" + accession2 + "\t" + productName2
                                + "\t" + PMID + "\t" + timestamp + "\t" + GeneRif);
                    }
                }
            } catch (geneListEmptyException ex) {
                //custom exception om aan te geven dat de genelist leeg is.
                JOptionPane.showMessageDialog(null, "genelist is leeg!", "Error",
                        JOptionPane.ERROR_MESSAGE);
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

    /**
     * functie om alleen genen te exporteren die pubmed IDs bevatten, verder
     * hetzelfde als de functie exportAll.
     */
    public void exportPub() {
        try {
            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            try {
                //wanneer de lijst leeg is, throw de custom exception om export te voorkomen
                if (genelist.isEmpty()) {
                    throw new geneListEmptyException();
                } else {
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
                }
            } catch (geneListEmptyException ex) {
                //pop up om aan te geven dat de genelist leeg is, en deze dus niet wordt geexporteerd
                JOptionPane.showMessageDialog(null, "genelist is leeg!", "Error",
                    JOptionPane.ERROR_MESSAGE);
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
