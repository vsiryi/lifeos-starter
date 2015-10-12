<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<form name="lifeos login" action="/login" method="POST">
  <table width="300px">
    <tr>
      <td height="50%" width="30%">
        <span>Login</span>
      </td>
      <td height="50%" width="70%">
        <input type="text" name="username"/>
      </td>
    </tr>
    <tr>
      <td height="50%" width="30%">
        <span>Password</span>
      </td>
      <td height="50%" width="70%">
        <input type="password" name="password"/>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Enter"/>
      </td>
    </tr>
  </table>

</form>
</body>
</html>
