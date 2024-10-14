package com.ra.model.entity.PhongBan;

import com.ra.model.entity.NhanVien.NhanVien;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name",length = 100,unique = true,nullable = false)
    private String departmentName;
    @OneToMany(mappedBy = "phongBan")
    private Set<NhanVien> nhanViens;

    public PhongBan() {}

    public PhongBan(int id, String departmentName, Set<NhanVien> nhanViens) {
        this.id = id;
        this.departmentName = departmentName;
        this.nhanViens = nhanViens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Set<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setPhongBans(Set<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }
}
