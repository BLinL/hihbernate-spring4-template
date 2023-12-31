package xyz.orm.bliu;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ImportResource({"classpath:applicationContext.xml"})
public class HibernateXMLConf {

}