<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="com.jiuqi.url.SSL"%>
<%@page import="com.jiuqi.util.JqLib"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String userName = request.getHeader("iv-user");
	System.out.println("userName:" + userName);
	String encryptUserName = JqLib.encodePassword(userName, 20);

	//报表服务地址http://10.1.1.248
	String jqrServerUrl = "http://10.208.28.40:9797";//地址最后不要加斜杠 /
	//报表入口
	String jqrEntry = "";

	StringBuilder loginUrl = new StringBuilder();
	try {
		//SSL.trustAllHttpsCertificates();
		String ssoUrl = jqrServerUrl + "/sso?iv-user=" + encryptUserName;
	    System.out.println("ssoUrl:" + ssoUrl);
	    URL _url = new URL(ssoUrl);
	    URLConnection conn = _url.openConnection();
	    conn.setConnectTimeout(10000);
	    conn.setReadTimeout(10000);
        
	    BufferedReader br = new BufferedReader(new InputStreamReader(
	    conn.getInputStream()));
	    String line = null;
	    while ((line = br.readLine()) != null) {
	        if(loginUrl.length() > 0){
	        	loginUrl.append("\n");
	        }
	        loginUrl.append(line);
	    }
        response.sendRedirect(jqrServerUrl + loginUrl.toString());
	} catch (Exception e) {
	    e.printStackTrace();
	    out.print("报表服务器发生异常，请联系管理员！" + e.getClass().getName() + ":" + e.getMessage());
	}
%>