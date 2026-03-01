import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainPage extends Application {

    @Override
    public void start(Stage stage) {
        Label title = new Label("General App Flow Demo");
        Label subtitle = new Label("Enter a task and click Start Flow");

        TextField taskInput = new TextField();
        taskInput.setPromptText("Example: Simulate black hole orbit");

        TextArea flowLog = new TextArea();
        flowLog.setEditable(false);
        flowLog.setPrefRowCount(10);
        flowLog.setWrapText(true);

        Label status = new Label("Status: Waiting for input");

        Button startButton = new Button("Start Flow");
        Button nextButton = new Button("Next Step");
        Button resetButton = new Button("Reset");

        nextButton.setDisable(true);

        final int[] step = {0};

        startButton.setOnAction(event -> {
            String task = taskInput.getText().trim();
            if (task.isEmpty()) {
                status.setText("Status: Please enter a task first");
                return;
            }

            step[0] = 1;
            flowLog.clear();
            flowLog.appendText("1) Input received: " + task + "\n");
            flowLog.appendText("2) Initializing resources...\n");
            status.setText("Status: Flow started");
            nextButton.setDisable(false);
        });

        nextButton.setOnAction(event -> {
            step[0]++;
            if (step[0] == 2) {
                flowLog.appendText("3) Processing data...\n");
                status.setText("Status: Processing");
            } else if (step[0] == 3) {
                flowLog.appendText("4) Generating output...\n");
                status.setText("Status: Generating output");
            } else {
                flowLog.appendText("5) Complete\n");
                status.setText("Status: Done");
                nextButton.setDisable(true);
            }
        });

        resetButton.setOnAction(event -> {
            taskInput.clear();
            flowLog.clear();
            step[0] = 0;
            status.setText("Status: Waiting for input");
            nextButton.setDisable(true);
        });

        HBox controls = new HBox(10, startButton, nextButton, resetButton);
        VBox root = new VBox(12, title, subtitle, taskInput, controls, flowLog, status);
        root.setPadding(new Insets(16));

        Scene scene = new Scene(root, 520, 420);
        stage.setTitle("mainPage");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
