DROP DATABASE IF EXISTS Testing_System_Assignment_6;

CREATE DATABASE IF NOT EXISTS Testing_System_Assignment_6;

USE Testing_System_Assignment_6;

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
    CreatorID TINYINT UNSIGNED UNIQUE KEY,
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

-- Câu 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
-- account thuộc phòng ban đó
SELECT * FROM `Account`;
SELECT * FROM Department;

DROP PROCEDURE IF EXISTS sp_InsertAccount;
DELIMITER $$
CREATE PROCEDURE sp_InsertAccount(IN in_DepartmentID TINYINT) 
	BEGIN
		SELECT a.*, d.DepartmentName FROM `Account` a
        INNER JOIN Department d ON a.DepartmentID = d.DepartmentID
        WHERE d.DepartmentID = in_DepartmentID;
	END$$
DELIMITER ;
CALL sp_InsertAccount (5);

-- Câu 2: Tạo store để in ra số lượng account trong mỗi group
SELECT * FROM `Account`;
SELECT * FROM GroupAccount;

DROP PROCEDURE IF EXISTS sp_MemberOfGroup;
DELIMITER $$
CREATE PROCEDURE sp_MemberOfGroup() 
	BEGIN
		SELECT ga.GroupID, COUNT(*) AS MemberOfGroup FROM GroupAccount ga
        INNER JOIN `Account` a ON ga.AccountID = a.AccountID
        GROUP BY ga.GroupID;
	END$$
DELIMITER ;

CALL sp_MemberOfGroup;

-- Câu 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
SELECT * FROM Question;
SELECT * FROM TypeQuestion;

DROP PROCEDURE IF EXISTS sp_CreateQuestionInMonth;
DELIMITER $$
CREATE PROCEDURE sp_CreateQuestionInMonth() 
	BEGIN
		SELECT tq.TypeID, tq.TypeName, q.CreateDate, COUNT(*) FROM TypeQuestion tq
		INNER JOIN Question q ON tq.TypeID = q.TypeID
        WHERE month(q.CreateDate) = month(now()) AND year(q.CreateDate) = year(now())
		GROUP BY TypeID;
	END$$
DELIMITER ;
CALL sp_CreateQuestionInMonth;

-- Câu 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
SELECT * FROM TypeQuestion;
SELECT * FROM Question;

DROP PROCEDURE IF EXISTS sp_Max_Type_Question;
DELIMITER $$
CREATE PROCEDURE sp_Max_Type_Question() 
	BEGIN
		WITH cte_Max_Type_Question AS (
			SELECT COUNT(*) AS Max_Type_Question FROM Question GROUP BY TypeID
		)
		SELECT q.TypeID, tq.TypeName, COUNT(*) AS Number_Question FROM Question q
		INNER JOIN TypeQuestion tq ON q.TypeID = tq.TypeID
		GROUP BY TypeID
		HAVING COUNT(*) = (SELECT MAX(Max_Type_Question) FROM cte_Max_Type_Question);
	END$$
DELIMITER ;

CALL sp_Max_Type_Question;

-- Câu 5: Sử dụng store ở question 4 để tìm ra tên của type question
SELECT * FROM TypeQuestion;
SELECT * FROM Question;

DROP PROCEDURE IF EXISTS sp_Max_Type_Question;
DELIMITER $$
CREATE PROCEDURE sp_Max_Type_Question() 
	BEGIN
		WITH cte_Max_Type_Question AS (
			SELECT COUNT(*) AS Max_Type_Question FROM Question GROUP BY TypeID
		)
		SELECT q.TypeID, tq.TypeName, COUNT(*) AS Number_Question FROM Question q
		INNER JOIN TypeQuestion tq ON q.TypeID = tq.TypeID
		GROUP BY TypeID
		HAVING COUNT(*) = (SELECT MAX(Max_Type_Question) FROM cte_Max_Type_Question);
	END$$
DELIMITER ;

CALL sp_Max_Type_Question;

-- Câu 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
-- chuỗi của người dùng nhập vào
SELECT * FROM `Group`;
SELECT * FROM `Account`;

DROP PROCEDURE IF EXISTS sp_Insert_String_data;
DELIMITER $$
CREATE PROCEDURE sp_Insert_String_data(IN in_string_data VARCHAR(50)) 
	BEGIN
		SELECT g.GroupName FROM `group` g WHERE g.GroupName LIKE CONCAT("%",in_string_data,"%")
		UNION
		SELECT a.Username FROM `account` a WHERE a.Username LIKE CONCAT("%",in_string_data,"%");
	END$$
DELIMITER ;

