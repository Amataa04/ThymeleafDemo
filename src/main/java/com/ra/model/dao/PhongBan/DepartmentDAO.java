package com.ra.model.dao.PhongBan;

import com.ra.model.entity.PhongBan.PhongBan;

import java.util.List;

public interface DepartmentDAO {
    List<PhongBan> findAll();
    boolean add(PhongBan phongBan);
    PhongBan findById(int id);
    boolean update(PhongBan phongBan);
    boolean delete(int id);
}
