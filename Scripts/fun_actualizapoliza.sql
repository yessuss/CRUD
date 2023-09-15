CREATE OR REPLACE FUNCTION fun_actualizapoliza(
	IN jsonActualizar JSON,
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
cfecha TIMESTAMP = CURRENT_DATE;
cantidadActual INT = 0;
cantTotal INT = 0;
cantidadPoliza INT = 0;

BEGIN
idPoliza := jsonActualizar -> 'id';
idEmpleado := jsonActualizar -> 'idEmpleado';
iSKU := jsonActualizar -> 'idSKU';
icantidad := jsonActualizar -> 'cantidad';


	IF((SELECT COUNT(1) FROM Polizas  WHERE  idPolizas = idPoliza) > 0 ) THEN
	
		IF(idPoliza <> 0 AND idEmpleado <> 0 AND iSKU <> 0 and icantidad > 0) THEN
		
			cantidadPoliza := (SELECT cantidad FROM Polizas  WHERE  idPolizas = idPoliza);

			UPDATE Polizas SET empleadogenero = idEmpleado, SKU = iSKU, cantidad = icantidad, Fecha = cfecha WHERE idPolizas = idPoliza;
			
			IF(cantidadPoliza <> icantidad) THEN
				
				CantidadActual := (SELECT cantidad FROM inventario WHERE SKU = iSKU);
				cantTotal := (CantidadActual - (icantidad - cantidadPoliza));

				UPDATE inventario SET cantidad = cantTotal WHERE SKU = iSKU;
				
			ELSE 
			
				IF(cantidadPoliza > icantidad) THEN
			
					CantidadActual := (SELECT cantidad FROM inventario WHERE SKU = iSKU);
					cantTotal := (CantidadActual + (cantidadPoliza - icantidad));

					UPDATE inventario SET cantidad = cantTotal WHERE SKU = iSKU;
					
				END IF;
			
			END IF;

			iestado := 0;
			cmensaje := 'Se actualizó correctamente la póliza #' || idPoliza;

		ELSE
			iestado:= 1;
			cmensaje := 'Ha ocurrido un error al intentar actualizar la póliza.';

		END IF;
	ELSE
			iestado:= 1;
			cmensaje := 'No existe el numero de póliza.';
		
	END IF;
	
		


EXCEPTION WHEN OTHERS THEN
  iestado := -1;
  cmensaje := 'DETALLES: ' || SQLERRM;
RETURN;

END;
$FUNCTION$