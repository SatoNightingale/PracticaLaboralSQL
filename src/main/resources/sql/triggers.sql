-- CREATE FUNCTION validar_importe_lds() RETURNS TRIGGER
-- LANGUAGE sql
-- AS $$
-- BEGIN
-- 	IF new.repartido > old.importe THEN
--         RAISE EXCEPTION "El monto repartido supera el impore total de la linea";
--     END IF;
-- END;
-- $$;

CREATE TRIGGER IF NOT EXISTS lds_validar_importe_trigger
BEFORE UPDATE ON linea_de_servicios
FOR EACH ROW
CALL "com.satoshihans.practicalaboralsql.lineaservicio.ValidarImporteTrigger";
-- EXECUTE FUNCTION validar_importe_lds


-- SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PUBLIC';