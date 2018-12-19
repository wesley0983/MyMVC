<%@page import="com.product.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	ProductService proSvc = new ProductService();
    List<ProductVO> list = proSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有員工資料 - listAllEmp.jsp</title>

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
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有員工資料 - listAllEmp.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<table>
	<tr>
	    <th>商品編號:</th>
		<th>商品類別編號(需要拉選單):</th>
		<th>商品名稱:</th>
		<th>照片:</th>
		<th>照片副檔名:</th>
		<th>商品規格:</th>
		<th>商品單價:</th>
		<th>商品庫存量:</th>
		<th>商品安全庫存量:</th>
		<th>商品詳述:</th>
		<th>商品狀態:</th>
		<th>商品總評價:</th>
		<th>商品評價總人數:</th>
		
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="proVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
		    <td>${proVO.pro_no}</td>
			<td>${proVO.pro_classid}</td>
			<td>${proVO.pro_name}</td>
			<td>${proVO.pro_pic}</td>
			
			<td><img src="<%=request.getContextPath()%>/pro/proImg.do?pro_no=${proVO.pro_no}">
			
			<td>${proVO.pro_pic_ext}</td>
			<td>${proVO.pro_format}</td>
			<td>${proVO.pro_bonus}</td>
			<td>${proVO.pro_stock}</td>
			<td>${proVO.pro_safestock}</td>
			<td>${proVO.pro_details}</td>
			<td>${proVO.pro_shelve}</td>
			<td>${proVO.pro_all_assess}</td>
			<td>${proVO.pro_all_assessman}</td>
		<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/pro/pro.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="pro_no"  value="${proVO.pro_no}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/pro/pro.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="pro_no"  value="${proVO.pro_no}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>