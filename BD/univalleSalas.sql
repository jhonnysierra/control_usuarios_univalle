drop database if exists controlaula;
create database controlaula;
use controlaula;

create table novedad(
	codigo char(3),
	descripcion varchar(200),
	primary key(codigo)
);

create table aula(
	codigo char(2),
	descripcion varchar(50),
	primary key(codigo)
);

create table equipo(
	codigo varchar(20),
	mac varchar(20),
	aula char(2),
	procesador varchar(10),
	modelo_procesador varchar(50),
	mgz_procesador varchar(10),
	sistema_archivos varchar(50),
	tamaño_disco_duro varchar(10),
	particiones_disco varchar(50),
	ram_total varchar(20),
	nombre_usuario varchar(30),
	sistema_operativo varchar(15),
	arquitectura_so varchar(10),
	version_so varchar(5),	
	primary key(codigo),
	foreign key (aula) references aula(codigo)
);

create table programa(
	codigo char(4),
	nombre varchar(50),
	primary key(codigo)
);

create table equipo_novedad(
	equipo varchar(20),
	novedad char(3),
	descripcion varchar(200),
	fecha date,
	hora time,
	estado char(1),
	foreign key (equipo) references equipo(codigo),
	foreign key (novedad) references novedad(codigo)
);

create table estudiante(
	codigo char(9),
	nombres varchar(80),
	apellidos varchar(80),
	programa char(4),
	semestre char(2),
	correo varchar(50),
	contraseña varchar(30),
	tipo char(1),
	estado char(1),
	primary key(codigo),
	foreign key (programa) references programa(codigo)
);

create table bitacora(
	codigo int,
	fecha date,
	horainicio time,
	horafin time,
	estudiante char(9),
	aula char(2),
	equipo varchar(20),
	primary key(codigo),
	foreign key (estudiante) references estudiante(codigo),
	foreign key (aula) references aula(codigo),
	foreign key (equipo) references equipo(codigo)
);

INSERT INTO  `controlaula`.`programa`VALUES ('2711',  'TECNOLOGÍA EN SISTEMAS DE INFORMACIÓN');
INSERT INTO  `controlaula`.`novedad` VALUES ('001',  'SOFTWARE'), ('002',  'HARDWARE');
INSERT INTO  `controlaula`.`estudiante` VALUES ('201251027','JHONNY','SIERRA PARRA','2711','5', 'jhonny.sierra@correounivalle.edu.co','jhonny','1','1');
INSERT INTO  `controlaula`.`estudiante` VALUES ('201251103','MAURICIO','RIVERA AVALO','2711','5', 'jhonny.sierra@correounivalle.edu.co','12345','0','1');
INSERT INTO  `controlaula`.`aula` VALUES ('01',  'SALA INFORMÁTICA 1');

INSERT INTO `equipo` (`codigo`,`mac`, `aula`, `procesador`, `modelo_procesador`, `mgz_procesador`, `sistema_archivos`, `tamaño_disco_duro`, `particiones_disco`, `ram_total`, `nombre_usuario`, `sistema_operativo`, `arquitectura_so`, `version_so`) VALUES
('02','', '01', 'Intel', 'Core(TM) i5-3230M CPU @ 2.60GHz', '2594', 'C:\\ NTFS;D:\\ NTFS;F:\\ FAT32;', '696 GB', '[C:\\, D:\\, E:\\, F:\\, G:\\]', '4185243648 KB','capriatto', 'Windows 7', 'amd64', '6.1'),
('01','00-50-56-C0-00-01', '01', 'Intel', 'Core(TM) i5-3230M CPU @ 2.60GHz', '2594', 'C:\\ NTFS;D:\\ NTFS;F:\\ FAT32;', '696 GB', '[C:\\, D:\\, E:\\, F:\\, G:\\]', '4185243648 KB','capriatto', 'Windows 7', 'amd64', '6.1');





