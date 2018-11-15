import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class quiz extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException,NullPointerException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

String comment=req.getParameter("quiz");

String time="";
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sriram","root","root");
if(con!=null)
pw.println("ok");
else
pw.println("not ok");

PreparedStatement pst1=con.prepareStatement("SELECT CURRENT_TIME");
ResultSet rst=pst1.executeQuery();
while(rst.next())
{
 time=rst.getString(1);
}

PreparedStatement pst=con.prepareStatement("insert into quiz values(?,?)");
pst.setString(1,comment);
pst.setString(2,time);

int k=pst.executeUpdate();



if(k!=0)
pw.println("Quiz updated");
}
catch(Exception e)
{
pw.println(e);
}
}
}