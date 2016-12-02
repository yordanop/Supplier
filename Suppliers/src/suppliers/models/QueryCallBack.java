/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import java.util.List;
import pojos.Tevents;

/**
 *
 * @author YordanoEynar
 */
public interface QueryCallBack {

    void finishedQueryCallBack(List items);
    
    void finishedEmployeeCallBack(List items);
    
    //void finishedQueryCallBack1(Tevents items);
}
