<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="jspf/head_config.jspf"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twitter App</title>
</head>
<body>
	<%@ include file="jspf/header.jspf"%>
	<%@ include file="jspf/main_menu.jspf"%>
	
	<form:form modelAttribute="tweet" method="post">
		<form:hidden path="id"/>
		
		<div>
			<form:label path="text">Tweet</form:label>
			<form:textarea path="text" placeholder="Your tweet"/>
			<form:errors path="text"></form:errors>
		</div>
		<div>
			<input type="submit" value="Zapisz"/>
		</div>
	</form:form>
	
	

	<%@ include file="jspf/footer.jspf"%>
</body>
</html>