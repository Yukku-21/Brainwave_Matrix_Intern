package com.bmi.task_2;

class Hospital {
    private int hId;
    private String hospitalName;
    private String contactNo;
    private String address;
    private String city;

    public Hospital(int hId, String hospitalName, String contactNo, String address, String city) {
        this.hId = hId;
        this.hospitalName = hospitalName;
        this.contactNo = contactNo;
        this.address = address;
        this.city = city;
    }

    public int getHId() { return hId; }
    public String getHospitalName() { return hospitalName; }
    public String getContactNo() { return contactNo; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
}
