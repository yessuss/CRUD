CREATE OR REPLACE FUNCTION fun_generaciondepoliza(
	IN jsonGrabar JSON,
	OUT iestado SMALLINT,
	OUT cmensaje CHARACTER VARYING
)
-- =======================================================================================
-- AUTOR: JESUS DANIEL AISPURO MORALES
-- FECHA: 10/09/2023 dd-mm-aaaa
-- DESCRIPCION GENERAL: 
-- =======================================================================================
LANGUAGE 'plpgsql'
 SECURITY DEFINER
AS $FUNCTION$

DECLARE
idPoliza INT = 0;
idEmpleado INT = 0;
iSKU INT = 0;
icantidad INT = 0;
fecha TIMESTAMP = CURRENT_DATE;
cantidadActual INT = 0;
cantTotal INT = 0;

BEGIN
idPoliza := jsonGrabar -> 'id';
idEmpleado := jsonGrabar -> 'idEmpleado';
iSKU := jsonGrabar -> 'idSKU';
icantidad := jsonGrabar -> 'cantidad';

	IF((SELECT COUNT(1) FROM Polizas  WHERE  idPolizas = idPoliza) = 0 ) THEN
	
		IF(idPoliza <> 0 AND idEmpleado <> 0 AND iSKU <> 0 and icantidad > 0) THEN

			INSERT INTO Polizas(idpolizas, EmpleadoGenero,SKU,Cantidad,Fecha)
			VALUES(idPoliza,idEmpleado, iSKU, icantidad, fecha);

			CantidadActual := (SELECT cantidad FROM inventario WHERE SKU = iSKU);
			cantTotal := (cantidadActual - icantidad);

			UPDATE inventario SET cantidad = cantTotal WHERE SKU = iSKU;

			iestado := 0;
			cmensaje := 'Se grabo correctamente la póliza #' || idPoliza;

		ELSE
			iestado:= 1;
			cmensaje := 'Ha ocurrido un error en los grabados de póliza.';

		END IF;
	ELSE
			iestado:= 1;
			cmensaje := 'Ya existe el numero de póliza.';
		
	END IF;
	
		


EXCEPTION WHEN OTHERS THEN
  iestado := -1;
  cmensaje := 'DETALLES: ' || SQLERRM;
RETURN;

END;
$FUNCTION$