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
<%@ page import="project.spring.app.zcom.constants.ActionConstants_Zcom" %>

<script type="text/javascript">

    var ctx = '${pageContext.request.contextPath}';

    /**************************************************************************
     *  거래처 검색
     **************************************************************************/
    function requestPopup(type) {
    	
        returnFunction = "setData";
        switch ( type ) {
	        case 'USER' :
	            returnFunction = "setUser";
	            break;
            case 'SUP_USER' :
                returnFunction = "setSupUser";
                break;
            case 'GRP_CO' :
                returnFunction = "setGrpCo";
                break;
        }
        
        requestPopupType(type, returnFunction);
    }
    
    /**************************************************************************
     *  거래처 검색
     **************************************************************************/
    function requestPopupType(type, returnFunction) {
    	
    	switch ( type ) {
	        case 'USER' :
	            openUser(returnFunction);
	            break;
            case 'SUP_USER' :
                openUser(returnFunction);
                break;
            case 'GRP_CO' :
                openGrpCo(returnFunction);
                break;
    	}
    }
    
    
    
    /**************************************************************************
     *  사용자 설정
     **************************************************************************/
    function setData(data) {
        for ( var key in data) {
            var val = data[key];
            if ( document.getElementById(key) != null ) {
                document.getElementById(key).value = val;
            }
        }
    }

    
    function setObjectValue(objId, objVal) {
        if ( document.getElementById(objId) != null ) {
            document.getElementById(objId).value = objVal;
        }
    }
    

    /**************************************************************************
     *  사용자 검색
     **************************************************************************/
    function openUser(returnFunction) {
        addParam("newPage", true);
        document.getElementById("returnFunction").value = returnFunction;
        var action = ctx + "/" + "<%= ActionConstants_Zcom.ACTION_ZCOM99030_90 %>";
        var target = "user";
        openPopup(target, '', 800, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    /**************************************************************************
     *  자산 설정
     **************************************************************************/
    function setUser(data) {
    	setData(data);
    }

    /**************************************************************************
     *  자산 설정
     **************************************************************************/
    function setSupUser(data) {
        document.getElementById("supUserId").value = data.userId;
        document.getElementById("supUserNm").value = data.userNm;
    }
    
    
    /**************************************************************************
     *  업체 검색
     **************************************************************************/
    function openGrpCo(returnFunction) {
        addParam("newPage", true);
        document.getElementById("returnFunction").value = returnFunction;
        var action = ctx + "/" + "<%= ActionConstants_Zcom.ACTION_ZCOM99000_90 %>" + getParam();
        var target = "co";
        openPopup(target, '', 800, 600, "YES");
        
        document.form1.target = target;
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();
    }
    
    /**************************************************************************
     *  업체 설정
     **************************************************************************/
    function setCo(data) {
        setData(data);
    }

</script>
