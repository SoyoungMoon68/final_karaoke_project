/*-------------------------------------------------------------------
* NAME   : Zcom99000Service
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

package project.spring.app.zcom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.app.zcom.lib.object.ZcomModel;
import project.spring.app.zcom.lib.object.ZcomService;
import project.spring.app.zcom.dao.Zcom99000Dao;
import project.spring.app.zcom.model.Zcom99000Model;

import project.spring.app.zcom.lib.object.CommonException;


@Service
public class Zcom99000Service extends ZcomService {

    @Autowired
    private Zcom99000Dao daoZcom99000;

    /**
     * 관리자_그룹사검색리스트
     * @param Zcom99000Model 관리자_그룹사
     * @return List<Zcom99000Model> 관리자_그룹사리스트
     */
    public List<Zcom99000Model> srchZcom99000List(Zcom99000Model param) throws CommonException {
        try {
            return daoZcom99000.srchZcom99000List(param);
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
            return daoZcom99000.srchZcom99000Cnt(param);
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
            return daoZcom99000.srchZcom99000(param);
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
            return daoZcom99000.srchZcom99000TotalList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹사저장
     * @param Zcom99000Model 관리자_그룹사
     * @return int 관리자_그룹사저장수
     */
    public int saveZcom99000(Zcom99000Model param) throws CommonException {
        try {
            int nCount = updateZcom99000(param);
            if ( nCount == 0 ) {
                nCount = insertZcom99000(param);
            }
            return nCount;
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
            return daoZcom99000.insertZcom99000(param);
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
            return daoZcom99000.updateZcom99000(param);
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
            return daoZcom99000.deleteZcom99000(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹사 전제 삭제
     * @param Zcom99000Model 관리자_그룹사
     * @return int 관리자_그룹사삭제수
     */
    public int deleteZcom99000All() throws CommonException {
        try {
            return daoZcom99000.deleteZcom99000All();
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
            return daoZcom99000.deleteZcom99000Co(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}