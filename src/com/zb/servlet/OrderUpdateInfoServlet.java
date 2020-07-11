package com.zb.servlet;

import com.zb.dao.OrderDao;
import com.zb.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: l
 * @date: 2020-7-10 23:19
 * @description:
 */
@WebServlet( "/orderUpdateInfo")
public class OrderUpdateInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.parseInt(req.getParameter("id"));
        HttpSession session=req.getSession();
        OrderDao orderDao=new OrderDao();
        Order order=orderDao.findById(id);
        session.setAttribute("order",order);
        req.getRequestDispatcher("/orderUpSnfo").forward(req,resp);
    }
}
