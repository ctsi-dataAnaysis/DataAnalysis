create table user(id int UNSIGNED AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
<<<<<<< HEAD
    create_time DATETIME NOT NULL,
=======
    createTime DATETIME NOT NULL,
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
    email VARCHAR(40) NOT NULL,
    PRIMARY KEY(id)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;