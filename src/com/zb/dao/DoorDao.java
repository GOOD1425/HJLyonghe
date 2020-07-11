package com.zb.dao;

import com.zb.pojo.Door;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author: l
 * @date: 2020-7-9 15:51
 * @description:
 */
public class DoorDao {
    public  ArrayList<Door>  findAll(){
        ArrayList<Door> list=new ArrayList<>();
        Connection conn= DBUtils.getConnection();
        try {
            String sql="select * from tb_door";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Door door=new Door();
               door.setId( rs.getInt("id"));
               door.setName(rs.getString("name"));
               door.setAddr(rs.getString("addr"));
               door.setTel(rs.getString("tel"));
               list.add(door);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public int addDoor(Door door){
        int i=0;
        Connection conn=DBUtils.getConnection();
        try {
            String sql="insert into tb_door values(null,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,door.getName());
            ps.setString(2,door.getTel());
            ps.setString(3,door.getAddr());
            i=ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public int deleteDoor(int  d){
        int i=0;
        Connection conn=DBUtils.getConnection();
        try {
            String sql="delete  from tb_door where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,d);
            i=ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public Door findById(int  d){
        Door door=new Door();
        Connection conn=DBUtils.getConnection();
        try {
            String sql="select * from tb_door where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,d);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                door.setId( rs.getInt("id"));
                door.setName(rs.getString("name"));
                door.setAddr(rs.getString("addr"));
                door.setTel(rs.getString("tel"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return door;
    }
    public  int updateDoor(Door door){
        int i=0;
        Connection conn=DBUtils.getConnection();
        try {
            String sql="update tb_door   set name =?,tel=?,addr=?  where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,door.getName());
            ps.setString(2,door.getTel());
            ps.setString(3,door.getAddr());
            ps.setInt(4,door.getId());
            i=ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
