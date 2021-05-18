-- -----------------------------------------------------
-- Table `universidade`
-- -----------------------------------------------------

CREATE DATABASE projectMvcPol
ENCODING = 'UTF-8'
LC_COLLATE = 'pl_PL.UTF-8';

CREATE TABLE IF NOT EXISTS employee (
  id SERIAL PRIMARY KEY,
  name VARCHAR(45) NULL,
  last_name VARCHAR(45) NOT NULL,
  position VARCHAR(25) NOT NULL,
  salary int NOT NULL
  );
  
  CREATE TABLE IF NOT EXISTS department (
	id SERIAL PRIMARY KEY,
	name VARCHAR(45) NOT NULL,
	employee_id INTEGER,
	FOREIGN KEY (employee_id) REFERENCES employee (id)
);


