package com.onlineBanking.card.service;

import com.onlineBanking.card.entity.Card;
import com.onlineBanking.card.exception.CardApplicationException;

public interface CardService {
	String deactivateCard(Long userId, Long CardNumber, boolean isActive) throws CardApplicationException;
	 Card createCard(Long userId,String cardType) throws CardApplicationException;
	String blockCard(Long userId, Long CardNumber, boolean isBlocked) throws CardApplicationException;
	
}
