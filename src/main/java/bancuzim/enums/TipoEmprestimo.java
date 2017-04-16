package bancuzim.enums;

public enum TipoEmprestimo {
    PESSOAL("PESSOAL"), IMOVEL("IMOVEL"), VEICULO("VEICULO");


    public String tipoEmprestimo;

    TipoEmprestimo(String tipoConta) {
        this.tipoEmprestimo = tipoConta;
    }

    public String getTipoEmprestimo() {
        return tipoEmprestimo;
    }


    public static boolean contains(String string) {

        for (TipoEmprestimo tipoEmprestimo : TipoEmprestimo.values()) {
            if (tipoEmprestimo.name().equals(string)) {
                return true;
            }
        }

        return false;
    }

    public static boolean notContains(String string) {

        for (TipoEmprestimo tipoEmprestimo : TipoEmprestimo.values()) {
            if (tipoEmprestimo.name().equals(string)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPESSOAL(TipoEmprestimo tipoConta){
        return tipoConta.equals(TipoEmprestimo.PESSOAL);
    }

    public static boolean notPESSOAL(TipoEmprestimo tipoConta){
        return !tipoConta.equals(TipoEmprestimo.PESSOAL);
    }

    public static boolean isIMOVEL(TipoEmprestimo tipoConta){
        return tipoConta.equals(TipoEmprestimo.IMOVEL);
    }

    public static boolean notIMOVEL(TipoEmprestimo tipoConta){
        return !tipoConta.equals(TipoEmprestimo.IMOVEL);
    }

    public static boolean isVEICULO(TipoEmprestimo tipoConta){
        return tipoConta.equals(TipoEmprestimo.VEICULO);
    }

    public static boolean notVEICULO(TipoEmprestimo tipoConta){
        return !tipoConta.equals(TipoEmprestimo.VEICULO);
    }
}
