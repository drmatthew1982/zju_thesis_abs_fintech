package com.v5ent.entity;

import net.matthew.app.data.ABS;

public class ReturnLatest {
	String code;
	Block capital;
	Block reputation;
	Block value;
	Block bank;
	ABS abs;
	boolean transferToWrongAccount;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Block getCapital() {
		return capital;
	}
	public void setCapital(Block capital) {
		this.capital = capital;
	}
	public Block getReputation() {
		return reputation;
	}
	public void setReputation(Block reputation) {
		this.reputation = reputation;
	}
	public Block getValue() {
		return value;
	}
	public void setValue(Block value) {
		this.value = value;
	}
	public Block getBank() {
		return bank;
	}
	public void setBank(Block bank) {
		this.bank = bank;
	}
	public boolean isTransferToWrongAccount() {
		return transferToWrongAccount;
	}
	public void setTransferToWrongAccount(boolean transferToWrongAccount) {
		this.transferToWrongAccount = transferToWrongAccount;
	}
	public ABS getAbs() {
		return abs;
	}
	public void setAbs(ABS abs) {
		this.abs = abs;
	}

}
