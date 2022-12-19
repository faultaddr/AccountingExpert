package com.faultaddr.greendaoapp.db;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "RECORD_DETAIL".
 */
@Entity
public class RecordDetail {

    @Id(autoincrement = true)
    private Long id;
    private String detail;
    private String category;
    private String amount;
    private String account;
    private String date;
    private java.util.Date timestamp;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public RecordDetail() {
    }

    public RecordDetail(Long id) {
        this.id = id;
    }

    @Generated
    public RecordDetail(Long id, String detail, String category, String amount, String account, String date, java.util.Date timestamp) {
        this.id = id;
        this.detail = detail;
        this.category = category;
        this.amount = amount;
        this.account = account;
        this.date = date;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public java.util.Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(java.util.Date timestamp) {
        this.timestamp = timestamp;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}