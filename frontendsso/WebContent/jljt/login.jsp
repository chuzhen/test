<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
/**
 * 电科院-卫士通 集成
 */
String userName = request.getParameter("userName");
if(userName == null){
    userName = "";
}
boolean error = "1".equals(request.getParameter("error"));
%>
<html>
<head>
<meta name="gwt:property" content="locale=zh_CN">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<title>系统登录</title>
<link href="style/alogin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
var error = <%=error%>;
function doInit(){
    if(error){
        alert("用户名或密码错误，请重新输入");
        form1.passwd.focus();
    }else{
        form1.usercode.focus();
        //form1.submit();
    }
}
</script>
</head>
<body onload="doInit()">
    <form name="form1" action="login_process.jsp" target="_self" method="post">
    <div class="Main" style="display:block">
        <ul class="top_ul">
            <li class="top"></li>
            <li class="top2"></li>
            <li class="topA"></li>
            <li class="topB"><span>
                <!-- <img src="images/login/logo.gif" alt="" style="" /> -->
            </span></li>
            <li class="topC"></li>
            <li class="topD">
                <ul class="login">
                    
                    <%
                    for(int i=0; i<10; i++) {
                    %>
                    	<li><span class="left"></span> <span style="left">
                        	<!-- <input id="Text3" type="text" class="txtCode" /> -->  
                        </span></li>
                    <%
                    }
                    %>
                   
                    <li><span class="left">用户名：</span> <span style="left">
                        <input id="usercode" name="usercode" type="text" class="txt" value="<%=userName%>"/>  
                    </span></li>
                    <li><span class="left_blank"></span> <span style="left">
                    	<!-- <input id="Text3" type="text" class="txtCode" /> -->  
                    </span></li>
                    <li><span class="left">密 码：</span> <span style="left">
                       <input id="passwd" name="passwd" type="password" class="txt" />  
                    </span></li>
                    <li><span class="left_blank"></span> <span style="left">
                    	<!-- <input id="Text3" type="text" class="txtCode" /> -->  
                    </span></li>
                    <li><span class="left"></span>
                    	<img alt="登录" src="images/login/button.png" onclick="form1.submit()"/>
                    </li>
                    
                </ul>
            </li>
            <!-- <li class="middle_D"></li>
            <li class="bottom_A"></li>
            <li class="bottom_B"></li> -->
        </ul>
    </div>
    </form>
</body>
</html>
