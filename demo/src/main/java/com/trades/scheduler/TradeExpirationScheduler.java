package com.trades.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class TradeExpirationScheduler {
	
    private static final Logger logger = LoggerFactory.getLogger(TradeExpirationScheduler.class);
    @Scheduled(initialDelay = 100, fixedRate=0)
	public void run() {
		System.out.println("calling DB query from here to update expiration date");
	}

}
