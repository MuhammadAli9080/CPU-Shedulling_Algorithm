package applicatio;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Applicatio extends Application {
   Stage s;
	Scene scene;
	
	@Override
	public void start(Stage stage) {
		
			s=stage;
			stage.setHeight(600);
			stage.setWidth(600);
			addcom();
			stage.setScene(scene);
			stage.show();
		
	}
	void addcom(){
		Button sjf=new Button("Shortest Job First");
		Button priority=new Button("Priority");
		
		GridPane grid=new GridPane();
		grid.setHgap(30);
		grid.setVgap(30);
		
		grid.setAlignment(Pos.CENTER);
		
		grid.add(sjf, 1,  0);
		grid.add(priority, 0, 1);
		
		
		
		
		sjf.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Sjf s=new Sjf();
				
			}
		});
		
		priority.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				Priority p=new Priority();
			}
		});
		
		scene=new Scene(grid);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
