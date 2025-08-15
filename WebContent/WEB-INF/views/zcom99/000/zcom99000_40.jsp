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
     *  검색
     **************************************************************************/
    function requestSrch() {
        requestPage(1);
    }

    /**************************************************************************
     *  검색 요청
     **************************************************************************/
    function requestPage(pageNo) {
        if ( !chkPage() ) {
            return false;
        }

        document.getElementById("pageNo").value = pageNo;

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Zcom.ACTION_ZCOM99000_40 %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
    }

    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function chkPage() {

        return true;
    }

    /**************************************************************************
     *  초기화
     **************************************************************************/
    function requestInit() {
        var grpCoId = "";

        requestDtl(grpCoId);
    }

    /**************************************************************************
     *  상세검색
     **************************************************************************/
    function requestDtl(grpCoId) {
        if ( !chkDtl() ) {
            return false;
        }

        document.getElementById("grpCoId").value = grpCoId;
        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Zcom.ACTION_ZCOM99000_41 %>" + getParam();

        document.getElementById("targetLayer").value = "detailLayer";
        requestPostAjax(action, setTable, document.getElementById("targetLayer").value);
    }

    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function chkDtl() {

        return true;
    }

    /**************************************************************************
     *  입력 요청
     **************************************************************************/
    function requestSave() {
        if ( !chkSave() ) {
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Zcom.ACTION_ZCOM99000_00 %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
    }

    /**************************************************************************
     *  check 입력 요청
     **************************************************************************/
    function chkSave() {
        if ( isEmptyObject(document.getElementById(Trim("grpCoId                       ")), Trim("그룹사 ID                     ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("grpCoNm                       ")), Trim("그룹사 명                     ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("grpCoCtt                      ")), Trim("그룹사 내용                   ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("effStaDt                      ")), Trim("유효 시작 일자                ")) ) return false;
        if ( isEmptyObject(document.getElementById(Trim("effEndDt                      ")), Trim("유효 종료 일자                ")) ) return false;

        return true;
    }

    /**************************************************************************
     *  삭제 요청
     **************************************************************************/
    function requestDel() {
        if ( !chkDel() ) {
            alert("삭제 대상이 없습니다. 삭제 대상을 선택하십시요.");
            return false;
        }

        var action = "<%= baseLoc %>/" + "<%= ActionConstants_Zcom.ACTION_ZCOM99000_80 %>";

        document.form1.target = "";
        document.form1.method = "post";
        document.form1.action = action + getParam();
        document.form1.submit();

        loading();
    }

    /**************************************************************************
     *  check 검색 요청
     **************************************************************************/
    function chkDel() {
        del = document.getElementsByName("delKey");
        if ( del.length > 0 ) {
            for ( var i = 0; i < del.length; i++ ) {
                if ( del[i].checked == true ) {
                    return true;
                }
            }
        } else {
            return false;
        }

        return false;
    }

    /**************************************************************************
     *  화면 로드시
     **************************************************************************/
    function loadPage() {
        DisabledBackColor();
        fncInitControl();

        try {
        	setPaging();
        } catch (e) {

        }
        try {
        	$.setDatePickerRange($("#srchStaDt"), $("#srchEndDt"));
        } catch (e) {

        }
        try {
        	message();
        } catch (e) {

        }
    }

    /***************************************************************************
     *  EnterKey 입력시 저장작업
     ***************************************************************************/
    function keyPress() {
        // Enter key
        if ( getKeyCode(event) == 13 )
        {
            if ( event.srcElement.name.indexOf("srch") == 0 ) {
                requestSrch();
            }
        }
    }

    window.onload      = loadPage;
    document.onkeydown = keyPress;

</script>


<body>
<form id="form1" name="form1" class="form-inline">
<div class="wrap">

    <!-- top menu -->
    <jsp:include page="/include/zcom/menu/topMenu.jsp" />


    <div class="container">
        <div class="inner">

	    <!-- top menu -->
	    <jsp:include page="/include/zcom/menu/leftMenu.jsp" />

            <div class="content">


            <!-- navi Menu -->
            <jsp:include page="/include/zcom/menu/naviMenu.jsp" />


                <!-- bodyarea -->
                <div class="bodyarea">


                    <div class="filter">
                        <div class="form-group">

                            <jsp:include page="/include/zcom/com/include_co_search.jsp" />

                            <div class="input-group">
                                <strong>조회 일자</strong>
                                <p>
                                    <span class="date_box"><input type="text" name="srchStaDt" id="srchStaDt" value="${srchStaDt}" title="조회 시작 일자" format="date"/></span>
                                    <span class="t-txt">~</span>
                                    <span class="date_box"><input type="text" name="srchEndDt" id="srchEndDt" value="${srchEndDt}" title="조회 종료 일자" format="date"/></span>
                                </p>
                            </div>

                            <div class="input-group">
                                <strong>그룹사 ID</strong>
                                <p>
                                <input type="text" name="srchGrpCoId"                  id="srchGrpCoId"                  value="<c:out value="${srchGrpCoId                   }"/>" class="w-full" title="그룹사 ID" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>그룹사 명</strong>
                                <p>
                                <input type="text" name="srchGrpCoNm"                  id="srchGrpCoNm"                  value="<c:out value="${srchGrpCoNm                   }"/>" class="w-full" title="그룹사 명" />
                                </p>
                            </div>
                            <div class="input-group">
                                <strong>그룹사 내용</strong>
                                <p>
                                <input type="text" name="srchGrpCoCtt"                 id="srchGrpCoCtt"                 value="<c:out value="${srchGrpCoCtt                  }"/>" class="w-full" title="그룹사 내용" />
                                </p>
                            </div>

                        </div>
                        <!-- form-group -->

                        <div class="btnarea">
                            <button class="btn point-b" title="검색" onclick="requestSrch(); return false;"><i class="i-search"></i>검색</button>
                        </div>

                    </div>
                    <!-- filter area -->


                    <div class="list-top">
                        <div class="select-box">
                            <select title="정렬방법">
                                <option>10개씩 보기</option>
                                <option>20개씩 보기</option>
                                <option>30개씩 보기</option>
                            </select>
                        </div>
                        <div class="btnarea">
                            <button class="btn default" title="삭제" onclick="requestDel();return false;">삭제</button>
                        </div>
                    </div>

                    <table class="table list">
                        <caption class="blind">검색 목록</caption>
                        <colgroup>
                            <col style="width:30px">
                            <col style="width:60px">
                            <col width="10%" />
                            <col width="10%" />
                            <col width="10%" />
                            <col width="10%" />
                            <col width="10%" />
                            <col width="*" />
                        </colgroup>
                        <tr>
                            <th><input type="checkbox" name="delKeyAll" id="delKeyAll" title="모두 선택" onclick="selectAll(event);"></th>
                            <th>번호</th>
                            <th>그룹사 ID</th>
                            <th>그룹사 명</th>
                            <th>그룹사 내용</th>
                            <th>유효 시작 일자</th>
                            <th>유효 종료 일자</th>
                        </tr>


                        <!-- 리스트 -->
                        <c:forEach var="row" items="${resultList}" varStatus="status">
                        <tr style="cursor:pointer;" onclick="requestDtl('<c:out value="${row.grpCoId}"/>');">
                            <td class="tx-center"><input type="checkbox" name="delKey" id="delKey" title="선택" onclick="selectAll(event);" value="<c:out value="${row.grpCoId}"/>"></td>
                            <td class="tx-center"><c:out value="${row.rowNum                        }"/></td>
                            <td class="tx-left"  ><c:out value="${row.grpCoId                       }"/></td>
                            <td class="tx-left"  ><c:out value="${row.grpCoNm                       }"/></td>
                            <td class="tx-left"  ><c:out value="${row.grpCoCtt                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.effStaDt                      }"/></td>
                            <td class="tx-left"  ><c:out value="${row.effEndDt                      }"/></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- table list -->

                    <div id="gridPaging" class="list-btm"></div>
                </div>
                <!-- bodyarea -->

                <!-- bodyarea -->
                <div class="bodyarea">
                    <h4><c:out value="${naviMenu.menuNm}"/> 상세정보</h4>
		            <div id="detailLayer">
		                <jsp:include page="./zcom99000_41.jsp" />
		            </div>
                    <div class="btnarea_bottom">
                        <button class="btn default" title="코드등록" onclick="openCd()     ;return false;">코드등록</button>
                        <button class="btn default" title="저장"     onclick="requestSave();return false;">저장</button>
                        <button class="btn default" title="초기화"   onclick="requestInit();return false;">초기화</button>
                    </div>
                </div>
                <!--//bodyarea-->
            </div>
            <!--//content-->
        </div>
        <!--//inner -->
    </div>
    <!--//container -->

    <!-- footer -->
    <jsp:include page="/include/zcom/include_footer.jsp" />
    <!--//footer -->
</div>
<!--//wrap -->

</form>
</body>
</html>