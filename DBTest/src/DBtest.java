
public class DBtest {

    public static void main(String[] args) throws Exception{
    	int id = 0;
    	String name = "oranie";
    	System.out.println(id + ":" + name);
    	
    	Mysqldboperation mysql = new Mysqldboperation(null, null);

    	//mysql.getData();
    	//mysql.postData(id, name);
    	for (; id < 100;id++){
    		String insert_id = Integer.toString(id);
    		String insert_name = name + "_mysql_" + id;
    		mysql.autoincrementPostData(insert_name);
        	mysql.getData(insert_id);
    	}
    	mysql.truncateDb();
    	mysql.sessionClose();
    	id = 0;
    	
    	//mysql.getData(insert_id);
    	mysql.sessionClose();
    	System.out.println("MySQL EXECUTE COMPLETE");
    	
    	
    	Redisoperation redis = new Redisoperation("localhost","oranie");
    	for (; id < 100;id++){
    		String insert_id = Integer.toString(id);
    		String insert_name = name + "_redis_" + id;
    		redis.postData(insert_id, insert_name);
    		redis.getData(insert_id);
    	}
    	//redis.postData(id, name);
    	//redis.getData();
    	redis.truncateDb();
    	redis.sessionClose();
    	System.out.println("Redis EXECUTE COMPLETE");
    	

    }
}