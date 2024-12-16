-- CREATE USER somename
--   IDENTIFIED BY somename
--   QUOTA unlimited on SYSTEM;


-- TODO IDSME Test if this is still needed below
GRANT create session TO somename;
GRANT create table TO somename;
GRANT create view TO somename;
GRANT create any trigger TO somename;
GRANT create any procedure TO somename;
GRANT create sequence TO somename;
GRANT create synonym TO somename;
