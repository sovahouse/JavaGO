package goit.hw7.model.jdbc;


import goit.hw7.model.DaoInterfaces.MenuDao;
import goit.hw7.model.Dish;
import goit.hw7.model.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JdbcMenuDao implements MenuDao {

    private DataSource dataSource;
    private JdbcDishDao dishDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuDao.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addMenu(Menu menu) {
        String menuQuery = "INSERT INTO MENU (NAME) " + "VALUES (?)";
        String dishesListQuery = "INSERT INTO MENU_LIST (dish_id, menu)" +
                "VALUES (?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement menuStatement = connection.prepareStatement(menuQuery);
             PreparedStatement dishesListStatement = connection.prepareStatement(dishesListQuery)) {

            menuStatement.setString(1, menu.getName());
            menuStatement.execute();

            for (Dish dish : menu.getDishes()) {
                dishesListStatement.setInt(1, dish.getId());
                dishesListStatement.setString(2, menu.getName());
                dishesListStatement.execute();
            }



        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot add new menu" + menu.toString());
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteMenuByName(String name) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement menuList = connection.prepareStatement("DELETE FROM menu_list WHERE menu = ?");
             PreparedStatement menu = connection.prepareStatement("DELETE FROM menu WHERE NAME = ?")) {

            menuList.setString(1, name);
            menuList.execute();

            menu.setString(1,name);
            menu.execute();

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot find Dish with name: " + name);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteDishesById(int id, Menu targetMenu) { //TODO: testing + add polymorphism for list
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM menu_list WHERE dish_id = ? AND menu = ?")) {

            statement.setInt(1, id);
            statement.setString(2, targetMenu.getName());
            statement.execute();

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot find Dish with id: " + id);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addDishesById(int id, Menu targetMenu) { //TODO: testing + add polymorphism for list
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO menu_list (dish_id, menu) VALUES (?, ?)")) {

            statement.setInt(1, id);
            statement.setString(2, targetMenu.getName());
            statement.execute();

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot find Dish with id: " + id);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Menu> findAll() {
        List<Menu> result = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM menu");

            while (resultSet.next()) {
                Menu menu = createMenu(resultSet);
                result.add(menu);
            }


        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException(e);
        }

        return result;

    }

    private Menu createMenu(ResultSet resultSet) throws SQLException {
        Menu menu = new Menu();
        menu.setName(resultSet.getString("NAME"));
        menu.setDishes(getDishesList(menu.getName()));

        return menu;
    }

    private List<Dish> getDishesList(String name) {
        List<Dish> dishes = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT dish_id FROM menu_list WHERE menu = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Dish dish = dishDao.getById(resultSet.getInt("DISH_ID"));
                dishes.add(dish);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB", e);
            throw new RuntimeException("Cannot find Dishes for menu name: " + name);
        }

        return dishes;
    }

    public void setDishDao(JdbcDishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
