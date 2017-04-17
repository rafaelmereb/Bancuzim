package bancuzim.util;

/**
 * Classe utilitária na definição dos menus apresentados nas Views.
 *
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


    /* ----------------------------------------- AGENCIA ----------------------------------------- */


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


    public static String CADASTRAR_AGENCIA = "\n/* ############### CADASTRAR AGÊNCIA ############### */";
    public static String BUSCAR_AGENCIA = "\n/* ############### BUSCAR AGÊNCIA ############### */";
    public static String ATUALIZAR_AGENCIA = "\n/* ############### ATUALIZAR AGÊNCIA ############### */";
    public static String DELETAR_AGENCIA = "\n/* ############### DELETAR AGÊNCIA ############### */";
    public static String LISTAR_AGENCIAS = "\n/* ############### LISTAR AGÊNCIAS ############### */";
    public static String IMPORTAR_AGENCIA = "\n/* ############### IMPORTAR AGÊNCIAS ############### */";


    /* ----------------------------------------- CLIENTE ----------------------------------------- */


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


    public static String CADASTRAR_CLIENTE = "\n/* ############### CADASTRAR CLIENTE ############### */";
    public static String IMPORTAR_CLIENTE = "\n/* ############### IMPORTAR CLIENTES ############### */";
    public static String ATUALIZAR_CLIENTE = "\n/* ############### ATUALIZAR CLIENTE ############### */";
    public static String DELETAR_CLIENTE = "\n/* ############### DELETAR CLIENTE ############### */";
    public static String BUSCAR_CLIENTE = "\n/* ############### BUSCAR CLIENTE ############### */";
    public static String LISTAR_CLIENTES = "\n/* ############### LISTAR CLIENTES ############### */";


    /* ----------------------------------------- CONTA ----------------------------------------- */


    public static String GERENCIAR_CONTAS =
            "\n/* ############### GERENCIAR CONTAS ############### */\n" +

                    "Digite um comando para prosseguir:\n" +
                    "C - Cadastrar uma conta\n" +
                    "B - Buscar por uma conta específico\n" +
                    "A - Atualizar os dados de uma conta\n" +
                    "D - Deletar uma conta\n" +
                    "L - Listar todos as contas\n" +
                    "I - Importar contas\n" +
                    "V - Voltar ao menu principal" +
                    "\n/* -------------------------------------------------- */";


    public static String CADASTRAR_CONTA = "\n/* ############### CADASTRAR CONTA ############### */";
    public static String IMPORTAR_CONTA = "\n/* ############### IMPORTAR CONTAS ############### */";
    public static String ATUALIZAR_CONTA = "\n/* ############### ATUALIZAR CONTA ############### */";
    public static String DELETAR_CONTA = "\n/* ############### DELETAR CONTA ############### */";
    public static String BUSCAR_CONTA = "\n/* ############### BUSCAR CONTA ############### */";
    public static String LISTAR_CONTAS = "\n/* ############### LISTAR CONTAS ############### */";


     /* ----------------------------------------- EMPRESTIMOS/FINANCIAMENTOS ----------------------------------------- */


    public static String GERENCIAR_EMPRESTIMOS =
            "\n/* ############### GERENCIAR EMPRÉSTIMOS ############### */\n" +

                    "Digite um comando para prosseguir:\n" +
                    "C - Cadastrar um empréstimo\n" +
                    "B - Buscar por um empréstimo específico\n" +
                    "A - Atualizar os dados de um empréstimo\n" +
                    "D - Deletar um empréstimo\n" +
                    "L - Listar todos os empréstimos\n" +
                    "I - Importar empréstimos\n" +
                    "V - Voltar ao menu principal" +
                    "\n/* -------------------------------------------------- */";


    public static String CADASTRAR_EMPRESTIMO = "\n/* ############### CADASTRAR EMPRÉSTIMO ############### */";
    public static String IMPORTAR_EMPRESTIMO = "\n/* ############### IMPORTAR EMPRÉSTIMOS ############### */";
    public static String ATUALIZAR_EMPRESTIMO = "\n/* ############### ATUALIZAR EMPRÉSTIMO ############### */";
    public static String DELETAR_EMPRESTIMO = "\n/* ############### DELETAR EMPRÉSTIMO ############### */";
    public static String BUSCAR_EMPRESTIMO = "\n/* ############### BUSCAR EMPRÉSTIMO ############### */";
    public static String LISTAR_EMPRESTIMOS = "\n/* ############### LISTAR EMPRÉSTIMOS ############### */";
}
