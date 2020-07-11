package com.zb.servlet;

import com.zb.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: l
 * @date: 2020-7-10 23:14
 * @description:
 */
@WebServlet("/orderDelete")
public class OrderDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.parseInt(req.getParameter("id"));
        OrderDao orderDao=new OrderDao();
        orderDao.delete(id);
        resp.sendRedirect("/orderList");
    }
}
