package com.malunjkar.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="card_payments")
@PrimaryKeyJoinColumn(name = "txid")
public class CardPayment extends Payment {

	private String cardNo;
	private String expDate;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", expDate=" + expDate + ", getCardNo()=" + getCardNo()
				+ ", getExpDate()=" + getExpDate() + "]";
	}

	
	
	

}
