package bancuzim.enums;

public enum Entidade {
   AGENCIA("AGÊNCIA"), CLIENTE("CLIENTE"), CONTA("CONTA"), EMPRESTIMO("EMPRÉSTIMO");

    private String entidade;

    Entidade(String entidade) {
        this.entidade = entidade;
    }

    public String getEntidade() {
        return entidade;
    }

    public static boolean contains(String string) {

        for (Entidade entidade : Entidade.values()) {
            if (entidade.name().equals(string)) {
                return true;
            }
        }

        return false;
    }

    public static boolean notContains(String string) {

        for (Entidade entidade : Entidade.values()) {
            if (entidade.name().equals(string)) {
                return false;
            }
        }

        return true;
    }

}
