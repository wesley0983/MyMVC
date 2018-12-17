<%@page import="com.product.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
ProdouctVO prodouctVO = (ProdouctVO) request.getAttribute("empVO");
%>

<%= prodouctVO == null %>


<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>員工資料新增 - addEmp.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>員工資料新增 - addEmp.jsp</h3></td><td>
		 <h4><a href="select_page.jsp"><img src="images/tomcat.png" width="100" height="100" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="emp.do" name="form1">
<table>
    <tr>
		<td>商品類別編號(需要拉選單):</td>
		<td><input type="TEXT" name="pro_classid" size="45" 
			 value="<%= (prodouctVO==null)? "吳永志" : prodouctVO.getPro_classid()%>" /></td>
	</tr>
    <tr>
		<td>商品名稱:</td>
		<td><input type="TEXT" name="ename" size="45" 
			 value="<%= (prodouctVO==null)? "吳永志" : prodouctVO.getPro_name()%>" /></td>
	</tr>
	
	<tr>
		<td>照片副檔名:</td>
		<td><input type="TEXT" name="pic_ext" size="45"
			 value="<%= (prodouctVO==null)? "MANAGER" : prodouctVO.getPro_pic_ext()%>" /></td>
	</tr>
	<tr>
		<td>商品規格:</td>
		<td><input type="TEXT" name="format" size="45"
			 value="<%= (prodouctVO==null)? "MANAGER" : prodouctVO.getPro_format()%>" /></td>
	</tr>
	<tr>
		<td>商品單價:</td>
		<td><input type="TEXT" name="bonus" size="45"
			 value="<%= (prodouctVO==null)? "123" : prodouctVO.getPro_bonus()%>" /></td>
	</tr>
	<tr>
		<td>商品庫存量:</td>
		<td><input type="TEXT" name="stock" size="45"
			 value="<%= (prodouctVO==null)? "123" : prodouctVO.getPro_stock()%>" /></td>
	</tr>
	<tr>
		<td>商品安全庫存量:</td>
		<td><input type="TEXT" name="safestock" size="45"
			 value="<%= (prodouctVO==null)? "123" : prodouctVO.getPro_safestock()%>" /></td>
	</tr>
	<tr>
		<td>商品詳述:</td>
		<td><input type="TEXT" name="details" size="45"
			 value="<%= (prodouctVO==null)? "MANAGER" : prodouctVO.getPro_details()%>" /></td>
	</tr>
	<tr>
		<td>商品狀態:</td>
		<td><input type="TEXT" name="shelve" size="45"
			 value="<%= (prodouctVO==null)? "MANAGER" : prodouctVO.getPro_shelve()%>" /></td>
	</tr>
	<tr>
		<td>商品總評價:</td>
		<td><input type="TEXT" name="assess" size="45"
			 value="<%= (prodouctVO==null)? "123" : prodouctVO.getPro_all_assess()%>" /></td>
	</tr>
	<tr>
		<td>商品評價總人數:</td>
		<td><input type="TEXT" name="assessman" size="45"
			 value="<%= (prodouctVO==null)? "123" : prodouctVO.getPro_all_assessman()%>" /></td>
	</tr>
	
	

<%-- 	<jsp:useBean id="deptSvc" scope="page" class="com.product.model.ProductService" /> --%>
<!-- 	<tr> -->
<!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
<!-- 		<td><select size="1" name="deptno"> -->
<%-- 			<c:forEach var="deptVO" items="${proClassDAO.all}"> --%>
<%-- 				<option value="${prodouctVO.deptno}" ${(prodouctVO.pro_shelve==prodouctVO.pro_shelve)? 'selected':'' } > --%>
<%-- 			</c:forEach> --%>
<!-- 		</select></td> -->
<!-- 	</tr> -->

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>






</html>