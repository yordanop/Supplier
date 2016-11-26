/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers;

/**
 *
 * @author YordanoEynar
 */
public class ProductSender {
     private String BarCorde;
    private String productName;
    private int amount;
    private float price;
    
    public ProductSender(String BarCode, String productName){
        this.BarCorde = BarCode;
        this.productName = productName;
    }
    
    public ProductSender(String BarCode, String productName, int amount, float price){
        this.BarCorde = BarCode;
        this.productName = productName;
        this.amount = amount;
        this.price = price;
    }

    public String getBarCorde() {
        return BarCorde;
    }

    public void setBarCorde(String BarCorde) {
        this.BarCorde = BarCorde;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
