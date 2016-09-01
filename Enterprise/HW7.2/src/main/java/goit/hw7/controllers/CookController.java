package goit.hw7.controllers;

import goit.hw7.model.Cook;
import goit.hw7.model.DaoInterfaces.CookDao;
import goit.hw7.model.Hibernate.HCookDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class CookController extends EmployeeController {

    private CookDao cookDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public Cook getById(int id){
        return cookDao.getById(id);
    }

    public void setCookDao(CookDao cookDao) {
        this.cookDao = cookDao;
    }
}
