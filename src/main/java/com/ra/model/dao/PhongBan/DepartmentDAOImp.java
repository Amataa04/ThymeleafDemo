package com.ra.model.dao.PhongBan;

import com.ra.model.entity.PhongBan.PhongBan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDAOImp implements DepartmentDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<PhongBan> findAll() {
        List<PhongBan> phongBans = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            phongBans = session.createQuery("from PhongBan",PhongBan.class).list();
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return phongBans;
    }

    @Override
    public boolean add(PhongBan phongBan) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(phongBan);
            session.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return false;
    }

    @Override
    public PhongBan findById(int id) {
        Session session = sessionFactory.openSession();
        try{
            return session.get(PhongBan.class,id);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(PhongBan phongBan) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(phongBan);
            session.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return false;
    }
}
