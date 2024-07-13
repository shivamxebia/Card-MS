package com.onlineBanking.card.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import com.onlineBanking.card.dao.CardRepository;
import com.onlineBanking.card.entity.Card;
import com.onlineBanking.card.exception.CardApplicationException;
import com.onlineBanking.card.service.CardService;

@Service
public class CardServiceImpl implements CardService {
	@Autowired
	private CardRepository cardRepository;

	@Override
	public String deactivateCard(Long userId, Long CardNumber, boolean isActive) throws CardApplicationException {
		// TODO Auto-generated method stub
		
		Card card = cardRepository.findByUserId(userId);
		if(card == null) {
			throw new CardApplicationException(HttpStatus.NOT_FOUND,"Card No is Not Valid,Please provide valid Card No");
		}
		card.setActive(isActive);
		cardRepository.save(card);
		return "Card has been Deactivated!";

	}

	public Long generateCardNumberUtil(){
	    Long accountNumber;
	    do {
	        accountNumber = (long) (Math.random() * 9000000000L) + 1000000000L; 
	    } while (cardRepository.existsByCardNumber(accountNumber)); 
		return accountNumber;
	}
	
	@Override
	public Card createCard(Long userId, String cardType) throws CardApplicationException {		

		// Generate card logic
		Card card = new Card();
		card.setUserId(userId);
		card.setCardType(cardType);
		Long cardNo = generateCardNumberUtil();
		card.setCardNumber(cardNo);
		return cardRepository.save(card);
	}

	@Override
	public String blockCard(Long userId, Long CardNumber, boolean isBlocked) throws CardApplicationException {
		Card card = cardRepository.findByUserId(userId);
		if(card == null) {
			throw new CardApplicationException(HttpStatus.NOT_FOUND,"Card No is Not Valid,Please provide valid Card No");
		}
		card.setBlocked(isBlocked);
		cardRepository.save(card);
		return "Card has been Blocked!";
	}
	


}
