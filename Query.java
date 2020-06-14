package sdtbu_java_shixun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
	private String databasename;//数据库名
	private String SQL;//查询语句
	private String columnname[];//列名
	private String record[][];//记录
	private Connection con;
	private String uri="jdbc:derby:";
	public Query() {
		super();
		// TODO Auto-generated constructor stub
		try {
			//加载驱动
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

	public String[] getColumnname() {
		return columnname;
	}

	public void setColumnname(String[] columnname) {
		this.columnname = columnname;
	}

	public String[][] getRecord() {
		return record;
	}

	public void setRecord(String[][] record) {
		this.record = record;
	}

	public void startQuery() {
		Statement smt;
		ResultSet rs;
		ResultSetMetaData metadate;
		if(databasename !=null) {
			uri+=databasename;
			try {
				//创建连接
				con=DriverManager.getConnection(uri);
				smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				rs=smt.executeQuery(SQL);
				metadate=rs.getMetaData();
				int clumns=metadate.getColumnCount();
				columnname=new String[clumns];
				for(int i=0;i<clumns;i++)
					columnname[i]=metadate.getColumnName(i+1);
				rs.last();
				record =new String[rs.getRow()][clumns];
				int j=0;
				rs.beforeFirst();
				while(rs.next()) {
					for(int i=1;i<=clumns;i++)
						record[j][i-1]=rs.getString(i);
					j++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {  
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
