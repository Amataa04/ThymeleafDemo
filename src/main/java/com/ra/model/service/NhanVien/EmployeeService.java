package com.ra.model.service.NhanVien;

import com.ra.model.entity.NhanVien.NhanVien;

import java.util.List;

public interface EmployeeService {
    List<NhanVien> findAll();
    Boolean add(NhanVien nhanVien);
    NhanVien findById(int id);
    Boolean update(NhanVien nhanVien);
    Boolean delete(int id);
}
