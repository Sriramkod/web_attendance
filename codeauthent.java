import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class codeauthent extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException,NullPointerException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String code=req.getParameter("tf1");
int k;
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sriram","root","root");
if(con!=null)
pw.println("ok");
else
pw.println("not ok");

PreparedStatement pst1=con.prepareStatement("select * from answers where code='5299'");
ResultSet rst=pst1.executeQuery();
String c="";
while(rst.next())
{
c=rst.getString(8);
}
if(c.equals(code))
res.sendRedirect("vali.jsp");
else
res.sendRedirect("quizlogin.html");
Window.alert("Invalid code");
}
catch(Exception e)
{
pw.println(e);
}
}
}