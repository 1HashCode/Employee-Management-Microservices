
CREATE TABLE IF NOT EXISTS "users" (
    id UUID PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);


INSERT INTO "users" (id, email, password, role)
SELECT '111e4567-e89b-12d3-a456-426614174001', 'user1@example.com',
       '$2a$12$xp36oMHlp0C2yzlWfS.rWOF2PZYm4AqovJRJaQ9mt0zYDdyWkWcvi', 'ADMIN'
WHERE NOT EXISTS (
    SELECT 1 FROM "users"
    WHERE id = '111e4567-e89b-12d3-a456-426614174001'
       OR email = 'user1@example.com'
);

