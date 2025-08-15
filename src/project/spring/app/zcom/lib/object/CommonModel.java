package project.spring.app.zcom.lib.object;



import java.lang.reflect.Method;

import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.StringUtil;

public class CommonModel {
	
	protected String groupPageCnt = "10";    /* 페이지 그룹내 페이지 수   */
	protected String pageRowCnt   = "10";    /* 페이지 페이지내 레코드 수 */
	protected String pageNo       = "1" ;    /* 페이지 페이지 번호        */
	protected String totCnt       = "0" ;    /* 페이지 총건수             */
	protected String rowNum             ;    /* ROW 번호                  */
	protected String strRowNum          ;    /* Mysql Page 시작번호       */
    
	protected String regIp        ;     /* 등록 IP          */
	protected String regId        ;     /* 등록 ID          */
	protected String regNm        ;     /* 등록 명          */
	protected String regDtm       ;     /* 등록 일시        */
	protected String updIp        ;     /* 수정 IP          */
	protected String updId        ;     /* 수정 ID          */
	protected String updNm        ;     /* 수정 명          */
	protected String updDtm       ;     /* 수정 일시        */
    
	
	protected String effStaDt     ;     /* 유효시작일자     */
	protected String effEndDt     ;     /* 유효종료일자     */
	
	
	// 검색일자관련 변수.. 시작.
	protected String srchDt       ;     /* 검색일자               */
	protected String srchStaDt    ;     /* 검색시작일자           */
	protected String srchEndDt    ;     /* 검색종료일자           */
	
	protected String srchStaHh    ;     /* 검색시작시각           */
	protected String srchEndHh    ;     /* 검색종료시각           */
	// 검색일자관련 변수.. 끝.
    
    protected String regUserNum   ;                     /* 등록 사용자 번호               */
    protected String regUserNm    ;                     /* 등록 사용자 명                  */
    protected String updUserNum   ;                     /* 수정 사용자 번호               */
    protected String updUserNm    ;                     /* 수정 사용자 명                  */
    protected String delYn        ;                     /* 삭제여부                   */
	
	/**************************************************************************
	 * 페이지설정
	 **************************************************************************/
	public String getGroupPageCnt() {
		return groupPageCnt;
	}

	public void setGroupPageCnt(String groupPageCnt) {
		this.groupPageCnt = groupPageCnt;
	}

	public String getPageRowCnt() {
		return pageRowCnt;
	}

	public int getPageRowCntInt() {
		try {
			return Integer.parseInt(pageRowCnt);
		} catch ( Exception e ) {
			
		}
		return 0;
	}

	public void setPageRowCnt(String pageRowCnt) {
		this.pageRowCnt = pageRowCnt;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getTotCnt() {
		return totCnt;
	}

	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}

