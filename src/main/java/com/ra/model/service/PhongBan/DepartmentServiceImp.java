package com.ra.model.service.PhongBan;

import com.ra.model.dao.PhongBan.DepartmentDAO;
import com.ra.model.entity.PhongBan.PhongBan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {
    @Autowired
    private DepartmentDAO departmentDAO;
    @Override
    public List<PhongBan> findAll() {
        return departmentDAO.findAll();
    }

    @Override
    public boolean add(PhongBan phongBan) {
        return departmentDAO.add(phongBan);
    }

    @Override
    public PhongBan findById(int id) {
        return departmentDAO.findById(id);
    }

    @Override
    public boolean update(PhongBan phongBan) {
        return departmentDAO.update(phongBan);
    }

    @Override
    public boolean delete(int id) {
        return departmentDAO.delete(id);
    }
}
