package net.matthew.app.data;
/**
 * 
 * @author ZJU 基于国内市场资产证券化风险事件分析与区块链应用的金融科技设计
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
