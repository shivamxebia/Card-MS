package com.onlineBanking.card.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateCardDto {

	@JsonProperty("userId")
	private Long userId;

	@JsonProperty("accountType")
	private String accountType;

	public CreateCardDto(Long userId, String accountType) {
		this.userId = userId;
		this.accountType = accountType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
