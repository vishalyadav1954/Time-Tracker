<%@ page import="java.sql.*"%>
<html>
 <head>
  <script src='/timetracker/JS/script.js'></script>
  <link href='/timetracker/CSS/style.css' rel='stylesheet'>
  <link href='/timetracker/CSS/bootstrap.min.css' rel='stylesheet'>
 </head>
 <body bgcolor='cyan'>
   <hr style='border:2px solid green'>
    <nav class='navbar navbar-expand navbar-light bg-light'>
    <label style='font-size:2vw'>Hi, ${sessionScope.user}</label>
     <ul class='nav nav-pills mx-auto'>
      <li><a id="home1" class='nav-link lau' href='/timetracker'>Home</a>
      <li><a id='out' class='nav-link lau' href='/timetracker/user/manage/time/out'>Time Out</a>
      <li><a id='in' class='nav-link lau' href='/timetracker/user/manage/time/in'>Time In</a>
      <li><a id='date' class='nav-link lau' href='#'>Date wise report</a>
      <li><a id='emp' class='nav-link lau' href='#'>Employee wise report</a>
      <li><a id='emp' class='nav-link lau' href='/timetracker/user/login/logout'>Logout</a>
     </ul>
    </nav>
   <hr style='border:2px solid green'>
 </body>
</html>