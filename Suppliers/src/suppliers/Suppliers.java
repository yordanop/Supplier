/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers;


import suppliers.controllers.MainViewController;
import suppliers.controllers.MainViewControllerInterface;
import suppliers.models.MainViewModel;
import suppliers.models.MainViewModelInterface;
import suppliers.views.MainView;

/**
 *
 * @author YordanoEynar
 */
public class Suppliers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        MainViewModelInterface model = new MainViewModel();
        MainViewControllerInterface controller = new MainViewController(model);
    }

    
    }
    
