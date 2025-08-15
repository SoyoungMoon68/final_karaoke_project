package project.spring.app.song;

import project.spring.app.zcom.lib.object.ZcomModel;

public class SINGROOMModel extends ZcomModel{
	
	private String storeId;                
    private String storeName;                  
    private String runYmd;
    private String totCnt;
    
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getRunYmd() {
		return runYmd;
	}
	public void setRunYmd(String runYmd) {
		this.runYmd = runYmd;
	}
    public void setTotCnt(String totCnt) {
    	this.totCnt = totCnt;
    }
    public String getTotCnt() {
    	return totCnt;
    }
}
