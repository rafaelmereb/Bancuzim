package bancuzim.enums;

public enum Operacao {
    CADASTRAR("CADASTRAR"), BUSCAR("BUSCAR"), ATUALIZAR("ATUALIZAR"), DELETAR("DELETAR"), IMPORTAR("IMPORTAR"), LISTAR_TODOS("LISTAR TODOS");

    public String operacao;

    Operacao(String operacao) {
        this.operacao = operacao;
    }

    public String getEntidade() {
        return operacao;
    }

    public static boolean contains(String string) {

        for (Operacao operacao : Operacao.values()) {
            if (operacao.name().equals(string)) {
                return true;
            }
        }

        return false;
    }

    public static boolean notContains(String string) {

        for (Operacao operacao : Operacao.values()) {
            if (operacao.name().equals(string)) {
                return false;
            }
        }

        return true;
    }
}
