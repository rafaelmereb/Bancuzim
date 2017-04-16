package bancuzim.util;


import bancuzim.enums.OpcaoMenu;
import bancuzim.enums.Plano;
import bancuzim.enums.Sexo;
import bancuzim.enums.TipoConta;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static bancuzim.enums.OpcaoMenu.A;
import static bancuzim.enums.OpcaoMenu.B;
import static bancuzim.enums.OpcaoMenu.CONTINUE;

/**
 * Classe utilitária na leitura das entradas.
 *
 * @author Rafael
 */
public final class Leitura {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat
            .forPattern("dd/MM/yyyy");

    private Leitura() {
    }

    /**
     * Solicita uma entrada enquanto a String informada pelo usuário
     * for inválida, não correspondendo a uma opcaoMenu.
     *
     * @return a opção escolhida, do tipo OpcaoMenu
     */
    public static OpcaoMenu lerOpcaoMenu() {
        Scanner leitor = new Scanner(System.in);
        String valor;
        boolean opcaoInvalida = true;
        do {
            System.out.println("Opção: ");

            valor = leitor.nextLine().toUpperCase();
            if (OpcaoMenu.notContains(valor)) {
                System.out.println("Opcao Invalida!");
            } else {
                opcaoInvalida = false;
            }
        } while (opcaoInvalida);

        return OpcaoMenu.valueOf(valor);
    }

