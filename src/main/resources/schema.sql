DROP TABLE IF EXISTS "City" CASCADE;
CREATE TABLE "City" (
index SERIAL PRIMARY KEY,
"Name" VARCHAR NOT NULL,
latitude REAL NOT NULL,
longitude REAL NOT NULL
);
DROP TABLE IF EXISTS measure;
CREATE TABLE measure (
id SERIAL PRIMARY KEY,
type VARCHAR NOT NULL,
unit VARCHAR NOT NULL,
value REAL,
measureDate TIMESTAMP NOT NULL
);

DROP TABLE IF EXISTS user_monument ;
DROP TABLE IF EXISTS monuments ;
CREATE TABLE monuments (
id SERIAL PRIMARY KEY,
name VARCHAR(100) NOT NULL,
city INTEGER references "City"
);
DROP TABLE IF EXISTS users ;
CREATE TABLE users (
id SERIAL PRIMARY KEY,
name VARCHAR(100) NOT NULL
);

CREATE TABLE user_monument (
fk_user INTEGER references users,
fk_monument INTEGER references monuments,
rating VARCHAR(31)
);