	public String getRowNum() {
		return rowNum;
	}

	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}

	public int getStrRowNum() {
		try {
			return (Integer.parseInt(getPageNo()) - 1) * Integer.parseInt(getPageRowCnt());
		} catch ( Exception e ) {
			
		}
		return 0;
	}

	public void setStrRowNum(String strRowNum) {
		this.strRowNum = strRowNum;
	}

	/**************************************************************************
	 * 사용자설정
	 **************************************************************************/
	
	public String getRegIp() {
		return regIp;
	}

	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getRegNm() {
		return regNm;
	}

	public void setRegNm(String regNm) {
		this.regNm = regNm;
	}

	public String getRegDtm() {
		return regDtm;
	}

	public String getRegDtmFormat() {
		return DateUtil.getDateFormat(regDtm);
	}

	public void setRegDtm(String regDtm) {
		this.regDtm = regDtm;
	}

	public String getUpdIp() {
		return updIp;
	}

	public void setUpdIp(String updIp) {
		this.updIp = updIp;
	}

	public String getUpdId() {
		return updId;
	}

	public void setUpdId(String updId) {
		this.updId = updId;
	}

	public String getUpdNm() {
		return updNm;
	}

	public void setUpdNm(String updNm) {
		this.updNm = updNm;
	}

	public String getUpdDtm() {
		return updDtm;
	}
	
	public String getUpdDtmFormat() {
		return DateUtil.getDateFormat(updDtm);
	}

	public void setUpdDtm(String updDtm) {
		this.updDtm = updDtm;
	}

	
	/**************************************************************************
	 * 유효기간
	 **************************************************************************/
	public String getEffStaDt() {
		return effStaDt;
	}

	public void setEffStaDt(String effStaDt) {
		this.effStaDt = StringUtil.getNumber(effStaDt);
	}

	public String getEffEndDt() {
		return effEndDt;
	}

	public void setEffEndDt(String effEndDt) {
		this.effEndDt = StringUtil.getNumber(effEndDt);
	}

	public String getEffStaDtFormat() {
		return DateUtil.getDateFormat(effStaDt);
	}

	public String getEffEndDtFormat() {
		return DateUtil.getDateFormat(effEndDt);
	}

	public String getEffDt() {
		return DateUtil.getDateFormat(effStaDt) + " ~ " + DateUtil.getDateFormat(effEndDt);
	}
	
	
	/**************************************************************************
     * 검색기간
     **************************************************************************/
    public String getSrchDt() {
		return srchDt;
	}

	public void setSrchDt(String srchDt) {
		this.srchDt = StringUtil.getNumber(srchDt);
	}

    public String getSrchStaDt() {
        return srchStaDt;
    }

	public void setSrchStaDt(String srchStaDt) {
        this.srchStaDt = StringUtil.getNumber(srchStaDt);
    }

	public String getSrchEndDt() {
        return srchEndDt;
    }

    public void setSrchEndDt(String srchEndDt) {
        this.srchEndDt = StringUtil.getNumber(srchEndDt);
    }

    public String getSrchDtFormat() {
    	return DateUtil.getDateFormat(srchDt);
    }
    
    public String getSrchStaDtFormat() {
        return DateUtil.getDateFormat(srchStaDt);
    }

    public String getSrchEndDtFormat() {
        return DateUtil.getDateFormat(srchEndDt);
    }
    
    public String getSrchStaHh() {
		return srchStaHh;
	}

	public void setSrchStaHh(String srchStaHh) {
		this.srchStaHh = srchStaHh;
	}

	public String getSrchEndHh() {
		return srchEndHh;
	}

	public void setSrchEndHh(String srchEndHh) {
		this.srchEndHh = srchEndHh;
	}

    /**************************************************************************
     * Model value 인쇄
     **************************************************************************/
	public void println() {
		try {
			Method[] methods = this.getClass().getMethods();
			
			System.out.println("***************************************************************************");
			System.out.println(this.getClass().getSimpleName() + " METHOD VALUE[METHOD CNT : " + methods.length + "]");
			System.out.println("***************************************************************************");
			for ( int j = 0; j < methods.length; j++ ) {
				if ( !methods[j].getName().startsWith("get") ) {
					continue;
				}
				System.out.println(methods[j].getName() + " : [" + methods[j].invoke(this) + "]");
			}
			System.out.println("***************************************************************************");

		} catch ( Exception e ) {
			e.printStackTrace();
		}
    }
	
    /***************************************************************************
    *  복사본 생성
    ***************************************************************************/
    public CommonModel clone() {
    	CommonModel newCommonModel = new CommonModel();
        try {
        	newCommonModel = (CommonModel) super.clone();
        } catch ( Exception e ) {
        	e.printStackTrace();
        }
        
        return newCommonModel;
    }

	public String getRegUserNum() {
		return regUserNum;
	}

	public void setRegUserNum(String regUserNum) {
		this.regUserNum = regUserNum;
	}

	public String getRegUserNm() {
		return regUserNm;
	}

	public void setRegUserNm(String regUserNm) {
		this.regUserNm = regUserNm;
	}

	public String getUpdUserNum() {
		return updUserNum;
	}

	public void setUpdUserNum(String updUserNum) {
		this.updUserNum = updUserNum;
	}

	public String getUpdUserNm() {
		return updUserNm;
	}

	public void setUpdUserNm(String updUserNm) {
		this.updUserNm = updUserNm;
	}
    
    
}

