use bigdata_test;

SELECT * FROM emp ;

INSERT INTO emp
VALUES('8000','MASTER','SALESMAN',7839,'1982-06-07',1200,500,40);

UPDATE emp SET comm=600 WHERE empno=7566; 

DELETE FROM emp WHERE empno=8000; 

SELECT @@autocommit;
set autocommit = 0; -- FALSE
DELETE FROM emp;
rollback;

SELECT deptno, COUNT(*) AS '부서별인원'  FROM emp
GROUP BY deptno with rollup;

use mysql;
CREATE USER testUser@'localhost' IDENTIFIED BY '12345';
SELECT * FROM mysql.USER WHERE user = 'testUser';
GRANT SELECT,UPDATE,INSERT,DELETE ON bigdata_test.* TO testUser@'localhost';
SHOW GRANTS FOR testUser@'localhost';
COMMIT;

SELECT e.empno,e.ename,d.dname 
FROM emp e , dept d
WHERE sal >=2000; 

delimiter //
create procedure test3_1()
BEGIN
	select empno, ename, dname
    From emp ,dept
    where emp.deptno= dept.deptno and emp.sal>=2000
    order by emp.deptno asc;
END//
delimiter ;

delimiter //
create procedure test3_1()
BEGIN
	select empno, ename, dname
    From emp e NATURAL JOIN dept d
    where e.sal>=2000
    order by e.deptno asc;
END//
delimiter ;

CALL test3_1();


DELIMITER //
	CREATE PROCEDURE test3(IN x INT,IN y INT)
	BEGIN
		UPDATE emp SET deptno = y WHERE empno = x;
	END //
DELIMITER ;
	
CALL test3(7369,10);
SELECT * FROM emp WHERE empno=7369;

CREATE TABLE back_up_emp(
	SELECT * FROM emp WHERE 1 = 0
); -- LIKE emp;

SELECT * FROM back_up_emp;

delimiter $$
	create trigger back_up_emp
    after delete
    on emp
    FOR EACH ROW
BEGIN
    INSERT INTO back_up_emp
    VALUES (OLD.empno, OLD.ename, OLD.job, OLD.mgr, OLD.hiredate, OLD.sal, OLD.comm, OLD.deptno);
END $$
delimiter ;

DELETE FROM emp WHERE empno = 7369;
SELECT * FROM back_up_emp;
SELECT * FROM emp;

CREATE UNIQUE INDEX index_emp_ename ON emp (ename);
ALTER TABLE emp ADD INDEX idx_emp_ename(ename);

SHOW INDEXES FROM emp;

DROP INDEX index_emp_ename ON emp;
ALTER TABLE bigdata_test.emp DROP INDEX idx_emp_ename;
