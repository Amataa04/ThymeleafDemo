package com.ra.model.entity.NhanVien;

import com.ra.model.entity.PhongBan.PhongBan;

import javax.persistence.*;

@Entity
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",length = 100,nullable = false)
    private String employeeName;
    @Column(name = "age")
    private int employeeAge;
    @Column(name = "salary")
    private Float employeeSalary;
    @Column(name = "images")
    private String images;
    @ManyToOne
    @JoinColumn(name = "id_phongban",referencedColumnName = "id")
    private PhongBan phongBan;

    public NhanVien() {
    }

    public NhanVien(int id, String employeeName, int employeeAge, Float employeeSalary, String images, PhongBan phongBan) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeSalary = employeeSalary;
        this.images = images;
        this.phongBan = phongBan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public Float getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Float employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }
}
