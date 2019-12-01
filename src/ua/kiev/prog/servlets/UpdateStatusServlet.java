package ua.kiev.prog.servlets;

import ua.kiev.prog.UsersList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/updateStatus")
public class UpdateStatusServlet extends HttpServlet {
    private UsersList usersList = UsersList.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newStatus = req.getParameter("newStatus");
        String currentUser = req.getParameter("currentUser");
        if(newStatus!=null&&currentUser!=null){
            usersList.getUsersMap().get(currentUser).setStatus(newStatus);
        }else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
