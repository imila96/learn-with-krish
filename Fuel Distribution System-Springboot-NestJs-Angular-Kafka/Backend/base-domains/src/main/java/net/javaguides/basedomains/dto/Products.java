package net.javaguides.basedomains.dto;

import java.util.Date;

public class Products {


    public String _id;

    public String orderId;

    public String status;

    public Date date;

    public Products() {
    }

    public Products(String _id, String orderId, String status, Date date) {
        this._id = _id;
        this.orderId = orderId;
        this.status = status;
        this.date = date;
    }
}