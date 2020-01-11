package sdtbu_java_shixun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	private String databasename;
	private String SQL;
	private Connection con;
	private String uri="jdbc:derby:";
	int flag=0;
	
	public Insert() {
		super();
		// TODO Auto-generated constructor stub
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

	public void startInsert() {
		Statement smt;
		if(databasename !=null) {
			uri+=databasename;
			try {
				con=DriverManager.getConnection(uri);
				smt=con.createStatement();
				try{
					smt.executeUpdate(SQL);
					flag=0;
				}catch(java.sql.SQLIntegrityConstraintViolationException e) {
					//e.printStackTrace();
					flag=1;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag=1;
			}
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
