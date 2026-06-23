-- CREATE FUNCTION validar_importe_lds() RETURNS TRIGGER
-- LANGUAGE sql
-- AS $$
-- BEGIN
-- 	IF new.repartido > old.importe THEN
--         RAISE EXCEPTION "El monto repartido supera el impore total de la linea";
--     END IF;
-- END;
-- $$;

-- CREATE TRIGGER IF NOT EXISTS lds_validar_importe_trigger
-- BEFORE UPDATE ON linea_de_servicios
-- FOR EACH ROW
-- BEGIN
--     IF :NEW.repartido > :OLD.importe THEN
--         SIGNAL SQLSTATE '45000'
--         SET MESSAGE_TEXT = 'El monto repartido supera el impore total de la linea';
--     END IF;
-- END;


-- SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PUBLIC';