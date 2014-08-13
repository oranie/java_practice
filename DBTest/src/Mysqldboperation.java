import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

class Mysqldboperation implements Dbinterface {
	Statement stmt;
	ResultSet rs;
	Connection conn;
		
	Mysqldboperation(Statement stmt, Connection conn) throws Exception {
		this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/oranie","oranie","pass");
		this.stmt = this.conn.createStatement();
	};
	

	public void getData(String id) throws Exception{
		try {
			rs = stmt.executeQuery("SELECT * FROM oranie_test WHERE id = " + id);
			/**
			int colCount = rs.getMetaData().getColumnCount();
			System.out.println("取得したカラム数:" + colCount);
			*/
			while(rs.next()){
			    System.out.print(rs.getString("id") + ":");
			    System.out.print(rs.getString("name"));
			    System.out.println();
			}
		}catch (Exception e){
				System.out.println(e);
				conn.close();
		} finally {
		}
	}
	

	public void postData(String id ,String name) throws Exception{
		try{
			String insert_id = id;
			String insert_name = name;
			System.out.println(insert_id  + ":" + insert_name);
			stmt.execute("INSERT INTO oranie_test VALUES (id ='" + insert_id + "',name='" + insert_name + "')");
		} catch (Exception e){ 
			System.out.println(e);
			conn.close();
		}finally{
		}
	}
	

	public void autoincrementPostData(String name) throws Exception{
		try{
			String insert_name = name;
			//System.out.println(insert_name);
			stmt.execute("INSERT INTO oranie_test (name) VALUES ('" + insert_name + "')");
		} catch (Exception e){ 
			System.out.println(e);
			conn.close();
		} finally{
		}
	}
	

	public void sessionClose() throws Exception{
		try{
			conn.close();
		} catch (Exception e){
			System.out.println(e);
		} finally{
		}
	}
	
	public void truncateDb() throws Exception{
		stmt.execute("TRUNCATE oranie_test");
	}
}