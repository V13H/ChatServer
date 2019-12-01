package ua.kiev.prog.servlets;

import ua.kiev.prog.UsersList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userslist")
public class GetUsersListServlet extends HttpServlet {
    private UsersList usersList = UsersList.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        String json = usersList.toJSON();
        if(json!=null){
            resp.getWriter().print(json);
        }
    }

}
