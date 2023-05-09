CREATE USER somename
  IDENTIFIED BY somename
  QUOTA unlimited on SYSTEM;

GRANT create session TO somename;
GRANT create table TO somename;
GRANT create view TO somename;
GRANT create any trigger TO somename;
GRANT create any procedure TO somename;
GRANT create sequence TO somename;
GRANT create synonym TO somename;
