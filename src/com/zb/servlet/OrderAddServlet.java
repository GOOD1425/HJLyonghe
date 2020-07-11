package com.zb.servlet;

import com.zb.dao.OrderDao;
import com.zb.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: l
 * @date: 2020-7-10 18:10
 * @description:
 */
@WebServlet("/addOrder")
public class OrderAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order=new Order();
        order.setDoor_id(Integer.parseInt(req.getParameter("doorId")));
        order.setOrder_no(req.getParameter("orderNo"));
        order.setOrder_type(req.getParameter("orderType"));
        order.setPnum(Integer.parseInt(req.getParameter("pnum")));
        order.setCashier(req.getParameter("cashier"));
        order.setPay_type(req.getParameter("payType"));
        order.setPrice(Double.parseDouble(req.getParameter("price")));
        OrderDao od=new OrderDao();

        od.insert(order);
        resp.sendRedirect("/orderList");
    }
}
