import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class question_format extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException,NullPointerException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String time="";
String date="";

String a1=req.getParameter("Ans1");
String a2=req.getParameter("Ans2");
String a3=req.getParameter("Ans3");
String a4=req.getParameter("Ans4");
String a5=req.getParameter("Ans5");

	String q1=req.getParameter("quest1");
	String q11=req.getParameter("O1A");
	String q12=req.getParameter("O1B");
	String q13=req.getParameter("O1C");
	String q14=req.getParameter("O1D");


	String q2=req.getParameter("quest2");
	String q21=req.getParameter("O2A");
	String q22=req.getParameter("O2B");
	String q23=req.getParameter("O2C");
	String q24=req.getParameter("O2D");


	
	String q3=req.getParameter("quest3");
	String q31=req.getParameter("O3A");
	String q32=req.getParameter("O3B");
	String q33=req.getParameter("O3C");
	String q34=req.getParameter("O3D");


	String q4=req.getParameter("quest4");
	String q41=req.getParameter("O4A");
	String q42=req.getParameter("O4B");
	String q43=req.getParameter("O4C");
	String q44=req.getParameter("O4D");


	String q5=req.getParameter("quest5");
	String q51=req.getParameter("O5A");
	String q52=req.getParameter("O5B");
	String q53=req.getParameter("O5C");
	String q54=req.getParameter("O5D");
	
	String c=req.getParameter("code");

int count=0;
int k;
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sriram","root","root");
if(con!=null)
pw.println("ok");
else
pw.println("not ok");

PreparedStatement pst2=con.prepareStatement("SELECT CURRENT_TIME");
PreparedStatement pst1=con.prepareStatement("SELECT CURRENT_DATE");

ResultSet rst=pst1.executeQuery();
ResultSet rst1=pst2.executeQuery();
while(rst.next())
{
time=rst.getString(1);
}
while(rst1.next())
{
date=rst1.getString(1);
}
PreparedStatement pst=con.prepareStatement("insert into answers values(?,?,?,?,?,?,?,?)");
pst.setString(1,a1);
pst.setString(2,a2);
pst.setString(3,a3);
pst.setString(4,a4);
pst.setString(5,a5);
pst.setString(6,time);
pst.setString(7,date);
pst.setString(8,c);


k=pst.executeUpdate();


if(k!=0)
pw.println("Quiz answers  Updated");

PreparedStatement pst3=con.prepareStatement("insert into question values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
pst3.setString(1,q1);
pst3.setString(2,q11);
pst3.setString(3,q12);
pst3.setString(4,q13);
pst3.setString(5,q14);
pst3.setString(6,q2);
pst3.setString(7,q21);
pst3.setString(8,q22);
pst3.setString(9,q23);pst3.setString(10,q24);pst3.setString(11,q3);pst3.setString(12,q31);pst3.setString(13,q32);pst3.setString(14,q33);pst3.setString(15,q34);pst3.setString(16,q4);pst3.setString(17,q41);pst3.setString(18,q42);pst3.setString(19,q43);pst3.setString(20,q44);pst3.setString(21,q5);pst3.setString(22,q51);pst3.setString(23,q52);pst3.setString(24,q53);pst3.setString(25,q54);pst3.setString(26,time);
 int e=pst3.executeUpdate();
if(e!=0)
{
pw.println("Question Updated");
}
}
catch(Exception e)
{
pw.println(e);
}
}
}