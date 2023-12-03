package xyz.orm.bliu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.orm.bliu.dao.SnipperDAO;
import xyz.orm.bliu.model.Snipper;

import java.util.Date;

@RequestMapping("/")
@RestController
public class Hellocontroller {

    @Autowired
    private SnipperDAO snipperDAO;

    @GetMapping("/hello")
    public Snipper hello() {
        Snipper snipper = new Snipper();
        snipper.setSnipperId(26);
        snipper.setSnipperCode("javacode");
        snipper.setDesc("jpa使用haha");
        snipper.setCreateTime(new Date());
        snipperDAO.update(snipper);
        return snipper;
    }
}
