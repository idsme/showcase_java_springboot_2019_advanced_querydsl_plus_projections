package nl.acmelabs.someapp.config;

import org.hibernate.spatial.dialect.oracle.OracleSpatial10gDialect;

import java.sql.Types;

/**
 * Temporarily needed until we migrate to PostGis or as long we need. It is used to disable warnings by hibernate
 * validate when using Double column without definition.
 */
@java.lang.SuppressWarnings("squid:MaximumInheritanceDepth") // This class is temporarily, should be fixed asap
public class Oracle10gDialectExtended extends OracleSpatial10gDialect {
    public Oracle10gDialectExtended() {
        registerColumnType(Types.DOUBLE, "float");
    }
}