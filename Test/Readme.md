# Examen COD Test Unitarios

## Partes:

##### 1- Los test unitarios de los **dos** métodos, utiliza test **parametrizados**. Suponiendo que la `string` DNI, siempre es un DNI válido.

###### El primerpaso sería crear los siguientes test parametrizados para cada metodo:
```bash
    # Test ComprobarDNI
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
    
    
    # Test CalcularLetraDNI
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
```



##### 2- En el código, hay un error, ¿lo pudiste comprabar en los test? ¿Plantea la solución?






##### 3- Si no hubiera una comprobación previamente encuanto a la longitud de la `string` del DNI, ¿Qué hay que cambiar en los tests para que comprueben estos casos?
