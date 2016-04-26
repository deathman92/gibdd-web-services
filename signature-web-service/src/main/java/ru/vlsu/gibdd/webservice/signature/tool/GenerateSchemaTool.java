package ru.vlsu.gibdd.webservice.signature.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.deathman.db.tool.SchemaGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@SuppressWarnings("Duplicates")
public class GenerateSchemaTool {

    private static Logger logger = LoggerFactory.getLogger(GenerateSchemaTool.class);

    public static void main(String[] args) {
        try {
            logger.debug("Schema generation started");
            generateDdl();
            logger.debug("Schema generation finished");
        } catch (Exception e) {
            logger.warn("Schema generation failed", e);
        }
    }

    private static void generateDdl() throws Exception {
        List<String> packages = new ArrayList<>();
        packages.add("ru.vlsu.gibdd.webservice.signature.domain");

        SchemaGenerator generator = new SchemaGenerator(packages);
        generator.generateDdl(SchemaGenerator.Dialect.H2);
    }
}
