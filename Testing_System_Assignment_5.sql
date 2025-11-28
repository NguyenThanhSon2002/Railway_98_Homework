DROP DATABASE IF EXISTS Testing_System_Assignment_5;

CREATE DATABASE IF NOT EXISTS Testing_System_Assignment_5;

USE Testing_System_Assignment_5;

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
    Email VARCHAR(50) NOT NULL UNIQUE KEY,
    Username VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName VARCHAR(50) NOT NULL,
    DepartmentID TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID),
    PositionID TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (PositionID) REFERENCES `Position` (PositionID),
    CreateDate DATETIME NOT NULL DEFAULT NOW()
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
                        
-- Câu 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
SELECT * FROM `Account`;
SELECT * FROM Department;  

CREATE OR REPLACE VIEW vw_Member_Department AS
SELECT a.*, d.DepartmentName FROM `Account` a
INNER JOIN Department d ON a.DepartmentID = d.DepartmentID
WHERE d.DepartmentID = 2;                     
SELECT * FROM vw_Member_Department;
DROP VIEW vw_Member_Department; 
                      
-- Câu 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất

SELECT * FROM `Account`;
SELECT * FROM GroupAccount;

CREATE OR REPLACE VIEW vw_GroupAccount AS
WITH cte_MAX_GROUP_JOIN AS (
	SELECT COUNT(*) AS GROUP_JOIN FROM GroupAccount ga GROUP BY ga.AccountID
)
SELECT ga.AccountID, a.FullName, COUNT(*) AS GROUP_JOIN FROM GroupAccount ga
INNER JOIN `Account` a ON a.AccountID = ga.AccountID
GROUP BY ga.AccountID
HAVING COUNT(*) = (SELECT MAX(GROUP_JOIN) FROM cte_MAX_GROUP_JOIN);

SELECT * FROM vw_GroupAccount;
DROP VIEW vw_GroupAccount;

-- Câu 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
SELECT * FROM Question;
CREATE OR REPLACE VIEW vw_LengthContent AS
SELECT Content, LENGTH(Content) AS LengthContent FROM Question WHERE LENGTH(Content) > 10; 
SELECT * FROM vw_LengthContent;
DROP VIEW vw_LengthContent;

-- Câu 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

SELECT * FROM Department;  
SELECT * FROM `Account`;

CREATE OR REPLACE VIEW vw_MAX_Member_Department AS
WITH cte_Member_Department AS (
	SELECT COUNT(*) AS Member_Department FROM `Account` a1 GROUP BY a1.DepartmentID
)
SELECT d.DepartmentName, a.*, COUNT(*) FROM Department d
INNER JOIN `Account` a ON d.DepartmentID = a.DepartmentID
GROUP BY a.DepartmentID
HAVING COUNT(*) = (SELECT MAX(Member_Department) FROM cte_Member_Department);     
                
SELECT * FROM vw_MAX_Member_Department;
DROP VIEW vw_MAX_Member_Department;

-- Câu 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
SELECT * FROM `Account`;
SELECT * FROM Question;

CREATE OR REPLACE VIEW vw_CreatorQuestion AS
SELECT q.QuestionID, q.Content, a.Username, a.FullName AS CreatorQuestion FROM Question q
INNER JOIN `Account` a ON q.CreatorID = a.AccountID
WHERE a.Username LIKE 'Nguyen%';
SELECT * FROM vw_CreatorQuestion;
DROP VIEW vw_CreatorQuestion;








                        
                        