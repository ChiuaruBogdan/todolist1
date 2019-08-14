package org.fasttrackit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.fasttrackit.service.ToDoItemService;
import org.fasttrackit.transfer.SaveToDoItemRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/to-do-items")

public class ToDoItemServlet extends HttpServlet {

    private ToDoItemService toDoItemService = new ToDoItemService();

//end point
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        SaveToDoItemRequest request = objectMapper.readValue(req.getReader(), SaveToDoItemRequest.class);
        try {
            toDoItemService.createToDoItem(request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "Internal server error: " + e.getMessage());
        }
    }


}