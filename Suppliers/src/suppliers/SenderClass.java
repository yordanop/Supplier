/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YordanoEynar
 */
public class SenderClass {
     List<ProductSender> productSenders = new ArrayList<>();
     int id;
     int version;
     int type;

    public void setProductSenders(List<ProductSender> productSenders) {
        this.productSenders = productSenders;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setType(int type) {
        this.type = type;
    }
     

    public List<ProductSender> getProductSenders() {
        return productSenders;
    }

    public int getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public int getType() {
        return type;
    }
     
     
}
