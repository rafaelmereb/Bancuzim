package theBancuzim.util;

import org.apache.log4j.Logger;

public class Menus {

    private static Menus ourInstance = new Menus();

    public static Menus getInstance() {
        return ourInstance;
    }

    private Menus() {
    }

    public static final String INICIAL =
            "Olá, bem vindo ao Bancuzim!\n" +
                "Digite um comando para prosseguir:\n" +
                "A - Gerenciar agências\n" +
                "B - Gerenciar clientes\n" +
                "C - Gerenciar contas\n" +
                "E - Gerenciar empréstimos/financiamentos\n" +
                "S - Sair";


    /* ----------------------------- AGENCIA ----------------------------- */


    public static final String GERENCIAR_AGENCIAS =
           "/* --------------- GERENCIAR AGÊNCIAS --------------- */\n" +

            "Digite um comando para prosseguir:\n" +
                "C - Cadastrar uma agência\n" +
                "B - Buscar por uma agência específica\n" +
                "A - Atualizar os dados de uma agência\n" +
                "D - Deletar uma agência\n" +
                "L - Listar todas as agências\n" +
                "I - Importar agências\n" +
                "V - Voltar ao menu principal\n" +
         "\n/* -------------------------------------------------- */\n";


    public static final String CADASTRAR_AGENCIA = "";
    public static final String BUSCAR_AGENCIA = "";
    public static final String ATUALIZAR_AGENCIA = "";
    public static final String DELETAR_AGENCIA = "";
    public static final String LISTAR_AGENCIAS = "";
    public static final String IMPORTAR_AGENCIA = "";



    /* ----------------------------- CLIENTE ----------------------------- */


    public static final String GERENCIAR_CLIENTES =
          "/* --------------- GERENCIAR AGÊNCIAS --------------- */\n" +

            "Digite um comando para prosseguir:\n"+
                "C - Cadastrar um cliente\n"+
                "B - Buscar por um cliente específico\n"+
                "A - Atualizar os dados de um cliente\n"+
                "D - Deletar um cliente\n"+
                "L - Listar todos os clientes\n"+
                "I - Importar clientes\n"+
                "V - Voltar ao menu principal" +
        "\n/* -------------------------------------------------- */\n";;


    public static final String CADASTRAR_CLIENTE = "";
    public static final String IMPORTAR_CLIENTE = "";
    public static final String ATUALIZAR_CLIENTE = "";
    public static final String DELETAR_CLIENTE = "";
    public static final String BUSCAR_CLIENTE = "";
    public static final String LISTAR_CLIENTES = "";


    /* ----------------------------- CONTA ----------------------------- */


    public static final String GERENCIAR_CONTAS =
            "/* --------------- GERENCIAR CONTAS --------------- */\n" +

                    "Digite um comando para prosseguir:\n"+
                    "C - Cadastrar uma conta\n"+
                    "B - Buscar por uma conta específico\n"+
                    "A - Atualizar os dados de uma conta\n"+
                    "D - Deletar uma conta\n"+
                    "L - Listar todos as contas\n"+
                    "I - Importar contas\n"+
                    "V - Voltar ao menu principal" +
          "\n/* -------------------------------------------------- */\n";;


    public static final String CADASTRAR_CONTA = "";
    public static final String IMPORTAR_CONTA = "";
    public static final String ATUALIZAR_CONTA = "";
    public static final String DELETAR_CONTA = "";
    public static final String BUSCAR_CONTA = "";
    public static final String LISTAR_CONTAS = "";


     /* ----------------------------- EMPRESTIMOS/FINANCIAMENTOS ----------------------------- */


    public static final String GERENCIAR_EMPRESTIMOS =
            "/* --------------- GERENCIAR EMPRÉSTIMOS --------------- */\n" +

                    "Digite um comando para prosseguir:\n"+
                    "C - Cadastrar um empréstimo\n"+
                    "B - Buscar por um empréstimo específico\n"+
                    "A - Atualizar os dados de um empréstimo\n"+
                    "D - Deletar um empréstimo\n"+
                    "L - Listar todos os empréstimos\n"+
                    "I - Importar empréstimos\n"+
                    "V - Voltar ao menu principal" +
          "\n/* -------------------------------------------------- */\n";;


    public static final String CADASTRAR_EMPRESTIMO = "";
    public static final String IMPORTAR_EMPRESTIMO = "";
    public static final String ATUALIZAR_EMPRESTIMO = "";
    public static final String DELETAR_EMPRESTIMO = "";
    public static final String BUSCAR_EMPRESTIMO = "";
    public static final String LISTAR_EMPRESTIMOS = "";
}
