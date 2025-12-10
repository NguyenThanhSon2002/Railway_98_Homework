DROP DATABASE IF EXISTS Testing_Exam_1; 
 
CREATE DATABASE Testing_Exam_1; 

USE Testing_Exam_1; 

DROP TABLE IF EXISTS CUSTOMER;
CREATE TABLE CUSTOMER (
	CustomerID SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name` VARCHAR(50) NOT NULL,
    Phone CHAR(10) NOT NULL UNIQUE KEY,
    Email VARCHAR(50) NOT NULL UNIQUE KEY,
    Address VARCHAR(100) NOT NULL,
    Note VARCHAR(300)
);

INSERT INTO CUSTOMER (`Name`, Phone, Email, Address, Note)
VALUES				 ('Tran Van H', '0981123001', 'tranvanh@gmail.com', 'Ha Noi', 'Khách mới đăng ký'),
					 ('Le Thi I', '0981123002', 'lethii@gmail.com', 'Hai Phong', 'Ưu tiên giao buổi sáng'),
					 ('Pham Van K', '0981123003', 'phamvank@gmail.com', 'Da Nang', 'Khách tiềm năng'),
					 ('Hoang Thi L', '0981123004', 'hoangthil@gmail.com', 'HCM', 'Đặt mua nhiều lần'),
					 ('Do Van M', '0981123005', 'dovanm@gmail.com', 'Can Tho', 'Cần tư vấn thêm');

DROP TABLE IF EXISTS CAR;
CREATE TABLE CAR (
	CarID SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Maker ENUM('HONDA','TOYOTA','NISSAN') NOT NULL,
    Model VARCHAR(20) NOT NULL UNIQUE KEY,
    `Year` YEAR NOT NULL,
    Color VARCHAR(10) NOT NULL,
    Note VARCHAR(300)
);

INSERT INTO CAR (Maker, Model, `Year`, Color, Note)
VALUES 			('HONDA', 'HONDA-ACCORD', 2022, 'SILVER', 'New model 2022'),
				('TOYOTA', 'TOYOTA-HILUX', 2019, 'RED', 'Pickup truck'),
				('NISSAN', 'NISSAN-ALTIMA', 2021, 'WHITE', 'Sedan, imported'),
				('HONDA', 'HONDA-JAZZ', 2018, 'BLUE', 'Compact car'),
				('TOYOTA', 'TOYOTA-RAV4', 2023, 'BLACK', 'New generation SUV');

DROP TABLE IF EXISTS CAR_ORDER;
CREATE TABLE CAR_ORDER (
	OrderID SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CustomerID SMALLINT UNSIGNED NOT NULL UNIQUE KEY,
    FOREIGN KEY (CustomerID) REFERENCES CUSTOMER (CustomerID),
    CarID SMALLINT UNSIGNED NOT NULL UNIQUE KEY,
    FOREIGN KEY (CarID) REFERENCES CAR (CarID),
    Amount TINYINT NOT NULL DEFAULT 1,
    SalePrice VARCHAR(20) NOT NULL, 
    OrderDate DATETIME DEFAULT NOW(), 
    DeliveryDate DATETIME DEFAULT NOW(),
    DeliveryAddress VARCHAR(20) NOT NULL,
    -- 0: đã đặt hàng, 1: đã giao, 2: đã hủy
    Staus ENUM('0','1','2') NOT NULL,
    Note VARCHAR(300)
);

INSERT INTO CAR_ORDER (CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, Staus, Note)
VALUES				  (1, 1, 1, '30000 USD', NOW(), NOW(), 'Ha Noi', '0', 'Khách đặt xe gấp'),	
					  (2, 3, 2, '55000 USD', NOW(), NOW(), 'Hai Phong', '1', 'Đã giao cho khách đúng hẹn'),	
					  (3, 5, 1, '150000 USD', NOW(), NOW(), 'Da Nang', '0', 'Khách đang xem xét thêm phụ kiện'),	
					  (4, 2, 1, '20000 USD', NOW(), NOW(), 'Ha Noi', '2', 'Khách hủy do thay đổi nhu cầu'),	
					  (5, 4, 3, '45000 USD', NOW(), NOW(), 'HCM', '1', 'Khách VIP – đã giao toàn bộ');

-- Câu 2: Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã
-- mua và sắp sếp tăng dần theo số lượng oto đã mua.
SELECT * FROM CUSTOMER;
SELECT * FROM CAR_ORDER;

SELECT c.CustomerID, c.`Name`, co.Amount AS Car_Buy FROM CUSTOMER c
INNER JOIN CAR_ORDER co ON c.CustomerID = co.CustomerID
ORDER BY co.Amount DESC;

-- Câu 3: Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều
-- oto nhất trong năm nay
SET GLOBAL log_bin_trust_function_creators = 1;

SELECT * FROM CAR;
SELECT * FROM CAR_ORDER;

DROP FUNCTION IF EXISTS f_GetTopMakerThisYear;

DELIMITER $$   
CREATE FUNCTION f_GetTopMakerThisYear() RETURNS VARCHAR(20)
BEGIN   
	DECLARE TopMaker VARCHAR(20);
    SELECT MAX(co.Amount), c.Maker INTO TopMaker FROM CAR_ORDER co
    INNER JOIN CAR c ON co.CarID = c.CarID
    WHERE co.Staus = '1' AND YEAR(co.DeliveryDate) = YEAR(CURDATE())
    GROUP BY c.Maker
    ORDER BY COUNT(*) DESC
    LIMIT 1;
    RETURN topMaker;
END $$ 
 
SELECT f_GetTopMakerThisYear();

