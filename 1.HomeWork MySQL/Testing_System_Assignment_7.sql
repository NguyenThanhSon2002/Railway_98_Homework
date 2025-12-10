DROP DATABASE IF EXISTS Testing_System_Assignment_7;

CREATE DATABASE IF NOT EXISTS Testing_System_Assignment_7;

USE Testing_System_Assignment_7;

-- Table 1:Department 
DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
    DepartmentID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName VARCHAR(50) NOT NULL UNIQUE KEY
);

INSERT INTO Department(DepartmentID, DepartmentName) 
VALUES				  
						(1, 'Marketing'),
                        (2, 'Sale'),
                        (3, 'Bảo vệ'),
                        (4, 'Nhân sự'),
                        (5, 'Kỹ thuật'),
                        (6, 'Tài chính'),
                        (7, 'Phó giám đốc'),
                        (8, 'Giám đốc'),
                        (9, 'Thư kí'),
                        (10, 'Bán hàng');
                        
-- Table 2: Position
DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position` (
    PositionID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName ENUM('Dev', 'Test', 'Scrum Master', 'PM') NOT NULL
);

INSERT INTO `Position` (PositionName) 
VALUES				  
						('Dev'),
                        ('Test'),
                        ('Scrum Master'),
                        ('PM');

-- Table 3: Account 
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account` (
    AccountID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(50) UNIQUE KEY,
    Username VARCHAR(50) UNIQUE KEY,
    FullName VARCHAR(50),
    DepartmentID TINYINT UNSIGNED,
    FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID),
    PositionID TINYINT UNSIGNED,
    FOREIGN KEY (PositionID) REFERENCES `Position` (PositionID),
    CreateDate DATETIME DEFAULT NOW()
);

INSERT INTO `Account` (Email,Username,FullName,DepartmentID,PositionID) 
VALUES				  
					  ('nguyenvana01@gmail.com','NguyenVanA01','Nguyen Van A',1,1),
					  ('nguyenvanb02@gmail.com','NguyenVanB02','Nguyen Van B',2,2),
					  ('nguyenvanc03@gmail.com','NguyenVanC03','Nguyen Van C',3,3),
					  ('nguyenvand04@gmail.com','NguyenVanD04','Nguyen Van D',4,4),
                      ('nguyenvane05@gmail.com','NguyenVanE05','Nguyen Van E',5,4),
                      ('nguyenvanf06@gmail.com','NguyenVanF06','Nguyen Van F',6,3),
                      ('nguyenvang07@gmail.com','NguyenVanG07','Nguyen Van G',7,2),
                      ('nguyenvanh08@gmail.com','NguyenVanH08','Nguyen Van H',8,1),
                      ('nguyenvani09@gmail.com','NguyenVanI09','Nguyen Van I',9,1),
                      ('nguyenvank010@gmail.com','NguyenVanK10','Nguyen Van K',10,2);

