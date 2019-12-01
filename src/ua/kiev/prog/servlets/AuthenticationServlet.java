package ua.kiev.prog.servlets;

import ua.kiev.prog.UsersList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth")
public class AuthenticationServlet extends HttpServlet {
    private UsersList users = UsersList.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String action = req.getParameter("action");
        String responseMessage = null;
        if(action.equals("1")){
            if(users.isLoginFree(login)){
                users.addUser(login,password);
                responseMessage = "Registered successfully";
            }
            else {
                responseMessage = "User with specified login already exists.Sign in or try another login";
            }
        }
        else if(action.equals("2")){
            if(users.isPasswordEnteredCorrectly(login,password)){
                responseMessage = "Singed in successfully";
            }
            else {
                responseMessage = "Invalid login or password";
            }
        }

        users.addUser(login,password);
        resp.getWriter().append(responseMessage);
    }
}
