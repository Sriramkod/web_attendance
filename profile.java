import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class profile extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

String name=req.getParameter("tf1");

/*String period=req.getParameter("tf2");
*/
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sriram","root","root");
if(con!=null)
pw.println("");
else
pw.println("not ok");

pw.println("<html><body>");

pw.println("<table>");
PreparedStatement pst1=con.prepareStatement("select * from lectureregistration where password=?");
pst1.setString(1,name);
ResultSet rst=pst1.executeQuery();
while(rst.next())
{
pw.println("<tr><h1 style=color:red;>Name:</h1></tr>"+rst.getString(1));
pw.println("<tr><h1 style=color:red;>Department:</h1></tr>"+rst.getString(4));
pw.println("<tr><h1 style=color:red;>course:</h1></tr>"+rst.getString(5));
pw.println("<tr><h1 style=color:red;>email:</h1></tr>"+rst.getString(6));
}
}
catch(Exception e)
{
pw.println(e);
}
}
}