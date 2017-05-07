DROP TABLE IF EXISTS user;
CREATE TABLE user (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	username varchar(64),
	password varchar(64),
	first_name varchar(64),
	last_name varchar(64),
	admin boolean,
	guild_id int
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS guild;
CREATE TABLE guild (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar(64)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS invite;
CREATE TABLE invite (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	date datetime,
	message text,
	sender_id int,
	recipient_id int,
	guild_id int
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE user
	ADD CONSTRAINT FOREIGN KEY (guild_id)
	REFERENCES guild(id)
	ON DELETE CASCADE
	ON UPDATE CASCADE;

ALTER TABLE invite
	ADD CONSTRAINT FOREIGN KEY (sender_id)
	REFERENCES user(id)
	ON DELETE CASCADE
	ON UPDATE CASCADE;
    
ALTER TABLE invite
	ADD CONSTRAINT FOREIGN KEY (recipient_id)
	REFERENCES user(id)
	ON DELETE CASCADE
	ON UPDATE CASCADE;
	
ALTER TABLE invite
	ADD CONSTRAINT FOREIGN KEY (guild_id)
	REFERENCES guild(id)
	ON DELETE CASCADE
	ON UPDATE CASCADE;

INSERT INTO guild (name) VALUES 
	("Some Guild"), 
	("Some Other Guild");
	
INSERT INTO user (username, password, first_name, last_name, admin, guild_id) VALUES 
	("admin", "admin", "Administrator", "Anonymous", 1, null), 
	("username", "password", "Administrator", "Anonymous", 0, null);