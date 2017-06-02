<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="com.jiuqi.url.SSL"%>
<%@page import="com.jiuqi.util.JqLib"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String userName = request.getParameter("userName");
String password = request.getParameter("password");
System.out.println(userName + "=" + password);
//报表服务地址http://10.1.1.248
String jqrServerUrl = "http://10.2.32.4:6888/bzxm";//地址最后不要加斜杠 /
//报表入口
String jqrEntry = "jqr";

StringBuilder sb = new StringBuilder();
try {
	//SSL.trustAllHttpsCertificates();
    URL _url = new URL(jqrServerUrl + "/jqr-user?action=validatePassword&userName=" + userName + "&password=" + JqLib.encodePassword(password, 20));
    URLConnection conn = _url.openConnection();
    BufferedReader br = new BufferedReader(new InputStreamReader(
    conn.getInputStream()));
    String line = null;
    while ((line = br.readLine()) != null) {
        if(sb.length() > 0){
           sb.append("\n");
        }
        sb.append(line);
    }
    
    String finalUrl = null;
    if("true".equalsIgnoreCase(sb.toString())){
    	finalUrl = jqrServerUrl + "/" + jqrEntry +"/login,JQRPassword," + JqLib.encodePassword(password, 20) + "," + userName + "/";
    }else{
	    System.out.println(sb);
	    finalUrl = "login.jsp?userName=" + userName + "&error=1";
    }
    
    StringBuffer result = new StringBuffer();
	result.append("<script>");
	result.append("top.location = '"+finalUrl+"';\n");
	result.append("</script>");
	
    //response.sendRedirect(finalUrl);
    out.print(result);
    out.flush();
    System.out.println(result);
} catch (Exception e) {
    e.printStackTrace();
    out.print("报表服务器发生异常，请联系管理员！" + e.getClass().getName() + ":" + e.getMessage());
}%>

