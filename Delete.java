package sdtbu_java_shixun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
    private String databasename;
    private Connection con;
    private String SQL;
    private String uri="jdbc:derby:";
	public String getDatabasename() {
		return databasename;
	}
	public void setDatabasename(String databasename) {
		this.databasename = databasename;
	}
	public String getSQL() {
		return SQL;
	}
	public void setSQL(String sQL) {
		SQL = sQL;
	}
	public Delete() {
		super();
		// TODO Auto-generated constructor stub
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void startDelete() {
		Statement smt;
		if(databasename!=null) {
			uri+=databasename;
			try {
				con=DriverManager.getConnection(uri);
				smt=con.createStatement();
				smt.executeUpdate(SQL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
     
}
