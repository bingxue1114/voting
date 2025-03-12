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
    voter_name VARCHAR(255) NOT NULL
);



CREATE TABLE vote_voting_item (
    vote_id INT NOT NULL,
    voting_item_id INT NOT NULL,
    PRIMARY KEY (vote_id, voting_item_id),
    FOREIGN KEY (vote_id) REFERENCES votes(id) ON DELETE CASCADE,
    FOREIGN KEY (voting_item_id) REFERENCES voting_items(id) ON DELETE CASCADE
);


SELECT * FROM voting_items;
SELECT * FROM votes;
SELECT * FROM vote_voting_item;
DROP TABLE IF EXISTS voting_items;
DROP TABLE IF EXISTS votes;
DROP TABLE IF EXISTS vote_voting_item;
ALTER TABLE vote_voting_item DROP FOREIGN KEY FK5fado1vufrgdd6ff4f65q7t0h;
