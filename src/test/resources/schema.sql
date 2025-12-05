CREATE TABLE sidos (
    sido_code INT PRIMARY KEY,
    sido_name VARCHAR(255)
);

CREATE TABLE guguns (
    gugun_code INT PRIMARY KEY,
    gugun_name VARCHAR(255),
    sido_code INT
);
