USE sqldb;
-- sqldb table 목록 확인
show tables;
-- userTbl , buyTbl 정보 검색
SELECT * FROM userTbl;
SELECT * FROM `buyTBL`;
DESC userTBL;
INSERT INTO userTBL
VALUES('PJS','박지성',1982,'부산',null,null,173,'2002-06-06');

INSERT INTO userTBL
VALUES('LSS','이순신',1685,'전남',null,null,170,'2002-06-06');
-- 경남에 사는 사람과 키가 동일한 사람 검색
Select height FROM usertbl
WHERE addr = '경남';
-- 170	, 173

SELECT name, height,addr FROM userTbl
WHERE height =170 or height=173;

delete FROM usertbl WHERE userid = 'PJS';
commit;

-- savepoint 지점으로 돌아감
rollback;
-- 서브쿼리를 사용할경우 리턴결과가 2가지이상이면 비교 불가 -> 에러뜸 -> 이상연산 IN사용하기
SELECT name, height,addr FROM userTbl
WHERE height IN(Select height FROM usertbl
WHERE addr = '경남');

-- userTBL 에서 경남에 사는 사람 보다 키가 같거나 큰 사람들 검색
SELECT name, height, addr FROM userTBL
WHERE height >= ANY(
	SELECT height FROM userTBL WHERE addr='경남'
);

-- USERTBL 에서 경남에 사는 사람중 가장 키가 큰 사람과 키가 같거나 큰 사람의 정보 검색
SELECT name, height, addr FROM userTBL
WHERE height >= ALL(
	SELECT height FROM userTBL WHERE addr='경남'
);

-- 검색된 행의 정보를 정렬하는 ORDER BY 절(ASC:오름차순/DESC:내림차순)
-- 거주 지역별로 오름차순 정렬
SELECT * FROM usertbl ORDER BY addr ASC;
-- ASC  오름차순 : default값 생략하면 ASC

-- 가장 최근에 가입한 순서대로 정렬
SELECT * FROM usertbl ORDER BY mDate DESC;

-- 거주지역 순으로 정렬하고 동일 지역이면 나이순으로 정렬 
SELECT * FROM usertbl order by addr, birthyear ASC;

-- 검색 결과에 중복된 행의 정보를 제거 - distinct
-- 키가175이상인 사람이 사는 곳 검색 
SELECT addr,height FROM userTbl
WHERE height >=175 ORDER BY addr;

-- 속성이 여러가지면 둘다 만족해야 중복으로 제거해줌 
SELECT distinct addr,height FROM userTbl
WHERE height >=175;

-- 검색된 결과 내에서 제공되는 개수를 제한하는 LIMIT
-- MySQL 에서만 존재하고 다른 데이터 베이스보다 속도가 빠르다
SELECT * FROM userTBL
ORDER BY mDate ASC LIMIT 5;

SELECT * FROM userTbl ORDER By mDate;

-- LIMIT 시작인덱스, 개수; 5번째 인덱스부터 5개 가져옴 
SELECT * FROM userTbl
ORDER By mDate asc limit 5, 5;

-- LIMIT 개수 OFFSET 시작 인덱스;
SELECT* FROM userTbl ORDER BY mDate ASC
LIMIT 6 OFFSET 5;

-- GROUP BY HAVING 절 과 집계함수
-- buyTbl에서 구매한 총 물량의 개수
SELECT amount FROM buyTbl;

-- sum() 합계 AS '별칭'
SELECT sum(amount) AS '구매개수' FROM buyTbl;

-- BUYTBL에서 사용자마다 구매한 개수를 검색 
SELECT userID, sum(amount) AS '개수' FROM buyTbl
GROUP BY userID;

-- count() table에 존재하는 행의 개수를 검색
-- count(열이름) 해당 속성에 유효한 값을 가진 행의 개수를 반환
SELECT * FROM userTbl;

SELECT count(*) FROM userTbl;

SELECT count(mobile1) FROM userTbl;

SELECT count(*) FROM userTbl
WHERE mobile1 is NOT NULL;

