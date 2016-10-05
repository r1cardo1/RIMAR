/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.DigitalClock;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class MainController implements Initializable {

    
    @FXML Label date;
    @FXML AnchorPane aux;
    @FXML AnchorPane menu;

    AnchorPane listTicket;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            new DigitalClock(date);
            loadResources();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }    
    
    @FXML public void loadResources() throws IOException{
        listTicket = FXMLLoader.load(getClass().getResource("/fxml/ticketList.fxml"));
       
    }
    
    @FXML public void focusin(MouseEvent evt){
          ScaleTransition st = new ScaleTransition();
          st.setNode((Node) evt.getSource());
          st.setFromX(1);
          st.setFromY(1);
          st.setToX(1.2);
          st.setToY(1.2);
          st.setDuration(Duration.millis(100));
          st.play();
    }
    
    @FXML public void focusout(MouseEvent evt){
          ScaleTransition st = new ScaleTransition();
          st.setNode((Node) evt.getSource());
          st.setFromX(1.2);
          st.setFromY(1.2);
          st.setToX(1);
          st.setToY(1);
          st.setDuration(Duration.millis(100));
          st.play();
    }
    
    @FXML public void manageTickets(ActionEvent evt) throws IOException{
       aux.getChildren().clear();
            aux.getChildren().add(listTicket);
            listTicket.prefHeightProperty().bind(aux.heightProperty());
            listTicket.prefWidthProperty().bind(aux.widthProperty());
        fadeout(menu);
        fadein(aux);
        aux.toFront();
    }
    
    @FXML public void mainMenu(ActionEvent evt){
        if(menu.isVisible())
        fadein(menu);
        fadeout(aux);
        menu.toFront();
    }
    

    
    public void fadein(Node n){
        FadeTransition ft = new FadeTransition();
        ft.setNode(n);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setDuration(Duration.millis(250));
        ft.play();
    }
    
    public void fadeout(Node n){
        FadeTransition ft = new FadeTransition();
        ft.setNode(n);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setDuration(Duration.millis(250));
        ft.play();
    }
    
}
