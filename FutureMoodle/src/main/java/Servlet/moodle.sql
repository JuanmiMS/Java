create database newmoodle;
use newmoodle;
#--Rango de las personas

create table rango(
id int primary key auto_increment not null,
rango varchar(50) not null
);
insert into rango (rango) values
('administrador'),
('profesor'),
('alumno');


#--Agregar usuarios
create table users(
dni varchar(10) primary key not null,
email varchar(50) unique not null,
password varchar(50)  not null,
name varchar(50) not null,
rango int,
FOREIGN KEY (rango) REFERENCES rango(id)
);

insert into users values ('00000000A','admin@admin.com','admin', 'Administrador', 1);
insert into users values ('11111111B','profe1@profe.com','profe', 'Profesor BBDD Prueba', 2);
insert into users values ('11111111C','profe2@profe.com','profe', 'Profesor LLMM Prueba', 2);
insert into users values ('11111111D','profe3@profe.com','profe', 'Profesor PROG Prueba', 2);
insert into users values ('11111111E','profe4@profe.com','profe', 'Profesor SSII Prueba', 2);
insert into users values ('22222222C','user@user.com','user','Usuario Normal Prueba', 3);



#--Agregar asignaturas
create table asignaturas(
id int primary key auto_increment not null,
nombre varchar(100) not null,
profesor varchar(100) not null,
FOREIGN KEY (profesor) REFERENCES users(dni)
);

select * from asignaturas;
insert into asignaturas (nombre, profesor) values 
('Programacion', '11111111B'),
('Base de Datos', '11111111C'),
('Sistemas Digitales', '11111111D'),
('Lenguaje de Marcas', '11111111E');


#--Matriculaciones
create table AsignaturasAlumnos(
id int auto_increment primary key not null,
alumno varchar(10) not null,
asignatura int not null,
superada boolean not null,
FOREIGN KEY (alumno) REFERENCES users(dni),
FOREIGN KEY (asignatura) REFERENCES asignaturas(id)
);

insert into AsignaturasAlumnos (alumno, asignatura, superada) values
('22222222C', 1, false),('22222222C', 2, false),('22222222C', 3, false),
('11111111B', 1, true),('11111111C', 2, true),('11111111D', 3, true),('11111111E',4, true);



#-trabajos
create table trabajos(
id int AUTO_INCREMENT not null,
nombre varchar(50) not null,
asignatura int not null,
primary key(id),
FOREIGN KEY (asignatura) REFERENCES asignaturas(id)
);

insert into trabajos (nombre, asignatura) values ('Trabajo 1', 1), ('Trabajo 2', 1), ('Trabajo 1', 2);
select * from trabajos;


#--Notas
create table notas(
id int primary key auto_increment not null,
alumno varchar(50) not null,
trabajo int not null,
nota int not null,
FOREIGN KEY (alumno) REFERENCES users(dni),
FOREIGN KEY (trabajo) REFERENCES trabajos(id)
);

insert into notas (alumno, trabajo, nota) value ('22222222C', 1, 8), ('22222222C', 2, 4), ('22222222C', 3, 10);


select * from users;
select name from users where email='profe1@profe.com';