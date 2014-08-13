import java.sql.SQLException;

public interface Dbinterface {
		 void getData(String key) throws Exception;
		 void postData(String id ,String name) throws Exception;
		 void autoincrementPostData(String name) throws Exception;
		 void sessionClose() throws Exception;
		 public void truncateDb() throws Exception;
}

