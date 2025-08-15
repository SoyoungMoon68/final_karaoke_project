/*-------------------------------------------------------------------
* NAME   : Zcom99000Model
* DESC   : 관리자_그룹사
* DATE   : 2023-12-26
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.zcom.model;

import project.spring.app.zcom.lib.object.ZcomModel;

public class Zcom99000Model extends ZcomModel {

    private String srchGrpCoId                   ;    /* 검색그룹사 ID                      */
    private String srchGrpCoNm                   ;    /* 검색그룹사 명                      */
    private String srchGrpCoCtt                  ;    /* 검색그룹사 내용                    */

    private String grpCoId                       ;    /* 그룹사 ID                      */
    private String grpCoNm                       ;    /* 그룹사 명                      */
    private String grpCoCtt                      ;    /* 그룹사 내용                    */


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

    public String getSrchGrpCoCtt() {
        return srchGrpCoCtt;
    }

    public void setSrchGrpCoCtt(String srchGrpCoCtt) {
        this.srchGrpCoCtt = srchGrpCoCtt;
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

    public String getGrpCoCtt() {
        return grpCoCtt;
    }

    public void setGrpCoCtt(String grpCoCtt) {
        this.grpCoCtt = grpCoCtt;
    }

}