package applicatio;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author Muhammad Ali
 */
public class Pwork {
    Stage stage=new Stage();
	Scene scene;
	public static int a;
	
	Pwork()
	{
		
	stage.setTitle("Priority");
	stage.setResizable(true);
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
	Text t4 = new Text(80,90,"Priority:");
	Text t1 = new Text(80,90,"Pno:");

	TextField[] pnot = new TextField[a];
	TextField[] att = new TextField[a];
	TextField[] btt = new TextField[a];
	TextField[] pr = new TextField[a];
	for(int i=0;i<a;i++)
	{
		pnot[i] = new TextField();
		att[i] = new TextField();
		btt[i] = new TextField();
		pr[i] = new TextField();
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
	
	VBox vbox4 = new VBox();
	vbox4.setSpacing(10);
	vbox4.getChildren().add(t4);

	for(int i=0;i<a;i++)
	{
		pr[i].setPrefWidth(60);
		pr[i].setMaxWidth(60);
		vbox4.getChildren().add(pr[i]);
		
	}

	Button btn = new Button("Go");

	GridPane grid = new GridPane();
	grid.add(vbox1 , 0, 5);
	grid.add(vbox2 ,0, 5);
	GridPane.setMargin(vbox2, new Insets(0, 0, 0, 80));
	grid.add(vbox3 ,0, 5);
	GridPane.setMargin(vbox3, new Insets(0, 0, 0, 160));
	grid.add(vbox4, 0, 5);
	GridPane.setMargin(vbox4, new Insets(0, 0, 0, 240));
	grid.add(btn, 0, 6);

	scene = new Scene(grid);

	btn.setOnAction(x ->{
		int processName[]=new int[a];
	 	int arrivalTime[]=new int[a];
        int burstTime[]=new int[a];
        int burstTime1[]=new int[a];
        int completion[]=new int[a];
        int waitingTime[]=new int [a];
        int startTime[]=new int[a];
        int turnaroundtime[]=new int[a];
        int priorityvalue[]=new int[a];
	
	
	for(int i=0;i<a;i++)
	{
		processName[i] = Integer.parseInt(pnot[i].getText());
		arrivalTime[i] = Integer.parseInt(att[i].getText());
		burstTime[i] = Integer.parseInt(btt[i].getText());
		priorityvalue[i] = Integer.parseInt(pr[i].getText());
		
	}
	for(int i=0;i<a;i++){
		System.out.println(arrivalTime[i]);
	}
	
	Text as1 = new Text(70,50,"Priority Process Algorithms");
	as1.setFont(Font.font(20));


	double ratio;
    double num;
    int aa, b, c, i, ii, iii, iiii;
    int no_Process=a;
    int totalwaitingTime = 0, totalturnaroundtime = 0;;
    int count = 0;
    double large = 0, averagewaitingTime = 0, averageturnaroundtime = 0;
    int total_Burst_Time = 0;
    
    for (ii = 0; ii < no_Process; ii++) {
        total_Burst_Time += burstTime[ii];
        burstTime1[ii] = burstTime[ii];
        completion[ii] = 0;
    }
    while (count <= total_Burst_Time) {
        b = 0;
        large = 0;
        for (aa = 0; aa < no_Process; aa++) {
            if (arrivalTime[aa] > count||burstTime[aa]<=0) {
                b++;
            }
        }
        if (b == no_Process) {
            count++;
            continue;
        }
        for (iii = 0; iii < no_Process; iii++) {
            if (arrivalTime[iii] > count || burstTime[iii] <= 0) {
                continue;
            } else {

                //      for(iiii=0;iiii<no_Process;iiii++)
                //        {
                if (priorityvalue[iii] > large) {
                    large = priorityvalue[iii];
                }
            }           //       }  
        }
        for (int iiiii = 0; iiiii < no_Process; iiiii++) {
            if (large == priorityvalue[iiiii]) {
                burstTime[iiiii] = burstTime[iiiii] - 1;
                count++;

                if (burstTime[iiiii] <= 0) {
                    completion[iiiii] = count;
                }  
            }
        }
    }
    for (int tt = 0; tt < no_Process; tt++) {
        waitingTime[tt] = completion[tt] - burstTime1[tt] - arrivalTime[tt];
//        System.out.println(" waiting time of " + processName[tt] + " = " + waitingTime[tt]);
//        System.out.println(" completion time of " + processName[tt] + " = " + completion[tt]);      
        turnaroundtime[tt] = completion[tt] - arrivalTime[tt];
//         System.out.println(" turnaround time of " + processName[tt] + " = " + turnaroundtime[tt]);
    }
    for (int ttt = 0; ttt < no_Process; ttt++) {
        totalwaitingTime = +totalwaitingTime + waitingTime[ttt];
        totalturnaroundtime = totalturnaroundtime + turnaroundtime[ttt];
    }
    
  Label Result = new Label("Result:");
  Label lavgwat = new Label();
  Label lavgtat = new Label();
  
  Result.setText("\n"+Result.getText()+"\nProcesses:\tArrival_Time\tBurst time:\tPriority:\tWaiting Time\tTurn Around Time\n");
  for(int i1=0; i1<a; i1++){
  Result.setText("\n"+Result.getText()+(i1+1)+"\t\t\t"+arrivalTime[i1]+"\t\t\t"+burstTime1[i1]+"\t\t\t"+priorityvalue[i1]+"\t\t\t"+waitingTime[i1]+"\t\t\t"+turnaroundtime[i1]+"\n");
  }
  lavgwat.setText("Average Waiting Time: "+(totalwaitingTime/a));
  lavgtat.setText("Average TurnAround Time: "+(totalturnaroundtime/a));
  
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
	
});
	
	}
}
