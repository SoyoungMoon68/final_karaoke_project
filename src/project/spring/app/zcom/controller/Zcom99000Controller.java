/*-------------------------------------------------------------------
* NAME   : Zcom99000Controller
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

package project.spring.app.zcom.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.spring.app.zcom.lib.object.ZcomController;
import project.spring.app.zcom.constants.ActionConstants_Zcom;
import project.spring.app.zcom.constants.ViewConstants_Zcom;
import project.spring.app.zcom.service.Zcom99000Service;
import project.spring.app.zcom.model.Zcom99000Model;

import project.spring.app.zcom.lib.object.CommonException;


@Controller
public class Zcom99000Controller extends ZcomController {

    @Autowired
    Zcom99000Service serviceZcom99000;

    private String resultList                     = "resultList"                  ;  // 리스트결과
    private String resultListCnt                  = "resultListCnt"               ;  // 리스트결과수
    private String resultCnt                      = "resultCnt"                   ;  // 결과수
    private String resultObject                   = "resultObject"                ;  // 검색결과

    private String grpCoList                      = "grpCoList"            ;  // 그룹사 리스트            
    /**
     * 관리자_그룹사리스트조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Zcom.ACTION_ZCOM99000_40)
    public @ResponseBody Object srchZcom99000List(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView, true) ) {
            return returnResponse(modelAndView);
        }

        Zcom99000Model grpCoParam = (Zcom99000Model) toBean(request, Zcom99000Model.class);
        modelAndView.addObject(grpCoList, serviceZcom99000.srchZcom99000TotalList(grpCoParam));
        
        Zcom99000Model param = new Zcom99000Model();
        getParameter(request, param);

        modelAndView.addObject(resultList   , serviceZcom99000.srchZcom99000List(param));
        modelAndView.addObject(resultListCnt, serviceZcom99000.srchZcom99000Cnt (param));

        modelAndView.setViewName(ViewConstants_Zcom.VIEW_ZCOM99000_40);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_그룹사조회
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Zcom.ACTION_ZCOM99000_41)
    public @ResponseBody Object srchZcom99000(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99000Model param = new Zcom99000Model();
        getParameter(request, param);

        modelAndView.addObject(resultObject , serviceZcom99000.srchZcom99000(param));

        modelAndView.setViewName(ViewConstants_Zcom.VIEW_ZCOM99000_41);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_그룹사저장
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Zcom.ACTION_ZCOM99000_00)
    public @ResponseBody Object saveZcom99000(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        Zcom99000Model param = new Zcom99000Model();
        getParameter(request, param);

        int cnt = 0;
        cnt = serviceZcom99000.saveZcom99000(param);

        modelAndView = (ModelAndView) srchZcom99000List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }


    /**
     * 관리자_그룹사삭제
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView ModelAndView객체
     * @exception Exception 처리 에러발생.
     */
    @RequestMapping(ActionConstants_Zcom.ACTION_ZCOM99000_80)
    public @ResponseBody Object deleteZcom99000(HttpServletRequest request) throws CommonException {
        ModelAndView modelAndView = new ModelAndView();
        this.init(request, modelAndView);

        // 사용자 로그인여부
        if ( !this.isLogin(request, modelAndView) ) {
            return returnResponse(modelAndView);
        }

        int cnt = 0;
        String[] delKeys = request.getParameterValues("delKey");
        Zcom99000Model param = new Zcom99000Model();
        for ( int i = 0; i < delKeys.length; i++ ) {
            param.setGrpCoId(delKeys[i]);

            cnt =+ serviceZcom99000.deleteZcom99000(param);
        }

        modelAndView = (ModelAndView) srchZcom99000List(request);
        modelAndView.addObject(resultCnt    , cnt);
        return returnResponse(modelAndView);
    }
}