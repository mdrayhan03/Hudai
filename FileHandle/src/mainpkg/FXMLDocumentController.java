package mainpkg;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class FXMLDocumentController implements Initializable {

    @FXML    private Label label;
    @FXML    private TextField firstNameTextField;
    @FXML    private TextField lastNameTextField;
    @FXML    private TextField cgpaTextField;
    @FXML    private Label showLabel;
    @FXML    private TableView<Person> personTableView;
    @FXML    private TableColumn<Person, String> fNTableColumn;
    @FXML    private TableColumn<Person, String> lNTableColumn;
    @FXML    private TableColumn<Person, Float> cgpaTableColumn;
    
    ObservableList<Person> list = FXCollections.observableArrayList() ;
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
        
        personTableView.setItems(this.getPerson()) ;
    }    

    public ObservableList<Person>  getPerson () {
        
        list.add(new Person("Ahsan" , "Habib" , 3.55f)) ;
        list.add(new Person("Abul" , "Kalam" , 3.65f)) ;
        list.add(new Person("Ahmed" , "Riya" , 3.99f)) ;
        
        return list ;
    }
    
    @FXML
    private void addPersonButton(ActionEvent event) {
        Person p = new Person(firstNameTextField.getText() , lastNameTextField.getText() , Float.parseFloat(cgpaTextField.getText())) ;
        list.add(p) ;
        
//        personTableView.getItems().add(p) ;
        showLabel.setText(p.toString()) ;
    }

    @FXML
    private void textFileButton(ActionEvent event) {
        FileWriter fw = null ;
        try {
            File f = new File("PersonTextFile.txt") ;
            
            if (f.exists()) {
                fw = new FileWriter(f , true) ;
            }
            else {
                fw = new FileWriter("PersonTextFile.txt") ;
            }
            String str = "" ;
            for (Person p: list) {
                str += p.getFirstName() + ";" +
                       p.getLastName()+ ";" +
                       p.getCgpa() + "\n" ;
            }
            fw.write(str) ;
            fw.close() ;
        }
        catch(Exception e) {
        }
    }

    @FXML
    private void dataBinButton(ActionEvent event) {
        try {
            FileOutputStream fos = new FileOutputStream("PersonDataFile.bin" , true) ;
            DataOutputStream dos = new DataOutputStream(fos) ;
            
            for (Person p: list) {
                dos.writeUTF(p.getFirstName()) ;
                dos.writeUTF(p.getLastName()) ; 
                dos.writeFloat(p.getCgpa()) ;
            }
            dos.close() ;
        }
        catch (Exception e) {
        }
    }

    @FXML
    private void objectButton(ActionEvent event) {
        try {
            FileOutputStream fos = new FileOutputStream("PersonObjectFile.bin" , true) ;
            ObjectOutputStream oos = new ObjectOutputStream(fos) ;
            for (Person p: list) {
                oos.writeObject(p) ;
            }
            oos.close() ;
        }
        catch (Exception e) {
            
        }
    }

    @FXML
    private void showFileButton(ActionEvent event) throws IOException {
        Parent root = null ;
        root = FXMLLoader.load(getClass().getResource("NewFxml.fxml"));
        
        Scene scene = new Scene(root);
        
        Stage stage = new Stage() ;
        stage.setScene(scene);
        stage.show();
    }
    
}