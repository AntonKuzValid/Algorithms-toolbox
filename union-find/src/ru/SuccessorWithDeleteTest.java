package ru;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuccessorWithDeleteTest {

    @Test
    public void main() {
        SuccessorWithDelete swd = new SuccessorWithDelete(10);
        assertEquals(4, swd.successor(4));
        swd.remove(5);
        assertEquals(6, swd.successor(5));
        swd.remove(6);
        assertEquals(7, swd.successor(5));
        assertEquals(7, swd.successor(6));
    }

}