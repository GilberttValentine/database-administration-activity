package main.model.entities;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Client {

    private String document;
    private String name;
    private String phone;
    private String email;

    public Client() {
    }

    public Client(String document, String name, String phone, String email) {
        this.document = document;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Client(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void save(Client client) throws SQLException {

        final String query = "CALL save_client(?,?,?,?)";

        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, client.getDocument());
            preparedStatement.setString(2, client.getName());
            preparedStatement.setString(3, client.getPhone());
            preparedStatement.setString(4, client.getEmail());

            preparedStatement.executeUpdate();
        }
    }

    public void update(String document, Client client) throws SQLException {
        final String query = "CALL update_client(?,?,?,?)";

        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, document);
            preparedStatement.setString(2, client.getName());
            preparedStatement.setString(3, client.getPhone());
            preparedStatement.setString(4, client.getEmail());

            preparedStatement.executeUpdate();
        }
    }

    public void delete(String document) throws SQLException {
        final String query = "CALL delete_client(?)";

        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, document);

            preparedStatement.executeUpdate();
        }
    }

    public boolean existByDocument(String document) throws SQLException {
        final String query = "CALL find_client_by_document(?)";

        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, document);

            final ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        }
    }

    public Client findClientByDocument(String document) throws SQLException {
        final String query = "CALL find_client_by_document(?)";

        final Client client;

        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, document);

            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                client = new Client(
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"));
            } else {
                return null;
            }
        }
        return client;
    }

    public List<Client> findClientsByDocument(String document) throws SQLException {
        final String query = "SELECT document, name, phone, email FROM clients WHERE document LIKE ?";

        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, "%"+document+"%");

            final ResultSet resultSet = preparedStatement.executeQuery();

            final List<Client> clients = new ArrayList<>();

            while (resultSet.next()) {
                clients.add(new Client(
                        resultSet.getString("document"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")));
            }

            return clients;
        }
    }
    
    public List<Client> findAllClients() throws SQLException {
        final String query = "CALL find_all_clients()";

        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {

            final ResultSet resultSet = preparedStatement.executeQuery();

            final List<Client> clients = new ArrayList<>();

            while (resultSet.next()) {
                clients.add(new Client(
                        resultSet.getString("document"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")));
            }

            return clients;
        }
    }
}
