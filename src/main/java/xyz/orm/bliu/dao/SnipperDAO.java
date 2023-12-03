package xyz.orm.bliu.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.orm.bliu.model.Snipper;

public interface SnipperDAO {

    Long save(Snipper snipper);

    void update(Snipper snipper);

    Snipper queryById(long id);
}
