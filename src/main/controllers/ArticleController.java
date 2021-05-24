/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controllers;

import main.model.entities.Article;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class ArticleController {

    private final Article article = new Article();

    public void createArticle(Article article) {
        try {
            this.article.save(article);
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editArticle(int code, Article article) {
        try {
            if (!this.article.existByCode(code)) {
                throw new Error("No se encontró ningún artículo con ese código");
            }
            this.article.update(code, article);
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteArticle(int code) {
        try {
            if (!this.article.existByCode(code)) {
                throw new Error("No se encontró ningún artículo con ese código");
            }
            this.article.delete(code);
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel listArticles() {

        final String columnHeaders[] = {"Code", "Name", "Price", "Category", "Stock", "", ""};

        final DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnHeaders);

        try {
            final List<Article> articles = this.article.findAllArticles();

            articles.forEach(it -> {
                model.addRow(new Object[]{
                    it.getCode(),
                    it.getNameArticle(),
                    it.getPrice(),
                    findCategoryById(it.getCategory()),
                    it.getStock(),
                    "Edit",
                    "Delete",});
            });

        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return model;
    }

    public DefaultTableModel listArticles(List<Article> articles) {
        final String columnHeaders[] = {"Code", "Name", "Price", "Category", "Stock", "", ""};

        final DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnHeaders);

        articles.forEach(it -> {
            model.addRow(new Object[]{
                it.getCode(),
                it.getNameArticle(),
                it.getPrice(),
                findCategoryById(it.getCategory()),
                it.getStock(),
                "Edit",
                "Delete",});
        });

        return model;
    }

    public String findCategoryById(int categoryId) {
        try {
            String category = article.getCategoryName(categoryId);
            return category;
        } catch (Exception ex) {
            return null;
        }
    }

    public int findCategoryByName(String categoryName) {
        try {
            int categoryId = article.getCategoryIdentificatorByCategoryName(categoryName);
            return categoryId;
        } catch (Exception ex) {
            return -1;
        }
    }

    public DefaultComboBoxModel listCategories() {

        final DefaultComboBoxModel model = new DefaultComboBoxModel();

        try {
            final List<String> categories = article.getAllCategoriesNames();

            categories.forEach(it -> {
                model.addElement(it);
            });

        } catch (Exception ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return model;
    }

    public Article findArticleByCode(int code) {
        try {
            if (!this.article.existByCode(code)) {
                throw new Error("No se encontró ningún artículo con ese código");
            }

            final Article articleFounded = this.article.findArticleByCode(code);

            return articleFounded;
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);

            return null;
        }
    }

    public List<Article> findArticlesByName(String name) {
        try {
            final List<Article> articles = this.article.findArticlesByName(name);

            return articles;
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);

            return null;
        }
    }
}
