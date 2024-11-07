<%-- 
    Document   : changepass
    Created on : Nov 7, 2024, 9:17:09 AM
    Author     : bener
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="shared/header.jsp"/>

<jsp:include page="shared/nav.jsp"/>

<div class="container">
    <form action="ChangePassServlet" method="post">
        <<h2>Change Password</h2>
        <div>
            <label>Old password</label>
            <input type="password" name="oldpassword" required="" class="form-control" />
        </div>
        <div>
            <label>New password</label>
            <input type="password" name="newpassword" required="" class="form-control" />
        </div>
        <div>
            <label>Confirm New password</label>
            <input type="password" name="confirmpassword" required="" class="form-control" />
        </div>
        <%
            if (request.getAttribute("error") != null)
            {
        %>
        <div class="text-danger mb-3">
            <%=request.getAttribute("error")%>
        </div>
        <%
            }
        %>
    </form>
</div>
        <jsp:include page="shared/footer.jsp"/>