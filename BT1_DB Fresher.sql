-- Tạo database
DROP DATABASE IF EXISTS BT1_DB_Fresher;

CREATE DATABASE BT1_DB_Fresher;

USE BT1_DB_Fresher;

-- Câu 1: tạo TABLE với các ràng buộc và kiểu dữ liệu
-- Tạo bảng Trainee
DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee (
	TraineeID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Full_Name VARCHAR(50) NOT NULL,
    Birth_Date DATE NOT NULL,
    Gender ENUM('MALE', 'FEMALE', 'UNKNOWN') NOT NULL, 
    ET_IQ TINYINT UNSIGNED NOT NULL, 		-- Điểm test đầu vào của thực tập sinh (integer có giá trị từ 0 🡺 20)
    ET_Gmath TINYINT UNSIGNED NOT NULL, 	-- Điểm test đầu vào của thực tập sinh (integer có giá trị từ 0 🡺 20)
    ET_English TINYINT UNSIGNED NOT NULL, 	-- Điểm test đầu vào của thực tập sinh (integer có giá trị từ 0 🡺 50)
	Training_Class VARCHAR(50) NOT NULL,	-- mã lớp của thực tập sinh đang học VD: 'VTI001', 'VTI002',....
    Evaluation_Notes VARCHAR(50) NOT NULL	-- Ghi thông tin trường thực tập sinh đang theo học ví dụ: 'DHBKHN', 'DHQGHN', 'HVBCVT'…
);

-- Câu 2: Thêm ít nhất 10 bản ghi và table
INSERT INTO Trainee (Full_Name, Birth_Date, Gender, ET_IQ, ET_Gmath, ET_English, Training_Class, Evaluation_Notes)
VALUES				('NguyenVanA', '2002-01-01', 'MALE', 10, 10, 30, 'VTI001', 'ĐHCN-ĐHQGHN'),
					('NguyenVanB', '2002-02-02', 'FEMALE', 11, 11, 31, 'VTI002', 'DHBKHN'),
                    ('NguyenVanC', '2002-03-03', 'MALE', 12, 12, 32, 'VTI003', 'ĐHCN-ĐHQGHN'),
                    ('NguyenVanD', '2002-04-04', 'FEMALE', 13, 13, 33, 'VTI004', 'DHBKHN'),
                    ('NguyenVanE', '2002-05-05', 'MALE', 14, 14, 34, 'VTI005', 'ĐHCN-ĐHQGHN'),
                    ('NguyenVanF', '2002-06-06', 'FEMALE', 15, 15, 35, 'VTI006', 'DHBKHN'),
                    ('NguyenVanG', '2002-07-07', 'MALE', 16, 16, 36, 'VTI007', 'DHBKHN'),
                    ('NguyenVanH', '2002-08-08', 'FEMALE', 17, 17, 37, 'VTI008', 'ĐHCN-ĐHQGHN'),
                    ('NguyenVanI', '2002-09-09', 'MALE', 18, 18, 38, 'VTI009', 'DHBKHN'),
                    ('NguyenVanK', '2002-10-10', 'FEMALE', 19, 19, 39, 'VTI0', 'ĐHCN-ĐHQGHN');

-- Câu 3: Insert 1 bản ghi mà có điểm ET_IQ = 30
SELECT * FROM Trainee;
UPDATE Trainee SET ET_IQ = 30 WHERE Full_Name = 'NguyenVanA';

-- Câu 4: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, và sắp xếp theo ngày sinh. Điểm ET_IQ >=12, ET_Gmath>=12, ET_English>=20
SELECT * FROM Trainee;
SELECT TraineeID, Full_Name, Birth_Date, Gender, ET_IQ, ET_Gmath, ET_English FROM Trainee WHERE ET_IQ >= 12 AND ET_Gmath >= 12 AND ET_English >= 20; 

-- Câu 5: Viết lệnh để lấy ra thông tin thực tập sinh có tên bắt đầu bằng chữ N và kết thúc bằng chữ C
SELECT * FROM Trainee;
SELECT TraineeID, Full_Name, Birth_Date, Gender FROM Trainee WHERE Full_Name LIKE 'N%_c';

-- Câu 6: Viết lệnh để lấy ra thông tin thực tập sinh mà tên có ký thự thứ 2 là chữ G
SELECT * FROM Trainee;
-- SELECT TraineeID, Full_Name, Birth_Date, Gender FROM Trainee WHERE Full_Name LIKE ;

-- Câu 7: Viết lệnh để lấy ra thông tin thực tập sinh mà tên có 10 ký tự và ký tự cuối cùng là C
SELECT * FROM Trainee;
SELECT TraineeID, Full_Name, Birth_Date, Gender FROM Trainee WHERE length(Full_Name) = 10 AND Full_Name Like '_%c';

-- Câu 8: Viết lệnh để lấy ra Fullname của các thực tập sinh trong lớp, lọc bỏ các tên trùng nhau.
SELECT * FROM Trainee;
SELECT DISTINCT(Full_Name) FROM Trainee; 

