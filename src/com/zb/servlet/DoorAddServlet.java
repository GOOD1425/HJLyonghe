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
 * @date: 2020-7-9 16:54
 * @description:
 */
@WebServlet("/doorAdd")
public class DoorAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String tel=req.getParameter("tel");
        String addr=req.getParameter("addr");
        Door door=new Door();
        door.setTel(tel);
        door.setAddr(addr);
        door.setName(name);
        DoorDao doorDao=new DoorDao();
        doorDao.addDoor(door);
        resp.sendRedirect("/doorList");
    }
}
