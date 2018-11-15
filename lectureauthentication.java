import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class lectureauthentication extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String username=req.getParameter("tf1").trim();
String password=req.getParameter("tf2").trim();
String n=req.getParameter("tf6");  
        pw.print("Welcome "+n);  
          
        HttpSession session=req.getSession();  
        session.setAttribute("uname",n);  
  
      
String user="";
String pwd="";
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sriram","root","root");
if(con!=null)
pw.println("ok");
else
pw.println("not ok");
Statement st=con.createStatement();
String q="select * from lectureregistration where username="+"'"+username+"'";
ResultSet rst=st.executeQuery(q);
while(rst.next())
{
user=rst.getString(2).trim();
pwd=rst.getString(3).trim();
}
if(username.equals(user)&&pwd.equals(password))
{
pw.println("user is authorized");
res.sendRedirect("nareshsir.html");
}
else
{
pw.println("<script> window.alert('Wrong password or username');</script>");
pw.println("<script> window.open('lecturelogin.html','_self');</script>");

}
PreparedStatement pst1=con.prepareStatement("select * from lectureregistration where password=?");
pst1.setString(1,password);
ResultSet rst1=pst1.executeQuery();
while(rst.next())
{
pw.println("<tr><h1 style=color:red;>Comment:</h1></tr>"+rst1.getString(6));
}

}
catch(Exception e)
{
pw.println(e);
}

}
}