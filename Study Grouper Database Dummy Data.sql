/**
These SQL scripts are meant to populate the data base with dummy data to test the program
**/
use studygrouper;

-- Updating datatypes
alter table messages 
modify column time_stamp timestamp default current_timestamp on update current_timestamp not null;

alter table reviews 
modify column time_stamp timestamp default current_timestamp on update current_timestamp not null;




-- Inserting test users
insert into users
values(1, 'lindaschminda@gmail.com', 'LSchminda', 'password', 'Linda', 'Schminda', null, null, 'student'),
(2, 'jschmo@gmail.com', 'Jschmo', 'password', 'Joe', 'Schmo', null, null, 'student'),
(3, 'doctorprofessor@gmail.com', 'DRProfess', 'password', 'Doctor', 'Professor', 'Dr.', null, 'instructor'),
(4, 'admin1@gmail.com', 'Admin1', 'password', 'Jimmy', 'Neutron', null, null, 'admin');
select * from users;

-- Inserting test study groups
insert into study_groups
values(1, 3, 'Software Engineering'),
(2, 3, 'Computer Architecture'),
(3, 3, 'Senior Capstone');


-- Inserting test groupaccess
insert into groupaccess (groupID, userID, group_access_id)
values (1, 1, 1),
(2,2, 2),
(1,3, 3);


-- Inserting test messages
insert into messages (messageID, message, senderID, groupID)
values(1, 'I need help with an assignment!', 1, 1),
(2, 'I will help you out as soon as I can.', 3, 1),
(3, 'Will this be one the exam?', 2, 2),
(4, 'Yes.', 3, 2),
(5, 'I just finished my project!!', 1, 3);


-- Inserting test reviews
insert into reviews (reviewID, groupID, review, senderID)
values (1,1, 'This class was great!', 1),
(2, 3, 'This was pretty fun making an application', 2); 




