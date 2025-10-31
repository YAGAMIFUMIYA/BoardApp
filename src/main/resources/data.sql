-- 先にユーザーを作成
INSERT INTO users (username, password) VALUES ('admin', 'admin123');

-- その後、投稿データを挿入
INSERT INTO posts (title, content, author, username)
VALUES
    ('初めての投稿', 'MyBatis掲示板へようこそ！', '管理者', 'admin')