import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class result extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException,NullPointerException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String time="";
String aa="";
String ab="";
String ac="";
String ad="";
String ae="";
String Q1=req.getParameter("q1");

String Q2=req.getParameter("q2");

String Q3=req.getParameter("q3");

String Q4=req.getParameter("q4");

String Q5=req.getParameter("q5");


try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sriram","root","root");
if(con!=null)
pw.println("<center><h1 style='color:green;'>Quiz Finished</h1></center>");
else
pw.println("<center><h1 style='color:green;'>Not Submitted Check your conncetion and retry!!!!</h1></center>");

PreparedStatement pst1=con.prepareStatement("SELECT CURRENT_DATE");
ResultSet rst=pst1.executeQuery();
while(rst.next())
{
time=rst.getString(1);
}

PreparedStatement pst2=con.prepareStatement("select * from answers");

ResultSet rst1=pst2.executeQuery();
while(rst1.next()){
aa=rst1.getString(1);
ab=rst1.getString(2);
ac=rst1.getString(3);
ad=rst1.getString(4);
ae=rst1.getString(5);

}
int count=0;
if(Q1.equals(aa))
{
count++;
}
if(Q2.equals(ab))
{
count++;
}
if(Q3.equals(ac))
{
count++;
}
if(Q4.equals(ad))
{
count++;
}
if(Q5.equals(ae))
{
count++;
}

if(count==5){
pw.println("<html><center><table><tr><td><h1 style='color:green;'>Score:"+count+"/5</h1><h1 style='color:blue;'>Well Done !!!</h1></table></center></html>");
}
if(count==4){
pw.println("<html><center><table><tr><td><h1 style='color:green;'>Score:"+count+"/5</h1><h1 style='color:blue;'>Good You can do Wonders !!!</h1></table></center></html>");
}
if(count==3){
pw.println("<html><center><table><tr><td><h1 style='color:green;'>Score:"+count+"/5</h1><h1 style='color:yellow;'>Not bad try to improve !!!</h1></table></center></html>");
}
if(count==2){
pw.println("<html><center><table><tr><td><h1 style='color:green;'>Score:"+count+"/5</h1><h1 style='color:gray;'>Nearer to danger Zone...Get well Soon !!!</h1></table></center></html>");
}
if(count==1){
pw.println("<html><center><table><tr><td><h1 style='color:green;'>Score:"+count+"/5</h1><h1 style='color:black;'>Poor !!!</h1></table></center></html>");
}
if(count==0){
pw.println("<html><center><table><tr><td><h1 style='color:green;'>Score:"+count+"/5</h1><h1 style='color:red;'>You are in Danger zone !!!</h1></table></center></html>");
}
}
catch(Exception e)
{
pw.println(e);
}
}
}