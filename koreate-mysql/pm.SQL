show databases;
show tables;

SELECT * FROM usertbl;
SELECT * FROM testdb.usertbl;

-- κΆν νμ
REVOKE UPDATE, INSERT ON sqldb.* FROM ceo@'%';

