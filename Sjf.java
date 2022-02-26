
package applicatio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *

 */
public class Sjf {
    Stage stage;
	Scene scene;
	
	Sjf(){
		stage =new Stage();
		stage.setHeight(500);
		stage.setWidth(500);
		stage.setTitle("Shortest Job First ");
		addcom();
		stage.setScene(scene);
		stage.show();
	}
	
	void addcom(){
		Text enq=new Text("Enter Number of processes");
		TextField enq1=new TextField();
		
		Button cont=new Button("Continue");
		
		
		GridPane grid=new GridPane();
		grid.add(enq, 0, 0);
		grid.add(enq1, 1, 0);
		
		grid.add(cont, 1, 2);
		
		grid.setAlignment(Pos.CENTER);
		scene =new Scene(grid);
		
		cont.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
		 
		Swork.a = Integer.parseInt(enq1.getText());
		new Swork();
		stage.hide();
		}
		});
	}
}
