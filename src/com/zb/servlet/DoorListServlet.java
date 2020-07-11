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
 * @date: 2020-7-9 15:46
 * @description:
 */
@WebServlet("/doorList")
public class DoorListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DoorDao doorDao=new DoorDao();
        ArrayList<Door> list=doorDao.findAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("door_list.jsp").forward(request,response);
    }
}
