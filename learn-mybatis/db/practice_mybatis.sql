/*
创建数据库
 */
 CREATE DATABASE IF NOT EXISTS practice_mysql DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
 /*
 切换到该数据库
  */
 USE practice_mysql;
/*
创建t_role表
 */
 CREATE TABLE IF NOT EXISTS t_role (
 id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL ,
 role_name VARCHAR(50) NOT NULL ,
 note VARCHAR(255)
 );
/*
插入一个值
 */
INSERT INTO t_role(role_name,note) VALUES("testRoleName","测试内容....");