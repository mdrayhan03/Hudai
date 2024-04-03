package mainpkg;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author cis101
 */
public class NewFxmlController implements Initializable {

    @FXML    private TableView<Person> personTableView;
    @FXML    private TableColumn<Person , String> fNTableColumn;
    @FXML    private TableColumn<Person , String> lNTableColumn;
    @FXML    private TableColumn<Person , Float> cgpaTableColumn;
    
    ObservableList<Person> listtxt = FXCollections.observableArrayList() ;
    ObservableList<Person> listdata = FXCollections.observableArrayList() ;
    ObservableList<Person> listobj = FXCollections.observableArrayList() ;
    Alert alert ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fNTableColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("firstName")) ;
        lNTableColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("lastName")) ;
        cgpaTableColumn.setCellValueFactory(new PropertyValueFactory<Person,Float>("cgpa")) ;
    }    

    @FXML
    private void textFileButton(ActionEvent event) {
        try {
            File f = new File("PersonTextFile.txt") ;
            Scanner sc = new Scanner(f) ;
            String str = "" , line = null ;
            
            while (sc.hasNextLine()) {
                line = sc.nextLine() ;
                String[] words ;
                words = line.split(";") ;
                
                listtxt.add(new Person(words[0] , words[1] , Float.parseFloat(words[2]))) ;
            }
        }
        catch (Exception e) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("File Warning.");
            alert.setContentText("File not found.") ;
            alert.showAndWait() ;
        }
        personTableView.setItems(listtxt) ;
    }

    @FXML
    private void dataFileButton(ActionEvent event) throws FileNotFoundException, IOException {
//        try {
            FileInputStream fis = new FileInputStream("PersonDataFile.bin") ;
            DataInputStream dis = new DataInputStream(fis) ;
            while (true) {
                listdata.add(new Person(dis.readUTF() , dis.readUTF() , dis.readFloat()));
            } 
//        }
//        catch (Exception e) {
//            alert = new Alert(Alert.AlertType.WARNING) ;
//            alert.setHeaderText("File Warning.");
//            alert.setContentText("File not found.") ;
//            alert.showAndWait() ;
//        }
/*personTableView.setItems(listdata) ;*/
    }

    @FXML
    private void objectFileButton(ActionEvent event) {
        try {
            FileInputStream fis = new FileInputStream("PersonObjectFile.bin") ;
            ObjectInputStream ois = new ObjectInputStream(fis) ;
            while (true) {
               listobj.add((Person) ois.readObject()) ;
            } 
        }
        catch (Exception e) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("File Warning.");
            alert.setContentText("File not found.") ;
            alert.showAndWait() ;
        }
        personTableView.setItems(listdata) ;
    }
    
}
