package goit.hw7.service;

import goit.hw7.model.DaoInterfaces.WaiterDao;
import goit.hw7.model.Waiter;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class WaiterService extends EmployeeService {

    private WaiterDao waiterDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public Waiter getById(int id){
        return waiterDao.getById(id);
    }

    public void setWaiterDao(WaiterDao waiterDao) {
        this.waiterDao = waiterDao;
    }
}
