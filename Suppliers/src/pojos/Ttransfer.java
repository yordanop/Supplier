package pojos;
// Generated 1/12/2016 09:36:38 AM by Hibernate Tools 4.3.1



/**
 * Ttransfer generated by hbm2java
 */
public class Ttransfer  implements java.io.Serializable {


     private Integer idTransfer;
     private Tevents tevents;
     private Tproducts tproducts;
     private int quantity;
     private String rfc;

    public Ttransfer() {
    }

	
    public Ttransfer(Tevents tevents, int quantity, String rfc) {
        this.tevents = tevents;
        this.quantity = quantity;
        this.rfc = rfc;
    }
    public Ttransfer(Tevents tevents, Tproducts tproducts, int quantity, String rfc) {
       this.tevents = tevents;
       this.tproducts = tproducts;
       this.quantity = quantity;
       this.rfc = rfc;
    }
   
    public Integer getIdTransfer() {
        return this.idTransfer;
    }
    
    public void setIdTransfer(Integer idTransfer) {
        this.idTransfer = idTransfer;
    }
    public Tevents getTevents() {
        return this.tevents;
    }
    
    public void setTevents(Tevents tevents) {
        this.tevents = tevents;
    }
    public Tproducts getTproducts() {
        return this.tproducts;
    }
    
    public void setTproducts(Tproducts tproducts) {
        this.tproducts = tproducts;
    }
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getRfc() {
        return this.rfc;
    }
    
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }




}


