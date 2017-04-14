package bancuzim.util;

/**
 * Classe utilitária na definição dos menus apresentados nas Views.
 * TODO: FINALIZAR DEMAIS MENUS
 * @author Rafael
 */
public final class Menu {

    private Menu() {
    }

    public static String INICIAL =
            "\n/* ############### BANCUZIM ############### */\n" +

            "Olá, bem vindo ao Bancuzim!\n" +
                    "Digite um comando para prosseguir:\n" +
                    "A - Gerenciar agências\n" +
                    "B - Gerenciar clientes\n" +
                    "C - Gerenciar contas\n" +
                    "E - Gerenciar empréstimos/financiamentos\n" +
                    "S - Sair";

    public static String GERENCIAR_AGENCIAS =
            "\n/* ############### GERENCIAR AGÊNCIAS ############### */\n" +

                    "Digite um comando para prosseguir:\n" +
                    "C - Cadastrar uma agência\n" +
                    "B - Buscar por uma agência específica\n" +
                    "A - Atualizar os dados de uma agência\n" +
                    "D - Deletar uma agência\n" +
                    "L - Listar todas as agências\n" +
                    "I - Importar agências\n" +
                    "V - Voltar ao menu principal\n" +
                    "\n/* -------------------------------------------------- */";



    /* ----------------------------------------- AGENCIA ----------------------------------------- */

    public static String CADASTRAR_AGENCIA ="\n/* ############### CADASTRAR AGÊNCIA ############### */\n";
    public static String BUSCAR_AGENCIA ="" ;
    public static String ATUALIZAR_AGENCIA = "";
    public static String DELETAR_AGENCIA = "";
    public static String LISTAR_AGENCIAS = "";
    public static String IMPORTAR_AGENCIA = "";
    public static String GERENCIAR_CLIENTES =
            "\n/* ############### GERENCIAR CLIENTES ############### */\n" +

                    "Digite um comando para prosseguir:\n" +
                    "C - Cadastrar um cliente\n" +
                    "B - Buscar por um cliente específico\n" +
                    "A - Atualizar os dados de um cliente\n" +
                    "D - Deletar um cliente\n" +
                    "L - Listar todos os clientes\n" +
                    "I - Importar clientes\n" +
                    "V - Voltar ao menu principal" +
                    "\n/* -------------------------------------------------- */";




    /* ----------------------------------------- CLIENTE ----------------------------------------- */

    public static String CADASTRAR_CLIENTE = "";
    public static String IMPORTAR_CLIENTE = "";
    public static String ATUALIZAR_CLIENTE = "";
    public static String DELETAR_CLIENTE = "";
    public static String BUSCAR_CLIENTE = "";
    public static String LISTAR_CLIENTES = "";
    public static String GERENCIAR_CONTAS =
            "/* ############### GERENCIAR CONTAS ############### */\n" +

                    "Digite um comando para prosseguir:\n" +
                    "C - Cadastrar uma conta\n" +
                    "B - Buscar por uma conta específico\n" +
                    "A - Atualizar os dados de uma conta\n" +
                    "D - Deletar uma conta\n" +
                    "L - Listar todos as contas\n" +
                    "I - Importar contas\n" +
                    "V - Voltar ao menu principal" +
                    "\n/* -------------------------------------------------- */";


    /* ----------------------------------------- CONTA ----------------------------------------- */

    public static String CADASTRAR_CONTA = "";
    public static String IMPORTAR_CONTA = "";
    public static String ATUALIZAR_CONTA = "";
    public static String DELETAR_CONTA = "";
    public static String BUSCAR_CONTA = "";
    public static String LISTAR_CONTAS = "";
    public static String GERENCIAR_EMPRESTIMOS =
            "/* ############### GERENCIAR EMPRÉSTIMOS ############### */\n" +

                    "Digite um comando para prosseguir:\n" +
                    "C - Cadastrar um empréstimo\n" +
                    "B - Buscar por um empréstimo específico\n" +
                    "A - Atualizar os dados de um empréstimo\n" +
                    "D - Deletar um empréstimo\n" +
                    "L - Listar todos os empréstimos\n" +
                    "I - Importar empréstimos\n" +
                    "V - Voltar ao menu principal" +
                    "\n/* -------------------------------------------------- */";


     /* ----------------------------------------- EMPRESTIMOS/FINANCIAMENTOS ----------------------------------------- */

    public static String CADASTRAR_EMPRESTIMO = "";
    public static String IMPORTAR_EMPRESTIMO = "";
    public static String ATUALIZAR_EMPRESTIMO = "";
    public static String DELETAR_EMPRESTIMO = "";
    public static String BUSCAR_EMPRESTIMO = "";
    public static String LISTAR_EMPRESTIMOS = "";

}
