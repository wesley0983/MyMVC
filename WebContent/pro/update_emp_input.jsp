<%@page import="com.product.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
ProductVO proVO = (ProductVO) request.getAttribute("empVO"); //EmpServlet.java (Concroller) �s�Jreq��empVO���� (�]�A�������X��empVO, �]�]�A��J��ƿ��~�ɪ�empVO����)
%>




<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>���u��ƭק� - update_emp_input.jsp</title>

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
		 <h3>���u��ƭק� - update_emp_input.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<h3>��ƭק�:</h3>

<%-- ���~���C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="pro.do" name="form1">
<table>
<tr>

<!-- 	<tr> -->
<!-- 		<td>�ӫ~�s��:<font color=red><b>*</b></font></td> -->
<%-- 		<td><%= proVO.getPro_no()%></td> --%>
<!-- 	</tr> -->

	<tr>
		<td>�ӫ~�s��:<font color=red><b>*</b></font></td>
		<td><%=proVO.getPro_no()%></td>
	</tr>

<!-- <td>�ӫ~�s��:</td> -->
<!--   <td><input type="TEXT" name="pro_no" size="45"  -->
<%--      value="<%= proVO.getPro_no()%>" /></td> --%>
<!-- </tr> -->

	<jsp:useBean id="productClassSvc" scope="page" class="com.productclass.model.ProductClassService" />
	<tr>
		<td>�ӫ~���O�s��:<font color=red><b>*</b></font></td>
		<td><select size="1" name="deptno">
			<c:forEach var="productClassVO" items="${productClassSvc.all}">
				<option value="${productClassVO.pro_classid}" ${(productClassVO.pro_classid==productClassVO.pro_classid)?'selected':'' } >${productClassVO.pro_classname}
			</c:forEach>
		</select></td>
	</tr>


<tr>
  <td>�ӫ~�W��:</td>
  <td><input type="TEXT" name="ename" size="45" 
     value="<%= proVO.getPro_name()%>" /></td>
</tr>

<tr>
  <td>�Ӥ����ɦW:</td>
  <td><input type="TEXT" name="pic_ext" size="45"
     value="<%= proVO.getPro_pic_ext()%>" /></td>
</tr>
<tr>
  <td>�ӫ~�W��:</td>
  <td><input type="TEXT" name="format" size="45"
     value="<%=  proVO.getPro_format()%>" /></td>
</tr>
<tr>
  <td>�ӫ~���:</td>
  <td><input type="TEXT" name="bonus" size="45"
     value="<%= proVO.getPro_bonus()%>" /></td>
</tr>
<tr>
  <td>�ӫ~�w�s�q:</td>
  <td><input type="TEXT" name="stock" size="45"
     value="<%= proVO.getPro_stock()%>" /></td>
</tr>
<tr>
  <td>�ӫ~�w���w�s�q:</td>
  <td><input type="TEXT" name="safestock" size="45"
     value="<%= proVO.getPro_safestock()%>" /></td>
</tr>
<tr>
  <td>�ӫ~�ԭz:</td>
  <td><input type="TEXT" name="details" size="45"
     value="<%=  proVO.getPro_details()%>" /></td>
</tr>
<tr>
  <td>�ӫ~���A:</td>
  <td><input type="TEXT" name="shelve" size="45"
     value="<%=  proVO.getPro_shelve()%>" /></td>
</tr>
<tr>
  <td>�ӫ~�`����:</td>
  <td><input type="TEXT" name="assess" size="45"
     value="<%= proVO.getPro_all_assess()%>" /></td>
</tr>
<tr>
  <td>�ӫ~�����`�H��:</td>
  <td><input type="TEXT" name="assessman" size="45"
     value="<%= proVO.getPro_all_assessman()%>" /></td>
</tr>



</table>
<br>

	<input type="hidden" name="action" value="update">
	<input type="hidden" name="pro_no" value="<%=proVO.getPro_no()%>">
	<input type="submit" value="�e�X�ק�"></FORM>
</body>




</html>