package project.spring.app.zcom.lib.object;

import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.model.Zcom99030Model;

public class ZcomModel extends CommonModel {
	
	public ZcomModel() {
		super();
	}

    private String srchGrpCoId                   ;    /* 검색그룹사 ID                  */
    private String srchGrpCoNm                   ;    /* 검색그룹사 명                  */
			 
    private String grpCoId                       ;    /* 그룹사 ID                      */
    private String grpCoNm                       ;    /* 그룹사 명                      */
    
    
    
    
    
	public String getSrchGrpCoId() {
		return srchGrpCoId;
	}
	
	public void setSrchGrpCoId(String srchGrpCoId) {
		this.srchGrpCoId = srchGrpCoId;
	}

	public String getSrchGrpCoNm() {
		return srchGrpCoNm;
	}

	public void setSrchGrpCoNm(String srchGrpCoNm) {
		this.srchGrpCoNm = srchGrpCoNm;
	}

	public String getGrpCoId() {
		return grpCoId;
	}

	public void setGrpCoId(String grpCoId) {
		this.grpCoId = grpCoId;
	}

	public String getGrpCoNm() {
		return grpCoNm;
	}

	public void setGrpCoNm(String grpCoNm) {
		this.grpCoNm = grpCoNm;
	}

	
	
	/**************************************************************************
	 * 사용자설정
	 **************************************************************************/
	public void setUser(Zcom99030Model sessionUser)  {
		if ( sessionUser == null ) {
    		return;
		}

		this.setGrpCoId(sessionUser.getGrpCoId());
		
		this.setRegUserNum(sessionUser.getUserNum());
		this.setUpdUserNum(sessionUser.getUserNum());
		
		this.setRegId(sessionUser.getUserId());
		this.setRegNm(sessionUser.getUserNm());
		this.setUpdId(sessionUser.getUserId());
		this.setUpdNm(sessionUser.getUserNm());

		this.setRegIp(sessionUser.getRegIp ());
		this.setUpdIp(sessionUser.getUpdIp ());

		String currDt = DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMDHMS);
		this.setRegDtm(currDt);
		this.setUpdDtm(currDt);
	}

}

