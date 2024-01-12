package com.aliakseila.serializeJavaObjects.repository;

import com.aliakseila.serializeJavaObjects.entity.CityTrade;
import com.aliakseila.serializeJavaObjects.entity.Trade;
import com.aliakseila.serializeJavaObjects.entity.ZkbTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepo<T extends Trade>  extends JpaRepository<T, Long> {

    @Query("from com.aliakseila.serializeJavaObjects.entity.ZkbTrade")
    List<ZkbTrade> findAllZkbTrades();
    @Query("from com.aliakseila.serializeJavaObjects.entity.CityTrade")
    List<CityTrade> findAllCityTrades();

}
