package com.trades.application.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trades.application.exception.ResourceNotFoundException;
import com.trades.application.model.Trade;
import com.trades.application.repository.TradeRepository;

@Service
@Transactional
public class TradeServiceImpl implements TradeService {

	@Autowired
	TradeRepository tradeRepository;

	@Override
	public Trade createTrade(Trade trade) {
		Trade trade1 = this.tradeRepository.findFirstByOrderByVersionDesc();

		if (null != trade1) {
			if (trade1.getVersion() < trade.getVersion()) {
				tradeRepository.save(trade);
			}else if(trade1.getVersion() == trade.getVersion()){
				updateTrade(trade);
			}else {
				throw new ResourceNotFoundException();
			}
		}else {
			return tradeRepository.save(trade);
		}
		return trade1;

	}

	@Override
	public List<Trade> getAllTrades() {

		return this.tradeRepository.findAll();
	}

	@Override
	public Trade updateTrade(Trade trade) {
		Optional<Trade> trades = this.tradeRepository.findByVersion(trade.getVersion());

		if (trades.isPresent()) {
			Trade updateTrade = trades.get();
			updateTrade.setCounterPartyId(trade.getCounterPartyId());
			updateTrade.setBookId(trade.getBookId());
			updateTrade.setExpired(trade.getExpired());
			tradeRepository.save(updateTrade);
			return trade;

		} else {
			throw new ResourceNotFoundException();
		}

	}

	@Override
	public Trade getTradeById(long tradeId) {

		Optional<Trade> trade = this.tradeRepository.findById(tradeId);

		if (trade.isPresent()) {
			return trade.get();

		} else {
			throw new ResourceNotFoundException();
		}
	}

}