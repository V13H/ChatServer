package ua.kiev.prog.servlets;

import ua.kiev.prog.models.Message;
import ua.kiev.prog.UsersList;
import ua.kiev.prog.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/addPrivate")
public class AddPrivateMessageServlet extends HttpServlet {
    private UsersList usersList = UsersList.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        byte[] buf = Utils.requestBodyToArray(req);
        String bufStr = new String(buf, StandardCharsets.UTF_8);

        Message msg = Message.fromJSON(bufStr);
        if (msg != null)
            usersList.getUsersMap().get(msg.getTo()).getPrivateMessages().add(msg);
        else
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

}
