package com.allstate.demos.mod2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageTest {

    @Test
    void variableDemoTest_shouldReturnIntOf100(){
        Language language = new Language();

        assertEquals(100, language.variableDemo());
    }

}
