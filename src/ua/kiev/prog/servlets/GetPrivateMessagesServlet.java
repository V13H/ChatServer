package ua.kiev.prog.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.kiev.prog.JsonMessages;
import ua.kiev.prog.models.Message;
import ua.kiev.prog.models.User;
import ua.kiev.prog.UsersList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
@WebServlet("/getPrivate")
public class GetPrivateMessagesServlet extends HttpServlet {
    private UsersList usersList = UsersList.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fromStr = req.getParameter("from");
        String currentUserLogin = req.getParameter("user");
        User currentUser = usersList.getUsersMap().get(currentUserLogin);
        List<Message> currentUserMessages = currentUser.getPrivateMessages();
        int from = 0;
        try {
            from = Integer.parseInt(fromStr);
            if (from < 0) from = 0;
        } catch (Exception ex) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        resp.setContentType("application/json");
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(new JsonMessages(currentUserMessages, from));
        if (json != null) {
            OutputStream os = resp.getOutputStream();
            byte[] buf = json.getBytes(StandardCharsets.UTF_8);
            os.write(buf);
        }
    }
}
