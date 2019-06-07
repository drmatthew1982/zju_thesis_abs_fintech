package net.matthew.app.data;
/**
 * 
 * @author matthew.yiqing.zhu/Zhu Yiqing  ZJU
 * 
 *
 */
import java.util.HashMap;

import net.matthew.Static_Value;

public class CDOs {
	String name;
	String link;
	public HashMap<String, CDO> cdo;

	public HashMap<String, CDO> getCdo() {
		return cdo;
	}

	public void setCdo(HashMap<String, CDO> cDO) {
		cdo = cDO;
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
