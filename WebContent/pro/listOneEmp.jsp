<%@page import="com.product.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>

<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
	ProductVO proVO = (ProductVO) request.getAttribute("proVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
	pageContext.setAttribute("list",proVO);
%>

<html>
<head>
<title>�ӫ~���O��� - listOneEmp.jsp</title>

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
	width: 600px;
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
    .imgsize {
   width: 300px;
   height: auto;
  }
</style>

</head>
<body bgcolor='white'>

<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>���u��� - ListOneEmp.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<td>�ӫ~�s��</td>
		<td>�ӫ~���O�s��</td>
		<td>�ӫ~�W��</td>
		<td>�ӫ~�Ϥ�</td>
		<td>�Ӥ����ɦW</td>
		<td>�ӫ~�W��</td>
		<td>�ӫ~���</td>
		<td>�ӫ~�w�s�q</td>
		<td>�ӫ~�w���w�s�q</td>
		<td>�ӫ~�ԭz</td>
		<td>�ӫ~���A</td>
		<td>�ӫ~�`����</td>
		<td>�ӫ~�����`�H��</td>
	
	</tr>
	${list.pro_no}
	<tr>
	     <td><%=proVO.getPro_no()%></td>
		 <td><%=proVO.getPro_classid()%></td>
		 <td><%=proVO.getPro_name()%></td>
		 
		 <td><img class="imgsize" src="<%=request.getContextPath()%>/pro/proImg.do?pro_no=<%= proVO.getPro_no() %>">
		 
		 <td><%=proVO.getPro_pic_ext()%></td>
		 <td><%=proVO.getPro_format()%></td>
		 <td><%=proVO.getPro_bonus()%></td>
		 <td><%=proVO.getPro_stock()%></td>
		 <td><%=proVO.getPro_safestock()%></td>
		 <td><%=proVO.getPro_details()%></td>
		 <td><%=proVO.getPro_shelve()%></td>
		 <td><%=proVO.getPro_all_assess()%></td>
		 <td><%=proVO.getPro_all_assessman()%></td>
	
	</tr>
</table>

</body>
</html>