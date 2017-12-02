package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Operations operation = new Operations();

        VBox vBoxNet = new VBox(5);
        vBoxNet.setPadding(new Insets(5));

        Label titleLabel = new Label();
        titleLabel.setText("ToDoQue");

        vBoxNet.getChildren().add(titleLabel);

        TextArea insertDisplayTextArea = new TextArea();
        insertDisplayTextArea.setWrapText(true);

        vBoxNet.getChildren().add(insertDisplayTextArea);


        HBox mainButtonsHBox = new HBox(5);
        Button addTaskButton = new Button("Dodaj zadanie");
        addTaskButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!insertDisplayTextArea.getText().equals("")&&
                        !insertDisplayTextArea.getText().equals("Brak historii!")&&
                        !insertDisplayTextArea.getText().equals("Brak zadań!")&&
                        !insertDisplayTextArea.getText().equals(operation.getTask())&&
                        !insertDisplayTextArea.getText().equals(operation.getTasksHisotry())
                        ){

                    operation.addTask(insertDisplayTextArea.getText());
                }
                insertDisplayTextArea.setText("");
            }
        });
        Button getTaskButton = new Button("Daj mi zadanie");
        getTaskButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                insertDisplayTextArea.setText(operation.getTask());
            }
        });
        Button getTasksHistoryButton = new Button("Historia zadań");
        getTasksHistoryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                insertDisplayTextArea.setText(operation.getTasksHisotry());
            }
        });
        mainButtonsHBox.getChildren().addAll(addTaskButton, getTaskButton, getTasksHistoryButton);

        HBox isTaskCompleteButtonsHBox = new HBox(5);
        Button taskCompleteButton = new Button("Wykonano");
        taskCompleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(insertDisplayTextArea.getText().equals(operation.getTask())) {
                    insertDisplayTextArea.setText(
                            operation.taskComplete(insertDisplayTextArea.getText())
                    );
                }
            }
        });
        Button taskFailedButton = new Button("Nie wykonano");
        taskFailedButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(insertDisplayTextArea.getText().equals(operation.getTask())) {
                    insertDisplayTextArea.setText(
                            operation.taskFailed(insertDisplayTextArea.getText())
                    );
                }
            }
        });
        isTaskCompleteButtonsHBox.getChildren().addAll(taskCompleteButton, taskFailedButton);

        vBoxNet.getChildren().addAll(isTaskCompleteButtonsHBox,mainButtonsHBox);


        primaryStage.setTitle("ToDoQue");
        primaryStage.setScene(new Scene(vBoxNet, 450, 350));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
