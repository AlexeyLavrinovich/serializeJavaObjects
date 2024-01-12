package com.aliakseila.serializeJavaObjects;

import com.aliakseila.serializeJavaObjects.entity.CityTrade;
import com.aliakseila.serializeJavaObjects.entity.ZkbTrade;
import com.aliakseila.serializeJavaObjects.repository.CityTradeRepo;
import com.aliakseila.serializeJavaObjects.repository.TradeRepo;
import com.aliakseila.serializeJavaObjects.repository.ZkbTradeRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class SerializeJavaObjectsApplication implements ApplicationRunner {

	private final TradeRepo tradeRepo;
	private final ZkbTradeRepo zkbTradeRepo;
	private final CityTradeRepo cityTradeRepo;

	public static void main(String[] args) {
		SpringApplication.run(SerializeJavaObjectsApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		ZkbTrade zkbTrade = new ZkbTrade();
		zkbTrade.setName("ZkbTrade");
		zkbTrade.setSum(345.23);
		CityTrade cityTrade = new CityTrade();
		cityTrade.setName("CityTrade");
		cityTrade.setSum(45432.23);

		tradeRepo.save(zkbTrade);
		tradeRepo.save(cityTrade);
		System.out.println(cityTradeRepo.findAll());
		System.out.println(zkbTradeRepo.findAll());
	}
}
