package com.v5ent.entity;

import java.util.List;

import net.matthew.app.data.ABS;
import net.matthew.app.data.CDO;
import net.matthew.app.data.CDOs;

public class WrappedChain {
	List<Block> chain;
	ABS abs;
	CDO cdo;
	CDOs cdos;
	public List<Block> getChain() {
		return chain;
	}
	public void setChain(List<Block> chain) {
		this.chain = chain;
	}
	public ABS getAbs() {
		return abs;
	}
	public void setAbs(ABS abs) {
		this.abs = abs;
	}
	public CDO getCdo() {
		return cdo;
	}
	public void setCdo(CDO cdo) {
		this.cdo = cdo;
	}
	public CDOs getCdos() {
		return cdos;
	}
	public void setCdos(CDOs cdos) {
		this.cdos = cdos;
	}
	
}
