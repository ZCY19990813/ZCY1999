package sdtbu_java_shixun;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFX extends Application{
	public static BorderPane borderpane;
	public void start(Stage primaryStage) {
		borderpane=new BorderPane();
		borderpane.setStyle("-fx-background-color:#FFF0F5");
		Button button1=new Button("判断题管理");
		Button button2=new Button("单选题管理");
		/*触发按钮1*/
		button1.setOnAction(e->{
			Judje(button1,button2);
		});
		/*触发按钮2*/
		button2.setOnAction(e->{
			Select(button2,button1);
		});
		HBox hbox=new HBox();
		/*设置按钮的大小*/
		button1.setPrefSize(80, 40);
		button2.setPrefSize(80, 40);
		/*将两个按钮放入一个水平面板中，在放入大面板上部*/
		hbox.getChildren().add(button1);
		hbox.getChildren().add(button2);
		borderpane.setTop(hbox);
		
		Label label=new Label("欢迎来到驾校考试管理系统，点击按钮继续…");
		borderpane.setCenter(label);
		label.setFont(new Font("Arial",30));
		label.setTextFill(Color.DARKBLUE);
		
		
		Scene scene=new Scene(borderpane,800,500);
		primaryStage.setTitle("驾考试题管理系统");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false); 
		primaryStage.show();
	}
	/*判断题选项卡*/
	public void Judje(Button button1,Button button2) {
		/*将两个按钮区别出来，当按下时是天蓝色，否则是灰色*/
		button1.setStyle("-fx-background-color: #E1FFFF");
		button2.setStyle("-fx-background-color: #F5F5F5");
		/*增加4个按钮*/
		Button buttonAdd=new Button("添加判断题");
		Button buttonUpdate=new Button("更新判断题");
		Button buttonDelete=new Button("删除判断题");
		Button buttonQuery=new Button("查询判断题");
		/*设置按钮大小*/
		buttonAdd.setPrefSize(400, 200);
		/*设置按钮背景色*/
		buttonAdd.setStyle("-fx-background-color:#FFC0CB");
		buttonUpdate.setPrefSize(400, 200);
		buttonUpdate.setStyle("-fx-background-color:#B0C4DE");
		buttonDelete.setPrefSize(400, 200);
		buttonDelete.setStyle("-fx-background-color:#98FB98");
		buttonQuery.setPrefSize(400, 200);
		buttonQuery.setStyle("-fx-background-color:#FFD700");
		
		/*触发增加判断题的按钮*/
		buttonAdd.setOnAction(e->{
			zcy.AddJudje(borderpane);
		});
		/*触发更新判断题的按钮*/
		buttonUpdate.setOnAction(e->{
			zcy.UpdateJudje(borderpane);
		});
		/*触发删除判断题的按钮*/
		buttonDelete.setOnAction(e->{
			zcy.DelectJudje(borderpane);
		});
		/*触发查询判断题的按钮*/
		buttonQuery.setOnAction(e->{
			zcy.QueryJudje(borderpane);
		});
		
		/*将两个水平的面板放入一个竖直面板中，在放到大面板中*/
		VBox vbox=new VBox();
		HBox hbox1=new HBox();
		HBox hbox2=new HBox();
		
		/*将增加按钮和更新按钮放入第一个水平面板中*/
		hbox1.getChildren().add(buttonAdd);
		hbox1.getChildren().add(buttonUpdate);
		
		/*将删除按钮和查询按钮放入到第二个水平面板中*/
		hbox2.getChildren().add(buttonDelete);
		hbox2.getChildren().add(buttonQuery);
		
		vbox.getChildren().add(hbox1);
		vbox.getChildren().add(hbox2);
		borderpane.setCenter(vbox);
		
	}
	/*选择题选项卡*/
	public void Select(Button button2,Button button1) {
		/*将两个按钮区别出来，当按下时是天蓝色，否则是灰色*/
		button2.setStyle("-fx-background-color: #E1FFFF");
		button1.setStyle("-fx-background-color: #F5F5F5");
		/*增加4个按钮*/
		Button buttonAdd=new Button("添加单选题");
		Button buttonUpdate=new Button("更新单选题");
		Button buttonDelete=new Button("删除单选题");
		Button buttonQuery=new Button("查询单选题");
		/*设置按钮大小*/
		buttonAdd.setPrefSize(400, 200);
		/*设置按钮背景色*/
		buttonAdd.setStyle("-fx-background-color:#FFC0CB");
		buttonUpdate.setPrefSize(400, 200);
		buttonUpdate.setStyle("-fx-background-color:#B0C4DE");
		buttonDelete.setPrefSize(400, 200);
		buttonDelete.setStyle("-fx-background-color:#98FB98");
		buttonQuery.setPrefSize(400, 200);
		buttonQuery.setStyle("-fx-background-color:#FFD700");
		
		/*触发增加单选题的按钮*/
		buttonAdd.setOnAction(e->{
			zcy.AddSelect(borderpane);
		});
		/*触发更新单选题的按钮*/
		buttonUpdate.setOnAction(e->{
			zcy.UpdateSelect(borderpane);
		});
		/*触发删除单选题的按钮*/
		buttonDelete.setOnAction(e->{
			zcy.DelectSelect(borderpane);
		});
		/*触发查询单选题的按钮*/
		buttonQuery.setOnAction(e->{
			zcy.QuerySelect(borderpane);
		});
		
		/*将两个水平的面板放入一个竖直面板中，在放到大面板中*/
		VBox vbox=new VBox();
		HBox hbox1=new HBox();
		HBox hbox2=new HBox();
		
		/*将增加按钮和更新按钮放入第一个水平面板中*/
		hbox1.getChildren().add(buttonAdd);
		hbox1.getChildren().add(buttonUpdate);
		
		/*将删除按钮和查询按钮放入到第二个水平面板中*/
		hbox2.getChildren().add(buttonDelete);
		hbox2.getChildren().add(buttonQuery);
		
		vbox.getChildren().add(hbox1);
		vbox.getChildren().add(hbox2);
		borderpane.setCenter(vbox);
	}
	/*判断题增加界面*/
	public static void InterfaceAddJudje(VBox vbox) {
		HBox hbox1=new HBox();
		HBox hbox2=new HBox();
		HBox hbox3=new HBox();
		HBox hbox4=new HBox();
		HBox hbox5=new HBox();
		HBox hbox6=new HBox();
		HBox hbox7=new HBox();
		Label label1=new Label("编号：                ");
		label1.setFont(new Font("Arial",30));
		label1.setTextFill(Color.DARKBLUE);
		TextField tf1=new TextField();
		tf1.setPrefSize(520, 35);
		hbox1.getChildren().add(label1);
		hbox1.getChildren().add(tf1);
		vbox.getChildren().add(new Label());
		vbox.getChildren().add(hbox1);
		
		Label label2=new Label("试题内容：         ");
		label2.setFont(new Font("Arial",30));
		label2.setTextFill(Color.DARKBLUE);
		TextArea textarea=new TextArea();
		textarea.setWrapText(true);
		hbox2.getChildren().add(label2);
		hbox2.getChildren().add(textarea);
		vbox.getChildren().add(new Label());
		vbox.getChildren().add(hbox2);
		
		Label label3=new Label("提示图名字：      ");
		label3.setFont(new Font("Arial",30));
		label3.setTextFill(Color.DARKBLUE);
		TextField tf3=new TextField();
		tf3.setPrefSize(520,35 );
		hbox3.getChildren().add(label3);
		hbox3.getChildren().add(tf3);
		vbox.getChildren().add(new Label());
		vbox.getChildren().add(hbox3);
		
		Label label4=new Label("正确选项：          ");
		label4.setFont(new Font("Arial",30));
		label4.setTextFill(Color.DARKBLUE);
		TextField tf4=new TextField();
		tf4.setPrefSize(520, 35);
		hbox4.getChildren().add(label4);
		hbox4.getChildren().add(tf4);
		vbox.getChildren().add(new Label());
		vbox.getChildren().add(hbox4);
		
		Label label5=new Label("错误选项：          ");
		label5.setFont(new Font("Arial",30));
		label5.setTextFill(Color.DARKBLUE);
		TextField tf5=new TextField();
		tf5.setPrefSize(520, 35);
		hbox5.getChildren().add(label5);
		hbox5.getChildren().add(tf5);
		vbox.getChildren().add(new Label());
		vbox.getChildren().add(hbox5);
		
		Label label6=new Label("正确答案：          ");
		label6.setFont(new Font("Arial",30));
		label6.setTextFill(Color.DARKBLUE);
		TextField tf6=new TextField();
		tf6.setPrefSize(520, 35);
		//tf.setOnAction(e->text.setText(tf.getText()));
		hbox6.getChildren().add(label6);
		hbox6.getChildren().add(tf6);
		vbox.getChildren().add(new Label());
		vbox.getChildren().add(hbox6);
		
		Label label7=new Label("添加试题：              ");
		label7.setFont(new Font("Arial",30));
		label7.setTextFill(Color.DARKBLUE);
		Button addall=new Button("添加试题");
		addall.setPrefSize(80, 40);
		hbox7.getChildren().add(label7);
		hbox7.getChildren().add(addall);
		vbox.getChildren().add(new Label());
		vbox.getChildren().add(hbox7);
		vbox.setStyle("-fx-background-color:#FFF0F5");
		Insert insert=new Insert();
		addall.setOnAction(e->{
			//如果点击添加试题按钮之后，有空为空就提示插入不成功
			if(textarea.getText().length()==0||tf1.getText().length()==0
					||tf3.getText().length()==0||tf4.getText().length()==0
					||tf5.getText().length()==0||tf6.getText().length()==0) {
				Label labelinsert=new Label("       信息不全，插入失败！");
				borderpane.setCenter(labelinsert);
			}
			
			else {
				insert.setDatabasename("C:/Users/yang2/Desktop/java_shixun/驾考管理");
				insert.setSQL("insert into 判断题 values('"+tf1.getText()+"','"+textarea.getText()
				  +"','"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()+"','"+tf6.getText()+"')");
				insert.startInsert();
				if(insert.flag==1) {//捕获到主码重复的异常也提示插入错误
					Label labelinsert=new Label("       主码冲突，插入失败！");
					borderpane.setCenter(labelinsert);
				}
				else {
					Label labelinsert=new Label("       插入成功！");
					borderpane.setCenter(labelinsert);					
				}
			}
		});
	}
	/*判断题删除界面*/
	public static void InterfaceDeleteJudje(VBox vbox) {
		Label labeldele=new Label("请输入需要删除的题号：");
		labeldele.setFont(new Font("Arial",20));
		TextField tfdele=new TextField();
		tfdele.setPrefSize(100, 35);
		Button buttondele=new Button("查询");
		buttondele.setPrefSize(100, 20);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(labeldele);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(tfdele);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(buttondele);
		borderpane.setCenter(vbox);
		buttondele.setOnAction(e->{
			
			Query query=new Query();
			query.setDatabasename("C:/Users/yang2/Desktop/java_shixun/驾考管理");
			query.setSQL("select * from 判断题 where 编号='"+tfdele.getText()+"'");
			query.startQuery();
			String[][] record=query.getRecord();
			VBox vbo=new VBox();
			if(record.length!=0) {
			
				HBox hbox2=new HBox();
				HBox hbox3=new HBox();
				HBox hbox4=new HBox();
				HBox hbox5=new HBox();
				HBox hbox6=new HBox();
				HBox hbox7=new HBox();
				
				Label label2=new Label("试题内容：         ");
				label2.setFont(new Font("Arial",30));
				label2.setTextFill(Color.DARKBLUE);
				TextArea textarea=new TextArea();
				textarea.setWrapText(true);
				textarea.setText(record[0][1]);
				hbox2.getChildren().add(label2);
				hbox2.getChildren().add(textarea);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox2);
				
				Label label3=new Label("提示图名字：      ");
				label3.setFont(new Font("Arial",30));
				label3.setTextFill(Color.DARKBLUE);
				TextField tf3=new TextField();
				tf3.setPrefSize(520,35 );
				tf3.setText(record[0][2]);
				hbox3.getChildren().add(label3);
				hbox3.getChildren().add(tf3);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox3);
				
				Label label4=new Label("正确选项：          ");
				label4.setFont(new Font("Arial",30));
				label4.setTextFill(Color.DARKBLUE);
				TextField tf4=new TextField();
				tf4.setPrefSize(520, 35);
				tf4.setText(record[0][3]);
				hbox4.getChildren().add(label4);
				hbox4.getChildren().add(tf4);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox4);
				
				Label label5=new Label("错误选项：          ");
				label5.setFont(new Font("Arial",30));
				label5.setTextFill(Color.DARKBLUE);
				TextField tf5=new TextField();
				tf5.setText(record[0][4]);
				tf5.setPrefSize(520, 35);
				hbox5.getChildren().add(label5);
				hbox5.getChildren().add(tf5);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox5);
				
				Label label6=new Label("正确答案：          ");
				label6.setFont(new Font("Arial",30));
				label6.setTextFill(Color.DARKBLUE);
				TextField tf6=new TextField();
				tf6.setPrefSize(520, 35);
				tf6.setText(record[0][5]);
				hbox6.getChildren().add(label6);
				hbox6.getChildren().add(tf6);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox6);
				
				Label label7=new Label("删除试题：              ");
				label7.setFont(new Font("Arial",30));
				label7.setTextFill(Color.DARKBLUE);
				Button addall=new Button("删除试题");
				addall.setPrefSize(80, 40);
				hbox7.getChildren().add(label7);
				hbox7.getChildren().add(addall);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox7);
				vbo.setStyle("-fx-background-color:#FFF0F5");
				borderpane.setCenter(vbo);
				
				addall.setOnAction(ee->{
					Delete delete=new Delete();
					delete.setDatabasename("C:/Users/yang2/Desktop/java_shixun/驾考管理");
					delete.setSQL("delete from 判断题 where 编号='"+tfdele.getText()+"'");
					delete.startDelete();
					Label label=new Label("删除成功！");
					borderpane.setCenter(label);
				});
			}
			else {
				Label label=new Label("此试题不存在，不可删除！");
				borderpane.setCenter(label);
			}
			
			
		});
		
	}
	/*判断题更新界面*/
	public static void InterfaceUpdateJudje(VBox vbox) {
		Label labelquery=new Label("请输入需要更新的题号：");
		labelquery.setFont(new Font("Arial",20));
		TextField tfquery=new TextField();
		tfquery.setPrefSize(100, 35);
		Button buttonquery=new Button("查询");
		buttonquery.setPrefSize(100, 20);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(labelquery);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(tfquery);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(buttonquery);
		borderpane.setCenter(vbox);//先将查询到的放入中心
		VBox vbo=new VBox();
		buttonquery.setOnAction(e->{
			Query query=new Query();
			query.setDatabasename("C:/Users/yang2/Desktop/java_shixun/驾考管理");
			query.setSQL("select * from 判断题  where 编号='"+tfquery.getText()+"'");
			query.startQuery();
			String[][] records=query.getRecord();
			//查到了
			if(records.length>0) {
				HBox hbox2=new HBox();
				HBox hbox3=new HBox();
				HBox hbox4=new HBox();
				HBox hbox5=new HBox();
				HBox hbox6=new HBox();
				HBox hbox7=new HBox();
				
				Label label2=new Label("试题内容：         ");
				label2.setFont(new Font("Arial",30));
				label2.setTextFill(Color.DARKBLUE);
				TextArea textarea=new TextArea();
				textarea.setWrapText(true);
				textarea.setText(records[0][1]);
				hbox2.getChildren().add(label2);
				hbox2.getChildren().add(textarea);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox2);
				
				Label label3=new Label("提示图名字：      ");
				label3.setFont(new Font("Arial",30));
				label3.setTextFill(Color.DARKBLUE);
				TextField tf3=new TextField();
				tf3.setPrefSize(520,35 );
				tf3.setText(records[0][2]);
				hbox3.getChildren().add(label3);
				hbox3.getChildren().add(tf3);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox3);
				
				Label label4=new Label("正确选项：          ");
				label4.setFont(new Font("Arial",30));
				label4.setTextFill(Color.DARKBLUE);
				TextField tf4=new TextField();
				tf4.setPrefSize(520, 35);
				tf4.setText(records[0][3]);
				hbox4.getChildren().add(label4);
				hbox4.getChildren().add(tf4);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox4);
				
				Label label5=new Label("错误选项：          ");
				label5.setFont(new Font("Arial",30));
				label5.setTextFill(Color.DARKBLUE);
				TextField tf5=new TextField();
				tf5.setText(records[0][4]);
				tf5.setPrefSize(520, 35);
				hbox5.getChildren().add(label5);
				hbox5.getChildren().add(tf5);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox5);
				
				Label label6=new Label("正确答案：          ");
				label6.setFont(new Font("Arial",30));
				label6.setTextFill(Color.DARKBLUE);
				TextField tf6=new TextField();
				tf6.setPrefSize(520, 35);
				tf6.setText(records[0][5]);
				hbox6.getChildren().add(label6);
				hbox6.getChildren().add(tf6);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox6);
				
				Label label7=new Label("更新试题：              ");
				label7.setFont(new Font("Arial",30));
				label7.setTextFill(Color.DARKBLUE);
				Button addall=new Button("更新试题");
				addall.setPrefSize(80, 40);
				hbox7.getChildren().add(label7);
				hbox7.getChildren().add(addall);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox7);
				vbo.setStyle("-fx-background-color:#FFF0F5");
				//将查到的放到中心，直接更改，然后提示
				borderpane.setCenter(vbo);
				addall.setOnAction(ee->{
					Update update=new Update();
					update.setDatabasename("C:/Users/yang2/Desktop/java_shixun/驾考管理");
					update.setSQL("update 判断题 set 试题内容='"+textarea.getText()+"',提示图名字='"+
					  tf3.getText()+"',正确选项='"+tf4.getText()+"',错误选项='"+tf5.getText()+
					  "',正确答案='"+tf6.getText()+"' where 编号='"+tfquery.getText()+"'");
					/*System.out.println("update 判断题 set 试题内容='"+textarea.getText()+"',提示图名字='"+
							  tf3.getText()+"',正确选项='"+tf4.getText()+"',错误选项='"+tf5.getText()+
							  "',正确答案='"+tf6.getText()+"' where 编号='"+tfquery.getText()+"'");*/
					update.startUpdate();
					Label label=new Label("更新成功！");
					borderpane.setCenter(label);
					
				});
			}
			else {
				Label label=new Label("此试题不存在，更新失败！");
				borderpane.setCenter(label);
			}
			
		});
		
	}
	/*判断题查询界面*/
	public static void InterfaceQueryJudje(VBox vbox) {
		Label labelquery=new Label("请输入需要查询的题号：");
		labelquery.setFont(new Font("Arial",20));
		TextField tfquery=new TextField();
		tfquery.setPrefSize(100, 35);
		Button buttonquery=new Button("查询");
		buttonquery.setPrefSize(100, 20);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(labelquery);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(tfquery);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(buttonquery);
		borderpane.setCenter(vbox);
		VBox vbo=new VBox();
		buttonquery.setOnAction(e->{
			Query query=new Query();
			query.setDatabasename("C:/Users/yang2/Desktop/java_shixun/驾考管理");
			String S="'"+tfquery.getText()+"'";
			query.setSQL("select * from 判断题 where 编号=" + S);
			query.startQuery();
			String[] clumnname=query.getColumnname();
			String[][] records=query.getRecord();
			int length=records.length;
			if(length>0) {
				HBox hbox2=new HBox();
				HBox hbox3=new HBox();
				HBox hbox4=new HBox();
				HBox hbox5=new HBox();
				HBox hbox6=new HBox();
				HBox hbox7=new HBox();
				
				Label label2=new Label("试题内容：         ");
				label2.setFont(new Font("Arial",30));
				label2.setTextFill(Color.DARKBLUE);
				TextArea textarea=new TextArea();
				textarea.setWrapText(true);
				textarea.setText(records[0][1]);
				hbox2.getChildren().add(label2);
				hbox2.getChildren().add(textarea);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox2);
				
				Label label3=new Label("提示图名字：      ");
				label3.setFont(new Font("Arial",30));
				label3.setTextFill(Color.DARKBLUE);
				TextField tf3=new TextField();
				tf3.setPrefSize(520,35 );
				tf3.setText(records[0][2]);
				hbox3.getChildren().add(label3);
				hbox3.getChildren().add(tf3);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox3);
				
				Label label4=new Label("正确选项：          ");
				label4.setFont(new Font("Arial",30));
				label4.setTextFill(Color.DARKBLUE);
				TextField tf4=new TextField();
				tf4.setPrefSize(520, 35);
				tf4.setText(records[0][3]);
				hbox4.getChildren().add(label4);
				hbox4.getChildren().add(tf4);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox4);
				
				Label label5=new Label("错误选项：          ");
				label5.setFont(new Font("Arial",30));
				label5.setTextFill(Color.DARKBLUE);
				TextField tf5=new TextField();
				tf5.setText(records[0][4]);
				tf5.setPrefSize(520, 35);
				hbox5.getChildren().add(label5);
				hbox5.getChildren().add(tf5);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox5);
				
				Label label6=new Label("正确答案：          ");
				label6.setFont(new Font("Arial",30));
				label6.setTextFill(Color.DARKBLUE);
				TextField tf6=new TextField();
				tf6.setPrefSize(520, 35);
				tf6.setText(records[0][5]);
				hbox6.getChildren().add(label6);
				hbox6.getChildren().add(tf6);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox6);
				vbo.setStyle("-fx-background-color:#FFF0F5");
				borderpane.setCenter(vbo);
			}
			else {
				Label labelanswer=new Label("          该记录不存在，请重新查找或退出！");
				labelanswer.setFont(new Font("Arial",20));
				vbo.getChildren().add(labelanswer);
				borderpane.setCenter(vbo);
			}
		});
		
	}
	
	/*选择题增加界面*/
	public static void InterfaceAddSelect(VBox vbox) {
		HBox hbox1=new HBox();
		HBox hbox2=new HBox();
		HBox hbox3=new HBox();
		HBox hbox4=new HBox();
		HBox hbox5=new HBox();
		HBox hbox6=new HBox();
		HBox hbox7=new HBox();
		HBox hbox8=new HBox();
		HBox hbox9=new HBox();
		Label label1=new Label("编号：                ");
		label1.setFont(new Font("Arial",20));
		label1.setTextFill(Color.DARKBLUE);
		TextField tf1=new TextField();
		tf1.setPrefSize(520, 35);
		hbox1.getChildren().add(label1);
		hbox1.getChildren().add(tf1);
		vbox.getChildren().add(new Label());
		vbox.getChildren().add(hbox1);
		
		Label label2=new Label("试题内容：         ");
		label2.setFont(new Font("Arial",20));
		label2.setTextFill(Color.DARKBLUE);
		TextArea textarea=new TextArea();
		//textArea自动换行
		textarea.setWrapText(true);
		hbox2.getChildren().add(label2);
		hbox2.getChildren().add(textarea);
		vbox.getChildren().add(new Label());
		vbox.getChildren().add(hbox2);
		
		Label label3=new Label("提示图名字：      ");
		label3.setFont(new Font("Arial",20));
		label3.setTextFill(Color.DARKBLUE);
		TextField tf3=new TextField();
		tf3.setPrefSize(520,35 );
		hbox3.getChildren().add(label3);
		hbox3.getChildren().add(tf3);
		vbox.getChildren().add(new Label());
		vbox.getChildren().add(hbox3);
		
		Label label4=new Label("选项A：               ");
		label4.setFont(new Font("Arial",20));
		label4.setTextFill(Color.DARKBLUE);
		TextField tf4=new TextField();
		tf4.setPrefSize(520, 35);
		//tf.setOnAction(e->text.setText(tf.getText()));
		hbox4.getChildren().add(label4);
		hbox4.getChildren().add(tf4);
		vbox.getChildren().add(new Label());
		vbox.getChildren().add(hbox4);
		
		Label label5=new Label("选项B：               ");
		label5.setFont(new Font("Arial",20));
		label5.setTextFill(Color.DARKBLUE);
		TextField tf5=new TextField();
		tf5.setPrefSize(520, 35);
		hbox5.getChildren().add(label5);
		hbox5.getChildren().add(tf5);
		vbox.getChildren().add(new Label());
		vbox.getChildren().add(hbox5);
		
		Label label6=new Label("选项C：               ");
		label6.setFont(new Font("Arial",20));
		label6.setTextFill(Color.DARKBLUE);
		TextField tf6=new TextField();
		tf6.setPrefSize(520, 35);
		hbox6.getChildren().add(label6);
		hbox6.getChildren().add(tf6);
		vbox.getChildren().add(new Label());
		vbox.getChildren().add(hbox6);
		
		Label label7=new Label("选项D：               ");
		label7.setFont(new Font("Arial",20));
		label7.setTextFill(Color.DARKBLUE);
		TextField tf7=new TextField();
		tf7.setPrefSize(520, 35);
		hbox7.getChildren().add(label7);
		hbox7.getChildren().add(tf7);
		vbox.getChildren().add(new Label());
		vbox.getChildren().add(hbox7);
		
		Label label8=new Label("正确答案：           ");
		label8.setFont(new Font("Arial",20));
		label8.setTextFill(Color.DARKBLUE);
		TextField tf8=new TextField();
		tf8.setPrefSize(520, 35);
		hbox8.getChildren().add(label8);
		hbox8.getChildren().add(tf8);
		vbox.getChildren().add(new Label());
		vbox.getChildren().add(hbox8);
		
		Label label9=new Label("添加试题：            ");
		label9.setFont(new Font("Arial",20));
		label9.setTextFill(Color.DARKBLUE);
		Button addall=new Button("添加试题");
		addall.setPrefSize(80, 40);
		hbox9.getChildren().add(label9);
		hbox9.getChildren().add(addall);
		vbox.getChildren().add(new Label());
		vbox.getChildren().add(hbox9);
		vbox.setStyle("-fx-background-color:#FFF0F5");
		Insert insert=new Insert();
		addall.setOnAction(e->{
			if(textarea.getText().length()==0||tf1.getText().length()==0
					||tf3.getText().length()==0||tf4.getText().length()==0
					||tf5.getText().length()==0||tf6.getText().length()==0
					||tf7.getText().length()==0||tf8.getText().length()==0) {
				Label labelinsert=new Label("       信息不全，插入失败！");
				borderpane.setCenter(labelinsert);
			}
			else {
				insert.setDatabasename("C:/Users/yang2/Desktop/java_shixun/驾考管理");
				insert.setSQL("insert into 单选题 values('"+tf1.getText()+"','"+textarea.getText()
				  +"','"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()
				  +"','"+tf6.getText()+"','"+tf7.getText()+"','"+tf8.getText()+"')");
				insert.startInsert();
				if(insert.flag==1) {
					Label labelinsert=new Label("       主码冲突，插入失败！");
					borderpane.setCenter(labelinsert);
				}
				else {
					Label labelinsert=new Label("       插入成功！");
					borderpane.setCenter(labelinsert);					
				}
			}
		});
		
	}
	/*选择题删除界面*/
	public static void InterfaceDeleteSelect(VBox vbox) {
		Label labeldele=new Label("请输入需要删除的题号：");
		labeldele.setFont(new Font("Arial",20));
		TextField tfdele=new TextField();
		tfdele.setPrefSize(100, 35);
		Button buttondele=new Button("查询");
		buttondele.setPrefSize(100, 20);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(labeldele);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(tfdele);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(buttondele);
		borderpane.setCenter(vbox);
		VBox vbo=new VBox();
		buttondele.setOnAction(e->{
			Query query=new Query();
			query.setDatabasename("C:/Users/yang2/Desktop/java_shixun/驾考管理");
			query.setSQL("select * from 单选题 where 编号='"+tfdele.getText()+"'");
			query.startQuery();
			String[][] records=query.getRecord();
			if(records.length>0) {
				HBox hbox2=new HBox();
				HBox hbox3=new HBox();
				HBox hbox4=new HBox();
				HBox hbox5=new HBox();
				HBox hbox6=new HBox();
				HBox hbox7=new HBox();
				HBox hbox8=new HBox();
				HBox hbox9=new HBox();
				
				Label label2=new Label("试题内容：         ");
				label2.setFont(new Font("Arial",20));
				label2.setTextFill(Color.DARKBLUE);
				TextArea textarea=new TextArea();
				//textArea自动换行
				textarea.setWrapText(true);
				textarea.setText(records[0][1]);
				hbox2.getChildren().add(label2);
				hbox2.getChildren().add(textarea);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox2);
				
				Label label3=new Label("提示图名字：      ");
				label3.setFont(new Font("Arial",20));
				label3.setTextFill(Color.DARKBLUE);
				TextField tf3=new TextField();
				tf3.setPrefSize(520,35 );
				tf3.setText(records[0][2]);
				hbox3.getChildren().add(label3);
				hbox3.getChildren().add(tf3);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox3);
				
				Label label4=new Label("选项A：               ");
				label4.setFont(new Font("Arial",20));
				label4.setTextFill(Color.DARKBLUE);
				TextField tf4=new TextField();
				tf4.setPrefSize(520, 35);
				tf4.setText(records[0][3]);
				hbox4.getChildren().add(label4);
				hbox4.getChildren().add(tf4);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox4);
				
				Label label5=new Label("选项B：               ");
				label5.setFont(new Font("Arial",20));
				label5.setTextFill(Color.DARKBLUE);
				TextField tf5=new TextField();
				tf5.setText(records[0][4]);
				tf5.setPrefSize(520, 35);
				hbox5.getChildren().add(label5);
				hbox5.getChildren().add(tf5);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox5);
				
				Label label6=new Label("选项C：               ");
				label6.setFont(new Font("Arial",20));
				label6.setTextFill(Color.DARKBLUE);
				TextField tf6=new TextField();
				tf6.setPrefSize(520, 35);
				tf6.setText(records[0][5]);
				hbox6.getChildren().add(label6);
				hbox6.getChildren().add(tf6);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox6);
				
				Label label7=new Label("选项D：               ");
				label7.setFont(new Font("Arial",20));
				label7.setTextFill(Color.DARKBLUE);
				TextField tf7=new TextField();
				tf7.setPrefSize(520, 35);
				tf7.setText(records[0][6]);
				hbox7.getChildren().add(label7);
				hbox7.getChildren().add(tf7);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox7);
				
				Label label8=new Label("正确答案：           ");
				label8.setFont(new Font("Arial",20));
				label8.setTextFill(Color.DARKBLUE);
				TextField tf8=new TextField();
				tf8.setPrefSize(520, 35);
				tf8.setText(records[0][7]);
				hbox8.getChildren().add(label8);
				hbox8.getChildren().add(tf8);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox8);
				
				Label label9=new Label("删除试题：            ");
				label9.setFont(new Font("Arial",20));
				label9.setTextFill(Color.DARKBLUE);
				Button addall=new Button("删除试题");
				addall.setPrefSize(80, 40);
				hbox9.getChildren().add(label9);
				hbox9.getChildren().add(addall);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox9);
				vbo.setStyle("-fx-background-color:#FFF0F5");
				borderpane.setCenter(vbo);
				
				addall.setOnAction(ee->{
					Delete delete=new Delete();
					delete.setDatabasename("C:/Users/yang2/Desktop/java_shixun/驾考管理");
					delete.setSQL("delete from 单选题 where 编号='"+tfdele.getText()+"'");
					delete.startDelete();
					Label label=new Label("删除成功！");
					borderpane.setCenter(label);
				});
			}
			else {
				Label label=new Label("该试题不存在！删除失败！");
				borderpane.setCenter(label);
			}
			
		});
	}
	/*选择题更新界面*/
	public static void InterfaceUpdateSelect(VBox vbox) {
		Label labelquery=new Label("请输入需要更新的题号：");
		labelquery.setFont(new Font("Arial",20));
		TextField tfquery=new TextField();
		tfquery.setPrefSize(100, 35);
		Button buttonquery=new Button("查询");
		buttonquery.setPrefSize(100, 20);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(labelquery);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(tfquery);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(buttonquery);
		borderpane.setCenter(vbox);
		VBox vbo=new VBox();
		buttonquery.setOnAction(e->{
			Query query=new Query();
			query.setDatabasename("C:/Users/yang2/Desktop/java_shixun/驾考管理");
			query.setSQL("select * from 单选题 where 编号='"+tfquery.getText()+"'");
			query.startQuery();
			String[][] records=query.getRecord();
			if(records.length>0) {
				HBox hbox2=new HBox();
				HBox hbox3=new HBox();
				HBox hbox4=new HBox();
				HBox hbox5=new HBox();
				HBox hbox6=new HBox();
				HBox hbox7=new HBox();
				HBox hbox8=new HBox();
				HBox hbox9=new HBox();
				
				Label label2=new Label("试题内容：         ");
				label2.setFont(new Font("Arial",20));
				label2.setTextFill(Color.DARKBLUE);
				TextArea textarea=new TextArea();
				//textArea自动换行
				textarea.setWrapText(true);
				textarea.setText(records[0][1]);
				hbox2.getChildren().add(label2);
				hbox2.getChildren().add(textarea);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox2);
				
				Label label3=new Label("提示图名字：      ");
				label3.setFont(new Font("Arial",20));
				label3.setTextFill(Color.DARKBLUE);
				TextField tf3=new TextField();
				tf3.setPrefSize(520,35 );
				tf3.setText(records[0][2]);
				hbox3.getChildren().add(label3);
				hbox3.getChildren().add(tf3);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox3);
				
				Label label4=new Label("选项A：               ");
				label4.setFont(new Font("Arial",20));
				label4.setTextFill(Color.DARKBLUE);
				TextField tf4=new TextField();
				tf4.setPrefSize(520, 35);
				tf4.setText(records[0][3]);
				hbox4.getChildren().add(label4);
				hbox4.getChildren().add(tf4);
				vbox.getChildren().add(new Label());
				vbox.getChildren().add(hbox4);
				
				Label label5=new Label("选项B：               ");
				label5.setFont(new Font("Arial",20));
				label5.setTextFill(Color.DARKBLUE);
				TextField tf5=new TextField();
				tf5.setText(records[0][4]);
				tf5.setPrefSize(520, 35);
				hbox5.getChildren().add(label5);
				hbox5.getChildren().add(tf5);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox5);
				
				Label label6=new Label("选项C：               ");
				label6.setFont(new Font("Arial",20));
				label6.setTextFill(Color.DARKBLUE);
				TextField tf6=new TextField();
				tf6.setPrefSize(520, 35);
				tf6.setText(records[0][5]);
				hbox6.getChildren().add(label6);
				hbox6.getChildren().add(tf6);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox6);
				
				Label label7=new Label("选项D：               ");
				label7.setFont(new Font("Arial",20));
				label7.setTextFill(Color.DARKBLUE);
				TextField tf7=new TextField();
				tf7.setPrefSize(520, 35);
				tf7.setText(records[0][6]);
				hbox7.getChildren().add(label7);
				hbox7.getChildren().add(tf7);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox7);
				
				Label label8=new Label("正确答案：           ");
				label8.setFont(new Font("Arial",20));
				label8.setTextFill(Color.DARKBLUE);
				TextField tf8=new TextField();
				tf8.setPrefSize(520, 35);
				tf8.setText(records[0][7]);
				hbox8.getChildren().add(label8);
				hbox8.getChildren().add(tf8);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox8);
				
				Label label9=new Label("更新试题：            ");
				label9.setFont(new Font("Arial",20));
				label9.setTextFill(Color.DARKBLUE);
				Button addall=new Button("更新试题");
				addall.setPrefSize(80, 40);
				hbox9.getChildren().add(label9);
				hbox9.getChildren().add(addall);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox9);
				vbo.setStyle("-fx-background-color:#FFF0F5");
				borderpane.setCenter(vbo);
				addall.setOnAction(ee->{
					Update update=new Update();
					update.setDatabasename("C:/Users/yang2/Desktop/java_shixun/驾考管理");
					update.setSQL("update 单选题 set 试题内容='"+textarea.getText()+"',提示图名字='"
							+tf3.getText()+"',选项A='"+tf4.getText()+"',选项B='"
							+tf5.getText()+"',选项C='"+tf6.getText()+"',选项D='"
							+tf7.getText()+"',正确答案='"+tf8.getText()+"' where 编号='"+tfquery.getText()+"'");
					/*System.out.println("update 单选题 set 试题内容='"+textarea.getText()+"',提示图名字='"
							+tf3.getText()+"',选项A='"+tf4.getText()+"',选项B='"
							+tf5.getText()+"',选项C='"+tf6.getText()+"',选项D='"
							+tf7.getText()+"',正确答案='"+tf8.getText()+"' where 编号='"+tfquery.getText()+"'");*/
					update.startUpdate();
					Label label=new Label("   更新成功！");
					borderpane.setCenter(label);
				});
			}
			else {
				Label label=new Label("   该试题不存在，更新失败！");
				borderpane.setCenter(label);
			}
		});
	}
	/*选择题查询界面*/
	public static void InterfaceQuerySelect(VBox vbox) {
		final int flagg=0;
		Label labelquery=new Label("请输入需要查询的题号：");
		labelquery.setFont(new Font("Arial",20));
		TextField tfquery=new TextField();
		tfquery.setPrefSize(100, 35);
		Button buttonquery=new Button("查询");
		buttonquery.setPrefSize(100, 20);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(labelquery);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(tfquery);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(buttonquery);
		borderpane.setCenter(vbox);
		VBox vbo=new VBox();
		buttonquery.setOnAction(e->{
			Query query=new Query();
			query.setDatabasename("C:/Users/yang2/Desktop/java_shixun/驾考管理");
			String S="'"+tfquery.getText()+"'";
			query.setSQL("select * from 单选题  where 编号 = "+ S);
			query.startQuery();
			String[] clumnname=query.getColumnname();
			String[][] records=query.getRecord();
			int length=records.length;
			if(length>0) {
				HBox hbox2=new HBox();
				HBox hbox3=new HBox();
				HBox hbox4=new HBox();
				HBox hbox5=new HBox();
				HBox hbox6=new HBox();
				HBox hbox7=new HBox();
				HBox hbox8=new HBox();
				HBox hbox9=new HBox();
				
				Label label2=new Label("试题内容：         ");
				label2.setFont(new Font("Arial",20));
				label2.setTextFill(Color.DARKBLUE);
				TextArea textarea=new TextArea();
				//textArea自动换行
				textarea.setWrapText(true);
				hbox2.getChildren().add(label2);
				textarea.setText(records[0][1]);
				hbox2.getChildren().add(textarea);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox2);
				
				Label label3=new Label("提示图名字：      ");
				label3.setFont(new Font("Arial",20));
				label3.setTextFill(Color.DARKBLUE);
				TextField tf3=new TextField();
				tf3.setPrefSize(520,35 );
				tf3.setText(records[0][2]);
				hbox3.getChildren().add(label3);
				hbox3.getChildren().add(tf3);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox3);
				
				Label label4=new Label("选项A：               ");
				label4.setFont(new Font("Arial",20));
				label4.setTextFill(Color.DARKBLUE);
				TextField tf4=new TextField();
				tf4.setPrefSize(520, 35);
				tf4.setText(records[0][3]);
				hbox4.getChildren().add(label4);
				hbox4.getChildren().add(tf4);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox4);
				
				Label label5=new Label("选项B：               ");
				label5.setFont(new Font("Arial",20));
				label5.setTextFill(Color.DARKBLUE);
				TextField tf5=new TextField();
				tf5.setText(records[0][4]);
				tf5.setPrefSize(520, 35);
				hbox5.getChildren().add(label5);
				hbox5.getChildren().add(tf5);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox5);
				
				Label label6=new Label("选项C：               ");
				label6.setFont(new Font("Arial",20));
				label6.setTextFill(Color.DARKBLUE);
				TextField tf6=new TextField();
				tf6.setPrefSize(520, 35);
				tf6.setText(records[0][5]);
				hbox6.getChildren().add(label6);
				hbox6.getChildren().add(tf6);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox6);
				
				Label label7=new Label("选项D：               ");
				label7.setFont(new Font("Arial",20));
				label7.setTextFill(Color.DARKBLUE);
				TextField tf7=new TextField();
				tf7.setPrefSize(520, 35);
				tf7.setText(records[0][6]);
				hbox7.getChildren().add(label7);
				hbox7.getChildren().add(tf7);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox7);
				
				Label label8=new Label("正确答案：           ");
				label8.setFont(new Font("Arial",20));
				label8.setTextFill(Color.DARKBLUE);
				TextField tf8=new TextField();
				tf8.setPrefSize(520, 35);
				tf8.setText(records[0][7]);
				hbox8.getChildren().add(label8);
				hbox8.getChildren().add(tf8);
				vbo.getChildren().add(new Label());
				vbo.getChildren().add(hbox8);
				borderpane.setCenter(vbo);
			}
			else {
				Label labelanswer=new Label("          该记录不存在，请重新查找或退出！");
				labelanswer.setFont(new Font("Arial",20));
				vbo.getChildren().add(labelanswer);
				borderpane.setCenter(vbo);
			}
			
			vbox.setStyle("-fx-background-color:#FFF0F5");
		});
	}
	public static void FX() {
		launch();
	}
}
