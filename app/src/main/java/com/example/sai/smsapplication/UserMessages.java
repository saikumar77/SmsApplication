package com.example.sai.smsapplication;

/**
 * Created by sai on 10/29/2016.
 */
public class UserMessages {
    private int _id;
    private String _mobileNo;
    private String _message;
    private String _time;
    private String _status;

    public UserMessages(String mobileNo, String message, String time,String status) {
        this._mobileNo = mobileNo;
        this._message = message;
        this._time = time;
        this._status = status;
    }

    public UserMessages(){}

    public int get_id() {
        return _id;
    }

    public String get_mobileNo() {
        return _mobileNo;
    }

    public String get_message() {
        return _message;
    }

    public String get_time() {
        return _time;
    }

    public String get_status() {return _status; }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_mobileNo(String _mobileNo) {
        this._mobileNo = _mobileNo;
    }

    public void set_message(String _message) {
        this._message = _message;
    }

    public void set_time(String _time) {
        this._time = _time;
    }

    public void set_status(String _status) {this._status = _status;}
}
