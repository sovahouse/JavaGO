package goit.hw7.service;

import goit.hw7.model.Cook;
import goit.hw7.model.DaoInterfaces.CookDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class CookService extends EmployeeService {

    private CookDao cookDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public Cook getById(int id){
        return cookDao.getById(id);
    }

    public void setCookDao(CookDao cookDao) {
        this.cookDao = cookDao;
    }
}
