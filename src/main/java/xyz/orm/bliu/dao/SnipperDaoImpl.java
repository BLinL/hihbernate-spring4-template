package xyz.orm.bliu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.orm.bliu.model.Snipper;

@Service
@Transactional
public class SnipperDaoImpl implements SnipperDAO{

    @Autowired
    SessionFactory sessionFactory;

//    @PersistenceContext
//    private EntityManager entityManager;


    @Override
    public Long save(Snipper snipper) {
//        Session session = getSession();
//        Transaction transaction = session.beginTransaction();
        Long id = (Long)getSession().save(snipper);
//        transaction.commit();
//        session.flush();
//        session.close();
        return id;
    }

    @Override
    public void update(Snipper snipper) {
        getSession().update(snipper);
    }

    @Override
    public Snipper queryById(long id) {
        return getSession().find(Snipper.class, id);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
