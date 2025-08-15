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

                    <table class="table form">
                        <caption class="blind">상세정보</caption>
                        <colgroup>
                            <col style="width:15%">
                            <col style="width:35%">
                            <col style="width:15%">
                            <col style="width:35%">
                        </colgroup>
                        <tbody>
                            <tr>
                                <th>그룹사 ID</th>
                                <td>
                                    <input type="text" name="grpCoId"                      id="grpCoId"                      value="<c:out value="${resultObject.grpCoId                       }"/>" title="그룹사 ID"                    maxlength="5"    class="w-full" />
                                </td>
                                <th>그룹사 명</th>
                                <td>
                                    <input type="text" name="grpCoNm"                      id="grpCoNm"                      value="<c:out value="${resultObject.grpCoNm                       }"/>" title="그룹사 명"                    maxlength="100"  class="w-full" />
                                </td>
                            </tr>
                            <tr>
                                <th>그룹사 내용</th>
                                <td>
                                    <textarea          name="grpCoCtt"                     id="grpCoCtt"                                                                                             title="그룹사 내용"                  maxlength="200"  class="w-full" onKeyUp="setMaxLength();" ><c:out value="${resultObject.grpCoCtt}"/></textarea>
                                </td>
                            <tr>
                                <th>유효 일자</th>
                                <td colspan="3">
                                    <span class="date_box"><input type="text" name="effStaDt"                     id="effStaDt"                     value="<c:out value="${resultObject.effStaDtFormat                }"/>" title="시작일 선택" format="date"></span>
                                    <span class="t-txt">~</span>
                                    <span class="date_box"><input type="text" name="effEndDt"                     id="effEndDt"                     value="<c:out value="${resultObject.effEndDtFormat                }"/>" title="종료일 선택" format="date"></span>
                                </td>
                            </tr>
                            <jsp:include page="/include/zcom/com/include_reg_detail.jsp" />
                        </tbody>
                    </table>


<script type="text/javascript">

    $.setDatePickerRange($("#effStaDt"), $("#effEndDt"));

    /**************************************************************************
     *  Key 설정
     **************************************************************************/
    function setKeyReadonly() {
        setKeyDisabled(document.getElementById(Trim("grpCoId                       ")));
    }

    setKeyReadonly();

</script>
