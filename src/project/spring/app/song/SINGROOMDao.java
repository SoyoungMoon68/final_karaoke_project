package project.spring.app.song;

import java.util.List;

import org.springframework.stereotype.Repository;

import project.spring.app.aprj.lib.object.AprjDao;
import project.spring.app.zcom.lib.object.CommonException;

@Repository
public class SINGROOMDao extends AprjDao{
    /**
     * 관리자_코드검색리스트
     * @param Zcom99010Model 관리자_코드
     * @return List<Zcom99010Model> 관리자_코드리스트
     */
    public List<SINGROOMModel> srchSINGROOMList(SINGROOMModel param) throws CommonException {
        try {
            return sessionConn.selectList("SINGROOMQuery.selectSINGROOMList", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_코드검색리스트수
     * @param Zcom99010Model 관리자_코드
     * @return String 관리자_코드리스트수
     */
    public String srchSINGROOMCnt(SINGROOMModel param) throws CommonException {
        try {
            return ((SINGROOMModel) sessionConn.selectOne("SINGROOMQuery.selectSINGROOMList_01", param)).getTotCnt();
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_코드검색
     * @param Zcom99010Model 관리자_코드
     * @return Zcom99010Model 관리자_코드
     */
    public SINGROOMModel srchSINGROOM(SINGROOMModel param) throws CommonException {
        try {
            return (SINGROOMModel) sessionConn.selectOne("SINGROOMQuery.selectSINGROOMList_02", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_코드입력
     * @param Zcom99010Model 관리자_코드
     * @return int 관리자_코드입력수
     */
    public int insertSINGROOM(SINGROOMModel param) throws CommonException {
        try {
            return sessionConn.update("SINGROOMQuery.insertSINGROOM", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_코드수정
     * @param Zcom99010Model 관리자_코드
     * @return int 관리자_코드수정수
     */
    public int updateSINGROOM(SINGROOMModel param) throws CommonException {
        try {
            return sessionConn.update("SINGROOMQuery.updateSINGROOM", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }


    /**
     * 관리자_코드삭제
     * @param Zcom99010Model 관리자_코드
     * @return int 관리자_코드삭제수
     */
    public int deleteSINGROOM(SINGROOMModel param) throws CommonException {
        try {
            return sessionConn.update("SINGROOMQuery.deleteSINGROOM", param);
        } catch ( Exception e) {
            throw new CommonException(e);
        }
    }
}
