package ua.kiev.prog.servlets;

import ua.kiev.prog.models.Message;
import ua.kiev.prog.MessageList;
import ua.kiev.prog.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

	private MessageList msgList = MessageList.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        StringBuilder builder = new StringBuilder();
		try(BufferedReader reader = req.getReader()) {
            while (reader.readLine()!=null) {
                builder.append(reader.readLine());
            }
                Message msg = Message.fromJSON(builder.toString());

		if (msg != null)
			msgList.add(msg);
		else
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	}


}}
