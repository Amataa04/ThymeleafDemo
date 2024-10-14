package com.ra.model.service.PhongBan;

import com.ra.model.entity.PhongBan.PhongBan;

import java.util.List;

public interface DepartmentService {
    List<PhongBan> findAll();
    boolean add(PhongBan phongBan);
    PhongBan findById(int id);
    boolean update(PhongBan phongBan);
    boolean delete(int id);
}
