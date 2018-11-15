import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class stddisplay extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String name=req.getParameter("tf1");
String period=req.getParameter("tf2");

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sriram","root","root");
if(con!=null)
pw.println("Today's date:");
else
pw.println("not ok");

pw.println("<html><body>");

pw.println("<table>");
PreparedStatement pst=con.prepareStatement("SELECT CURRENT_DATE");

ResultSet rst1=pst.executeQuery();
String date="";
while(rst1.next())
{
pw.println("<tr><h1>DATE AND TIME:</h1></tr>"+rst1.getString(1));
}
pw.println("<tr><center><h1>Student details</h1></center></tr>");

PreparedStatement pst1=con.prepareStatement("select * from cse_c_attendance where date_time=?");
pst1.setString(1,name);
ResultSet rst=pst1.executeQuery();
while(rst.next())
{
pw.println("<tr><h1 style=color:red;>Comment:</h1></tr>"+rst.getString(1));
pw.println("<tr><h1 style=color:red;>Students Absent are:</h1></tr>"+rst.getString(4));
pw.println("<tr><h1 style=color:red;>Students Period:</h1></tr>"+rst.getString(2));
pw.println("<tr><td><h1 style=color:red;>Count of absenteez:</h1></td></tr></table></body></html>"+rst.getString(5));
}
}
catch(Exception e)
{
pw.println(e);
}
}
}