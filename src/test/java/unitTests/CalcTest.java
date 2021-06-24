package unitTests;

import devcalc.Calc;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CalcTest {
    @Test(priority = 1)

    public void testarSomarDoisNumeros() {
     // 1 - Prepara - Configurar - Given - Arrange

        int num1 = 5;
        int num2 = 7;
        int resultadoEsperado = 12;

     // 2 - Executar - When - Act
        int resultadoAtual = Calc.somarDoisNumeros(num1, num2);

    // 3 - Validar - Then - Assert
        System.out.println("O resultado esperado seria " + resultadoEsperado + " e o resultado atual foi " + resultadoAtual);

        assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test(priority = 2)
    public void testarSubtrairDoisNumeros(){

        int num1 = 6;
        int num2 = 2;
        int resultadoEsperado = 4;

        int resultadoAtual = Calc.subtrairDoisNumeros(num1,num2);

        System.out.println("O resultado esperado seria " + resultadoEsperado
                + " e o resultado atual foi " + resultadoAtual);

        assertEquals(resultadoAtual,resultadoEsperado);
    }


    @Test(priority = 3)

    public void testarmultiplicarDoisNumeros(){

        int num1 = 6;
        int num2 = 6;
        int resultadoEsperado = 36;

        int resultadoAtual = Calc.multiplicarDoisNumeros(num1,num2);

        System.out.println("O resultado esperado seria " + resultadoEsperado
                + " e o resultado atual foi " + resultadoAtual);

        assertEquals(resultadoAtual,resultadoEsperado);
     }

    @Test(priority = 4)

    public void testardividirDoisNumeros(){
        int num1 = 100;
        int num2 = 2;
        int resultadoEsperado = 50;

        int resultadoAtual = Calc.dividirDoisNumeros(num1, num2);

        System.out.println("O resultado esperado seria " + resultadoEsperado
                + " e o resultado atual foi " + resultadoAtual);

        assertEquals(resultadoAtual,resultadoEsperado);
    }


    }




