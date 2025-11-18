DROP DATABASE IF EXISTS Testing_System_Assignment_2;

CREATE DATABASE IF NOT EXISTS Testing_System_Assignment_2;

USE Testing_System_Assignment_2;

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
    GroupID TINYINT UNSIGNED PRIMARY KEY,
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID),
    AccountID TINYINT UNSIGNED UNIQUE KEY,
    JoinDate DATETIME NOT NULL DEFAULT NOW()
);

INSERT INTO GroupAccount(GroupID, AccountID) 
VALUES				  
						(1, 110),
                        (2, 111),
                        (3, 112),
                        (4, 113),
                        (5, 114),
                        (6, 115),
                        (7, 116),
                        (8, 117),
                        (9, 118),
                        (10, 119);

-- Table 6: TypeQuestion
DROP TABLE IF EXISTS TypeQuestion;  
CREATE TABLE TypeQuestion (
    TypeID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName ENUM('Essay', 'Multiple-Choice') NOT NULL
);

INSERT INTO TypeQuestion(TypeID, TypeName) 
VALUES				  
						(1, 'Essay'),
                        (2, 'Multiple-Choice');

-- Table 7: CategoryQuestion 
DROP TABLE IF EXISTS CategoryQuestion; 
CREATE TABLE CategoryQuestion (
    CategoryID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName VARCHAR(30) NOT NULL
);

INSERT INTO CategoryQuestion(CategoryName) 
VALUES				  
						('Kinh nghiệm'),
                        ('Chuyên môn'),
                        ('Các kỹ năng liên quan'),
                        ('Học vấn'),
                        ('Thông tin cơ bản'),
                        ('Các kỹ năng khác');

-- Table 8: Question 
DROP TABLE IF EXISTS Question; 
CREATE TABLE Question (
    QuestionID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content VARCHAR(100) NOT NULL UNIQUE KEY,
    CategoryID TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
    TypeID TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreatorID TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreateDate DATETIME NOT NULL DEFAULT NOW()
);

-- Table 9: Answer
DROP TABLE IF EXISTS Answer;   
CREATE TABLE Answer (
    AnswerID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content VARCHAR(100) NOT NULL UNIQUE KEY,
    FOREIGN KEY (Content) REFERENCES Question (Content),
    QuestionID TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID),
    isCorrect BIT NOT NULL 
);

-- Table 10: Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam (
    ExamID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code` TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    Title VARCHAR(50) NOT NULL UNIQUE KEY,
    CategoryID TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
    Duration TINYINT NOT NULL,
    CreatorID TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (CreatorID) REFERENCES Question (CreatorID),
    CreateDate DATETIME NOT NULL DEFAULT NOW()
);

-- Table 11: ExamQuestion
DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion (
    ExamID TINYINT UNSIGNED,
    FOREIGN KEY (ExamID) REFERENCES Exam (ExamID),
    QuestionID TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)    
);