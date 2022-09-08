-- ctrl + enter
/*
	Create 명령어를 이용하여 
    database 또는 table 등 데이터를 정의하는
    구조를 생성
    
*/
-- CREATE SCHEMA `sqldb` ;
-- CREATE SCHEMA sqldb ;
use sqldb;

CREATE TABLE `sqldb`.`member_tbl` (
  `member_id` VARCHAR(50) NOT NULL COMMENT '회원을 구분짓는 아이디',
  `member_name` VARCHAR(45) NULL DEFAULT NULL COMMENT '회원의 이름',
  `member_addr` VARCHAR(45) NULL COMMENT '회원 배송 주소',
  PRIMARY KEY (`member_id`))
COMMENT = '회원정보에 대한 정보';


/*
 table 이름 : product_tbl 
 상품이름 : product_name VARCHAR(50),
 상품가격 : cost INT,
 제조날짜 : make_date VARCHAR(20),
 남은수량 : amount INT NULL
*/
CREATE TABLE `sqldb`.`product_tbl` (
  `product_name` VARCHAR(50) NOT NULL,
  `cost` INT NULL,
  `make_date` VARCHAR(20) NULL,
  `amount` INT NULL,
  PRIMARY KEY (`product_name`))
COMMENT = '상품 정보';

-- 지정된 데이터베이스의 테이블 이름 정보 확인
show tables;

-- product_tbl의 모든 열의 정보 검색
SELECT * FROM product_tbl;

-- sqldb schema or database 삭제
DROP DATABASE sqldb;

-- ----------------------------------
-- sqldb schema 생성
CREATE DATABASE sqldb;

-- testdb DATABASE 생성
-- testdb가 존재하지 않으면 create
CREATE SCHEMA IF NOT EXISTS testdb;

-- testdb 삭제
DROP DATABASE IF EXISTS testDB;

USE testdb;

