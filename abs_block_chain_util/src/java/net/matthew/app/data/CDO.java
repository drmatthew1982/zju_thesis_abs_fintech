package net.matthew.app.data;

import java.util.HashMap;

import net.matthew.Static_Value;

public class CDO {
	public String name;
	public String link;
	public CDOs cdos;
	public HashMap<String, ABS> abs;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public HashMap<String, ABS> getAbs() {
		return abs;
	}
	public void setAbs(HashMap<String, ABS> abs) {
		this.abs = abs;
	}
	public CDOs getCdos() {
		return cdos;
	}
	public void setCdos(CDOs cdos) {
		this.cdos = cdos;
	}
	
	
}
