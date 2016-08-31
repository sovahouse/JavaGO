package goit.hw7.controllers;

import goit.hw7.model.Cook;
import goit.hw7.model.Hibernate.HCookDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class CookController {

    private HCookDao hCookDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public Cook getById(int id){
        return hCookDao.getById(id);
    }

    public void sethCookDao(HCookDao hCookDao) {
        this.hCookDao = hCookDao;
    }
}
