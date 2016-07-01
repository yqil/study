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
		// 设置 redis 字符串数据
		User user = new User();
		user.setName("测试");
		user.setAddr("湖北赤壁");
		user.setSex("男");
//		jedis.set("userObj", serialize(user));
		//获取缓存数据
		deserialize(jedis.get("userObj"));
		jedis.close();
	}
	/**
	 * 序列化对象
	 * @param user
	 * @return
	 */
	public static String serialize(User user){
		byte[] bytes = null; 
		String rs = null;
		try{
			ByteArrayOutputStream bo = new ByteArrayOutputStream();  
	        ObjectOutputStream oo = new ObjectOutputStream(bo);  
	        oo.writeObject(user);  
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
	public static User deserialize(String str){
		User user = null;
		try{
			byte[] b = Base64.decodeBase64(str);
			ByteArrayInputStream bi = new ByteArrayInputStream(b);  
		    ObjectInputStream oi = new ObjectInputStream(bi);  
		    user = (User) oi.readObject(); 
		    System.out.println(user.getName());
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
}