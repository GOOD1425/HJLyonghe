package com.zb.pojo;

import java.util.Date;

/**
 * @author: l
 * @date: 2020-7-10 9:21
 * @description:
 */
public class Order {
    private  int id;
    private  String order_no;
    private  int door_id;
    private  String  order_type;
    private  int pnum;
    private  String cashier;

    public Date getOrder_time() {
        return order_time;
    }

    public Order setOrder_time(Date order_time) {
        this.order_time = order_time;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_no='" + order_no + '\'' +
                ", door_id=" + door_id +
                ", order_type='" + order_type + '\'' +
                ", pnum=" + pnum +
                ", cashier='" + cashier + '\'' +
                ", order_time=" + order_time +
                ", pay_time=" + pay_time +
                ", pay_type='" + pay_type + '\'' +
                ", price=" + price +
                '}';
    }

    public Date getPay_time() {
        return pay_time;
    }

    public Order setPay_time(Date pay_time) {
        this.pay_time = pay_time;
        return this;
    }

    private Date order_time;
    private Date pay_time;
    private  String pay_type;
    private  double price;
    public int getId() {
        return id;
    }

    public Order setId(int id) {
        this.id = id;
        return this;
    }

    public String getOrder_no() {
        return order_no;
    }

    public Order setOrder_no(String order_no) {
        this.order_no = order_no;
        return this;
    }

    public int getDoor_id() {
        return door_id;
    }

    public Order setDoor_id(int door_id) {
        this.door_id = door_id;
        return this;
    }

    public String getOrder_type() {
        return order_type;
    }

    public Order setOrder_type(String order_type) {
        this.order_type = order_type;
        return this;
    }

    public int getPnum() {
        return pnum;
    }

    public Order setPnum(int pnum) {
        this.pnum = pnum;
        return this;
    }

    public String getCashier() {
        return cashier;
    }

    public Order setCashier(String cashier) {
        this.cashier = cashier;
        return this;
    }




    public String getPay_type() {
        return pay_type;
    }

    public Order setPay_type(String pay_type) {
        this.pay_type = pay_type;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Order setPrice(double price) {
        this.price = price;
        return this;
    }


}
