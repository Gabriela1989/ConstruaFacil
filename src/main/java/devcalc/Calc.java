// 14 - Pacote
package devcalc;
// 2 - Bibliotecas
import java.util.Scanner;

//3 - Classes
public class Calc {
    // 3.1 - Atributos
    static Scanner entrada  = new Scanner(System.in); // entrada = input


    //3.2 - Métodos e Funções
    public static void main (String[] args){
        // Exibe o menu da calculadora
        System.out.println(">>> CALCULADORA <<<");
        System.out.println("(1) Somar");
        System.out.println("(2) Subtrair");
        System.out.println("(3) Multiplicar");
        System.out.println("(4) Dividir");
        System.out.println("Escolha o Calculo desejado:");

        //Recebe as opção deseja
        String opcao = entrada.nextLine();

        //Pergunta os valores a serem usados no calculo
        System.out.print("Entre o 1 numero: ");
        int num1 = entrada.nextInt();
        System.out.print("Entre o 2 numero: ");
        int num2 = entrada.nextInt();
        System.out.print( "O resultado é: ");

        //Chama a função do calculo desejado
        switch (opcao){
            case "1":
                System.out.println(somarDoisNumeros(num1, num2));
                break;
            case "2":
                System.out.println(subtrairDoisNumeros(num1, num2));
                break;
            case "3":
                System.out.println(multiplicarDoisNumeros(num1, num2));
                break;
            case "4":
                System.out.println(dividirDoisNumeros(num1, num2));
                break;

            default:
                System.out.println("Opcao invalida");
                break;
        }

    }

    public static int dividirDoisNumeros(int num1, int num2) {
        return num1 / num2;
    }

    public static int multiplicarDoisNumeros(int num1, int num2) {
        return num1 * num2;
    }

    public static int subtrairDoisNumeros(int num1, int num2) {
        return num1 - num2;
    }

    // Operação
    public static int somarDoisNumeros(int num1,int num2){
        return num1 + num2;

    }





}


