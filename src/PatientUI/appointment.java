package PatientUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class appointment extends Home implements Initializable {


    @FXML
    private ListView<?> listview;

    @FXML
    void OnTime(MouseEvent event) {

    }

    @FXML
    void backClick(ActionEvent event) {

    }

    @FXML
    void editClick(ActionEvent event) {
       ObservableList select = listview.getSelectionModel().getSelectedIndices();
       if (select.getClass()!= null){
           // TODO: 6/22/2019 get selected appointment
       }

    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String item = "";
        ObservableList<application.Clinic> li =  FXCollections.observableArrayList();
        // TODO: 6/22/2019 setting all free time for appointment 
      //  listview.getItems().addAll()
    }
}
