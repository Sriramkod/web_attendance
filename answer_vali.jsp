<%@ page import="java.sql.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<% 
String ans=" ";
if(request.getParameter("correctAns")!=null)
{
ans=request.getParameter("correctAns").toString();
}
Connection conn = null;
ResultSet qrst;
ResultSet rs = null;

String id=request.getParameter("id");
System.out.println("id:"+id);

int i=1;

String s,g;

int count=0;

try {
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sriram","root","root");
if(con!=null);
out.println("ok");
Statement st;
st = conn.createStatement();
rs = st.executeQuery("select * from question");

while(rs.next()) {
%>
 <br>
<br/>
<center>

<table border="1" width="500px" bgcolor="pink" cellspacing="0" cellpadding="0">
<tr>
<td width="100%">

<form name="form1">

<h2 align="center"><font color="red">Online Quize Application</font></h2>

<b>Select Correct Answer</b>
<table border="0" width="500px" cellspacing="2" cellpadding="4">
<tr>

<td width="50%"> Question:</td>
<input type="text" name="correctAns" value="<%=rs.getString(1)%>" />
<tr>
<td><%= rs.getString("quest") %></td></tr>
<tr>
<td>

1: <input type="radio" name="a" value= "QA" /></td>
<td><%= rs.getString(2) %></td></tr> 
<tr>
<td>
2: <input type="radio" name="a" value="QB" /></td>
<td><%= rs.getString(3) %></td></tr>

<tr>
<td>
3: <input type="radio" name="a" value="QC" /></td>
<td><%= rs.getString("3") %> </td></tr>

<tr>
<td>
4: <input type="radio" name="a" value="QD" /> </td>
<td> <%= rs.getString("4") %> </td></tr>

<tr>
<td>
<center>
<input type="submit" value="Submit" name="submit"></center></td></tr>
</table>

</form>
</td>
</tr>
</table>
</center>
</body>
<% g=request.getParameter("a");
%>
<% 
if(g.equals(ans)){

count++;
out.println("Correct");

}
else
out.println("false");
%>

<%
}}

catch (Exception ex) {
ex.printStackTrace();

%>

<%
} 
out.println("Score="+count);
%>
</html>


