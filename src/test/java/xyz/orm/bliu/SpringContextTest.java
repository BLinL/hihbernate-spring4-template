package xyz.orm.bliu;

//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;
import org.springframework.transaction.annotation.TransactionManagementConfigurationSelector;
import org.springframework.transaction.annotation.Transactional;
import xyz.orm.bliu.dao.SnipperDAO;
import xyz.orm.bliu.model.Snipper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
//@ContextConfiguration(classes = {HibernateXMLConf.class})
public class SpringContextTest {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SnipperDAO snipperDAO;
//
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testDefaultTransaction() {
        ProxyTransactionManagementConfiguration configuration =
               (ProxyTransactionManagementConfiguration )applicationContext.getBean("org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration");

        System.out.println(configuration);
    }

    @Test
    @Commit
    @Transactional
    public void testSave() {
        Snipper snipper = new Snipper();
        snipper.setSnipperCode("hah今天天气真不错");
        snipper.setDesc("hehe");
        Long saveId = snipperDAO.save(snipper);
//
        System.out.println(snipperDAO.queryById(saveId));
//        System.out.println(entityManager);
//
//        entityManager.persist(snipper);
    }

    @Test
    @Commit
    @Transactional
    public void testUpdate() {
        Snipper snipper = new Snipper();
        snipper.setSnipperId(26);
        snipper.setSnipperCode("javacode");
        snipper.setDesc("jpa使用");
        snipper.setCreateTime(new Date());
        snipperDAO.update(snipper);
    }

    @Test
    @Commit
    @Transactional
    public void testSaveOrUpdate() {
        Snipper snipper= snipperDAO.queryById(23);
        snipper.setSnipperCode("javacode");
        snipper.setDesc("jpa使用2323 read only111");
        snipper.setAuthId("aaa");
        snipper.setCreateTime(new Date());

        sessionFactory.getCurrentSession().saveOrUpdate(snipper);
    }

    @Test
    @Commit
    @Transactional
    public void testMerge() {
//        Snipper snipper= snipperDAO.queryById(22);
//        snipper.setCreateTime(new Date());
        Snipper snipper = new Snipper();
        snipper.setSnipperId(22);
        snipper.setSnipperCode("javacode");
        snipper.setDesc("jpa使用2323 read only222");
        snipper.setAuthId("aaa");
        sessionFactory.getCurrentSession().merge(snipper);
    }
}