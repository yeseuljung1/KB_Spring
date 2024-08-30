#scoula_db 라는 이름의 db생성
create database scoula_db;
create user 'scoula'@'%' identified by '1234';
grant all privileges on scoula_db.* to 'scoula'@'%';
