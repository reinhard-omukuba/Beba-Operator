package com.beba.bebaoperator;


public class User {
    private String MatatuInfo;
    private String bookingtime;
    private String documentid;
    private String fare;
    private String regno;
    private String route;

    private String sacco;
    private String status;
    private String userid;

    private String matatubooked;

    public User() {}

    public User(String matatuInfo, String bookingtime, String documentid, String fare, String regno, String route, String sacco, String status, String userid, String matatubooked) {
        MatatuInfo = matatuInfo;
        this.bookingtime = bookingtime;
        this.documentid = documentid;
        this.fare = fare;
        this.regno = regno;
        this.route = route;
        this.sacco = sacco;
        this.status = status;
        this.userid = userid;
        this.matatubooked = matatubooked;
    }

    public String getMatatuInfo() {
        return MatatuInfo;
    }

    public void setMatatuInfo(String matatuInfo) {
        MatatuInfo = matatuInfo;
    }

    public String getBookingtime() {
        return bookingtime;
    }

    public void setBookingtime(String bookingtime) {
        this.bookingtime = bookingtime;
    }

    public String getDocumentid() {
        return documentid;
    }

    public void setDocumentid(String documentid) {
        this.documentid = documentid;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getSacco() {
        return sacco;
    }

    public void setSacco(String sacco) {
        this.sacco = sacco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMatatubooked() {
        return matatubooked;
    }

    public void setMatatubooked(String matatubooked) {
        this.matatubooked = matatubooked;
    }
}

