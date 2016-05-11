package io.intellijokers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HorseNameGeneratorSpec {

    HorseNameGenerator horseNameGenerator;
    @Before public void setupInitializer() {
        horseNameGenerator = new HorseNameGenerator();
    }

    @Test
    public void horseNameGeneratorTest() {
        String expectedValue = "Get'im";
        String actualValue = horseNameGenerator.nameGenerator();
        assertEquals("Should output a random name", expectedValue, actualValue);
    }


    ;




















}
