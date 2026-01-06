<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, com.skillnext2.Student" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Student Management</title>
            <style>
                body {
                    font-family: Arial;
                    margin: 30px;
                }
                
                table {
                    border-collapse: collapse;
                    width: 60%;
                }
                
                th,
                td {
                    border: 1px solid #444;
                    padding: 8px;
                    text-align: center;
                }
                
                th {
                    background-color: #f2f2f2;
                }
            </style>
        </head>

        <body>

            <h2>Student Management</h2>

            <!-- Add Student Form -->
            <form action="StudentServlet" method="post">
                <input type="hidden" name="action" value="add"> Semester:
                <input type="number" name="sem" required> Department:
                <input type="text" name="department" required>

                <button type="submit">Add Student</button>
            </form>

            <br><br>

            <!-- Student List -->
            <table>
                <tr>
                    <th>ID</th>
                    <th>Semester</th>
                    <th>Department</th>
                    <th>Actions</th>
                </tr>

                <%
    List<Student> students = (List<Student>) request.getAttribute("students");
    if (students != null) {
        for (Student s : students) {
%>
                    <tr>
                        <td>
                            <%= s.getId() %>
                        </td>
                        <td>
                            <%= s.getSem() %>
                        </td>
                        <td>
                            <%= s.getDepartment() %>
                        </td>
                        <td>
                            <!-- Delete -->
                            <form action="StudentServlet" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="id" value="<%= s.getId() %>">
                                <button type="submit">Delete</button>
                            </form>

                            <!-- Update -->
                            <form action="StudentServlet" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="update">
                                <input type="hidden" name="id" value="<%= s.getId() %>">
                                <input type="number" name="sem" value="<%= s.getSem() %>" required>
                                <input type="text" name="department" value="<%= s.getDepartment() %>" required>
                                <button type="submit">Update</button>
                            </form>
                        </td>
                    </tr>
                    <%
        }
    }
%>

            </table>

        </body>

        </html>