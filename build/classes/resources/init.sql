CREATE DATABASE taller3;

USE taller3;

CREATE TABLE clients(
  document VARCHAR(20) NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  phone VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL
);

CREATE TABLE categories(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE articles(
  code INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  price INT NOT NULL,
  category_id INT NOT NULL,
  stock INT NOT NULL,
  CONSTRAINT art_cat_fkey FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE PROCEDURE save_client(
  document_client VARCHAR(20),
  name_client VARCHAR(255),
  phone_client VARCHAR(255),
  email_client VARCHAR(255)
)
INSERT INTO clients (document, name, phone, email) VALUES(document_client, name_client, phone_client, email_client);

CREATE PROCEDURE update_client(
  document_client VARCHAR(20),
  name_client VARCHAR(255),
  phone_client VARCHAR(255),
  email_client VARCHAR(255)
)
UPDATE clients SET name = name_client, phone = phone_client, email = email_client WHERE document = document_client;

CREATE PROCEDURE delete_client(document_client VARCHAR(20))
DELETE FROM clients WHERE document = document_client;

CREATE PROCEDURE find_client_by_document(document_client VARCHAR(20))
SELECT name, phone, email FROM clients WHERE document = document_client;

CREATE PROCEDURE find_all_clients()
SELECT document, name, phone, email FROM clients;

CREATE PROCEDURE save_article(
  name_article VARCHAR(255),
  price_article INT,
  article_category_id INT,
  stock_article INT
)
INSERT INTO articles (code, name, price, category_id, stock) VALUES(null, name_article, price_article, article_category_id, stock_article);

CREATE PROCEDURE update_article(
  code_article INT,
  name_article VARCHAR(255),
  price_article INT,
  article_category_id INT,
  stock_article INT
)
UPDATE articles SET name = name_article, price = price_article, category_id = article_category_id, stock = stock_article WHERE code = code_article;

CREATE PROCEDURE delete_article(code_article INT)
DELETE FROM articles WHERE code = code_article;

CREATE PROCEDURE find_article_by_code(code_article INT)
SELECT name, price, category_id, stock FROM articles WHERE code = code_article;

CREATE PROCEDURE find_all_articles()
SELECT code, name, price, category_id, stock FROM articles;

CREATE PROCEDURE save_category(
  name_category VARCHAR(255)
)
INSERT INTO categories (id, name) VALUES(null, name_category);

CREATE PROCEDURE get_category_name(category_id INT)
SELECT name FROM categories WHERE id = category_id;

CREATE PROCEDURE get_category_id_by_name(category_name VARCHAR(255))
SELECT id FROM categories WHERE name = category_name;

CREATE PROCEDURE find_all_categories()
SELECT name FROM categories;

CALL save_client('Document 1', 'Name 1', 'Phone 1', 'Email 1');
CALL save_client('Document 2', 'Name 2', 'Phone 2', 'Email 2');
CALL save_client('Document 3', 'Name 3', 'Phone 3', 'Email 3');
CALL save_client('Document 4', 'Name 4', 'Phone 4', 'Email 4');
CALL save_client('Document 5', 'Name 5', 'Phone 5', 'Email 5');

CALL save_category('Category 1');
CALL save_category('Category 2');
CALL save_category('Category 3');
CALL save_category('Category 4');
CALL save_category('Category 5');
CALL save_category('Category 6');
CALL save_category('Category 7');
CALL save_category('Category 8');
CALL save_category('Category 9');
CALL save_category('Category 10');

CALL save_article('Article 1', 100, 1, 1);
CALL save_article('Article 2', 200, 2, 2);
CALL save_article('Article 3', 300, 3, 3);
CALL save_article('Article 4', 400, 4, 4);
CALL save_article('Article 5', 500, 5, 5);