package com.aliakseila.serializeJavaObjects.repository;

import com.aliakseila.serializeJavaObjects.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepo<T extends Trade>  extends JpaRepository<T, Long> {
}
