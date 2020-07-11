package com.zb.servlet;

import com.zb.dao.DoorDao;
import com.zb.pojo.Door;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author: l
 * @date: 2020-7-10 22:11
 * @description:
 */
@WebServlet("/addOrderInfo")
public class OrderAddInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoorDao doorDao=new DoorDao();
        ArrayList<Door> list= doorDao.findAll();
        req.setAttribute("doorList",list);
        req.getRequestDispatcher("order_add.jsp").forward(req,resp);
    }
}
