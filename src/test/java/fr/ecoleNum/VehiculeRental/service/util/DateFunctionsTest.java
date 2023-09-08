package fr.ecoleNum.VehiculeRental.service.util;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DateFunctionsTest {
    @Test
    void testAge(){
        assertEquals(DateFunctions.getAge(Timestamp.valueOf("2013-09-09 00:00:00")),9);
        assertEquals(DateFunctions.getAge(Timestamp.valueOf("2013-09-08 00:00:00")),10);
        assertEquals(DateFunctions.getAge(Timestamp.valueOf("2013-09-07 00:00:00")),10);
        assertEquals(DateFunctions.getAge(Timestamp.valueOf("0001-01-07 00:00:00")),2022);
        assertEquals(DateFunctions.getAge(Timestamp.valueOf("0001-12-07 00:00:00")),2021);
    }
    @Test
    void areDistinctPeriods(){
        assertTrue(
                DateFunctions.areDistinctPeriods(
                        new Timestamp(0), new Timestamp(1),
                        new Timestamp(2), new Timestamp(3))
        );
        assertFalse(
                DateFunctions.areDistinctPeriods(
                        new Timestamp(0), new Timestamp(3),
                        new Timestamp(2), new Timestamp(4))
        );
        assertFalse(
                DateFunctions.areDistinctPeriods(
                        new Timestamp(1), new Timestamp(4),
                        new Timestamp(2), new Timestamp(3))
        );
        assertFalse(
                DateFunctions.areDistinctPeriods(
                        new Timestamp(2), new Timestamp(4),
                        new Timestamp(1), new Timestamp(3))
        );
        assertTrue(
                DateFunctions.areDistinctPeriods(
                        new Timestamp(3), new Timestamp(4),
                        new Timestamp(1), new Timestamp(2))
        );
        assertFalse(
                DateFunctions.areDistinctPeriods(
                        new Timestamp(1), new Timestamp(2),
                        new Timestamp(2), new Timestamp(3))
        );
        assertFalse(
                DateFunctions.areDistinctPeriods(
                        new Timestamp(1), new Timestamp(2),
                        new Timestamp(1), new Timestamp(3))
        );
        assertFalse(
                DateFunctions.areDistinctPeriods(
                        new Timestamp(1), new Timestamp(2),
                        new Timestamp(1), new Timestamp(2))
        );
        assertFalse(
                DateFunctions.areDistinctPeriods(
                        new Timestamp(2), new Timestamp(3),
                        new Timestamp(1), new Timestamp(2))
        );
        assertFalse(
                DateFunctions.areDistinctPeriods(
                        new Timestamp(2), new Timestamp(4),
                        new Timestamp(1), new Timestamp(3))
        );
        assertFalse(
                DateFunctions.areDistinctPeriods(
                        new Timestamp(2), new Timestamp(4),
                        new Timestamp(1), new Timestamp(3))
        );
    }
}
