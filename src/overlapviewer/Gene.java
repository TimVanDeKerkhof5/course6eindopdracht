/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overlapviewer;

/**
 * Gene object. bevat alle variabelen geimporteerd vanuit het aangeleverde bestand. 
 * @author Tim
 */
//class gene bevat alle eigenschappen van de genen in het opgeleverde bestand. 
//voor generieke code is ervoor gekozen om alle in het bestand gevonden variabelen mee te nemen in het object tegenover de vereisten conform de opdracht.
public class Gene implements Comparable<Gene>{

    //fields
    private int TaxID1;
    private int TaxID2;
    private int GeneID1;
    private int GeneID2;
    private String accession1;
    private String accession2;
    private String productName1;
    private String productName2;
    private String interaction;
    private String PMID;
    private String timestamp;
    private String GeneRif;

//constructor
    public Gene(int TaxID1, int TaxID2, int GeneID1, int GeneID2,
            String accession1, String accession2, String productName1,
            String productName2, String interaction, String PMID, String timestamp, String GeneRif) {
        this.TaxID1 = TaxID1;
        this.TaxID2 = TaxID2;
        this.GeneID1 = GeneID1;
        this.GeneID2 = GeneID2;
        this.accession1 = accession1;
        this.accession2 = accession2;
        this.productName1 = productName1;
        this.productName2 = productName2;
        this.interaction = interaction;
        this.PMID = PMID;
        this.timestamp = timestamp;
        this.GeneRif = GeneRif;
    }

//getters en setters van gene hieronder, comparable interface helemaal onderaan.
    public int getTaxID1() {
        return TaxID1;
    }

    public int getTaxID2() {
        return TaxID2;
    }

    public int getGeneID1() {
        return GeneID1;
    }

    public int getGeneID2() {
        return GeneID2;
    }

    public String getAccession1() {
        return accession1;
    }

    public String getAccession2() {
        return accession2;
    }

    public String getProductName1() {
        return productName1;
    }

    public String getProductName2() {
        return productName2;
    }

    public String getInteraction() {
        return interaction;
    }

    public String getPMID() {
        return PMID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getGeneRif() {
        return GeneRif;
    }
//setters van Gene hieronder

    public void setTaxID1(int TaxID1) {
        this.TaxID1 = TaxID1;
    }

    public void setTaxID2(int TaxID2) {
        this.TaxID2 = TaxID2;
    }

    public void setGeneID1(int GeneID1) {
        this.GeneID1 = GeneID1;
    }

    public void setGeneID2(int GeneID2) {
        this.GeneID2 = GeneID2;
    }

    public void setAccession1(String accession1) {
        this.accession1 = accession1;
    }

    public void setAccession2(String accession2) {
        this.accession2 = accession2;
    }

    public void setProductName1(String productName1) {
        this.productName1 = productName1;
    }

    public void setProductName2(String productName2) {
        this.productName2 = productName2;
    }

    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }

    public void setPMID(String PMID) {
        this.PMID = PMID;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setGeneRif(String GeneRif) {
        this.GeneRif = GeneRif;
    }
    
    //comparable interface, zorgt ervoor dat de genelist te sorteren is op basis van GeneID1

    @Override
    public int compareTo(Gene comparenum) {
        return Integer.compare(this.GeneID1, comparenum.getGeneID1());
    }

}