-- Table 4: Group  
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group` (
    GroupID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName VARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID TINYINT UNSIGNED,
    FOREIGN KEY(CreatorID) 	REFERENCES `Account`(AccountId),
    CreateDate DATETIME NOT NULL DEFAULT NOW()
);

INSERT INTO `Group`(GroupName, CreatorID) 
VALUES				  
						('MarketingDepartment', 1),
                        ('SaleDepartment', 2),
                        ('SecurityDepartment', 3),
                        ('HumanResourcesDepartment', 4),
                        ('ITDepartment', 5),
                        ('FinanceDepartment', 6),
                        ('DeputyDirectorDepartment', 7),
                        ('DirectorDepartment', 8),
                        ('SecretarygDepartment', 9),
                        ('SellDepartment', 10);

-- Table 5: GroupAccount
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount (
    GroupID TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID),
    AccountID TINYINT UNSIGNED NOT NULL,
    PRIMARY KEY (GroupID,AccountID),
    JoinDate DATETIME NOT NULL DEFAULT NOW()
);

INSERT INTO GroupAccount(GroupID, AccountID) 
VALUES				  
						(1, 1),
                        (2, 1),
                        (3, 2),
                        (4, 3),
                        (5, 4),
                        (6, 5),
                        (7, 6),
                        (8, 7),
                        (9, 8),
                        (10, 9);

-- Table 6: TypeQuestion
DROP TABLE IF EXISTS TypeQuestion;  
CREATE TABLE TypeQuestion (
    TypeID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName ENUM('Essay', 'Multiple-Choice') NOT NULL UNIQUE KEY
);

INSERT INTO TypeQuestion(TypeID, TypeName) 
VALUES				  
						(1, 'Essay'),
                        (2, 'Multiple-Choice');

-- Table 7: CategoryQuestion 
DROP TABLE IF EXISTS CategoryQuestion; 
CREATE TABLE CategoryQuestion (
    CategoryID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName VARCHAR(50) NOT NULL UNIQUE KEY
);

INSERT INTO CategoryQuestion(CategoryName) 
VALUES				  
						('Java'),
						('ASP.NET'),
						('ADO.NET'),
						('SQL'),
						('Postman'),
						('Ruby'),
						('Python'),
						('C++'),
						('C Sharp'),
						('PHP');

-- Table 8: Question 
DROP TABLE IF EXISTS Question; 
CREATE TABLE Question (
    QuestionID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content VARCHAR(50) NOT NULL,
    CategoryID TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
    TypeID TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (TypeID) REFERENCES TypeQuestion (TypeID),
    CreatorID TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(CreatorID) 	REFERENCES `Account`(AccountId),
    CreateDate DATETIME NOT NULL DEFAULT NOW()
);

INSERT INTO Question	(Content, CategoryID, TypeID, CreatorID)
VALUES 					('Câu hỏi về Java', 1, 1, 1),
						('Câu Hỏi về PHP', 10, 2, 2),
						('Hỏi về C#', 9, 2, 3),
						('Hỏi về Ruby', 6, 1, 4),
						('Hỏi về Postman', 5, 1, 5),
						('Hỏi về ADO.NET', 3, 2, 6),
						('Hỏi về ASP.NET', 2, 1, 7),
						('Hỏi về C++', 8, 1, 8),
						('Hỏi về SQL', 4, 2, 9),
						('Hỏi về Python', 7, 1, 10);

-- Table 9: Answer
DROP TABLE IF EXISTS Answer;   
CREATE TABLE Answer (
    AnswerID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content VARCHAR(50) NOT NULL,
    QuestionID TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID),
    isCorrect BIT NOT NULL 
);

INSERT INTO Answer	(Content, QuestionID, isCorrect	)
VALUES 				('Trả lời 01', 1, 0),
					('Trả lời 02', 1, 1),
                    ('Trả lời 03', 1, 0),
                    ('Trả lời 04', 1, 1),
                    ('Trả lời 05', 2, 1),
                    ('Trả lời 06', 3, 1),
                    ('Trả lời 07', 4, 0),
                    ('Trả lời 08', 8, 0),
                    ('Trả lời 09', 9, 1),
                    ('Trả lời 10', 10, 1);

-- Table 10: Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam (
    ExamID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code` VARCHAR(10) NOT NULL UNIQUE KEY,
    Title VARCHAR(50) NOT NULL UNIQUE KEY,
    CategoryID TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
    Duration TINYINT NOT NULL,
    CreatorID TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (CreatorID) REFERENCES Question (CreatorID),
    CreateDate DATETIME NOT NULL
);

INSERT INTO Exam	(`Code`			, Title					, CategoryID	, Duration	, CreatorID		, CreateDate )
VALUES 				('VTIQ001'		, N'Đề thi C#'			,	1			,	60		,   '5'			,'2019-04-05'),
					('VTIQ002'		, N'Đề thi PHP'			,	10			,	60		,   '2'			,'2019-04-05'),
                    ('VTIQ003'		, N'Đề thi C++'			,	9			,	120		,   '2'			,'2019-04-07'),
                    ('VTIQ004'		, N'Đề thi Java'		,	6			,	60		,   '3'			,'2020-04-08'),
                    ('VTIQ005'		, N'Đề thi Ruby'		,	5			,	120		,   '4'			,'2020-04-10'),
                    ('VTIQ006'		, N'Đề thi Postman'		,	3			,	60		,   '6'			,'2020-04-05'),
                    ('VTIQ007'		, N'Đề thi SQL'			,	2			,	60		,   '7'			,'2020-04-05'),
                    ('VTIQ008'		, N'Đề thi Python'		,	8			,	60		,   '8'			,'2020-04-07'),
                    ('VTIQ009'		, N'Đề thi ADO.NET'		,	4			,	90		,   '9'			,'2020-04-07'),
                    ('VTIQ010'		, N'Đề thi ASP.NET'		,	7			,	90		,   '10'		,'2020-04-08');

