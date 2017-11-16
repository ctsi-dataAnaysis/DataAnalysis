create table user(id int UNSIGNED AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    create_time DATETIME NOT NULL,
    email VARCHAR(40) NOT NULL,
    PRIMARY KEY(id)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;