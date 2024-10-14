package com.ra.model.dao.NhanVien;

import com.ra.model.entity.NhanVien.NhanVien;

import java.util.List;

public interface EmployeeDAO {
    List<NhanVien> findAll();
    Boolean add(NhanVien nhanVien);
    NhanVien findById(int id);
    Boolean update(NhanVien nhanVien);
    Boolean delete(int id);
}
