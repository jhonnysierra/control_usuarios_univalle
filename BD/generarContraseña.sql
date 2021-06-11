drop procedure if exists generarContrase;
delimiter //
create procedure generarContrase(cod char(9))
begin
	declare contrase varchar(30);
	declare estudian varchar(30);
	
	set estudian = (select contraseña from estudiante where codigo=cod);
	select estudian;
	
	if(estudian is NULL or estudian="")then
		set contrase = (select concat(left(nombres,1),right(codigo,7),left(apellidos,1)) from estudiante where codigo=cod);
		update estudiante set contraseña=contrase where codigo=cod;
	end if;

end //
delimiter ;