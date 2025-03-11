SHOW DATABASES;

CREATE DATABASE voting_system;

USE voting_system;

CREATE TABLE voting_items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE votes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    voter_name VARCHAR(255) NOT NULL,
    voting_item_id INT,
    FOREIGN KEY (voting_item_id) REFERENCES voting_items(id)
);

SELECT * FROM voting_items;
SELECT * FROM votes;
DROP TABLE IF EXISTS voting_items;
