package com.v5ent.entity;

import net.matthew.app.data.ABS;
/**
 * 
 * @author 浙江大学 基于国内市场资产证券化风险事件分析与区块链应用的金融科技设计
 * 
 *
 */
public class ReturnLatest {
	String code;
	Block capital;
	Block reputation;
	Block value;
	Block bank;
	Block rank;
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
	public Block getRank() {
		return rank;
	}
	public void setRank(Block rank) {
		this.rank = rank;
	}

}
