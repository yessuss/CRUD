CREATE OR REPLACE FUNCTION fun_consultarpoliza(
	IN idPoliza INT,
	OUT iestado SMALLINT,
	OUT cmensaje CHARACTER VARYING,
	OUT cjson CHARACTER VARYING
)
-- =======================================================================================
-- AUTOR: JESUS DANIEL AISPURO MORALES
-- FECHA: 10/09/2023 dd-mm-aaaa
-- DESCRIPCION GENERAL: 
-- =======================================================================================
RETURNS RECORD
LANGUAGE 'plpgsql'
 SECURITY DEFINER
AS $FUNCTION$

DECLARE
registro RECORD;
icantidad INT = 0;
cnombre CHARACTER VARYING = '';
capellido CHARACTER VARYING = '';
isku INT = 0;
nombreProd CHARACTER VARYING = '';
iempleado SMALLINT = 0;

BEGIN
cjson := '';


	IF((SELECT COUNT(1) FROM Polizas  WHERE  idPolizas = idPoliza) > 0 ) THEN
	
		SELECT empleadogenero,sku INTO registro FROM Polizas  WHERE  idPolizas = idPoliza;

		icantidad := (SELECT cantidad FROM Polizas  WHERE  idPolizas = idPoliza);
		cnombre := (SELECT nombre FROM Empleado  WHERE  idEmpleado = registro.empleadogenero);
		capellido := (SELECT Apellido FROM Empleado  WHERE  idEmpleado = registro.empleadogenero);
		isku := (SELECT sku FROM inventario  WHERE  sku = registro.sku);
		nombreProd := (SELECT nombre FROM inventario  WHERE  sku = registro.sku);
	
		cJson := cJson || '{"Poliza":{ "idPoliza":'|| idPoliza ||',"Cantidad":'|| icantidad || '}, "Empleado" :{ "Nombre":"' || cnombre || '","Apellido":"'|| capellido ||'"}, "DetalleArticulo": {"SKU":'|| isku ||',"Nombre":"'|| nombreProd ||'"}';
		cJson := cJson || '}';
		
		iestado:= 0;
		cmensaje := 'Exito';
	
	ELSE
		iestado:= 1;
		cmensaje := 'Ha ocurrido un error al consultar la póliza';
		
	END IF;

EXCEPTION WHEN OTHERS THEN
  iestado := -1;
  cmensaje := 'DETALLES: ' || SQLERRM;
RETURN;

END;
$FUNCTION$