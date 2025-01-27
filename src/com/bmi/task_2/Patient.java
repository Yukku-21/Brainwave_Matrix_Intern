package com.bmi.task_2;

class Patient {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String contact;
    private String disease;

    public Patient(String id, String name, int age, String gender, String contact, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.disease = disease;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getContact() { return contact; }
    public String getDisease() { return disease; }
}