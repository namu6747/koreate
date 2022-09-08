CREATE TABLE tbl_book(
	num INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(300) NOT NULL,
	author VARCHAR(300) NOT NULL,
	regDate TIMESTAMP DEFAULT now()
);

DESC tbl_book;

INSERT INTO tbl_book(title, author)
VALUES('혼자공부하는 자바','신용권');

SELECT * FROM tbl_book;
ROLLBACK;
TRUNCATE tbl_book;
COMMIT;
SHOW TABLE status WHERE name = 'tbl_book';

ALTER TABLE bigdata.tbl_book AUTO_INCREMENT = 1;
commit;
SHOW processlist;

show table status where name = 'tbl_book';
alter table tbl_book auto_increment = 1;
flush privileges;
show table status where name = 'tbl_book';