package com.curso;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

class LibreriaTest {
    
    @Test
    @DisplayName("Libreria: Sumar 2 números positivos")
    void sumar2PositivosTest(){
        // Configurar el entorno en que ejecutaré la prueba. GIVEN
        double numero1 = 10;
        double numero2 = 30;
        double resultadoEsperado = 40;
        // Realizo la acción a probar. WHEN
        double resultadoRecibido = Libreria.sumar(numero1, numero2);
        // confirmo el resultado de la acción. THEN
        Assertions.assertEquals(resultadoEsperado, resultadoRecibido, 0.000001)
    }

    @Test
    @DisplayName("Libreria: Sumar 2 números negativos")
    void sumar2NegativosTest(){
        // Configurar el entorno en que ejecutaré la prueba. GIVEN
        double numero1 = -10;
        double numero2 = -30;
        double resultadoEsperado = -40;
        // Realizo la acción a probar. WHEN
        double resultadoRecibido = Libreria.sumar(numero1, numero2);
        // confirmo el resultado de la acción. THEN
        Assertions.assertEquals(resultadoEsperado, resultadoRecibido, 0.000001)
    }

    @Test
    @DisplayName("Libreria: Sumar a un número 0")
    void sumarCeroTest(){
        // Configurar el entorno en que ejecutaré la prueba. GIVEN
        double numero1 = 10;
        double numero2 = 0;
        double resultadoEsperado = 10;
        // Realizo la acción a probar. WHEN
        double resultadoRecibido = Libreria.sumar(numero1, numero2);
        // confirmo el resultado de la acción. THEN
        Assertions.assertEquals(resultadoEsperado, resultadoRecibido, 0.000001)
    }
    @Test
    @DisplayName("Libreria: Doblar un positivo")
    void doblarPositivoTest(){
        // Configurar el entorno en que ejecutaré la prueba. GIVEN
        double numero = 10;
        double resultadoEsperado = 20;
        // Realizo la acción a probar. WHEN
        double resultadoRecibido = Libreria.doblar(numero);
        // confirmo el resultado de la acción. THEN
        Assertions.assertEquals(resultadoEsperado, resultadoRecibido, 0.000001)
    }
    @Test
    @DisplayName("Libreria: Doblar un negativo")
    void doblarNegativoTest(){
        // Configurar el entorno en que ejecutaré la prueba. GIVEN
        double numero = -10;
        double resultadoEsperado = -20;
        // Realizo la acción a probar. WHEN
        double resultadoRecibido = Libreria.doblar(numero);
        // confirmo el resultado de la acción. THEN
        Assertions.assertEquals(resultadoEsperado, resultadoRecibido, 0.000001)
    }
    @Test
    @DisplayName("Libreria: Doblar cero")
    void doblarCeroTest(){
        // Configurar el entorno en que ejecutaré la prueba. GIVEN
        double numero = 0;
        double resultadoEsperado = 0;
        // Realizo la acción a probar. WHEN
        double resultadoRecibido = Libreria.doblar(numero);
        // confirmo el resultado de la acción. THEN
        Assertions.assertEquals(resultadoEsperado, resultadoRecibido, 0.000001)
    }

}

//new LibreriaTest()