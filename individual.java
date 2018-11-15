import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class individual extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

 
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sriram","root","root");
if(con!=null)
pw.println("ok");
else
pw.println("not ok");

PreparedStatement pst=con.prepareStatement("SELECT * FROM cse_c_attendance WHERE  attendance_absent Like '%,%'");
ResultSet rst=pst.executeQuery();

while(rst.next())
{
rst.getString(1);
rst.getString(2);
rst.getString(3);
rst.getString(4);

}

}
catch(Exception e)
{
pw.println(e);
}
}
}