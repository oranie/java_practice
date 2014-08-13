import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Redisoperation implements Dbinterface  {
	private Jedis jedis;
	private String value;

	
	Redisoperation(String host, String value){
		this.jedis = new Jedis(host);
		this.value = value;
	}
	
	public void getData(String key){
		try {
			value = jedis.get(key);
			System.out.println(value);	
		} catch (Exception e){
			System.out.println(e);
		} finally {
			//System.out.println(value);
		}
	}

	public void postData(String id, String name) throws Exception {
		try {
			jedis.set(id, name);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			//System.out.println();
		}
	}

	public void sessionClose() throws Exception {
		// TODO Auto-generated method stub
		jedis.close();
	}

	public void truncateDb() throws Exception{
		jedis.flushAll();
	}
	
	public void autoincrementPostData(String name) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

