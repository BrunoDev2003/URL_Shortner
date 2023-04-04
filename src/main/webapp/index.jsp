<%@taglib uri="" prefix="c" %>
<jsp:useBean id="linkViewer" class="com.url_shortner.view.LinkViewer"></jsp:useBean>
<%@page import="com.url_shortner.persistence.LinkBean"%>
<%@page import="com.url_shortner.persistence.linkDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Url Shortner</title>
</head>
<body>

	<div class="main">
		<h1>URL Shortener</h1>
		<form action="InsertUrlController" method="POST"> 
			<input type="url" required="required" name="url" placeholder="url">
			<input type="submit" value="Create URL" />
		</form>
		<c:out value="${msg }"></c:out>
		<table border="1">
			<thead>
				<tr>
					<th>Id</th>
					<th>URL</th>
					<th>Code</th>
					<th>Custom</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${linkViewer.getLinks }" var="link">
					<tr>
						<td>${link.getId() }</td>
						<td>${link.getCustom() }</td>
						<td>${link.getCode() }</td>
						<td>${link.getUrl() }</td>
					</tr>
				</c:forEach>
				
				
			</tbody>
		</table>
	</div>

</body>
</html>