/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model.entities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo
 */
public class Article {

    private int code;
    private String nameArticle;
    private int price;
    private int category;
    private int stock;

    public Article() {

    }

    public Article(int code, String nameArticle, int price, int category, int stock) {
        this.code = code;
        this.nameArticle = nameArticle;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    public Article(String nameArticle, int price, int category, int stock) {
        this.nameArticle = nameArticle;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNameArticle() {
        return nameArticle;
    }

    public void setNameArticle(String nameArticle) {
        this.nameArticle = nameArticle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void save(Article article) throws SQLException {

        final String query = "CALL save_article(?,?,?,?)";

        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, article.getNameArticle());
            preparedStatement.setInt(2, article.getPrice());
            preparedStatement.setInt(3, article.getCategory());
            preparedStatement.setInt(4, article.getStock());

            preparedStatement.executeUpdate();
        }
    }

    public void update(int code, Article article) throws SQLException {
        final String query = "CALL update_article(?,?,?,?,?)";

        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, code);
            preparedStatement.setString(2, article.getNameArticle());
            preparedStatement.setInt(3, article.getPrice());
            preparedStatement.setInt(4, article.getCategory());
            preparedStatement.setInt(5, article.getStock());

            preparedStatement.executeUpdate();
        }
    }

    public void delete(int code) throws SQLException {
        final String query = "CALL delete_article(?)";

        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, code);

            preparedStatement.executeUpdate();
        }
    }

    public boolean existByCode(int code) throws SQLException {
        final String query = "CALL find_article_by_code(?)";

        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, code);

            final ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        }
    }

    public Article findArticleByCode(int code) throws SQLException {
        final String query = "CALL find_article_by_code(?)";

        final Article article;

        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, code);

            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                article = new Article(
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getInt("category_id"),
                        resultSet.getInt("stock")
                );
            } else {
                return null;
            }
        }
        return article;
    }

    public List<Article> findArticlesByName(String name) throws SQLException {
        final String query = "SELECT code, name, price, category_id, stock FROM articles WHERE name LIKE ?";

        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, "%" + name + "%");

            final ResultSet resultSet = preparedStatement.executeQuery();

            final List<Article> articles = new ArrayList<>();

            while (resultSet.next()) {
                articles.add(new Article(
                        resultSet.getInt("code"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getInt("category_id"),
                        resultSet.getInt("stock")));
            }

            return articles;
        }
    }

    public List<Article> findAllArticles() throws SQLException {
        final String query = "CALL find_all_articles()";

        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {

            final ResultSet resultSet = preparedStatement.executeQuery();

            final List<Article> articles = new ArrayList<>();

            while (resultSet.next()) {
                articles.add(new Article(
                        resultSet.getInt("code"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getInt("category_id"),
                        resultSet.getInt("stock")));
            }

            return articles;
        }
    }

    public String getCategoryName(int categoryId) throws SQLException {
        final String query = "CALL get_category_name(?)";
        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, categoryId);

            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("name");
            }
        }
        return "";
    }

    public int getCategoryIdentificatorByCategoryName(String categoryName) throws SQLException {
        final String query = "CALL get_category_id_by_name(?)";
        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, categoryName);

            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        }
        return -1;
    }

    public List<String> getAllCategoriesNames() throws SQLException {
        final String query = "CALL find_all_categories()";

        try (PreparedStatement preparedStatement = new ConnectionBD().getConnection().prepareStatement(query)) {

            final ResultSet resultSet = preparedStatement.executeQuery();

            final List<String> categories = new ArrayList<>();

            while (resultSet.next()) {
                categories.add(resultSet.getString("name"));
            }

            return categories;
        }
    }
}
