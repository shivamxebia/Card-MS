package com.onlineBanking.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineBanking.card.entity.Card;
import com.onlineBanking.card.exception.CardApplicationException;
import com.onlineBanking.card.request.BlockCardDto;
import com.onlineBanking.card.request.CreateCardDto;
import com.onlineBanking.card.request.DeactivateCardDto;
import com.onlineBanking.card.service.CardService;

@RestController
@RequestMapping("/api/v1/")
public class CardController {

	private final CardService cardService;

	@Autowired
	public CardController(CardService cardService) {
		this.cardService = cardService;
	}

	@PostMapping("card")
	public Card createCard(@RequestBody CreateCardDto request) throws CardApplicationException {
		System.out.println("Card id is: "+ request.getUserId());
		return cardService.createCard(request.getUserId(), request.getAccountType());
	}

	@PatchMapping("/deactivate-card")
	ResponseEntity<String> deactivateCard(@RequestBody DeactivateCardDto deactivateCardDto) throws CardApplicationException {
		String response = cardService.deactivateCard(deactivateCardDto.getUserId(),deactivateCardDto.getCardNumber(),deactivateCardDto.getIsActive());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@PatchMapping("/block-card")
	ResponseEntity<String> blockCard(@RequestBody BlockCardDto blockCardDto) throws CardApplicationException {
		String response = cardService.blockCard(blockCardDto.getUserId(),blockCardDto.getCardNumber(),blockCardDto.isBlocked());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
