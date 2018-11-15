<html>
<head>
<style>
body{
background-image:url("email1.jpg");
background-repeat:no-repeat;
}
#id1{
padding-top:80;
color:blue;
}
table{
padding-top:100;
}
</style>
</head>
<body><center><h3 id="id1"><i>Your attendance has been updated</i></h3></center>
<center>
<form action="mail" method="post">
<table>
  <tr><td>To:</td><td><input type="text" name="to" value="peddi.shashank6@gmail.com"></td></tr>
 <tr><td>Subject:</td><td><input type="text" name="subject" ></td></tr>
 <tr><td>Message:</td><td><input type="text" name="message"  required></td></tr>
  <tr><td>Your Email id:</td><td><input type="email" name="user" required></td></tr>
  <tr><td>Password</td><td><input type="password" name="pass" required></td></tr>
 <tr><td><input type="submit" value="send" /></td></tr>
</table>
</form>
</center>
<p>NOTE:
To send mail plz allow the permission</p>
</body>
</html>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%
try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wt_ass","root","root");
	if(con!=null)
	out.println("ok");
	else
	out.println("not ok");
	String s = "SELECT emailid FROM lectureregistartion WHERE username =?";
        pst=conn.prepareStatement(s);
        pst.setString(1,.getText());
	/*request.getParameter("")
	PreparedStatement pst=con.prepareStatement("select emailid from lectureregistration where username='?'");
	pst.setString(1,username);*/

	HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("uname");  
        out.print("Hello "+n);  
        
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String message =  request.getParameter("message");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        SendMail.send(to,subject, message, user, pass);
        out.println("Mail send successfully");

out.println("<html><a href=lecture.html>--Go Back to main form</a></html>");

       //response.setRedirect("lecture.html");
%>
}
<%
catch(Exception e)
{
}
%>
</html>