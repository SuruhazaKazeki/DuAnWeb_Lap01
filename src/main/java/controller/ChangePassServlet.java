/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.TaiKhoanDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.TaiKhoan;

/**
 *
 * @author bener
 */
public class ChangePassServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String oldpass = request.getParameter("oldpassword");
        String newpass = request.getParameter("newpassword");
        String confirnpass = request.getParameter("confirnpassword");
        if (!newpass.equals(confirnpass)) {
            request.setAttribute("error", "Mật khẩu mới và mật khẩu xác nhận không trùng khớp!");
            request.getRequestDispatcher("changepass.jsp").forward(request, response);
        }

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("usename");
        TaiKhoanDao tkDAO = new TaiKhoanDao();
        TaiKhoan tk = tkDAO.kiemTraTonTai(username, oldpass);
        if (tk != null) //xác thự lại hợp lệ
        {
            tk.setMatKhau(newpass);
            if(tkDAO.Update(tk)){
                response.sendRedirect("home.jsp");
            }
        }else{
            request.setAttribute("error","Mật khẩu cũ không đúng!");
            request.getRequestDispatcher("changepass.jsp").forward(request, response);
        }
    }
        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}