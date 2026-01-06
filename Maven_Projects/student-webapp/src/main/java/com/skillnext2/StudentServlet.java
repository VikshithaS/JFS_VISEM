package com.skillnext2;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    private StudentDAO dao;

    @Override
    public void init() {
        dao = new StudentDAO();
    }

    // Fetch all students
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            List<Student> students = dao.getAllStudents();
            request.setAttribute("students", students);

            // Forward to index.jsp
            request.getRequestDispatcher("/index.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    // Add / Update / Delete
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        try {
            if ("add".equals(action)) {

                int sem = Integer.parseInt(request.getParameter("sem"));
                String department = request.getParameter("department");
                dao.addStudent(new Student(sem, department));

            } else if ("update".equals(action)) {

                int id = Integer.parseInt(request.getParameter("id"));
                int sem = Integer.parseInt(request.getParameter("sem"));
                String department = request.getParameter("department");
                dao.updateStudent(new Student(id, sem, department));

            } else if ("delete".equals(action)) {

                int id = Integer.parseInt(request.getParameter("id"));
                dao.deleteStudent(id);
            }

            // SAFE redirect (works even if app name changes)
            response.sendRedirect(
                request.getContextPath() + "/StudentServlet"
            );

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
