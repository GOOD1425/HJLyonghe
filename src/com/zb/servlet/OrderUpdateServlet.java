package com.zb.servlet;

import com.zb.dao.OrderDao;
import com.zb.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: l
 * @date: 2020-7-11 7:53
 * @description:
 */
@WebServlet("/orderUpdate")
public class OrderUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order=new Order();
        order.setId(Integer.parseInt(req.getParameter("id")));
        order.setOrder_no(req.getParameter("orderNo"));
        order.setDoor_id(Integer.parseInt(req.getParameter("doorId")));
        order.setOrder_type(req.getParameter("orderType"));
        order.setPnum(Integer.parseInt(req.getParameter("pnum")));
        order.setCashier(req.getParameter("cashier"));
        String order_time=req.getParameter("orderTime");
        String pay_time=req.getParameter("payTime");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1=null,date2=null;
        try {
            date1=sdf.parse(order_time);
            date2=sdf.parse(pay_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        order.setOrder_time(date1);
        order.setPay_time(date2);
        order.setPay_type(req.getParameter("payType"));
        order.setPrice(Double.parseDouble(req.getParameter("price")));



        OrderDao orderDao=new OrderDao();
        orderDao.update(order);
        resp.sendRedirect("/orderList");
    }
}
