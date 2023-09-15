CREATE OR REPLACE FUNCTION fun_consultaGeneralPoliza(
  IN idPoliza INT,
  OUT idpolizas INT,
  OUT empleado CHARACTER VARYING,
  OUT sku INT,
  OUT nombreProducto CHARACTER VARYING, 
  OUT cantidad INT,
  OUT empleadogenero INT
)

 RETURNS SETOF RECORD
 LANGUAGE plpgsql
 SECURITY DEFINER
AS $FUNCTION$

DECLARE
registros RECORD;


BEGIN
IF (idPoliza > 0) THEN 

	FOR registros IN (SELECT p.idpolizas, (e.nombre || ' ' || e.apellido) as empleado, p.sku,i.nombre as nombreProducto, p.cantidad,p.empleadogenero
	FROM polizas p 
	LEFT JOIN empleado e on p.empleadogenero = e.idempleado
	LEFT JOIN inventario i on p.sku = i.sku
	WHERE p.idPolizas = idPoliza
	ORDER BY p.idpolizas)
		LOOP
		
			idpolizas := registros.idpolizas;
			empleado := registros.empleado;
			sku := registros.sku;
			nombreProducto := registros.nombreProducto;
			cantidad := registros.cantidad;
			empleadogenero := registros.empleadogenero;

		RETURN NEXT;
	END LOOP;
ELSE 
	FOR registros IN (SELECT p.idpolizas, (e.nombre || ' ' || e.apellido) as empleado, p.sku,i.nombre as nombreProducto, p.cantidad,p.empleadogenero
	FROM polizas p 
	LEFT JOIN empleado e on p.empleadogenero = e.idempleado
	LEFT JOIN inventario i on p.sku = i.sku
	ORDER BY p.idpolizas)
		LOOP
		
			idpolizas := registros.idpolizas;
			empleado := registros.empleado;
			sku := registros.sku;
			nombreProducto := registros.nombreProducto;
			cantidad := registros.cantidad;
			empleadogenero := registros.empleadogenero;

		RETURN NEXT;
	END LOOP;

END IF;

END;
$FUNCTION$;

