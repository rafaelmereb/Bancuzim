package bancuzim.util;

import java.util.InputMismatchException;

public class ValidadorCPF {

    public static boolean isCPF(String CPF) {
        // Considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int soma, i, r, num, peso;

        try {
            // Cálculo do 1º dígito verificador:
            soma = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // Converte o i-ésimo caractere do CPF em um numero.
                // Exemplo, transforma o caractere '0' no inteiro 0. (48 eh a posicao de '0' na tabela ASCII)
                num = CPF.charAt(i) - 48;
                soma += (num * peso);
                peso -= 1;
            }

            r = 11 - (soma % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                // Converte no respectivo caractere numerico:
                dig10 = (char) (r + 48);
            }

            // Cálculo do 2º dígito verificador:
            soma = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = CPF.charAt(i) - 48;
                soma += (num * peso);
                peso -= 1;
            }

            r = 11 - (soma % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados:
            return (dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10));
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public static void imprimeCPF(String CPF) {
        String CPFcomMascara = (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
                CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
        System.out.println(CPF);
    }
}
