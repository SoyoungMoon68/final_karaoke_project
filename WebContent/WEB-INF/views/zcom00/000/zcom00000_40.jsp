<%@page import="project.spring.app.zcom.constants.ActionConstants_Zcom"%>
<%@ page
  info         = "Project Management"
  language     = "java"
  session      = "true"
  buffer       = "16kb" 
  autoFlush    = "true"
  isThreadSafe = "true"
  isErrorPage  = "false"
  contentType  = "text/html; charset=utf-8"
%>

<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/include/zcom/include_header.jsp" %>

<script type="text/javascript">

    /**************************************************************************
     *  ID저장요청
     **************************************************************************/
    function confirmSave(checkbox) {
        var isRemember;

        if ( checkbox.checked ) {
            isRemember = confirm("이 PC에 로그인 정보를 저장하시겠습니까? PC방등의 공공장소에서는 개인정보가 유출될 수 있으니 주의해주십시오.");

            if ( !isRemember ) {
                checkbox.checked = false;
                setCookie("saveGrpCoId", "", -1);
                setCookie("saveUserId" , "", -1);
            }
        }
    }

    /**************************************************************************
     *  로그인요청
     **************************************************************************/
    function requestLogin() {
        if ( !chkLogin() ) {
            return false;
        }

        if ( document.form1.idSave.checked == false ) {
            setCookie("saveGrpCoId", "", -1);
            setCookie("saveUserId" , "", -1);
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Zcom.ACTION_LOGIN %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action;
        document.form1.submit();

        loading();
    }

    /**************************************************************************
     *  check 로그인요청
     **************************************************************************/
    function chkLogin() {
        if ( isEmptyObject(document.form1.grpCoId , "그룹사"         ) ) return false;
        if ( isEmptyObject(document.form1.userId  , "사용자 ID"      ) ) return false;
        if ( isEmptyObject(document.form1.userPwd , "사용자 비밀번호") ) return false;

        return true;
    }

    /**************************************************************************
     *  화면 로드시
     **************************************************************************/
    function loadPage() {

        var saveGrpCoId = getCookie("saveGrpCoId");
        var saveUserId  = getCookie("saveUserId" );
        
        if ( saveUserId != null && saveUserId != "" ) {
            $("#grpCoId").val(saveGrpCoId);
            $("#userId" ).val(saveUserId );
            $("#userPwd").focus();
            $("#idSave").attr("checked", true);
        } else {
            $("#userId").focus();
        }

        try {
            message();
        } catch ( e ) {
        }

        try {
        	goHome();
        } catch ( e ) {
        }

    }

    /***************************************************************************
     *  EnterKey 입력시 저장작업
     ***************************************************************************/
    function keyPress() {
        // Enter key
        if ( event.keyCode == 13 ) {
            requestLogin();
        }
    }

    window.onload      = loadPage;
    document.onkeydown = keyPress;

</script>


<c:if test="${!empty sessionUser}" >
<script type="text/javascript">

    /**************************************************************************
     *  사용자 검색
     **************************************************************************/
    function goHome() {
    	
    	var idSave = '<c:out value="${idSave}"/>';
    	if ( idSave == '1' ) {
    		setCookie("saveGrpCoId", "<c:out value="${grpCoId}"/>", 365);
    		setCookie("saveUserId" , "<c:out value="${userId }"/>", 365);
    	}
    	
    	var remoteActId = '<c:out value="${remoteActId}"/>';
    	if ( isEmpty(remoteActId) ) {
    		remoteActId = "<%= ActionConstants_Zcom.ACTION_HOME %>";
    	}
        var action = ctx + "/" + remoteActId;
        
        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
</script>
</c:if>

</head>


<body>
<div class="login_bg">  
    <div class="login_page">
        <div class="login_wrap">
            <div class="login_container">
                <div class="login_logo">
                    <h1><img src="<%= imgLoc %>/login-h1.png" alt="Login"></h1>
                </div>
                <div class="login">
                    <form name="form1">
                        <input type="hidden" id="remoteActId"    name="remoteActId"    value="${remoteActId}"/>
                        <fieldset>
                        <legend>Project Login</legend>
                        <div class="login_area">
                            <ul>
                                <li>
                                    <span>Project</span>
                                    <div class="email">
	                                    <select name="grpCoId"                   id="grpCoId"                   class="w-full">
	                                        <option value="">선택하세요</option>
	                                    <c:forEach var="code" items="${grpCoList}" varStatus="status">
	                                        <option value="${code.grpCoId}" <c:if test="${code.grpCoId == grpCoId}">selected</c:if>>${code.grpCoNm}</option>
	                                    </c:forEach>
	                                    </select>
                                    </div>
                                </li>
                                <li>
                                    <span>아이디</span>
                                    <div class="email">
                                        <input id="userId"     name="userId"     value="${userId}"     class="form-control" title="아이디"   type="text"     placeholder="아이디"  format="alpha" required autofocus />
                                    </div>
                                </li>
                                <li>
                                    <span>비밀번호</span>
                                    <div class="pwd">
                                        <input id="userPwd"    name="userPwd"    value="${userPwd}"    class="form-control" title="비밀번호" type="password" placeholder="비밀번호" required />
                                    </div>
                                </li>
                            </ul>
                            <div class="btn_login">
                            <a href="#" type="submit" onclick="requestLogin(); return false;">로그인</a>
                            </div>
                        </div>
                        <div class="login_check_info">
                            <input type="checkbox" id="idSave" name="idSave" value="1" onclick="confirmSave(this);">
                            <label for="idsave">아이디 저장</label>
                        </div>
                        </fieldset>
                    </form>
                </div>
            </div>
            <div class="copy_area">
                <p>COPYRIGHT GADIAN Security. CO., LTD. ALL RIGHTS RESERVED.</p>
            </div>
        </div>
        <!--//login_wrap-->
    </div>
</div>  
</body>
</html>