    /**
     * Colhe uma referência entre duas opcoes
     *
     * @return referência que será utilizada em futuros procedimentos
     */
    public static OpcaoMenu colherReferenciaEntreDuasOpcoes(String opcaoA, String opcaoB) {
        OpcaoMenu opcao = CONTINUE;
        ArrayList<OpcaoMenu> opcoesDisponiveis = new ArrayList<>();
        opcoesDisponiveis.add(A);
        opcoesDisponiveis.add(B);

        while (!opcoesDisponiveis.contains(opcao)) {
            System.out.println("Escolha a referência:\nA - " + opcaoA + "\nB - " + opcaoB);
            opcao = Leitura.lerOpcaoMenu();
            switch (opcao) {
                case A:
                case B:
                    return opcao;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        return opcao;
    }

    /**
     * Solicita uma entrada enquanto a String informada pelo usuário
     * for inválida, não correspondendo a um TipoConta.
     *
     * @return a opção escolhida, do tipo TipoConta
     */
    public static TipoConta lerTipoConta() {
        Scanner leitor = new Scanner(System.in);
        String valor;
        boolean tipoContaInvalida = true;
        do {
            System.out.println("Tipo da Conta (Poupanca, Corrente ou Salario): ");
            valor = leitor.nextLine().toUpperCase();

            if (TipoConta.notContains(valor)) {
                System.out.println("Opcao Invalida!");
            } else {
                tipoContaInvalida = false;
            }
        } while (tipoContaInvalida);

        return TipoConta.valueOf(valor);
    }

    /**
     * Solicita uma entrada enquanto a String informada pelo usuário
     * for inválida, não correspondendo a um Plano.
     *
     * @return a opção escolhida, do tipo Plano
     */
    public static Plano lerPlano() {
        Scanner leitor = new Scanner(System.in);
        String valor;
        boolean planoInvalido = false;
        do {
            System.out.println("Plano (Silver, Gold ou Diamond): ");
            valor = leitor.nextLine().toUpperCase();

            if (Plano.notContains(valor)) {
                System.out.println("Opcao Invalida!");
                planoInvalido = true;
            }
        } while (planoInvalido);


        return Plano.valueOf(valor);
    }

    /**
     * Solicita uma entrada enquanto a String informada pelo usuário for
     * inválida.
     *
     * @param mensagem para solicitar a entrada do campo
     * @return o campo String informado
     */
    public static String lerCampoStringObrigatorio(String mensagem) {
        Scanner leitor = new Scanner(System.in);
        String valor = "";
        do {
            System.out.println(mensagem);
            try {
                valor = leitor.nextLine();
            } catch (IllegalStateException e) {
                System.out.println("Opção inválida!");
            }
        } while (StringUtils.isBlank(valor));

        return valor;
    }

    /**
     * Solicita uma entrada enquanto a String informada pelo usuário não for um CPF/CNPJ válido.
     *
     * @return o campo String informado
     */
    public static String lerCPFouCNPJvalido() {

        String cpfCnpj = "";
        boolean entradaInvalida = false;
        do {
            if (entradaInvalida) {
                System.out.println("CPF/CNPJ Inválido!!");
            }
            cpfCnpj = lerCampoStringObrigatorio("Digite um CPF/CNPJ do cliente: ");
            if (cpfCnpj.contains(".")) {
                cpfCnpj = StringUtils.replaceAll(cpfCnpj, ".", "");
            }
            if (cpfCnpj.contains("-")) {
                cpfCnpj = StringUtils.replaceAll(cpfCnpj, "-", "");
            }
            entradaInvalida = !(ValidadorCPF.isCPF(cpfCnpj) ^ ValidadorCNPJ.isCNPJ(cpfCnpj));
            // '^' é o operador OU-EXCLUSIVO. O resultado só é verdadeiro se as cláusulas tem cpfCnpj diferente.
        } while (entradaInvalida);

        return cpfCnpj;
    }


    /**
     * Solicita uma entrada enquanto o número informado pelo usuário for
     * inválida.
     *
     * @param mensagem para solicitar a entrada do campo
     * @return o campo Integer informado
     */
    public static Integer lerCampoIntegerObrigatorio(String mensagem) {
        Scanner leitor = new Scanner(System.in);
        Integer valor = null;
        do {
            try {
                System.out.println(mensagem);
                valor = Integer.parseInt(leitor.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada Inválida. Digite um número válido!");
            }
        } while (valor == null);

        return valor;
    }

    /**
     * Solicita uma entrada enquanto o número informado pelo usuário for
     * inválida.
     *
     * @param mensagem para solicitar a entrada do campo
     * @return o campo Double informado
     */
    public static Double lerCampoDoubleObrigatorio(String mensagem) {
        Scanner leitor = new Scanner(System.in);
        Double valor = null;
        do {
            try {
                System.out.println(mensagem);
                valor = Double.parseDouble(leitor.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada Inválida. Digite um número válido!");
            }
        } while (valor == null);

        return valor;
    }


    /**
     * Solicita uma entrada enquanto a String informada pelo usuário for uma data
     * inválida.
     *
     * @param mensagem para solicitar a entrada do campo
     * @return o campo String informado
     */
    public static Date lerCampoDateObrigatorio(String mensagem) {
        Scanner leitor = new Scanner(System.in);
        //SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        boolean valido;
        String valor;
        LocalDate data = null;
        do {
            System.out.println(mensagem);
            try {
                valor = leitor.nextLine();
                if (StringUtils.isBlank(valor)) {
                    throw new DateTimeParseException("Conteúdo ausente!", valor, 0);
                } else {
                    data = LocalDate.parse(valor);
                    valido = true;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida!");
                valido = false;
            }
        } while (!valido);

        return java.sql.Date.valueOf(data);
        //('java.sql.Date' é filha de 'java.util.Date' e possui o método de conversão de LocalDate (java 8) para Date)
    }


    /**
     * Solicita uma entrada enquanto o valor informado pelo usuário for
     * diferente do desejado.
     *
     * @param mensagem para solicitar a entrada do campo
     * @return o valor Boolean
     */
    public static Boolean lerCampoBooleanObrigatorio(String mensagem) {
        Scanner leitor = new Scanner(System.in);
        Boolean valorBooleano = false;
        Integer valor = null;
        do {
            try {
                System.out.println(mensagem);
                valor = Integer.parseInt(leitor.nextLine());
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
     * @param scanner  instancia do Scanner
     * @return a data informada
     */
    public static LocalDateTime lerCampoDateTimeObrigatorio(String mensagem,
                                                            Scanner scanner) {

        LocalDateTime date;
        do {
            try {
                System.out.println(mensagem);
                String dataTexto = scanner.nextLine();
                date = LocalDateTime.parse(dataTexto, DATE_FORMATTER);
            } catch (final IllegalArgumentException e) {
                System.out.println("Data Inválida. Informe uma data/hora no "
                        + "formato dd/MM/yyyy");
                date = null;
            }
        } while (date == null);

        return date;
    }

    /**
     * Solicita uma entrada enquanto o sexo informado pelo usuário for inválido.
     *
     * @return o sexo informado
     */
    public static Sexo lerSexoObrigatorio() {
        Scanner leitor = new Scanner(System.in);
        String valor;
        boolean sexoValido = false;
        do {
            System.out.println("Sexo: ");
            valor = leitor.nextLine().toUpperCase();

            if (Sexo.notContains(valor)) {
                System.out.println("Opcao Invalida!");
            } else sexoValido = true;
        } while (!sexoValido);

        return Sexo.valueOf(valor);
    }

}
