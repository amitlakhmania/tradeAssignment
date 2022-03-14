
package com.trades.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trades.application.model.Trade;

@Service
public interface TradeService {
	Trade createTrade(Trade trade);

	Trade updateTrade(Trade trade);

	List<Trade> getAllTrades();

	Trade getTradeById(long tradeId);

}