package org.example;

import org.example.areaOfTriangle.ExceptionsForTriangle;
import org.example.areaOfTriangle.Triangle;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    private static final Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll(){
        logger.info("Start of tests.");
    }

    @Test
    @DisplayName("Positive test")
    public void correctValueArea () throws ExceptionsForTriangle {
        final Triangle triangle = new Triangle();
        assertEquals(12,triangle.areaOfTriangle(7,5,9));
    }

    @Test
    @DisplayName("Negative test. Meaning = <0.")
    public void incorrectValueAreLessThanZero () {
        final Triangle triangle = new Triangle();
        assertAll(
                ()-> assertThrows(ExceptionsForTriangle.class,()-> triangle.areaOfTriangle(0,5,9)),
                ()-> assertThrows(ExceptionsForTriangle.class,()-> triangle.areaOfTriangle(-7,5,9)),
                ()-> assertThrows(ExceptionsForTriangle.class,()-> triangle.areaOfTriangle(-7,-5,9)),
                ()-> assertThrows(ExceptionsForTriangle.class,()-> triangle.areaOfTriangle(0,5,0))
        );
    }

    @Test
    @DisplayName("Negative test. The parties do not form a triangle.")
    public void incorrectValuePartiesDoNotTriangle() {
        final Triangle triangle = new Triangle();
        assertThrows(ExceptionsForTriangle.class,() -> triangle.areaOfTriangle(7,5,30));
    }

    @AfterAll
    static void afterAll() {
        logger.info("Tests completed.");
    }

}
