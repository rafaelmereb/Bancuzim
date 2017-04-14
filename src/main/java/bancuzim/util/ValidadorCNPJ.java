package bancuzim.util;

import java.util.InputMismatchException;

public class ValidadorCNPJ {

    public static boolean isCNPJ(String CNPJ) {

        // Considera-se erro CNPJ's formados por uma sequencia de numeros iguais

        if (CNPJ == null || CNPJ.length() != 14 || CNPJ.matches("^(0|1|2|3|4|5|6|7|8|9)$")) {
            return (false);
        }

        char dig13, dig14;
        int soma, i, r, num, peso;
        try {
            // Calculo do 1º dígito verificador:
            soma = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {

                // Converte o i-ésimo caractere do CNPJ em um número:
                // Exemplo: transforma o caractere '0' no inteiro 0 (48 eh a posição de '0' na tabela ASCII)
                num = (int) (CNPJ.charAt(i) - 48);
                soma = soma + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = soma % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }

            // Calculo do 2º dígito verificador:
            soma = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (CNPJ.charAt(i) - 48);
                soma = soma + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = soma % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }

            // Verifica se os dígitos calculados conferem com os dígitos informados:
            return (dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13));

        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    /**
     * Imprime uma string correspondente ao CNPJ aplicando a máscara padrão
     *
     * @param CNPJ que será impresso com máscara
     * @return
     */
    public static void imprimirCNPJ(String CNPJ) {

        // Máscara do CNPJ: 99.999.999.9999-99
        String CNPJcomMascara = (
                CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." +
                        CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
                        CNPJ.substring(12, 14)
        );

        System.out.println(CNPJcomMascara);
    }

}