package applicatio;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author Muhammad Ali
 */
public class Swork {
    public static int  temp;
	public static float avgwt,avgtat;
	public static int a,n, i,st=0,tot=0;
	public static int[]   pid,bt,at,wt,ct,ta,f,k;
	public static int[]   turns;
	
	Stage stage=new Stage();
	Scene scene;
	
	
	Swork()
	{
		stage.setTitle("SJFSprem");
		stage.setResizable(false);
		stage.setHeight(400);
		stage.setWidth(700);
		stage.setResizable(false);
		insert();
		stage.setScene(scene);
		stage.show();
	}
	public void insert()
	{
		Text t2 = new Text(80,90,"Arrival time:");
		Text t3 = new Text(80,90,"Burst time:");
		Text t1 = new Text(80,90,"Pno:");
		
		TextField[] pnot = new TextField[a];
		TextField[] att = new TextField[a];
		TextField[] btt = new TextField[a];
		for(int i=0;i<a;i++)
		{
			pnot[i] = new TextField();
			att[i] = new TextField();
			btt[i] = new TextField();
		}
		
		VBox vbox1 = new VBox();
		vbox1.setSpacing(10);
		vbox1.getChildren().add(t1);
		for(int i=0;i<a;i++)
		{
			pnot[i].setPrefWidth(60);
			pnot[i].setMaxWidth(60);
			vbox1.getChildren().add(pnot[i]);
		}
		
		VBox vbox2 = new VBox();
		vbox2.setSpacing(10);
		vbox2.getChildren().add(t2);
		
		for(int i=0;i<a;i++)
		{
			att[i].setPrefWidth(60);
			att[i].setMaxWidth(60);
			vbox2.getChildren().add(att[i]);
			
		}
		
		VBox vbox3 = new VBox();
		vbox3.setSpacing(10);
		vbox3.getChildren().add(t3);
		
		for(int i=0;i<a;i++)
		{
			btt[i].setPrefWidth(60);
			btt[i].setMaxWidth(60);
			vbox3.getChildren().add(btt[i]);
			
		}
		
		Button btn = new Button("Go");

		GridPane grid = new GridPane();
		grid.add(vbox1 , 0, 5);
		grid.add(vbox2 ,0, 5);
		GridPane.setMargin(vbox2, new Insets(0, 0, 0, 80));
		grid.add(vbox3 ,0, 5);
		GridPane.setMargin(vbox3, new Insets(0, 0, 0, 160));
		grid.add(btn, 0, 6);

		scene = new Scene(grid);
		
		btn.setOnAction(x ->{
			
			pid = new int[a];
			bt = new int[a];
			at = new int[a];
			wt = new int[a];
			ta = new int[a];
			ct = new int[a];
			k = new int[a];
			f = new int[a];
			turns = new int[a];
			
			for(int i=0;i<a;i++)
			{
				pid[i] = Integer.parseInt(pnot[i].getText());
				at[i] = Integer.parseInt(att[i].getText());
				bt[i] = Integer.parseInt(btt[i].getText());
				k[i] = bt[i];
				f[i] = 0;
			}
			work();
		});
	}
	
	public void work(){
	
	Text as1 = new Text(70,50,"SJF Process Algorithms");
	as1.setFont(Font.font(20));
	
	
	while(true){
	    int min=99,c=a;
	    if (tot==a)
	    break;
	   
	    for ( i=0;i<a;i++)
	    {
	    if ((at[i]<=st) && (f[i]==0) && (bt[i]<min))
	    {
	    min=bt[i];
	    c=i;
	    }
	    }
	   
	    if (c==a)
	    st++;
	    else
	    {
	    bt[c]--;
	    st++;
	    if (bt[c]==0)
	    {
	    ct[c]= st;
	    f[c]=1;
	    tot++;
	    }
	    }
	   }
	   
	for(int i=0;i<a;i++)
	                    {
	ta[i] = ct[i] - at[i];
	wt[i] = ta[i] - k[i];
	avgwt = avgwt + wt[i];
	avgtat = avgtat + ta[i];
     }
	Label Result = new Label("Result:");
	Label lavgwat = new Label();
	Label lavgtat = new Label();
	
	Result.setText("\n"+Result.getText()+"\nProcesses:\tArrival_Time\tBurst time:\tWaiting Time\tTurn Around Time\n");
	for(int i=0; i<a; i++){
	Result.setText("\n"+Result.getText()+(i+1)+"\t\t\t"+at[i]+"\t\t\t"+k[i]+"\t\t\t"+wt[i]+"\t\t\t"+ta[i]+"\n");
	}
	lavgwat.setText("Average Waiting Time: "+(avgwt/a));
	lavgtat.setText("Average TurnAround Time: "+(avgtat/a));
	
	Button button3 = new Button("exit");
	button3.setPrefSize(50,50);
	button3.setOnAction(e2-> stage.close());
	
	   GridPane gx = new GridPane();
	   gx.setAlignment(Pos.BASELINE_CENTER);	   
	   gx.add(Result, 1, 0);
	   gx.add(lavgwat, 1, 4);
	   gx.add(lavgtat, 1, 5);
	   gx.add(button3, 1, 7);
	Scene scene = new Scene(gx);
	stage.setScene(scene);
	
	}

}
