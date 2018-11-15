import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class attendance extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException,NullPointerException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String rl="";
String[] rollno;
String time="";
String comment=req.getParameter("comments");
String period=req.getParameter("period");
rollno=req.getParameterValues("csc[]");
String none="all are present";

for(int i=0;i<rollno.length;i++)
{
rl=rl+rollno[i]+",";
}
int count=rollno.length;
int k;
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sriram","root","root");
if(con!=null)
pw.println("ok");
else
pw.println("not ok");

PreparedStatement pst1=con.prepareStatement("SELECT CURRENT_DATE");
ResultSet rst=pst1.executeQuery();
while(rst.next())
{
time=rst.getString(1);
}
if(rl!=null)
{
PreparedStatement pst=con.prepareStatement("insert into cse_c_attendance values(?,?,?,?,?)");
pst.setString(1,comment);
pst.setString(2,period);
pst.setString(3,time);
pst.setString(4,rl);
pst.setInt(5,count);
k=pst.executeUpdate();
}

else
{
PreparedStatement pst=con.prepareStatement("insert into cse_c_attendance values("+"'"+comment+"'"+"'"+period+"'"+"'"+time+"'"+"'"+rl+""+"'"+count+"')");
pst.setString(1,comment);
pst.setString(2,period);
pst.setString(3,time);
pst.setString(4,none);
pst.setInt(5,count);
k=pst.executeUpdate();
}

if(k!=0)
{
pw.println("attendance Updated");
res.sendRedirect("dex.html");
}

}
catch(Exception e)
{
pw.println(e);
}
}
}