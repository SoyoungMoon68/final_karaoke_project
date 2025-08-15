/*-------------------------------------------------------------------
* NAME   : SINGROOMController
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

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.aprj.constants.ActionConstants_Aprj;
import project.spring.app.aprj.constants.ViewConstants_Aprj;
import project.spring.app.aprj.lib.object.AprjMessage;
import project.spring.app.zcom.lib.object.CommonException;
import project.spring.app.zcom.lib.object.ZcomController;
import project.spring.app.song.SINGROOMModel;
import project.spring.app.song.SINGROOMService;


@Controller
public class SINGROOMController extends ZcomController {

    @Autowired
    SINGROOMService serviceSINGROOM;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    /**
     * 관리자_그룹코드리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_SINGROOM_40)
    public @ResponseBody Object srchSINGROOMList(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        SINGROOMModel param = new SINGROOMModel();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceSINGROOM.srchSINGROOMList(param));
        modelAndView.addObject(resultListCnt, serviceSINGROOM.srchSINGROOMCnt (param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_SINGROOM_40);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_그룹코드조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_SINGROOM_41)
    public @ResponseBody Object srchSINGROOM(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        SINGROOMModel param = new SINGROOMModel();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceSINGROOM.srchSINGROOM(param));

        modelAndView.setViewName(ViewConstants_Aprj.VIEW_SINGROOM_41);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_그룹코드저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_SINGROOM_00)
    public @ResponseBody Object saveSINGROOM(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        SINGROOMModel param = new SINGROOMModel();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceSINGROOM.saveSINGROOM(param);

        modelAndView = (ModelAndView) srchSINGROOMList(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.save.success");
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_그룹코드삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Aprj.ACTION_SINGROOM_80)
    public @ResponseBody Object deleteSINGROOM(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        SINGROOMModel param = new SINGROOMModel();
        for ( int i = 0; i < delKeys.length; i++ ) {

            cnt =+ serviceSINGROOM.deleteSINGROOM(param);
        }

        modelAndView = (ModelAndView) srchSINGROOMList(request);
        modelAndView.addObject(resultCnt    , cnt);
		AprjMessage.setMsg(modelAndView, "info.common.delete.success");
        return returnResponse(modelAndView);
    }
}