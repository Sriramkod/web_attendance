import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class trial extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String period=req.getParameter("tf1");
String date=req.getParameter("tf2");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sriram","root","root");
if(con!=null)
pw.println("<tr>ok</tr>");
else
pw.println("not ok");

PreparedStatement pst1=con.prepareStatement("set @roll=0");
PreparedStatement pst2=con.prepareStatement("@roll=(select attendance_absent from cse_c_attendance where period_no=? and date_time=?)");

pst2.setString(1,period);
pst2.setString(2,date);

ResultSet rst=pst1.executeQuery();
ResultSet rst1=pst2.executeQuery();

while(rst1.next())
{
pw.println("ssssssssssss");
}
}
catch(Exception e)
{
pw.println(e);
}
}
}