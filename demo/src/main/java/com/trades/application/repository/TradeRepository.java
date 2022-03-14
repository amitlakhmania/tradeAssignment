package com.trades.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trades.application.model.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {


	Trade findFirstByOrderByVersionDesc();

	Optional<Trade> findByVersion(int version);
    
}
