

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;

import java.io.Serializable;


/**
 * Write a description of JavaFX class ClientPasswordsGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ClientPasswordsGUI extends Application implements Serializable
{
    private int count = 0;
    private ArrayList<Client> lstClients = new ArrayList<>();
    
    private Label shopLabel = new Label("Online Shop");
    private Label nameLabel = new Label("Enter name:");
    private Label emailLabel = new Label("Enter email address:");
    private Label lookupLabel = new Label("Enter name to find:  ");
    private TextField nameTextField = new TextField();
    private TextField emailTextField = new TextField();   
    private TextField lookupTextField = new TextField(); 
    private Button addButton = new Button("Add Client");
    private Button passButton = new Button("Save Passwords");
    private Button saveButton = new Button("Lookup Password");
    private Button exitButton = new Button("Exit");
    private TextArea outputArea = new TextArea("List of Clients" + "\n" );

   
    @Override
    public void start(Stage stage) 
    {
        
        shopLabel.setFont(Font.font("Comic Sans", FontWeight.BOLD, 18));
        shopLabel.setPrefWidth(140);
        nameLabel.setPrefWidth(140);
        emailLabel.setPrefWidth(140);
        lookupLabel.setPrefWidth(120);
      
        addButton.setPrefWidth(120);
        passButton.setPrefWidth(120);
        saveButton.setPrefWidth(120);
        exitButton.setPrefWidth(120);
        ImageView imageView2 = new ImageView(new Image("Robot.jpg"));
        imageView2.setFitHeight(70);
        imageView2.setFitWidth(65);
        
        HBox headingPane = new HBox();
        HBox namePane = new HBox();
        HBox emailPane = new HBox();
        HBox topButtonPane = new HBox(20);
        HBox lookupPane = new HBox(20);
        HBox bottomButtonPane = new HBox(20);

        headingPane.getChildren().addAll(shopLabel, imageView2);
        namePane.getChildren().add(nameLabel);
        namePane.getChildren().add(nameTextField);
        emailPane.getChildren().add(emailLabel);
        emailPane.getChildren().add(emailTextField);
        lookupPane.getChildren().add(lookupLabel);
        lookupPane.getChildren().add(lookupTextField);
        topButtonPane.getChildren().addAll(addButton, passButton);
        bottomButtonPane.getChildren().addAll(saveButton, exitButton);
        
        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        pane.setVgap(10);
        pane.setHgap(10);

        //set an action on the button using method reference
        addButton.setOnAction(this::addClick);
        passButton.setOnAction(this::passClick);
        saveButton.setOnAction(this::lookupClick);
        exitButton.setOnAction(this::exitClick);

        // Add the button and label into the pane
        pane.add(headingPane, 0, 0);
        pane.add(namePane, 0, 1);
        pane.add(emailPane, 0, 2);
        pane.add(topButtonPane, 0, 3);
        pane.add(outputArea, 0, 4);
        pane.add(lookupPane, 0, 5);
        pane.add(bottomButtonPane, 0, 6);
 
        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 400,450);
        stage.setTitle("Client passwords");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }

   
    private void addClick(ActionEvent event)
    {
       count++;
       String name = nameTextField.getText().trim();
       String email = emailTextField.getText().trim();
       Client client = new Client(name, email);
       lstClients.add(client);
       outputArea.appendText(count + ". " + client.toString() + " \n" );
       nameTextField.setText(" ");
       emailTextField.setText(" ");
       nameTextField.requestFocus();       
    }
    
    private void passClick(ActionEvent event) 
    {
        outputArea.setText("List of clients and passwords" + " \n" );
        try
        {
          ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("passwords.ser"));
          for(int k = 0; k < lstClients.size();k++)
          {
              
            Client client = (Client)lstClients.get(k);
            out.writeObject(client.toString());            
          }
            
          out.close();
          outputArea.setText("Data written to file" );
        }
        catch(IOException ex)
        {
          Alert done = new Alert(Alert.AlertType.ERROR);
          done.setTitle("Write to file");
          done.setContentText("Error writing data to the file");
          done.showAndWait();      
        }        
    }
    
    public void lookupClick(ActionEvent event) 
    {
        outputArea.setText("Lookup" + " \n" );
        String name = lookupTextField.getText().trim();
        outputArea.appendText(name + "\n" );
        
          for(int k = 0; k < lstClients.size();k++)
          {
                     
              if (name.equalsIgnoreCase(lstClients.get(k).getName()))
              {
                Alert find = new Alert(Alert.AlertType.INFORMATION);
                find.setTitle("Password lookup");
                find.setContentText("Name: " + name + "\n" + "Password: " + lstClients.get(k).getPassword());
                find.showAndWait();       
              }
          }                
    }            
   
     private void exitClick(ActionEvent event)
    {
        System.exit(0);
    }
}
