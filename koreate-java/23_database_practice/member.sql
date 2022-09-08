use bigdata;

CREATE TABLE tbl_member(
	mNum INT PRIMARY KEY auto_increment,
	mName VARCHAR(50),
	mId VARCHAR(20) NOT NULL UNIQUE,
	mPw VARCHAR(30) NOT NULL,
	reg BIGINT DEFAULT 0
);

INSERT INTO tbl_member(mName,mId,mPw)
VALUES('관리자','root','root');

SELECT * FROM tbl_member;

commit;

-- Like는 key도 가져온다
CREATE TABLE back_up_member LIKE tbl_member;
DESC back_up_member;
ALTER TABLE back_up_member ADD COLUMN deleteDate TIMESTAMP DEFAULT now();

// 회원관리번호
private int mNum;
// 회원 이름
private String mName;
// 회원 아이디
private String mId;
// 회원 비밀번호
private String mPw;
//회원가입일
private long reg;


DROP TRIGGER IF EXISTS back_up_memberTrg;
DELIMITER //
CREATE TRIGGER back_up_memberTrg
	AFTER DELETE
    ON tbl_member
    FOR EACH ROW
BEGIN
	INSERT INTO back_up_member VALUES( 
    OLD.mNum, OLD.mName, OLD.mId, OLD.mPw, OLD.reg, DEFAULT);
END //
DELIMITER ;

SELECT * FROM tbl_member;