-- Câu 9: Viết lệnh để lấy ra Fullname của các thực tập sinh trong lớp, sắp xếp các tên này theo thứ tự từ A-Z
SELECT * FROM Trainee;
SELECT DISTINCT(Full_Name) FROM Trainee ORDER BY Full_Name ASC; 

-- Câu 10: Viết lệnh để lấy ra thông tin thực tập sinh có tên dài nhất
SELECT * FROM Trainee;
WITH cte_MaxLengthFullName AS (
	SELECT MAX(LENGTH(Full_Name)) AS MaxLengthFullName FROM Trainee
)
SELECT * FROM Trainee WHERE LENGTH(Full_Name) = (SELECT MAX(LENGTH(Full_Name)) AS MaxLengthFullName);

-- Câu 11: Viết lệnh để lấy ra ID, Fullname và Ngày sinh thực tập sinh có tên dài nhất
SELECT * FROM Trainee;
WITH cte_MaxLengthFullName AS (
	SELECT MAX(LENGTH(Full_Name)) AS MaxLengthFullName FROM Trainee
)
SELECT TraineeID, Full_Name, Birth_Date FROM Trainee WHERE LENGTH(Full_Name) = (SELECT MAX(LENGTH(Full_Name)) AS MaxLengthFullName);

-- Câu 12: Viết lệnh để lấy ra Tên, và điểm IQ, Gmath, English thực tập sinh có tên dài nhất
SELECT * FROM Trainee;
WITH cte_MaxLengthFullName AS (
	SELECT MAX(LENGTH(Full_Name)) AS MaxLengthFullName FROM Trainee
)
SELECT Full_Name, ET_IQ, ET_Gmath, ET_English FROM Trainee WHERE LENGTH(Full_Name) = (SELECT MAX(LENGTH(Full_Name)) AS MaxLengthFullName);

-- Câu 13: Lấy ra 5 thực tập sinh có tuổi nhỏ nhất
SELECT * FROM Trainee;
SELECT TraineeID, Full_Name, Birth_Date, Gender FROM Trainee ORDER BY Birth_Date DESC LIMIT 5;

-- Câu 14: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là những người thỏa mãn số điểm như sau:
-- ET_IQ + ET_Gmath>=20
-- ET_IQ>=8
-- ET_Gmath>=8
-- ET_English>=18
SELECT * FROM Trainee;
SELECT * FROM Trainee WHERE ET_IQ + ET_Gmath >= 20 AND ET_IQ > 8 AND ET_Gmath >= 8 AND ET_English >= 18;

-- Câu 15: Xóa thực tập sinh có TraineeID = 5
SELECT * FROM Trainee;
DELETE FROM Trainee WHERE TraineeID = 5;

-- Câu 16: Xóa thực tập sinh có tổng điểm ET_IQ, ET_Gmath <=15
SELECT * FROM Trainee;
DELETE FROM Trainee WHERE ET_IQ <= 15 AND ET_Gmath <=15;

-- Câu 17: Xóa thực tập sinh quá 30 tuổi
SELECT * FROM Trainee;
SELECT YEAR(CURRENT_DATE()) - YEAR(Birth_Date) AS Age FROM Trainee;
DELETE FROM Trainee WHERE Age > 30;

-- Câu 18: Thực tập sinh có TraineeID = 3 được chuyển sang lớp "VTI004". Hãy cập nhật thông tin vào database
SELECT * FROM Trainee;
UPDATE Trainee SET Training_Class = 'VTI004' WHERE TraineeID = 3;  	

-- Câu 19: Do có sự nhầm lẫn khi nhập liệu nên thông tin của học sinh số 10 đang bị sai, 
-- hãy cập nhật lại tên thành “LeVanA”, điểm ET_IQ =10, điểm ET_Gmath =15, điểm ET_English = 30.
SELECT * FROM Trainee;
UPDATE Trainee SET Full_Name = 'LeVanA', ET_IQ = 10, ET_Gmath = 15, ET_English = 30 WHERE TraineeID = 10;

-- Câu 20: Đếm xem trong lớp VTI001  có bao nhiêu thực tập sinh
SELECT * FROM Trainee;
SELECT  COUNT(Training_Class) FROM Trainee WHERE Training_Class = 'VTI001';

-- Câu 21: Đếm xem trong lớp VTI004  có bao nhiêu thực tập sinh
SELECT * FROM Trainee;
SELECT  COUNT(Training_Class) AS MEMBER FROM Trainee WHERE Training_Class = 'VTI004';

-- Câu 22: Đếm tổng số thực tập sinh trong lớp VTI001 và VTI003 có bao nhiêu thực tập sinh.
SELECT * FROM Trainee;
SELECT  COUNT(Training_Class) AS MEMBER_VTI001 FROM Trainee WHERE Training_Class = 'VTI001'
UNION
SELECT  COUNT(Training_Class) AS MEMBER_VTI003 FROM Trainee WHERE Training_Class = 'VTI003';










