package ua.kiev.prog.servlets;

import ua.kiev.prog.GroupsList;
import ua.kiev.prog.Utils;
import ua.kiev.prog.models.ChatGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
@WebServlet("/createChatGroup")
public class AddChatGroupServlet extends HttpServlet {
    private GroupsList groupsList = GroupsList.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        byte[]bytes = Utils.requestBodyToArray(req);
        String bufStr = new String(bytes, StandardCharsets.UTF_8);
        ChatGroup chatGroup = ChatGroup.fromJSON(bufStr);
        groupsList.add(chatGroup.getAdmin().getLogin(),chatGroup);
    }

}
