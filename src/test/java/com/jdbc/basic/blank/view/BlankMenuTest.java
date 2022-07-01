package com.jdbc.basic.blank.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlankMenuTest {

    BlankMenu menu = new BlankMenu();



    @Test
    @DisplayName("문제가 나와야 한다 ")
    void printTextTest() {

        menu.printText();


    }


}