CREATE TABLE IF NOT EXISTS userTbl(
	userID char(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    birthyear INT NOT NULL,
    addr char(2) NOT NULL,
    mobile1 char(3),
    mobile2 char(8),
    height smallint,
    mDate date
);

-- 상품 정보를 저장하는 테이블
CREATE TABLE IF NOT EXISTS prodoctTbl(
	num INT(8) NOT NULL PRIMARY KEY,
    userID char(8) NOT NULL,
    prodName char(6),
    groupName char(4),
    price char(5),
    count smallint NOT NULL
);

show tables;

DESCRIBE usertbl;
DESC usertbl;

-- 정의된 정보를 수정하는 keyword - ALTER
-- table 이름 수정
ALTER TABLE prodocttbl RENAME buyTBL;

show tables;

-- buyTBL 에 있는 price 속성에 dataType을 INT로 변경
ALTER TABLE buytbl MODIFY price INT;

-- 변경 확인
DESC buytbl;

-- buyTBL의 num 속성을 변경
ALTER TABLE buytbl 
modify num INT AUTO_INCREMENT;

-- buyTBL count열의 이름과 속성 변경
-- amount로 변경
ALTER TABLE buytbl CHANGE count amount smallint NOT NULL;


DESC buytbl;


-- 테이블에 행의 정보를 추가하는 DML
-- INSERT INTO VALUES
DESC userTBL;
INSERT INTO usertbl
VALUES('PJS','박주신',1988, '평양',null,null,162,'1989-8-8');
INSERT INTO usertbl
VALUES('PJS','박재신',1987, '서울',null,null,180,'1995-8-3');

SELECT * FROM usertbl;

DESC buytbl;
INSERT INTO buyTBL
VALUES(null,'PJS',"운동화",'의류',30,1);

select * from buytbl;

INSERT INTO buyTBL
VALUES(null,'PTH',"세탁기",'전자',300,2);

SELECT * FROM userTBL;


-- buyTBL의 USERiD 열정보를
-- USERTBL 테이블에 USERId의 외래키(참조키)로 지정

ALTER TABLE buytbl ADD CONSTRAINT FOREIGN KEY(userID)
REFERENCES userTBL(userID);

DESC buytbl;

commit;

TRUNCATE buyTbl;
TRUNCATE userTBL;
-- 테이블에 존재하는 특정 행의 정보를 삭제하는 DML
-- DELETE FROM table명
DELETE FROM userTBL; 
-- WHERE 0 = 0;

-- SELECT column명 FROM table 명 where 조건절
SELECT * FROM usertbl
WHERE NAME = '김범수';
-- 조건절 : NAME 속성의 값이 '김범수'와 일치하는 사용자
-- userTBL 에서 userID가 BBK인 사람을 검색
SELECT * FROM userTBL 
WHERE userID = 'BBK';

-- 1970년 이후에 출생하고 키가 182 이상인 사람 검색
SELECT * FROM usertbl 
WHERE birthyear>1970 AND height>=182;

-- userTbl에서 경기에 사는 사람의 이름과 주소만 검색
SELECT name,addr FROM usertbl
WHERE addr='경기' ;

-- userTBL에서 1970 ~ 1979년 사이에 태어난 사람의 이름
SELECT name FROM usertbl
WHERE birthyear >=1970 AND birthyear<=1979;

-- 키가 180이상 183 이하인 사람의 이름, 주소, 키 정보 검색
select name,addr,height FROM usertbl
WHERE height>=180 && height<=183;

-- BETWEEN 범위값 AND 범위값
SELECT * FROM userTBL
where height between 180 AND 183;

-- usertbl에서 주소가 '경남'이거나 '전남'이거나 '경북'인 사람 검색
select * From usertbl
WHERE addr='경남' || addr='전남' || addr='경북';

-- 동일한 속성에서 특정 조건들을 만족하는 정보를 검색
-- WHERE IN
SELECT * FROM userTbl 
WHERE addr IN('경북','경기','전남');

-- LIKE wildcard[% || _ ]를 활용한 검색
-- 와일드 카드를 이용하여 1970년대 출생한 사람 찾기 1970~1979
SELECT * FROM userTBL WHERE birthyear LIKE '197_';

-- userTBL에서 성이 '김'씨 인 모든 사용자 정보 검색
SELECT * FROM usertbl WHERE name LIKE '김__';

-- userTBL에서 이름 사이에 '시' 가 들어가는 사용자 검색
SELECT * FROM usertbl where name LIKE '_시_';

-- 김으로 시작하고 뒤에는 무슨 값이든 상관없음.
SELECT * FROM userTbl 
WHERE name LIKE'김%';

-- Null 값 비교
SELECT * FROM userTbl;

-- userTbl에서 mobile1 핸드폰 번호가 없는 사용자 정보 검색
-- NULL 비교 연산 할때는 WHERE IS
SELECT * FROM userTbl
WHERE mobile1 IS null;

-- 전화번호가 존재하는 사용자
SELECT * FROM userTbl
WHERE mobile1 IS NOT null;

-- 거주지(주소)가 서울이 아닌 사람 검색
SELECT * FROM usertbl
WHERE addr !='서울';

SELECT * FROM usertbl
WHERE NOT addr ='서울';

SELECT * FROM usertbl
WHERE addr <> '서울';

-- 전화번호 시작(mobile1) 016,018,019인 사람들 검색
SELECT * FROM userTbl
WHERE mobile1 IN(016,018,019);

-- height 키가 170 이상인 사람 검색
SELECT * FROM userTbl
WHERE height >=170;

-- 이름이 김경호인 사람의 키 검색
SELECT height FROM userTbl
WHERE name ='김경호';
-- 177
-- 김경호보다 키가 같거나 큰 사람의 이름과 키를 검색
SELECT name,height FROM userTbl
WHERE height >=177; 

-- 서브쿼리 이용해서 검색
SELECT name,height FROM userTbl
WHERE height >=(
	SELECT height FROM userTbl
	WHERE name ='김경호'
); 































  
  


