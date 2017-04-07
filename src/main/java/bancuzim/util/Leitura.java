package bancuzim.util;


import bancuzim.enums.OpcaoMenu;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Scanner;

/**
 * Classe utilitária na leitura das entradas.
 *
 * @author Rafael
 */
public final class Leitura {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat
            .forPattern("dd/MM/yyyy HH:mm");

    private Leitura() {
    }

    /**
     * Solicita uma entrada enquanto a String informada pelo usuário
     * for inválida, não correspondendo a uma opcaoMenu.
     *
     * @param mensagem para solicitar a entrada do campo
     * @param scanner instancia do Scanner
     * @return a opção escolhida, do tipo OpcaoMenu
     */
    public static OpcaoMenu lerOpcaoMenu(String mensagem,
                                                   Scanner scanner) {

        String valor = "";
        do {
            System.out.println(mensagem);
            valor = scanner.nextLine().toUpperCase();
        } while (StringUtils.isBlank(valor) && OpcaoMenu.notContains(valor));

        return OpcaoMenu.valueOf(valor);
    }

    /**
     * Solicita uma entrada enquanto a String informada pelo usuário for
     * inválida.
     *
     * @param mensagem para solicitar a entrada do campo
     * @param scanner instancia do Scanner
     * @return o campo String informado
     */
    public static String lerCampoStringObrigatorio(String mensagem,
                                                   Scanner scanner) {

        String valor = "";
        do {
            System.out.println(mensagem);
            valor = scanner.nextLine();
        } while (StringUtils.isBlank(valor));

        return valor;
    }

    /**
     * Solicita uma entrada enquanto o número informado pelo usuário for
     * inválida.
     *
     * @param mensagem para solicitar a entrada do campo
     * @param scanner instancia do Scanner
     * @return o campo Integer informado
     */
    public static Integer lerCampoIntegerObrigatorio(String mensagem,
                                                     Scanner scanner) {

        Integer valor = null;
        do {
            try {
                System.out.println(mensagem);
                valor = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Entrada Inválida. Digite um número válido!");
            }
        } while (valor == null);

        return valor;
    }

    /**
     * Solicita uma entrada enquanto o valor informado pelo usuário for
     * diferente do desejado.
     *
     * @param mensagem para solicitar a entrada do campo
     * @param scanner instancia do Scanner
     * @return o valor Boolean
     */
    public static Boolean lerCampoBooleanObrigatorio(String mensagem,
                                                     Scanner scanner) {

        Boolean valorBooleano = false;
        Integer valor = null;
        do {
            try {
                System.out.println(mensagem);
                valor = Integer.parseInt(scanner.nextLine());
                switch (valor) {
                    case 0:
                        valorBooleano = false;
                        break;
                    case 1:
                        valorBooleano = true;
                        break;
                    default:
                        System.out.println("Valor informado não corresponde "
                                + "as opções!");
                        valor = null;
                        break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Entrada Inválida. Digite um número válido!");
            }
        } while (valor == null);

        return valorBooleano;
    }

    /**
     * Solicita uma entrada enquanto a data informada pelo usuário for inválida.
     *
     * @param mensagem para solicitar a entrada do campo
     * @param scanner instancia do Scanner
     * @return a data informada
     */
    public static LocalDateTime lerCampoDateTimeObrigatorio(String mensagem,
                                                            Scanner scanner) {

        LocalDateTime date = null;
        do {
            try {
                System.out.println(mensagem);
                String dataTexto = scanner.nextLine();
                date = LocalDateTime.parse(dataTexto, DATE_FORMATTER);
            } catch (final IllegalArgumentException e) {
                System.out.println("Data Inválida. Informe uma data/hora no "
                        + "formato dd/MM/yyyy hh:mm");
                date = null;
            }
        } while (date == null);

        return date;
    }

}
