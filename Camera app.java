import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CameraApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create text fields for user input
        TextField modelField = new TextField();
        TextField makeField = new TextField();
        TextField colorField = new TextField();
        TextField sensorField = new TextField();
        TextField lensField = new TextField();
        
        // Set prompt text for the fields
        modelField.setPromptText("Model");
        makeField.setPromptText("Make");
        colorField.setPromptText("Color");
        sensorField.setPromptText("Sensor");
        lensField.setPromptText("Lens");

        // Label to display output
        Label outputLabel = new Label();

        // Button to create Camera object
        Button createButton = new Button("Create Camera");
        createButton.setOnAction(event -> {
            try {
                // Retrieve text from text fields
                String model = modelField.getText();
                String make = makeField.getText();
                String color = colorField.getText();
                String sensor = sensorField.getText();
                String lens = lensField.getText();

                // Create a Camera object
                Camera camera = new Camera(model, make, color, sensor, lens);
                
                // Clear the text fields
                modelField.clear();
                makeField.clear();
                colorField.clear();
                sensorField.clear();
                lensField.clear();

                // Display the Camera object's toString() result
                outputLabel.setText(camera.toString());
            } catch (IllegalArgumentException e) {
                // Display validation error message
                outputLabel.setText(e.getMessage());
            }
        });

        // Arrange components in a vertical box
        VBox vbox = new VBox(10, modelField, makeField, colorField, sensorField, lensField, createButton, outputLabel);
        Scene scene = new Scene(vbox, 300, 250);

        // Set up the stage
        primaryStage.setTitle("Camera App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
