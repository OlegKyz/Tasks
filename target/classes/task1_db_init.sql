CREATE DATABASE Task1;

CREATE TABLE Tasks
(
	Id INT AUTO_INCREMENT PRIMARY KEY,
	Description VARCHAR(200)
);

ALTER TABLE Tasks
ADD Name VARCHAR(100);

UPDATE Tasks
SET Name = Description;

CREATE TABLE Subtasks
(
	Id INT AUTO_INCREMENT PRIMARY KEY,
	Main_task_id INT,
	Description VARCHAR(200),
	Current_result INT,
	Finish_result INT,
	FOREIGN KEY (Main_task_id) REFERENCES Tasks (id) ON DELETE CASCADE
);

ALTER TABLE Subtasks
ADD Name VARCHAR(100);

UPDATE Subtasks
SET Name = Description;

INSERT INTO Tasks(Description)
VALUES
('First'),
('Second'),
('Third');

INSERT INTO Subtasks(Main_task_id, Description, Current_result, Finish_result)
VALUES
(1, 'First First', 0, 10),
(1, 'First Second', 3, 6),
(2, 'Second First', 1, 5),
(3, 'Third First', 0, 11);