-- Table 11: ExamQuestion
DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion (
    ExamID TINYINT UNSIGNED,
    FOREIGN KEY (ExamID) REFERENCES Exam (ExamID),
    QuestionID TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID),  
    PRIMARY KEY (ExamID, QuestionID)
);

INSERT INTO ExamQuestion(ExamID	, QuestionID	) 
VALUES 					(	1	,		5		),
						(	2	,		10		), 
						(	3	,		4		), 
						(	4	,		3		), 
						(	5	,		7		), 
						(	6	,		10		), 
						(	7	,		2		), 
						(	8	,		10		), 
						(	9	,		9		), 
						(	10	,		8		); 
                        
-- Câu 1: tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước đó 1 năm
SELECT * FROM `Group`;

DROP TRIGGER IF EXISTS Trg_bf_Create_Group;
DELIMITER $$
	CREATE TRIGGER Trg_bf_Create_Group
	BEFORE INSERT ON `Group`
    FOR EACH ROW
    BEGIN
		-- trigger không cho phép người dùng nhập vào Group có ngày tạo trước đó 1 năm
		DECLARE v_Create_Date DATETIME;
		SET v_Create_Date = DATE_SUB(NOW(), INTERVAL 1 YEAR); -- DATE_SUB: lấy ra khoảng thời gian mà trước hoặc sau tham số thứ nhất một khoảng nào đó, tham số dương là chỉ quá khứ, âm là chỉ tương lai
        IF (v_Create_Date >= NEW.CreateDate) THEN
			-- Dừng chương trình
            SIGNAL SQLSTATE '12345'
            -- Thông báo 
            SET MESSAGE_TEXT = 'Cant join group';
		END IF;
    END$$
DELIMITER ;
SHOW TRIGGERS;
INSERT INTO `Group` (`GroupID`, `GroupName`, `CreatorID`, `CreateDate`) 
VALUES 				('11', 'Sale01', '9', '2025-11-29 21:45:03');


-- Câu 3: Cấu hình 1 group có nhiều nhất là 5 user
SELECT * FROM GroupAccount;

DROP TRIGGER IF EXISTS Trg_bf_Insert_GroupAccount;
DELIMITER $$
	CREATE TRIGGER Trg_bf_Insert_GroupAccount
	BEFORE INSERT ON GroupAccount
    FOR EACH ROW
    BEGIN
		-- Đếm số lượng AccountID có trong GroupAccount hiện tại 
        DECLARE v_count_AccountID SMALLINT DEFAULT 0; 
        SELECT COUNT(*) INTO v_count_AccountID FROM GroupAccount WHERE GroupID = NEW.GroupID;
		IF(v_count_AccountID > 5) THEN 
			-- Dừng chương trình
            SIGNAL SQLSTATE '12345'
            -- Thông báo 
            SET MESSAGE_TEXT = 'Cant add more Account';
		END IF;
    END$$
DELIMITER ;
SHOW TRIGGERS;
INSERT INTO GroupAccount (`GroupID`, `AccountID`, `JoinDate`) 
VALUES 					  ('3', '5', '2025-11-29 21:45:04');

DROP TRIGGER IF EXISTS Trg_bf_Join_GroupAccount;

-- Câu 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
SELECT * FROM ExamQuestion;

