import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class gui extends Application {
    Stage window;
    function fun = new function();
    private Generator gen = new Generator();

    BorderPane mainLayout = new BorderPane();

    @Override
    public void start(Stage primaryStage) throws Exception {
        window =primaryStage;
        GridPane mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setPadding(new Insets(25));
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);
        Label text = new Label("Welcome to Password combination Generator");
        text.setFont(Font.font("times new roman", FontWeight.BOLD,20));
        mainGrid.add(text,0,0,3,1);

        Label length = new Label("Length of password");
        TextField lengthtextfield = new TextField();
        lengthtextfield.setPromptText("Enter length");
        mainGrid.add(length,0,3);
        mainGrid.add(lengthtextfield,1,3);

        CheckBox checkBox1 = new CheckBox("Capital Letters");
        CheckBox checkBox2 = new CheckBox("Numbers");
        CheckBox checkBox3 = new CheckBox("SpecialCharacters");
        HBox hbox = new HBox();
        hbox.getChildren().addAll(checkBox1,checkBox2,checkBox3);
        hbox.setSpacing(20);
        mainGrid.add(hbox,1,6);
        Label result = new Label("result");
        TextField res = new TextField();
        res.setEditable(false);
//        res.setDisable(true);

        Button generate = new Button("Generate");
        mainGrid.add(generate,1,9);
        generate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int length = Integer.parseInt(lengthtextfield.getText());
                boolean options[] = {
                        checkBox1.isSelected(),
                        true,
                        checkBox3.isSelected(),
                        checkBox2.isSelected()
                };

                res.setText(gen.generate(length, options));


            }
        });

        mainGrid.add(result,0,10);
        mainGrid.add(res,1,10);
        window.setTitle("password generator");
        Scene mainscene= new Scene(mainGrid,650,500);

        window.setScene(mainscene);
        window.show();
    }
}
