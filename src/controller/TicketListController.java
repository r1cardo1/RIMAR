/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;




/**
 * FXML Controller class
 *
 * @author Ricardo Marcano
 */
public class TicketListController implements Initializable {
    
    
    @FXML TableColumn num,pneto,proc,dest,precio,emp;
    @FXML TableView tlist;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initTable();
    }    
    
    public void initTable(){
        num.prefWidthProperty().bind(tlist.widthProperty().divide(6));
        pneto.prefWidthProperty().bind(tlist.widthProperty().divide(6));
        proc.prefWidthProperty().bind(tlist.widthProperty().divide(6));
        dest.prefWidthProperty().bind(tlist.widthProperty().divide(6));
        precio.prefWidthProperty().bind(tlist.widthProperty().divide(6));
        emp.prefWidthProperty().bind(tlist.widthProperty().divide(6));
    }
}
