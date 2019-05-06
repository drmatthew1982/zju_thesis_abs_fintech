package net.matthew.app.data;

import java.util.HashMap;

import net.matthew.Static_Value;

public class CDOs {
	String name;
	String link;
	public HashMap<String, CDO> CDO;

	public HashMap<String, CDO> getCDO() {
		return CDO;
	}

	public void setCDO(HashMap<String, CDO> cDO) {
		CDO = cDO;
	}

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
	
	
}
