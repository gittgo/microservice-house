package com.ruanmou.house.houseserver;

import com.ruanmou.house.houseserver.domain.House;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = {"com.ruanmou.house"})
@MapperScan(value = "com.ruanmou.house.houseserver.mapper")
public class ServerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext
				context = SpringApplication.run(ServerApplication.class, args);

		// 获取交给spring容器管理Maper接口对应代理实现类
//		HouseMapper bean = context.getBean(HouseMapper.class);
//		List<House> houses = bean.selectAll();
//		System.out.println(houses);
		// 批量插入
		// int i = bean.insertList(Arrays.asList(new House(), new House(), new House()));
		// System.out.println(i);

		RedisTemplate redisTemplate = (RedisTemplate) context.getBean("redisTemplate");
		System.out.println(redisTemplate);
//		redisTemplate.opsForValue().set("hello11", new House());
		House  house = (House) redisTemplate.opsForValue().get("hello11");
//		Object gerry = redisTemplate.opsForValue().get("gerry");
		System.out.println(house+"=================================================");



//		context.close();
	}


}
