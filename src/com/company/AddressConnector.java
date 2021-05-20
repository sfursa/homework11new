package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressConnector {

    private static Connection connection;

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/addr_db?useUnicode=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "zadiak";


    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    private static final String ADD = "INSERT INTO addresses (id, city, street, house_number) VALUES(?, ?, ?, ?)";

    public static void save(Address address) {
        Connection connection = AddressConnector.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(ADD)) {
            statement.setInt(1, address.getId());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getStreet());
            statement.setInt(4, address.getHouse_number());

            statement.executeLargeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static final String SELECT_ALL = "SELECT * FROM ADDRESSES";

    public List<Address> readAll() {
        List<Address> res = new ArrayList<>();
        Connection connection = AddressConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Address address = AddressConnector.toObject(result);
                res.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static Address toObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String city = resultSet.getString("city");
        String street = resultSet.getString("street");
        int house_number = resultSet.getInt("house_number");

        return new Address(id, city, street, house_number);
    }


    private static final String DELETE = "DELETE FROM ADDRESSES WHERE id = ?";

    public static void delete(int id) {
        Connection connection = AddressConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static final String UPDATE = "UPDATE ADDRESSES SET city = ?, street = ?, house_number = ? WHERE id = ?";

    public static boolean update(Address address) {
        Connection connection = AddressConnector.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3, address.getHouse_number());
            int changed = statement.executeUpdate();
            return changed != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }


    private static final String SELECT_BY_ID = "SELECT * FROM ADDRESSES WHERE id = ?";

    public static Address byId(int id) {
        Connection connection = AddressConnector.getConnection();
        Address result = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            result = AddressConnector.buildPerson(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static Address buildPerson(ResultSet resultSet) {
        Address result = null;

        try {
            int id = resultSet.getInt("id");
            String city = resultSet.getString("city");
            String street = resultSet.getString("street");
            int house_number = resultSet.getInt("house_number");
            result = new Address(id, city, street, house_number);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
