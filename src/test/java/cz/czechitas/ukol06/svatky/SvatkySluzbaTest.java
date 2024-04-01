package cz.czechitas.ukol06.svatky;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.MonthDay;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SvatkySluzbaTest {

    @Test
    void testVyhledatSvatkyKeDni() throws IOException {
        //test metody vyhledatSvatkyKeDni
        SvatkySluzba seznamSvatku = new SvatkySluzba();

        List<String> vysledekJednoJmeno = seznamSvatku.vyhledatSvatkyKeDni(MonthDay.of(1,5));
        List<String> vysledekViceJmen = seznamSvatku.vyhledatSvatkyKeDni(MonthDay.of(2,9));
        List<String> vysledekZadneJmeno = seznamSvatku.vyhledatSvatkyKeDni(MonthDay.of(1,1));

        //test pro den, kdy má svátek jedno jméno
        assertAll(
                () -> assertEquals(1, vysledekJednoJmeno.size()),
                () -> assertEquals("Dalimil", vysledekJednoJmeno.getFirst())
        );

        //test pro den, kdy má svátek více jmen
        assertAll(
                () -> assertEquals(2, vysledekViceJmen.size()),
                () -> assertEquals("Apolena", vysledekViceJmen.getFirst()),
                () -> assertEquals("Apolonie", vysledekViceJmen.getLast())
        );

        //test pro den, kdy nemá svátek nikdo (1.1.) "--01-01"
        assertEquals(0, vysledekZadneJmeno.size());
    }
}
