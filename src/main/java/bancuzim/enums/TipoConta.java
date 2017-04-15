package bancuzim.enums;

public enum TipoConta {
    POUPANCA("POUPANCA"), CORRENTE("CORRENTE"), SALARIO("SALARIO");


    public String tipoConta;

    TipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }


    public static boolean contains(String string) {

        for (TipoConta tipoConta : TipoConta.values()) {
            if (tipoConta.name().equals(string)) {
                return true;
            }
        }

        return false;
    }

    public static boolean notContains(String string) {

        for (TipoConta tipoConta : TipoConta.values()) {
            if (tipoConta.name().equals(string)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPOUPANCA(TipoConta tipoConta){
        return tipoConta.equals(TipoConta.POUPANCA);
    }

    public static boolean notPOUPANCA(TipoConta tipoConta){
        return !tipoConta.equals(TipoConta.POUPANCA);
    }

    public static boolean isCORRENTE(TipoConta tipoConta){
        return tipoConta.equals(TipoConta.CORRENTE);
    }

    public static boolean notCORRENTE(TipoConta tipoConta){
        return !tipoConta.equals(TipoConta.CORRENTE);
    }

    public static boolean isSALARIO(TipoConta tipoConta){
        return tipoConta.equals(TipoConta.SALARIO);
    }

    public static boolean notSALARIO(TipoConta tipoConta){
        return !tipoConta.equals(TipoConta.SALARIO);
    }
}
