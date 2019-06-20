package net.matthew.app.data;
/**
 * 
 * @author  ZJU 基于国内市场资产证券化风险事件分析与区块链应用的金融科技设计
 * 
 *
 */
public class ABS {
	public String name;
	public String link;
	public CDO cdo;
	public CDOs cdos;
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
