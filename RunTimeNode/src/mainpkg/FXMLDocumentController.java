package mainpkg;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;

/**
 *
 * @author cis101
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private PieChart piechart;
    
    private ObservableList <PieChart.Data> list 
            = FXCollections.observableArrayList();
    
    private ObservableList <PieChart.Data> list1 
            = FXCollections.observableArrayList();
    
    @FXML
    private Label showLabel;
    
    int cnt = 0 ;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        list.add(new PieChart.Data("hi" , 3.00)) ;
        list.add(new PieChart.Data("b" , 50.00)) ;
        list.add(new PieChart.Data("c" , 13.00)) ;
        list.add(new PieChart.Data("d" , 30.00)) ;
        
        list1.add(new PieChart.Data("A" , 10)) ;
        list1.add(new PieChart.Data("S" , 10)) ;
        list1.add(new PieChart.Data("J" , 10)) ;
        list1.add(new PieChart.Data("K" , 10)) ;
        
    }    

    @FXML
    private void pieButton(ActionEvent event) {
        if (cnt == 0) {
            piechart.setData(list);
            cnt = 1 ;
        }
        else {
            piechart.setData(list1);
            cnt = 0 ;
        }
//        for(PieChart.Data data: piechart.getData()){
//            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED , new EventHandler<MouseEvent>(){
//                    @Override
//                    public void handle(MouseEvent event) {
//                        showLabel.setText(String.valueOf(data.getPieValue()));
//                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                    }
//                }
//            );
//            
//        }

    }
    
}
