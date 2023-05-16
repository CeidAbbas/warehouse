package ir.hinceid.warehouse.repository.body;

import ir.hinceid.warehouse.model.warhouse.WarehouseResponsible;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class WarehouseResponsibleRepository {


//    public WarehouseResponsible findByUUID(String pk) {
//        try (Session session = MainOrm.getSession();) {
//            return session.load(WarehouseResponsible.class, pk);
//        }
//    }

//    public List<WarehouseResponsible> loadAll() {
//        try (Session session = MainOrm.getSession();) {
//            List<WarehouseResponsible> list = (List<WarehouseResponsible>) session
//                    .createQuery("SELECT e FROM " + WarehouseResponsible.class + " e ")
//                    .list();
//            session.close();
//            return list;
//        }
//    }

//    @Autowired
//    private SessionFactory sessionFactory;

//    public Session getSessionFactory() {
//        return sessionFactory.getCurrentSession();
//    }

//    public List<WarehouseResponsible> findByAll() {
//        Session session = getSessionFactory();
//        List<WarehouseResponsible> warehouseResponsibles;
////        warehouseResponsibles = session.list();
//        warehouseResponsibles = session.createQuery(" FROM WarehouseResponsible").list();
//        session.close();
//        return warehouseResponsibles;
//    }

}
