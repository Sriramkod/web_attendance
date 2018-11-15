import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class lectureregistration extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String name=req.getParameter("tf1");
String userid=req.getParameter("tf2");
String password=req.getParameter("tf3");
String branch=req.getParameter("tf4");
String course=req.getParameter("tf5");
String email=req.getParameter("tf6");
String phone=req.getParameter("tf7");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sriram","root","root");
if(con!=null)
pw.println("ok");
else
pw.println("not ok");
PreparedStatement pst=con.prepareStatement("insert into lectureregistration values(?,?,?,?,?,?,?)");
pst.setString(1,name);
pst.setString(2,userid);
pst.setString(3,password);
pst.setString(4,branch);
pst.setString(5,course);
pst.setString(6,email);
pst.setString(7,phone);
int k=pst.executeUpdate();
if(k!=0)
{
pw.println("registrtion sucess");
res.sendRedirect("alert.html");
}
else
pw.println("registration failed");
}
catch(Exception e)
{
pw.println(e);
}
}
}