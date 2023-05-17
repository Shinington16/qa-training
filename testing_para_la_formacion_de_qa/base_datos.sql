CREATE TABLE usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  usuario VARCHAR(50) NOT NULL,
  contrasena VARCHAR(50) NOT NULL,
  tipo_usuario ENUM('admin', 'usuario_normal') NOT NULL DEFAULT 'usuario_normal'
);


INSERT INTO users(USERNAME, PASSWORD, USER_TYPE) VALUES 
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