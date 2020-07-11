package com.zb.dao;

import com.zb.pojo.Order;
import com.zb.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author: l
 * @date: 2020-7-10 18:29
 * @description:
 */
public class OrderDao {
    public ArrayList<Order>  findAll(){
        ArrayList<Order> list=new ArrayList<>();
        try {
            Connection conn= DBUtils.getConnection();
            String sql="select t1.* ,t2.name from tb_order t1,tb_door t2 where t2.id=t1.door_id ";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Order order=new Order();
                order.setId(rs.getInt("id"));
                order.setOrder_no(rs.getString("order_no"));

                order.setDoor_id(rs.getInt("door_id"));

                order.setOrder_type(rs.getString("order_type"));
                order.setPnum(rs.getInt("pnum"));
                order.setCashier(rs.getString("cashier"));

                order.setOrder_time(rs.getTimestamp("order_time"));
                order.setPay_time(rs.getTimestamp("pay_time"));

                order.setPay_type(rs.getString("pay_type"));
                order.setPrice(rs.getDouble("price"));

                list.add(order);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public int insert(Order order){
        int i=0;
        Connection conn=DBUtils.getConnection();
        try {
            String sql="insert into tb_order values(null,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,order.getDoor_id());
            ps.setString(2,order.getOrder_no());
            ps.setString(3,order.getOrder_type());
            ps.setInt(4,order.getPnum());
            ps.setString(5,order.getCashier());
            ps.setTimestamp(6,new Timestamp(new Date().getTime()));
            ps.setTimestamp(7,new Timestamp(new Date().getTime()+100000));
            ps.setString(8,order.getPay_type());
            ps.setDouble(9,order.getPrice());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public  int delete(int id){
        int i=0;
        Connection conn=DBUtils.getConnection();
        try {
            String sql="delete from tb_order where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            i=ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public  Order findById(int id){
        Order order=new Order();
        Connection conn=DBUtils.getConnection();
        try {
            String sql="select t1.* ,t2.name from tb_order t1,tb_door t2 where t2.id=t1.door_id and t1.id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                order.setId(rs.getInt("id"));
                order.setOrder_no(rs.getString("order_no"));

                order.setDoor_id(rs.getInt("door_id"));

                order.setOrder_type(rs.getString("order_type"));
                order.setPnum(rs.getInt("pnum"));
                order.setCashier(rs.getString("cashier"));

                order.setOrder_time(rs.getTimestamp("order_time"));
                order.setPay_time(rs.getTimestamp("pay_time"));

                order.setPay_type(rs.getString("pay_type"));
                order.setPrice(rs.getDouble("price"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
    public int update(Order order){
        int i=0;
        Connection conn=DBUtils.getConnection();
        System.out.println(order.toString());
        try {
            String sql="update tb_order set door_id=?,order_no=?,order_type=?,pnum=?,cashier=?,order_time=?,pay_time=?,pay_type=?,price=? where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,order.getDoor_id());
            ps.setString(2,order.getOrder_no());
            ps.setString(3,order.getOrder_type());
            ps.setInt(4,order.getPnum());
            ps.setString(5,order.getCashier());
            Timestamp order_time=new Timestamp(order.getOrder_time().getTime());
            ps.setTimestamp(6,order_time);
            Timestamp pay_time=new Timestamp(order.getPay_time().getTime());
            ps.setTimestamp(7,pay_time);
            ps.setString(8,order.getPay_type());
            ps.setDouble(9,order.getPrice());
            ps.setInt(10,order.getId());
            i=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
