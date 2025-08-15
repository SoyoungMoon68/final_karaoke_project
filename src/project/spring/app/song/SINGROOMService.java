/*-------------------------------------------------------------------
* NAME   : SINGROOMService
* DESC   : 관리자_그룹코드
* Author : 
* DATE   : 2018-09-12
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.song;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.app.aprj.lib.object.AprjService;
import project.spring.app.zcom.lib.object.CommonException;

@Service
public class SINGROOMService extends AprjService {

    @Autowired
    private SINGROOMDao singroom;

    /**
     * 관리자_그룹코드검색리스트
     * @param SINGROOMModel 관리자_그룹코드
     * @return List<SINGROOMModel> 관리자_그룹코드리스트
     */
    public List<SINGROOMModel> srchSINGROOMList(SINGROOMModel param) throws CommonException {
        try {
            return singroom.srchSINGROOMList(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드검색리스트수
     * @param SINGROOMModel 관리자_그룹코드
     * @return String 관리자_그룹코드리스트수
     */
    public String srchSINGROOMCnt(SINGROOMModel param) throws CommonException {
        try {
            return singroom.srchSINGROOMCnt(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드검색
     * @param SINGROOMModel 관리자_그룹코드
     * @return SINGROOMModel 관리자_그룹코드
     */
    public SINGROOMModel srchSINGROOM(SINGROOMModel param) throws CommonException {
        try {
            return singroom.srchSINGROOM(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드저장
     * @param SINGROOMModel 관리자_그룹코드
     * @return int 관리자_그룹코드저장수
     */
    public int saveSINGROOM(SINGROOMModel param) throws CommonException {
        try {
            int nCount = updateSINGROOM(param);
            if ( nCount == 0 ) {
                nCount = insertSINGROOM(param);
            }
            return nCount;
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드입력
     * @param SINGROOMModel 관리자_그룹코드
     * @return int 관리자_그룹코드입력수
     */
    public int insertSINGROOM(SINGROOMModel param) throws CommonException {
        try {
            return singroom.insertSINGROOM(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드수정
     * @param SINGROOMModel 관리자_그룹코드
     * @return int 관리자_그룹코드수정수
     */
    public int updateSINGROOM(SINGROOMModel param) throws CommonException {
        try {
            return singroom.updateSINGROOM(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_그룹코드삭제
     * @param SINGROOMModel 관리자_그룹코드
     * @return int 관리자_그룹코드삭제수
     */
    public int deleteSINGROOM(SINGROOMModel param) throws CommonException {
        try {
            return singroom.deleteSINGROOM(param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }

}