DROP TRIGGER IF EXISTS Trg_bf_Insert_Question;
DELIMITER $$
	CREATE TRIGGER Trg_bf_Insert_Question
	BEFORE INSERT ON ExamQuestion
    FOR EACH ROW
    BEGIN
		-- Đếm số lượng Question có trong ExamQuestion hiện tại 
        DECLARE v_count_QuestionID SMALLINT DEFAULT 0; 
        SELECT COUNT(*) INTO v_count_QuestionID FROM ExamQuestion WHERE ExamID = NEW.ExamID;
		IF(v_count_QuestionID > 3) THEN 
			-- Dừng chương trình
            SIGNAL SQLSTATE '12345'
            -- Thông báo 
            SET MESSAGE_TEXT = 'Cant add more Question';
		END IF;
    END$$
DELIMITER ;
SHOW TRIGGERS;

INSERT INTO ExamQuestion (`ExamID`, `QuestionID`) 
VALUES 					 ('3', '3'),
						 ('3', '5');

INSERT INTO ExamQuestion (`ExamID`, `QuestionID`) 
VALUES 					 ('3', '6');
						
-- Câu 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
-- admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
-- tin liên quan tới user đó
SELECT * FROM `Account`;

UPDATE `Account` SET Email = 'admin@gmail.com' WHERE AccountID = 10;

DROP TRIGGER IF EXISTS Trg_bf_Delete_Account;
DELIMITER $$
	CREATE TRIGGER Trg_bf_Delete_Account
	BEFORE DELETE ON `Account`
    FOR EACH ROW
    BEGIN
		-- trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com
        DECLARE v_Delete_Email VARCHAR(50); 
        DELETE FROM `Account` WHERE OLD.Email = v_Delete_Email;
		IF(v_Delete_Email = 'admin@gmail.com') THEN 
			-- Dừng chương trình
            SIGNAL SQLSTATE '12345'
            -- Thông báo 
            SET MESSAGE_TEXT = 'Cant delete admin email';
		END IF;
    END$$
DELIMITER ;
SHOW TRIGGERS;

DELETE FROM `Account` WHERE Email = 'admin@gmail.com';

-- Câu 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
SELECT * FROM `Account`;
SELECT * FROM Department;
-- INSERT INTO Department (DepartmentID,DepartmentName)
-- VALUES 				   (11, 'waiting Department');

INSERT INTO `Account` (`Email`, `Username`, `FullName`, `PositionID`, `CreateDate`) 
VALUES 				  ('nguyenthanhson@gmail.com', 'NguyenThanhSon11', 'Nguyen Thanh Son', '3', '2025-12-02 20:43:33');


DROP TRIGGER IF EXISTS Trg_bf_Insert_DepartmentID;
DELIMITER $$
	CREATE TRIGGER Trg_bf_Insert_DepartmentID
	BEFORE INSERT ON `Account`
    FOR EACH ROW
    BEGIN
		DECLARE v_DepartmentID TINYINT DEFAULT 0;
		SELECT DepartmentID INTO v_DepartmentID FROM Department WHERE DepartmentName = 'waiting Department';
        IF(v_DepartmentID = '0') THEN 
			-- Dừng chương trình
            SIGNAL SQLSTATE '12345'
            -- Thông báo 
            SET MESSAGE_TEXT = 'waiting Department dosent exist';
		END IF;
		IF (NEW.DepartmentID IS NULL) THEN
		 	SET NEW.DepartmentID = v_DepartmentID;
		END IF;
    END$$
DELIMITER ;
SHOW TRIGGERS;

-- câu 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
SELECT * FROM Exam;

DROP TRIGGER IF EXISTS Trg_bf_Delete_Exam;
DELIMITER $$
	CREATE TRIGGER Trg_bf_Delete_Exam
	BEFORE DELETE ON Exam
    FOR EACH ROW
    BEGIN
		DECLARE v_Exam_Create_Date DATETIME;
		SET v_Exam_Create_Date = DATEDIFF(NOW(), OLD.CreateDate);
		IF (v_Exam_Create_Date <= 2) THEN
			-- Dừng chương trình
            SIGNAL SQLSTATE '12345'
            -- Thông báo 
            SET MESSAGE_TEXT = 'Cannt delete this exam';
		END IF;
    END$$
DELIMITER ;
SHOW TRIGGERS;

DELETE FROM Exam WHERE CreateDate = '2025-12-02 00:00:00';








                        