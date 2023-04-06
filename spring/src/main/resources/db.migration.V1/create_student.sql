CREATE TABLE STUDENTS(
                          STUDENT_ID BIGINT NOT NULL AUTO_INCREMENT,
                          NAME VARCHAR(255) NOT NULL,
                          EMAIL VARCHAR(255) NOT NULL,
                          DOB VARCHAR(255) NOT NULL UNIQUE,
                          );