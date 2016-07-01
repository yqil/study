public static void main(String[] args) {
//		JedisShardInfo jsi = new JedisShardInfo("10.10.2.99", 6379, 360000);
//		jsi.setPassword("123456");//设置密码
		// 连接 Redis 服务
		Jedis jedis = new Jedis("10.10.2.99", 6379, 360000);
		jedis.auth("123456");//设置密码
		System.out.println("Connection to server sucessfully");
		// 设置 redis 字符串数据
//		jedis.set("w3ckey", "Redis tutorial");
//		jedis.setex("w3ckey", 60, "Redis tutorial");//设置过期时间
		// 获取存储的数据并输出
//		System.out.println("Stored string in redis:: " + jedis.get("teststr"));
//		System.out.println("Stored string in redis:: " + jedis.get("w3ckey"));
		/*Set<String> list = jedis.keys("*");
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()){
			System.out.println("List of stored keys:: "+itr.next());
		}*/
		jedis.close();
	}

