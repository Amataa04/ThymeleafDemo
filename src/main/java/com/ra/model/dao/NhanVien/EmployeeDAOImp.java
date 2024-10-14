package com.ra.model.dao.NhanVien;

import com.ra.model.entity.NhanVien.NhanVien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<NhanVien> findAll() {
        Session session = sessionFactory.openSession();
        List<NhanVien> nhanViens = new ArrayList<>();
        try{
            nhanViens = session.createQuery("from NhanVien",NhanVien.class).list();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return nhanViens;
    }

    @Override
    public Boolean add(NhanVien nhanVien) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(nhanVien);
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }
        return false;
    }

    @Override
    public NhanVien findById(int id) {
        Session session = sessionFactory.openSession();
        try{
            return session.get(NhanVien.class, id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return null;
    }

    @Override
    public Boolean update(NhanVien nhanVien) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(nhanVien);
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }
        return false;
    }

    @Override
    public Boolean delete(int id) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return false;
    }
}
