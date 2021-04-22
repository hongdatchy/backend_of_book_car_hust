CREATE TABLE user(
	id int NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(45) not null,
    pass VARCHAR(45) not null,
    phone VARCHAR(45) not null,
    primary key (id),
    UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE contract(
	id int NOT NULL AUTO_INCREMENT,
	user_id int not null,
    distance varchar(20) not null,
    cost int not null,
    time datetime not null,
    primary key (id),
    UNIQUE KEY `id_UNIQUE` (`id`),
    CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;