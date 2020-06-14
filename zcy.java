package sdtbu_java_shixun;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
public class zcy {
	/*增加判断题*/
	public static void  AddJudje(BorderPane borderpane){
		VBox vbox=new VBox(); 
		JavaFX.InterfaceAddJudje(vbox);
		borderpane.setCenter(vbox);
	}
	/*更新判断题*/
	public static void UpdateJudje(BorderPane borderpane) {
		VBox vbox=new VBox(); 
		JavaFX.InterfaceUpdateJudje(vbox);
	}
	/*删除判断题*/
	public static void DelectJudje(BorderPane borderpane) {
		VBox vbox=new VBox(); 
		JavaFX.InterfaceDeleteJudje(vbox);
	}
	/*查询判断题*/
	public static void QueryJudje(BorderPane borderpane) {
		VBox vbox=new VBox(); 
		JavaFX.InterfaceQueryJudje(vbox);
		borderpane.setCenter(vbox);
	}
	
	/*增加选择题*/
	public static void AddSelect(BorderPane borderpane) {
		VBox vbox=new VBox(); 
		JavaFX.InterfaceAddSelect(vbox);
		borderpane.setCenter(vbox);
	}
	/*更新选择题*/
	public static void UpdateSelect(BorderPane borderpane) {
		VBox vbox=new VBox(); 
		JavaFX.InterfaceUpdateSelect(vbox);		
	}
	/*删除选择题*/
	public static void DelectSelect(BorderPane borderpane) {
		VBox vbox=new VBox(); 
		JavaFX.InterfaceDeleteSelect(vbox);
		//borderpane.setCenter(vbox);
	}
	/*查询选择题*/
	public static void QuerySelect(BorderPane borderpane) {
		VBox vbox=new VBox(); 
		JavaFX.InterfaceQuerySelect(vbox);
		borderpane.setCenter(vbox);
	}
	public static void main(String[] args) {
		JavaFX.FX();
	}
}
/*create table 判断题(
	编号 char(10) primary key,
	试题内容 varchar(200),
	提示图名字 varchar(20),
	正确选项 varchar(20),
	错误选项 varchar(20),
	正确答案 varchar(20)
)
*/

/*create table 单选题(
	编号 char(10) primary key,
	试题内容 varchar(200),
	提示图名字 varchar(20),
	选项A varchar(200),
	选项B varchar(200),
	选项C varchar(200),
	选项D varchar(200),
	正确答案 varchar(20)
)
*/