-- 프라이머리 키를 이용해서 COUNT
SELECT count(userID) FROM userTBL;

SELECT addr FROM userTBL ORDER BY addr DESC;

SELECT count(distinct addr) FROM userTbl;

-- min(), max() - 동일속성에 저장된 최소값과 최대값을 검색
-- userTbl에서 키가 가장 작은 사람 
SELECT min(height) FROM userTbl;
--  userTbl에서 키가 가장 큰 사람
SELECT max(height) FROM userTbl;

-- usesrTBL에서 키가 가장 작은 사람과 키가 가장 큰사람의 이름과 키 검색
SELECT name, height FROM userTbl
WHERE height = (SELECT min(height) FROM userTBL)
	OR 
	  height = (SELECT max(height) FROM userTBL);

SELECT name, height FROM userTbl
WHERE height IN(
				(SELECT min(height) FROM userTBL),
				(SELECT max(height) FROM userTBL)
                );
            
-- buyTbl에 등록된상품 들중에 가장 가격이 낮은상품과
-- 가장 가격이 높은 상품의 이름(prodName)과 가격(price) 검색

SELECT prodname, price FROM buyTbL
WHERE price IN(
				(SELECT min(price) FROM buyTBL),
				(SELECT max(price) FROM buyTBL)
                ) GROUP BY prodName;
                

-- 전체 판매 금액
SELECT sum( price * amount ) FROM buyTbl;

-- 그룹별 판매 금액
SELECT groupName, sum( price * amount ) FROM buyTbl
group by groupName;

-- avg(열이름) 평균
-- sum(열이름) / count(열이름)
select avg(height) FROM userTbl;

-- 지역별 평균키 - 역순으로 출력
SELECT addr, avg(height) AS '평균키' FROM userTbl
group by addr ORDER BY 평균키 DESC;

-- 실수값을 소수점 첫째자리에서 반올림 ROUND()
SELECT addr,ROUND(avg(height)) AS '키' FROM userTBL
group by addr;

-- CEIL() 올림
SELECT CEIL(192.166); -- FROM DUAL 생략되어있음
-- FLOOR() 내림
SELECT FLOOR(192.166);

-- WITH ROLLUP
-- 그룹별로 합계를 구할때 사용 GROUP BY
-- 항목별 합계에 항목별 합계가 아니라 항목별 합계와 전체합계를 검색해주는 키워드
SELECT addr, ROUND(avg(height)) AS'평균키' FROM userTbl
GROUP BY addr with rollup; 
SELECT ROUND(avg(height)) AS'평균키' FROM userTbl;

-- 그룹별 총 판매 금액/ 상품별 총 판매 금액 검색 /전체 판매금액을 계산
-- 그룹 이름, 상품 이름 , 판매 금액 검색
SELECT prodName, sum(price * amount) FROM buyTbl
group by prodName;

SELECT groupName, prodName, sum(price * amount) FROM buytBl
GROUP BY groupName, prodName
WITH ROLLUP -- 그룹화된 내용의 총 합계를 구해줌
ORDER BY groupName DESC, prodName DESC;

/*********************************************************************/
-- 임시 테이블을 생성하여 기존 테이블의 정보를 가져와서 저장
DESC userTbl;
-- userID, name, mDate

CREATE TABLE temp_user_tbl(
 userID char(8) primary key,
 name varchar(10) NOT NULL,
 mDate date
);

-- INSERT INTO table명(컬럼 명) values(열값,열값);
INSERT INTO temp_user_tbl
SELECT userID, name, mDate FROM userTbl;

SELECT * FROM temp_user_tbl;

-- buyTbl 구조를 복사하여 테이블 생성하고 SELECT 문에서 검색된
-- 구조와 데이터를 저장 , but key는 없음
CREATE TABLE buytbl2(
	SELECT * FROM buytbl
); 

DESC buytbl2;
SELECT * FROM buytbl2;

CREATE TABLE buytbl3(
 SELECT userID FROM buytbl
);
DESC buytbl3;
SELECT * FROM buytbl3;

