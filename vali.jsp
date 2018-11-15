<%@page import="java.sql.*"%>
<html>
<center><h1 style="color:red">Online Quiz</h1></center>
<center><h1 style="color:red">ALL THE BEST</h1></center>
<style>
table
{
 border: 5px solid #FFFFFF;
 margin: 50px;

width: 520px;
height: 300px;
background-color: rgba(0,0,0,0.1); 
border-radius: 10px;
box-shadow: inset 0 50px rgba(255,255,255,0.2), 
            inset 0 -15px 30px rgba(0,0,0,0.4),
                  0 5px 10px rgba(0,0,0,0.5);
text-align:justify;
}
body{
background-color: rgba(0,0,0,0.3);
}
td {
    font-size: 2.0em; /* 40px/16=2.5em */
    font-weight:normal;s
}
</style>
<body>
<form method="post" action="result">
<center>
<table>
<%

Class.forName("com.mysql.jdbc.Driver");
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sriram","root", "root");
Statement st=connection.createStatement();
ResultSet rs=st.executeQuery("Select * from question");
int i=1;

while(rs.next()){
%>

<tr>
<td style="color:white">Question1:</td>
</tr>

<tr>
<td style="color:white"> <%=rs.getString("q1")%></td>
</tr>

<tr>
<td style="color:white">A:<input type="radio" id="r1"  value="A" name="q1" required><%=rs.getString("q11")%></td>
</tr>
<tr>
<td style="color:white">B:<input type="radio"  id="r1" value="B" name="q1" required><%=rs.getString("q12")%></td>
</tr>

<tr>
<td style="color:white">C:<input type="radio"  id="r1" value="C" name="q1" required><%=rs.getString("q13")%></td>
</tr>
<tr>
<td style="color:white">D:<input type="radio" id="r1" value="D" name="q1"  required><%=rs.getString("q14")%></td>
</tr>
</tr>



<tr>
<td style="color:white">Question 2:</td>
</tr>

<tr>
<td style="color:white"><%=rs.getString("q2")%></td>
</tr>

<tr>
<td style="color:white">A:<input type="radio" id="r2" value="A" name="q2"  required><%=rs.getString("q21")%></td>
</tr>
<tr>
<td style="color:white">B:<input type="radio" id="r2" value="B" name="q2"  required><%=rs.getString("q22")%></td>
</tr>
<tr>
<td style="color:white">C:<input type="radio" id="r2" value="C" name="q2"  required><%=rs.getString("q23")%></td>
</tr>
<tr>
<td style="color:white">D:<input type="radio"  id="r2" value="D" name="q2"  required><%=rs.getString("q24")%></td>
</tr>
</tr>



<tr>
<td style="color:white">Question 3:</td>
</tr>

<tr>
<td style="color:white"><%=rs.getString("q3")%></td>
</tr>

<tr>
<td style="color:white">A:<input type="radio" id="r3"  value="A" name="q3"  required><%=rs.getString("q31")%></td>
</tr>
<tr>
<td style="color:white">B:<input type="radio" id="r3" value="B" name="q3"  required><%=rs.getString("q32")%></td>
</tr>
<tr>
<td  style="color:white">C:<input type="radio" id="r3" value="C" name="q3"  required><%=rs.getString("q33")%></td>
</tr>
<tr>
<td  style="color:white">D:<input type="radio"  id="r3" value="D" name="q3"  required><%=rs.getString("q34")%></td>
</tr>
</tr>




<tr>
<td style="color:white">Question 4:</td>
</tr>

<tr>
<td style="color:white"><%=rs.getString("q4")%></td>
</tr>

<tr>
<td style="color:white">A:<input type="radio" id="r4" value="A" name="q4"  required><%=rs.getString("q41")%></td>
</tr>
<tr>
<td style="color:white">B:<input type="radio" id="r4" value="B" name="q4"  required><%=rs.getString("q42")%></td>
</tr>
<tr>
<td style="color:white">C:<input type="radio" id="r4" value="C" name="q4"  required><%=rs.getString("q43")%></td>
</tr>
<tr>
<td style="color:white">D:<input type="radio" id="r4" value="D" name="q4"  required><%=rs.getString("q44")%></td>
</tr>
</tr>


<tr>
<td style="color:white">Question 5:</td>
</tr>

<tr>
<td style="color:white"><%=rs.getString("q5")%></td>
</tr>

<tr>
<td style="color:white"> A:<input type="radio" id="r5" value="A" name="q5"  required><%=rs.getString("q51")%></td>
</tr>
<tr>
<td style="color:white">B:<input type="radio" id="r5" value="B" name="q5"  required><%=rs.getString("q52")%></td>
</tr>
<tr>
<td style="color:white">C:<input type="radio" id="r5" value="C" name="q5"  required><%=rs.getString("q53")%></td>
</tr>
<tr>
<td style="color:white">D:<input type="radio" id="r5" value="D" name="q5"  required><%=rs.getString("q54")%></td>
</tr>
</tr>



<%
i++;
}
%>
<tr><td><input type="submit" value="submit"></td></tr>
</table>
</centers>
</form>
</body>
</html>-