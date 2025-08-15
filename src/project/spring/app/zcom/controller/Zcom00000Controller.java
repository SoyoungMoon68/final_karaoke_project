/*-------------------------------------------------------------------
* NAME   : Zcom00000Controller
* DESC   : 로그인
* Author : 
* DATE   : 2023-02-13
*--------------------------------------------------------------------
* 변 경 사 항                                                        
*--------------------------------------------------------------------
* DATE       AUTHOR DESCRIPTION                                      
* ---------- ------ -------------------------------------------------
*                                                                    
*------------------------------------------------------------------*/

package project.spring.app.zcom.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.aprj.constants.ApplicationConstants_Aprj;
import project.spring.app.zcom.constants.ActionConstants_Zcom;
import project.spring.app.zcom.constants.ViewConstants_Zcom;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.object.ZcomController;
import project.spring.app.zcom.lib.object.ZcomMessage;
import project.spring.app.zcom.lib.util.DateUtil;
import project.spring.app.zcom.lib.util.StringUtil;
import project.spring.app.zcom.model.Zcom99000Model;
import project.spring.app.zcom.model.Zcom99030Model;
import project.spring.app.zcom.service.Zcom99000Service;
import project.spring.app.zcom.service.Zcom99030Service;


@Controller
public class Zcom00000Controller extends ZcomController {

    @Autowired
    Zcom99000Service serviceZcom99000;

    @Autowired
    Zcom99030Service serviceZcom99030;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String grpCoList                      = "grpCoList"            ;  // 그룹사 리스트            
    /**
     * 로그인
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Zcom.ACTION_LOGIN)
    public @ResponseBody Object srchBacr10010List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);
        modelAndView.setViewName(ViewConstants_Zcom.VIEW_LOGIN);

        Zcom99000Model grpCoParam = (Zcom99000Model) toBean(request, Zcom99000Model.class);
        modelAndView.addObject(grpCoList, serviceZcom99000.srchZcom99000TotalList(grpCoParam));
        
        // 데이터 설정
        Zcom99030Model param = (Zcom99030Model) toBean(request, Zcom99030Model.class);
        
        // 사용자 ID가 없는 경우 화면만 오픈
        if ( StringUtil.isNull(param.getUserId()) ) {
            return returnResponse(modelAndView);
        }

        
        // 로그인 조회
        param.setSrchGrpCoId(param.getGrpCoId());
        param.setSrchUserId (param.getUserId ());
        
        List<Zcom99030Model> resultList = (List<Zcom99030Model>) serviceZcom99030.srchZcom99030List(param);
        
        
        // 사용자ID 오류
        if ( resultList == null || resultList.size() == 0 ) {
        	ZcomMessage.setMsg(modelAndView, "warn.common.login.fail.empty");
            return returnResponse(modelAndView);
        }

        Zcom99030Model result = resultList.get(0);

        // 사용자ID 오류
        if ( result == null ) {
        	ZcomMessage.setMsg(modelAndView, "warn.common.login.fail.empty");
            return returnResponse(modelAndView);
        }

        // 비밀번호 오류
        if ( !param.getUserPwd().equals(result.getUserPwd()) ) {
        	ZcomMessage.setMsg(modelAndView, "warn.common.login.fail.pwd");
            return returnResponse(modelAndView);
        }

        // 유효기간경과
        String currDt = DateUtil.getCurrentDate(DateUtil.sDateInputFormatYMD);
        if ( currDt.compareTo(result.getEffStaDt()) < 0 ) {
        	ZcomMessage.setMsg(modelAndView, "warn.common.login.fail.eff");
            return returnResponse(modelAndView);
        }

        if ( currDt.compareTo(result.getEffEndDt()) > 0 ) {
        	ZcomMessage.setMsg(modelAndView, "warn.common.login.fail.eff");
            return returnResponse(modelAndView);
        }
        
        // Session Time 설정
        if ( !ApplicationConstants_Aprj.USER_AUTH_ADMIN.equals(result.getUserAuthCd()) ) {
            // 관리자가 아닌 경우 session time out을 30분으로 설정.
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval((24 * 60 * 60) / 2);
        } else {
            // 관리자인 경우 session time out을 8시간으로 설정.
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(24 * 60 * 60);
        }
        
        String ip = request.getRemoteAddr();
        result.setRegIp(ip);
        result.setUpdIp(ip);
        
        sessionUser = result;
        setLogin(request, modelAndView);
        
//        modelAndView.setViewName(ViewConstants_Zcom.VIEW_LOGIN);
//        modelAndView.setViewName(ViewConstants_Zcom.VIEW_HOME);
//        modelAndView.setViewName(ViewConstants_Zcom.VIEW_ZCOM99000_40);
        return returnResponse(modelAndView);
    }


    /**
     * 로그아웃
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Zcom.ACTION_LOGOUT)
    public @ResponseBody Object srchBacr10010(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        removeLogin(request);

        modelAndView.setViewName(ViewConstants_Zcom.VIEW_LOGOUT);
        return returnResponse(modelAndView);
    }

}