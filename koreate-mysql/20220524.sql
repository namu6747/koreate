use bigdata;
DESC member_tbl;
SELECT * FROM member_tbl; 


DELIMITER //
	CREATE TRIGGER member_trg -- 트리거 이름 지정
    AFTER DELETE
    ON tbl_member
    FOR EACH ROW
    BEGIN
     INSERT INTO back_up_member VALUES(old.mNum,old.mName,old.mId,old.mPw,old.reg,default);
    END //
DELIMITER ;
commit;

