package com.bmi.task_2;

class Doctor {
    private int id;
    private String name;
    private String specialization;
    private String contact;
    private int hospitalId;

    public Doctor(int id, String name, String specialization, String contact, int hospitalId) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.contact = contact;
        this.hospitalId = hospitalId;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public String getContact() { return contact; }
    public int getHospitalId() { return hospitalId; }
}