mysql -u root -p 
admin

show databases;

drop database song;

create database song default character set utf8;

CREATE USER 'song'@'localhost' IDENTIFIED BY 'song';
GRANT EXECUTE, PROCESS, SELECT, SHOW DATABASES, SHOW VIEW, ALTER, ALTER ROUTINE, CREATE, CREATE ROUTINE, CREATE TABLESPACE, CREATE TEMPORARY TABLES, CREATE VIEW, DELETE, DROP, EVENT, INDEX, INSERT, REFERENCES, TRIGGER, UPDATE, CREATE USER, FILE, LOCK TABLES, RELOAD, REPLICATION CLIENT, REPLICATION SLAVE, SHUTDOWN, SUPER  ON *.* TO 'song'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;
SHOW GRANTS FOR 'song'@'localhost';

use song;
 
show tables;


mysql -u song -p
song
use song;

show tables;


SET SQL_SAFE_UPDATES = 0;


SELECT                                   
        ORDINAL_POSITION                 
      , TABLE_NAME                tblNm  
      , COLUMN_NAME               colNm  
      , COLUMN_KEY                pkYn   
      , DATA_TYPE                 dataTyp
      , CHARACTER_MAXIMUM_LENGTH  dataLen
      , IS_NULLABLE               nullYn 
      , COLUMN_COMMENT            cmnt   
FROM   information_schema.columns        
WHERE  1 = 1                             
AND    TABLE_SCHEMA = 'song'
AND    table_name = 'ZCOM99011'
ORDER BY                                 
		ORDINAL_POSITION; 
		
		


SELECT                                   
        *
FROM   information_schema.columns        
WHERE  1 = 1                             
AND    TABLE_SCHEMA = 'song'
AND    table_name = 'ZCOM99022'
ORDER BY                                 
		ORDINAL_POSITION;             