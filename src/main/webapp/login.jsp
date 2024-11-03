<%-- 
    Document   : Login
    Created on : Nov 3, 2024, 7:30:51 PM
    Author     : bener
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="shared/header.jsp"/>
<jsp:include page="shared/nav.jsp"/>
<div class="container">
    <form action="LoginServlet" method="post">
        <<h2>Login System</h2>
        <div>
            <label>User name</label>
            <input type="text" name="username" required="" class="form-control">
        </div>
        <div>
            <label>Password</label>
            <input type="submit" name="password" required="" class="form-control">
        </div>
        <div class="mt-2">
            <button type="submit" class="btn btn-primary">Login</button>
        </div>
        <%
            if (request.getAttribute("Error") != null) {
        %>
        <div class="text-danger">
            <%=request.getAttribute("error")%>
        </div>
        <%
            }
        %>
    </form>
</div>
