/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidemoproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Atomic-Boy
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label result;
    @FXML
    private Button Submit;
    @FXML
    private CheckBox Mango;
    @FXML
    private CheckBox Passion;
    @FXML
    private CheckBox Banana;
    
    @FXML
    private Label ChoiceBoxLabel;
    @FXML
    private ChoiceBox choiceBox;
    
    @FXML
    private
            Label ComboBoxLabel;
    @FXML
    private ComboBox comboBox;
    //Fxml for RADIO BUTTON
    @FXML
            private RadioButton Php;
    @FXML
            private RadioButton Java;
    @FXML
            private RadioButton CSharp;
    @FXML
            private RadioButton Go;
    private ToggleGroup getCheckedRadioButtonToggle;
    
    @FXML    
    private Label RadioButtonLabel;
    //Variables for TextArea and ListView 
    @FXML private ListView ListView;
    @FXML private TextArea textArea;
    
    /**
     *Code for ComboBox Object
     */
    public void ComboBoxMethod(){
        this.ComboBoxLabel.setText("The Subject Selected is: \n" +comboBox.getValue().toString());
        
    }
     /**
      *Code for the ChoiceBox Object
     * 
      */
     public void ChoiceBoxmethod(){
         ChoiceBoxLabel.setText("Your Favorite Fruit is: \n"+choiceBox.getValue().toString());
         
     }
     
     /**
      *Code for the CheckBox Object
      */
     @FXML
    private void SumbitPushed(ActionEvent event) {
        String order = "You Ordered: ";
        
        if(Mango.isSelected()){
            order+="\nMango Juice";
            
        }
         if(Passion.isSelected()){
            order+="\nPassion Juice";
            
        }
          if(Banana.isSelected()){
            order+="\nBanana Juice";
            
            
        }
         
          this.result.setText(order);
          
       
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        result.setText(""); 
        /**
         *code for ChoiceBox
         */
         ChoiceBoxLabel.setText("");
        
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().add("Banana");
        choiceBox.getItems().add("Pears");
        choiceBox.getItems().addAll("Strawberries","Mangoes","Passion","Pineaples");
        
        //setting default value
        choiceBox.setValue("Strawberries");
        
        //configuring values for ComboBox;
        ComboBoxLabel.setText("");
        comboBox.getItems().add("Electronis");
        comboBox.getItems().add("Engineering Maths");
        comboBox.getItems().addAll("Java","CAD","C language");
        
        //Configuring the items for ListView and TextArea
        
        ListView.getItems().addAll("Java","C#","C++","JavaScript","Android","Go","Pascal","Arduino");
        ListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
      
    } 
//Method for Adding items from Listview to TextArea;  
    public void AddItimesButtonPushed(){
        String TextAreaString = " ";
       //Getting Items since they are in a kind of array
       ObservableList ListOfItems  = ListView.getSelectionModel().getSelectedItems();
       for(Object Items:ListOfItems){
           
           TextAreaString += String.format("%s%n",(String)Items);
       }
       this.textArea.setText(TextAreaString);
    }
    //Method for Checked Radio  BUTTON
    public void GetCheckedRadio(){
        getCheckedRadioButtonToggle = new ToggleGroup();
        Php.setToggleGroup(getCheckedRadioButtonToggle);
        Java.setToggleGroup(getCheckedRadioButtonToggle);
        CSharp.setToggleGroup(getCheckedRadioButtonToggle);
        Go.setToggleGroup(getCheckedRadioButtonToggle);
        RadioButtonLabel.setText("");
       
        if(this.getCheckedRadioButtonToggle.getSelectedToggle().equals(this.Php)){
            RadioButtonLabel.setText("You Selected Php");
        }
         if(this.getCheckedRadioButtonToggle.getSelectedToggle().equals(this.Java)){
            RadioButtonLabel.setText("You Selected Java");
        }
          if(this.getCheckedRadioButtonToggle.getSelectedToggle().equals(this.CSharp)){
         
            RadioButtonLabel.setText("You Selected C#");
            }
         if(this.getCheckedRadioButtonToggle.getSelectedToggle().equals(this.Go)){
            RadioButtonLabel.setText("You Selected GO ");
        }
        
    }
    
}
