<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="2" width="100%" height="100%">
<tr>
<td colspan="2"><img src="images/qqbj.gif" width="100%" height="30%"></td>
</tr>

<!-- <tr> -->
<!-- <td width="50%"><a href="tencent://message/?uin=2644794564"><img src="images/qq.png" width="30" height="30"><font size="4" color="red"><b>&nbsp;客服一: &nbsp;</b></font><font size="4"><b>与我联系...</b></font></a></td> -->
<!-- <td><a href="tencent://message/?uin=2424203561"><img src="images/qq.png" width="30" height="30"><font size="4" color="red"><b>&nbsp;客服二: &nbsp;</b></font><font size="4"><b>与我联系...</b></font></a></td> -->
<!-- </tr> -->

<!-- <tr> -->
<!-- <td><a href="tencent://message/?uin=984208452"><img src="images/qq.png" width="30" height="30"><font size="4" color="red"><b>&nbsp;客服三: &nbsp;</b></font><font size="4"><b>与我联系...</b></font></a></td> -->
<!-- <td><a href="tencent://message/?uin=1004666187"><img src="images/qq.png" width="30" height="30"><font size="4" color="red"><b>&nbsp;客服四: &nbsp;</b></font><font size="4"><b>与我联系...</b></font></a></td> -->
<!-- </tr> -->

<!-- <tr> -->
<!-- <td><a href="tencent://message/?uin=466169163"><img src="images/qq.png" width="30" height="30"><font size="4" color="red"><b>&nbsp;客服五: &nbsp;</b></font><font size="4"><b>与我联系...</b></font></a></td> -->
<!-- <td><a href="tencent://message/?uin=1010851542"><img src="images/qq.png" width="30" height="30"><font size="4" color="red"><b>&nbsp;客服六: &nbsp;</b></font><font size="4"><b>与我联系...</b></font></a></td> -->
<!-- </tr> -->

<!-- <tr> -->
<!-- <td><a href="tencent://message/?uin=2508240794"><img src="images/qq.png" width="30" height="30"><font size="4" color="red"><b>&nbsp;客服七: &nbsp;</b></font><font size="4"><b>与我联系...</b></font></a></td> -->
<!-- <td><a href="tencent://message/?uin=461202797"><img src="images/qq.png" width="30" height="30"><font size="4" color="red"><b>&nbsp;客服八: &nbsp;</b></font><font size="4"><b>与我联系...</b></font></a></td> -->
<!-- </tr> -->

<s:iterator value="list">
	<tr align="center"><td><a href="tencent://message/?uin=${rqq}"><img src="images/qq.png" width="30" height="30"><font size="4" color="red"><b>&nbsp;${reffect}: ${rcontent}&nbsp;</b></font><font size="4"><b>与我联系...</b></font></a></td></tr>
</s:iterator>
</table>
</body>
</html>