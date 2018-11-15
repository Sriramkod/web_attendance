import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class emaildata extends HttpServlet
{
public static void main(String args[])
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sriram","root","root");
if(con!=null)
System.out.println("ok");
else
System.out.println("not ok");

PreparedStatement pst1=con.prepareStatement("select * from cse_c_attendance");

File f=new File("img.text");
FileOutputStream fos=new FileOutputStream(f);
ResultSet rs=pst1.executeQuery();
String blb;
byte b[];
while(rs.next()) {
                GetterSetter getset = new GetterSetter();
                getset.setUserId(Integer.parseInt(rs.getString("cid")));
                 int i= getset.getUserId();
                try{
                        FileWriter fw = new FileWriter("ffff.text");
                        BufferedWriter bw = new BufferedWriter(fw);
                        System.out.println(rs.getString("cid"));
                        bw.write(i); // \n is for to write in a new Line .
                        bw.newLine();
                        bw.close();
                }
                catch (Exception e) {
                    System.out.println("Errrrr......... writing to a file..... :P"+e);
                }
}
}
catch(Exception e)
{
System.out.println(e);
}
}
}












