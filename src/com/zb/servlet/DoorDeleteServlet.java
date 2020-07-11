package com.zb.servlet;

import com.zb.dao.DoorDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: l
 * @date: 2020-7-10 9:05
 * @description:
 */
@WebServlet("/doorDelete")
public class DoorDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.parseInt(req.getParameter("id"));
        DoorDao doorDao=new DoorDao();
        doorDao.deleteDoor(id);
        resp.sendRedirect("/doorList");
    }
}
