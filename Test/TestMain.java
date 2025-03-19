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
            "00000000, T, true",
            "00000001, R, true",
            "00000002, W, true",
            "00000003, A, true",
            "00000004, G, true",
            "00000005, M, true",
            "00000006, Y, true",
            "00000007, F, true",
            "00000008, P, true",
            "00000009, D, true",
            "00000010, X, true",
            "00000011, B, true",
            "00000012, N, true",
            "00000013, J, true",
            "00000014, Z, true",
            "00000015, Q, true",
            "00000016, S, true",
            "00000017, V, true",
            "00000018, H, true",
            "00000019, L, true",
            "00000020, C, true",
            "00000021, K, true",
            "00000022, E, true",
            "00000000, X, false",  // Letra incorrecta
            "12345678, Z, false",  // Letra errónea
            "98765432, M, false"   // Letra errónea
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
            "00000001, R",
            "00000002, W",
            "00000003, A",
            "00000004, G",
            "00000005, M",
            "00000006, Y",
            "00000007, F",
            "00000008, P",
            "00000009, D",
            "00000010, X",
            "00000011, B",
            "00000012, N",
            "00000013, J",
            "00000014, Z",
            "00000015, Q",
            "00000016, S",
            "00000017, V",
            "00000018, H",
            "00000019, L",
            "00000020, C",
            "00000021, K",
            "00000022, E"
    })
    public void testCalcularLetraDNI(String dni, String letraEsperada) {
        char letraCalculada = Main.calcularLetraDNI(dni);
        assertEquals(letraEsperada.charAt(0), letraCalculada);
    }


    // Test del error encontrado en el programa
    @Tag("Longitud")
    @DisplayName("Comprobar que el DNI tenga 8 caracteres")
    @ParameterizedTest
    @CsvSource({
            "1234567, false",       // Menos de 8 caracteres
            "123456789, false",     // Más de 8 caracteres
            "12345678, true",       // DNI correcto
            "ABCDEFGH, false",      // Solo letras
            "1234A678, false",      // Mezcla de números y letras
            "12-34*678, false",     // Contiene caracteres especiales
            ", false",              // DNI vacío
            "        , false"       // Solo espacios
    })
    public void testComprobarLongitudYFormatoDNI(String dni, boolean esperado) {
        boolean resultado = comprobarLongitudYFormatoDNI(dni);
        assertEquals(esperado, resultado);
    }

    /**
     * Verifica si el DNI tiene exactamente 8 caracteres y solo números sin usar matches()
     * @param dni DNI a verificar
     * @return true si cumple los requisitos, false si no
     */
    public boolean comprobarLongitudYFormatoDNI(String dni) {
        if (dni == null || dni.length() != 8) {
            return false;
        }

        // Verifica que todos los caracteres sean dígitos usando Character.isDigit()
        for (int i = 0; i < dni.length(); i++) {
            if (!Character.isDigit(dni.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