-- 데이터는 백업하지 않고 구조만 일치하는 새로운 테이블 생성
CREATE TABLE buytbl4(
	SELECT * FROM buytbl WHERE 1= 0
);
DESC buytbl4;
SELECT * FROM buytbl4;

-- GROUP BY HAVING
-- 주문횟수가 3번 이상인 회원의 id, 주문횟수 정보 검색
SELECT * FROM buytbl;
SELECT userid, count(*) AS '구매횟수' FROM buytbl
GROUP BY userid HAVING 구매횟수 >=3;

SELECT userid,count(*) AS '구매횟수' FROM buytbl
GROUP BY userid HAVING 구매횟수 >=3;

-- JYP가 구매한 구매금액 검색
SELECT SUM(price*amount) FROM buytbl where userid='JYP';
-- 구매금액이 JYP보다 크거나 같은 회원 정보 ID, 구매금액 검색
SELECT userid, SUM(price*amount) AS '돈' FROM buytbl
group by userid having 돈>=200;
                                              
SELECT userid, SUM(price*amount) AS '돈' FROM buytbl
group by userid having 돈>=(
SELECT SUM(price*amount) FROM buytbl where userid='JYP'
);

-- DML - 데이터 조작어
-- SELECT(검색),INSERT INTO(삽입), UPDATE(수정), DELETE(삭제)
-- INSERT INTO table명 VALUES(컬럼명,...);
DESC buytbl4;
SELECT count(*) FROM buytbl4;

INSERT INTO buytbl4 VALUES(1,'PJS','RT3080','전자',1000,1);
SELECT * FROM buytbl4;
INSERT INTO buytbl4(num,userID,prodName,price,amount)
VALUES(2,'HOH','청소기','1500',2);
commit;
rollback;

-- 수정 UPDATE
-- UPDATE table명 SET 수정할 열이름 = 수정할 값, 수정할 열 이름 = 수정할 값 ...
-- WHERE 조건을 비교할 속성이름 = 비교할 값;
-- buyTbl4 table에 num2번인 행의 정보를
-- groupName = 전자 로 수정
UPDATE buytbl4 SET groupName = '전기'
WHERE num =2;
commit;
rollback;

SELECT * FROM buytbl2;

-- buytbl2의 모니터 가격을 250으로 변경
UPDATE buytbl2 SET price = 250 
WHERE prodName = '모니터';

-- buytb12의 상품 중 청바지의 가격을 60으로 변경하고
-- 판매갯수(amount)를 5로 변경

UPDATE buytbl2 SET price = 60, amount =5
WHERE prodName='청바지';

-- num이 8번인 행의
-- prodName을 면바지로 변경,
-- price를 40으로 변경, amount를 6으로,
-- groupName을 의류로 변경
UPDATE buytbl2 SET prodName='면바지',price=40, amount=6, groupName='의류'
WHERE num=8;

-- 조건절이 없는 update
-- 모든 상품의 가격이 5000인상
UPDATE buytbl2 SET price=price+5;

-- 전자제품의 가격이 10,000 인상
UPDATE buytbl2 SET price=price+10
WHERE groupName='전자';
commit;
-- table에 삽입되어 있는 행의 정보를 삭제 하는 DELETE FROM 
DELETE FROM buytbl2;
SELECT * FROM buytbl2;
rollback;

-- buytbl2에서 userid가 bbk인 정보 삭제
DELETE FROM buytbl2 WHERE userid='bbk';
rollback;
-- TRUNCATE :  table에 모든정보를 비운다.-> 자동커밋되서 rollback해도 안돌아감
TRUNCATE buytbl2;
DESC buytbl2;
INSERT INTO buytbl2(userID,amount)
VALUES('PJS',5);
INSERT INTO buytbl2(userID,amount)
VALUES('CEJ',2);
DELETE FROM buytbl2;	-- 2까지 저장되어있던 정보를 삭제하고 다시 입력하는경우 NUM이 3부터 시작
SELECT * FROM buytbl2; 
TRUNCATE buytbl2;		-- 2까지 저장되어있던 정보를 삭제하고 다시 입력하는경우 NUM이 1부터 시작 -> 완전히 초기화












































