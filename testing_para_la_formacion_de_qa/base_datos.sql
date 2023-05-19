CREATE DATABASE formacion_qa;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user VARCHAR(50) NOT NULL,
  pass VARCHAR(50) NOT NULL,
  user_type ENUM('admin', 'usuario_normal') NOT NULL DEFAULT 'usuario_normal'
);


INSERT INTO users (user, pass, user_type) VALUES 
	('admin', '123456789', 'admin'),
        ('form&radio', 'form1234', 'reg_user'),
        ('button', 'button1234', 'reg_user'),
        ('dinamicElements', 'dinamic1234', 'reg_user'),
        ('modalWindow', 'modal1234', 'reg_user'),
        ('alertWindow', 'alert1234', 'reg_user'),
        ('menu&list', 'menu1234', 'reg_user'),
        ('otherInput', 'input1234', 'reg_user'),
        ('movingElements', 'moving1234', 'reg_user'),
        ('auxiliarUser1', '2468', 'reg_user'),
        ('auxiliarUser2', '2648', 'reg_user'),
        ('auxiliarUser3', '2684', 'reg_user'),
        ('auxiliarUser4', '2846', 'reg_user'),
        ('auxiliarUser5', '2864', 'reg_user'),
        ('errorUser1', '8642', 'reg_user'),
        ('errorUser2', '8462', 'reg_user'),
        ('errorUser3', '4862', 'reg_user'),
        ('errorUser4', '6482', 'reg_user'),
        ('errorUser5', '4682', 'reg_user');