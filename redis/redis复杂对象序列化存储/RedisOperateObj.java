import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.tomcat.util.codec.binary.Base64;

import redis.clients.jedis.Jedis;

public class RedisOperateObj {

	public static void main(String[] args) {
		// 连接 Redis 服务
		Jedis jedis = new Jedis("10.10.2.99", 6379, 360000);
		jedis.auth("123456");//设置密码
		System.out.println("Connection to server sucessfully");
		User user = new User();
		user.setName("张三");
		user.setAddr("XXXXXX");
		user.setSex("男");
		Map<String, String> map = new HashMap<String, String>();
		map.put("aaa", "么么哒");
		map.put("bbb", "2222");
		//缓存map数据
//		jedis.set("testobj", serialize(map));
		//获取缓存中的map数据
		/*Map<String, String> rs = (Map<String, String>)deserializeObj(jedis.get("testobj"));
		System.out.println(rs.get("aaa"));*/
		//缓存user数据
//		jedis.set("testobj", serialize(user));
		//获取缓存中的user信息
		User user1 = (User)deserializeObj(jedis.get("testobj"));
		System.out.println(user1.getName());
		jedis.close();
	}
	/**
	 * 序列化对象信息
	 * @param obj
	 * @return
	 */
	public static String serialize(Object obj){
		byte[] bytes = null; 
		String rs = null;
		try{
			ByteArrayOutputStream bo = new ByteArrayOutputStream();  
	        ObjectOutputStream oo = new ObjectOutputStream(bo);  
	        oo.writeObject(obj);  
	        bytes = bo.toByteArray(); 
	        rs = Base64.encodeBase64String(bytes);
		}catch(Exception e){
			e.printStackTrace();
		}
        return rs;
	}
	/**
	 * 对象反序列化
	 * @param str
	 * @return
	 */
	public static Object deserializeObj(String str){
		Object obj = null;
		try{
			byte[] b = Base64.decodeBase64(str);
			ByteArrayInputStream bi = new ByteArrayInputStream(b);  
		    ObjectInputStream oi = new ObjectInputStream(bi);	  
		    obj = oi.readObject(); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return obj;
	}
}