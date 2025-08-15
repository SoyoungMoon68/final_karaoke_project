/*-------------------------------------------------------------------
* NAME   : Zcom99000Dao
* DESC   : 관리자_그룹사
* Author : 
* DATE   : 2023-12-26
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.zcom.dao;

import project.spring.app.zcom.lib.object.ZcomDao;
import project.spring.app.zcom.lib.object.ZcomModel;
import project.spring.app.zcom.model.Zcom99000Model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.spring.app.zcom.lib.object.CommonException;


@Repository
@Transactional
public class Zcom99000Dao extends ZcomDao {

    /**
     * 관리자_그룹사검색리스트
     * @param Zcom99000Model 관리자_그룹사
     * @return List<Zcom99000Model> 관리자_그룹사리스트
     */
    public List<Zcom99000Model> srchZcom99000List(Zcom99000Model param) throws CommonException {
        try {
            return sessionConn.selectList("Zcom99000Query.selectZCOM99000_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹사검색리스트수
     * @param Zcom99000Model 관리자_그룹사
     * @return String 관리자_그룹사리스트수
     */
    public String srchZcom99000Cnt(Zcom99000Model param) throws CommonException {
        try {
            return ((Zcom99000Model) sessionConn.selectOne("Zcom99000Query.selectZCOM99000_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹사검색
     * @param Zcom99000Model 관리자_그룹사
     * @return Zcom99000Model 관리자_그룹사
     */
    public Zcom99000Model srchZcom99000(Zcom99000Model param) throws CommonException {
        try {
            return (Zcom99000Model) sessionConn.selectOne("Zcom99000Query.selectZCOM99000_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹사검색리스트
     * @param Zcom99000Model 관리자_그룹사
     * @return List<Zcom99000Model> 관리자_그룹사리스트
     */
    public List<Zcom99000Model> srchZcom99000TotalList(Zcom99000Model param) throws CommonException {
        try {
            return sessionConn.selectList("Zcom99000Query.selectZCOM99000_03", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹사입력
     * @param Zcom99000Model 관리자_그룹사
     * @return int 관리자_그룹사입력수
     */
    public int insertZcom99000(Zcom99000Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99000Query.insertZCOM99000_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹사수정
     * @param Zcom99000Model 관리자_그룹사
     * @return int 관리자_그룹사수정수
     */
    public int updateZcom99000(Zcom99000Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99000Query.updateZCOM99000_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹사삭제
     * @param Zcom99000Model 관리자_그룹사
     * @return int 관리자_그룹사삭제수
     */
    public int deleteZcom99000(Zcom99000Model param) throws CommonException {
        try {
            return sessionConn.update("Zcom99000Query.deleteZCOM99000_00", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹사 전체 삭제
     * @param Zcom99000Model 관리자_그룹사
     * @return int 관리자_그룹사삭제수
     */
    public int deleteZcom99000All() throws CommonException {
        try {
            return sessionConn.update("Zcom99000Query.deleteZCOM99000_01");
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹사 그룹사 삭제
     * @param Zcom99000Model 관리자_그룹사
     * @return int 관리자_그룹사삭제수
     */
    public int deleteZcom99000Co(ZcomModel param) throws CommonException {
        try {
            return sessionConn.update("Zcom99000Query.deleteZCOM99000_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}