package com.zb.servlet;

import com.zb.dao.DoorDao;
import com.zb.pojo.Door;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: l
 * @date: 2020-7-9 17:38
 * @description:
 */
@WebServlet("/doorInfo")
public class DoorInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.parseInt(req.getParameter("id"));
        DoorDao doorDao=new DoorDao();
        Door door=doorDao.findById(id);
        System.out.println(door);
        req.setAttribute("door",door);
        req.getRequestDispatcher("/door_update.jsp").forward(req,resp);
    }
}