CALL sp_Insert_String_data('n');

-- Câu 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
-- trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công
SELECT * FROM `Account`;

DROP PROCEDURE IF EXISTS sp_Insert_data;
DELIMITER $$
CREATE PROCEDURE sp_Insert_data(IN in_FullName_data VARCHAR(50), IN in_Email_data VARCHAR(50)) 
	BEGIN
		DECLARE v_Username VARCHAR(50) DEFAULT SUBSTRING_INDEX(in_Email_data,'@',1);
		DECLARE v_PositionID VARCHAR(50) DEFAULT 'Developer';
        DECLARE v_DepartmentID TINYINT UNSIGNED DEFAULT 11;
        DECLARE v_CreateDate DATETIME DEFAULT NOW();
        INSERT INTO Department(DepartmentID, DepartmentName)
        VALUES				  (11, 'WaitingRoom');	
        INSERT INTO `Account` (Email, Username, FullName, DepartmentID, PositionID, CreateDate)
        VALUES				  (in_Email_data,v_Username,in_FullName_data,v_DepartmentID,v_PositionID,v_CreateDate); 	 
	END$$
DELIMITER ;

CALL sp_Insert_data('Nguyen Thanh Son','nguyenthanhson@gmail.com');

-- Câu 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
SELECT * FROM Question;
SELECT * FROM TypeQuestion;

DROP PROCEDURE IF EXISTS sp_Insert_TypeQuestion;
DELIMITER $$
CREATE PROCEDURE sp_Insert_TypeQuestion(IN in_TypeQuestion ENUM('Essay', 'Multiple-Choice')) 
	BEGIN
		WITH cte_Length_Content AS (
			SELECT LENGTH(q.Content) AS Length_Content FROM Question q 	
        )
		SELECT tq.TypeID, tq.TypeName, LENGTH(q.Content) FROM TypeQuestion tq
        INNER JOIN Question q ON tq.TypeID = q.TypeID
        WHERE LENGTH(q.Content) = (SELECT MAX(Length_Content) FROM cte_Length_Content);
 	END$$
DELIMITER ;

CALL sp_Insert_TypeQuestion('Essay');

-- Câu 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
SELECT * FROM Exam;

DROP PROCEDURE IF EXISTS sp_Delete_Exam;
DELIMITER $$
CREATE PROCEDURE sp_Delete_Exam(IN in_Delete_ExamID TINYINT) 
	BEGIN
		DELETE FROM Exam 
        WHERE ExamID = in_Delete_ExamID;
 	END$$
DELIMITER ;

CALL sp_Delete_Exam(1);

-- Câu 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
-- dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi
-- removing
SELECT * FROM Exam;

DROP PROCEDURE IF EXISTS sp_Delete_Exam;
DELIMITER $$
CREATE PROCEDURE sp_Delete_Exam() 
	BEGIN
		DELETE FROM Exam e
        WHERE year(NOW()) - year(e.CreateDate) = 5;
 	END$$
DELIMITER ;

CALL sp_Delete_Exam();







-- Mở rộng: Tìm ra TypeQuestion đưa vào 1 ngày nào đó, sau khi có KQ => đầu ra: ID của TypeQuestion và số lượng câu hỏi (out)
SELECT * FROM TypeQuestion;
SELECT * FROM Question;

DROP PROCEDURE IF EXISTS sp_Date_Create_Question;
DELIMITER $$
CREATE PROCEDURE sp_Date_Create_Question(IN in_Date_Create_Question DATETIME, OUT out_NumberOfQuestion INT) 
	BEGIN
		SELECT tq.TypeID, tq.TypeName, q.Content, q.CreateDate FROM TypeQuestion tq
        INNER JOIN Question q ON tq.TypeID = q.TypeID
        WHERE CreateDate = in_Date_Create_Question;
        SELECT tq.TypeID, tq.TypeName, q.CreateDate, COUNT(*) AS out_NumberOfQuestion FROM TypeQuestion tq
		INNER JOIN Question q ON tq.TypeID = q.TypeID
		GROUP BY TypeID
		HAVING CreateDate = out_NumberOfQuestion;
	END$$
DELIMITER ;
SET @v_NumberOfQuestion = '';
CALL sp_Date_Create_Question('2025-11-28 23:42:23',@v_NumberOfQuestion);

SELECT tq.TypeID, tq.TypeName, q.CreateDate, COUNT(*)  FROM TypeQuestion tq
INNER JOIN Question q ON tq.TypeID = q.TypeID
GROUP BY TypeID
HAVING CreateDate = '2025-11-28 23:42:23';



