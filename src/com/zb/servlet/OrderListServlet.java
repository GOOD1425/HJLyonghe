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
import java.util.ArrayList;

/**
 * @author: l
 * @date: 2020-7-10 20:00
 * @description:
 */
@WebServlet("/orderList")
public class OrderListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        OrderDao orderDao=new OrderDao();
        ArrayList<Order> list=orderDao.findAll();
        session.setAttribute("orderList",list);
        req.getRequestDispatcher("/selectOrderInfo").forward(req,resp);
    }
}
