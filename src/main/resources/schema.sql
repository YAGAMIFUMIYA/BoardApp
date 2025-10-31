-- =============================
-- ユーザー情報テーブル
-- =============================
-- DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL
);


-- =============================
-- 投稿テーブル
-- =============================
CREATE TABLE IF NOT EXISTS posts (
                                     id IDENTITY PRIMARY KEY,
                                     title VARCHAR(255) NOT NULL,
    content VARCHAR(1000),
    author VARCHAR(100),
    username VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_posts_users FOREIGN KEY (username) REFERENCES users(username)
    );
