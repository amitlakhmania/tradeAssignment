package com.trades.application.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trades.application.model.Trade;
import com.trades.application.service.TradeService;

@RestController
public class TradeController {

	@Autowired
	TradeService tradeService;

	@GetMapping("/trades")
	public ResponseEntity<List<Trade>> getAllTrades() {
		return ResponseEntity.ok().body(tradeService.getAllTrades());
	}

	@GetMapping("/trades/{id}")
	public ResponseEntity<Trade> getTradeById(@PathVariable long id, @RequestBody Trade trade) {
		return ResponseEntity.ok().body(tradeService.getTradeById(id));
	}

	@PostMapping("/trade")
	public ResponseEntity<Trade> createTrade(@Valid @RequestBody Trade trade) {
		return ResponseEntity.ok().body(this.tradeService.createTrade(trade));
	}

	@PutMapping("/trades/{id}")
	public ResponseEntity<Trade> updateTrade(@PathVariable long id, @RequestBody Trade trade) {
		trade.setId(id);
		return ResponseEntity.ok().body(this.tradeService.updateTrade(trade));
	}

	@ResponseStatus()
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}


}
