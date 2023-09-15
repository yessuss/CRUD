CREATE OR REPLACE FUNCTION fun_eliminarpoliza(
	IN jsonEliminar JSON,
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
idPoliza INT;


BEGIN
idPoliza := jsonEliminar -> 'id';

	IF((SELECT COUNT(1) FROM Polizas  WHERE  idPolizas = idPoliza) > 0 ) THEN
	
		DELETE FROM Polizas WHERE idPolizas = idPoliza;
	
		iestado := 0;
		cmensaje := 'Se eliminó correctamente la póliza #' || idPoliza;

	ELSE
		iestado:= 1;
		cmensaje := 'Ha ocurrido un error al intentar eliminar la póliza.';
		
	END IF;

EXCEPTION WHEN OTHERS THEN
  iestado := -1;
  cmensaje := 'DETALLES: ' || SQLERRM;
RETURN;

END;
$FUNCTION$