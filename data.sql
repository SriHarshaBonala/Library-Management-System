insert into student("ID","NAME","EMAIL","USERNAME","PASSWORD","ROLE") values(121327,'Sri Harsha Bonala','st121327@ait.asia','st121327','bnvrsharsha','student');
insert into student("ID","NAME","EMAIL","USERNAME","PASSWORD","ROLE") values(121326,'Sri Harsha Somaraju','st121326@ait.asia','st121326','somuking','student');
insert into student("ID","NAME","EMAIL","USERNAME","PASSWORD","ROLE") values(121323,'Shantanu Asthana','st121323@ait.asia','st121323','shantanua','student');
insert into student("ID","NAME","EMAIL","USERNAME","PASSWORD","ROLE") values(121344,'Siva Babu','st121344@ait.asia','st121344','ssivababu','student');

insert into librarian("ID","NAME","EMAIL","USERNAME","PASSWORD","ROLE") values(101,'Chaky','101@ait.asia','st101','chaky','librarian');

insert into book("TITLE","AUTHOR1","AUTHOR2","AUTHOR3","EDITION","COPIES_AVAILABLE") values ('Human Computer and Interaction','Scott McKenzie','','',13,15);
insert into book("TITLE","AUTHOR1","AUTHOR2","AUTHOR3","EDITION","COPIES_AVAILABLE") values ('Design of Everyday Things','Don Norman','','',2,5);
insert into book("TITLE","AUTHOR1","AUTHOR2","AUTHOR3","EDITION","COPIES_AVAILABLE") values ('Design Patterns by Gang Of Four','Erich Gamma','Richard Helm','Ralph Johnson',37,20);
insert into book("TITLE","AUTHOR1","AUTHOR2","AUTHOR3","EDITION","COPIES_AVAILABLE") values ('Effective Java','Joshua Bloch','','',3,3);
insert into book("TITLE","AUTHOR1","AUTHOR2","AUTHOR3","EDITION","COPIES_AVAILABLE") values ('Software Architecture in Practice','Len Bass','Paul Clements','Rick Kazman',3,17);
insert into book("TITLE","AUTHOR1","AUTHOR2","AUTHOR3","EDITION","COPIES_AVAILABLE") values ('Head First Design Patterns','Eric Freeman','Elisabeth Freeman','Kathy Sierra',1,2);

insert into user_book("UID","BID") values(121326,1);
insert into user_book("UID","BID") values(121323,1);
insert into user_book("UID","BID") values(121327,4);
insert into user_book("UID","BID") values(121327,3);
insert into user_book("UID","BID") values(121327,5);
insert into user_book("UID","BID") values(121326,4);
insert into user_book("UID","BID") values(121344,5);
insert into user_book("UID","BID") values(121344,2);
insert into user_book("UID","BID") values(121323,2);