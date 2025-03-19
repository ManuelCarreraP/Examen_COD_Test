import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestMain {
    @Tag("Correcto")
    @DisplayName("Comprobar si el DNI y la letra son correctos")
    @ParameterizedTest
    @CsvSource({
            "00000000, T, true",  // Correcto
            "98765432, R, false", // Letra equivocada
            "00000001, T, false", // DNI incorrecto
            "00000000, X, false"  // Letra incorrecta
    })
    public void testComprobarDNI(String dni, String letra, boolean esperado) {
        boolean resultado = Main.comprobarDNI(dni, letra.charAt(0));
        assertEquals(esperado, resultado);
    }


    @Tag("Letra")
    @DisplayName("Comprobar la letra calculada del DNI")
    @ParameterizedTest
    @CsvSource({
            "00000000, T",
            "12345678, Z, false", //Letra erronea
            "98765432, M, false", // Letra erronea
    })
    public void testCalcularLetraDNI(String dni, String letraEsperada) {
        char letraCalculada = Main.calcularLetraDNI(dni);
        assertEquals(letraEsperada.charAt(0), letraCalculada);
    }

}
