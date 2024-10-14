package com.ra.model.service.NhanVien;

import com.ra.model.dao.NhanVien.EmployeeDAO;
import com.ra.model.entity.NhanVien.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Override
    public List<NhanVien> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Boolean add(NhanVien nhanVien) {
        return employeeDAO.add(nhanVien);
    }

    @Override
    public NhanVien findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    public Boolean update(NhanVien nhanVien) {
        return employeeDAO.update(nhanVien);
    }

    @Override
    public Boolean delete(int id) {
        return employeeDAO.delete(id);
    }
}
