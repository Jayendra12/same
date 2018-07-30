<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<!-- <a href="savefile.html">click</a>
<form action="hello.html"  enctype="multipart/form-data">
Username:<input type="text" name="username">
Password:<input type="text" name="password">

<input type="submit" value="login"> -->

<h1>File Upload Example - JavaTpoint</h1>  
  
    
<form:form method="post" action="savefile.html" enctype="multipart/form-data">  
<p><label for="image">Choose Image</label></p>  
<p><input name="file" id="fileToUpload" type="file" /></p>  
<p><input type="submit" value="Upload"></p>  
</form:form>

</form>
</body>
</html>