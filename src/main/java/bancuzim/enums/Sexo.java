package bancuzim.enums;

public enum Sexo {
    MASCULINO("MASCULINO"), FEMININO("FEMININO");

    private String sexo;

    Sexo(String sexo) {
        this.sexo = sexo;
    }

    public static boolean contains(String string) {

        for (Sexo sexo : Sexo.values()) {
            if (sexo.name().equals(string)) {
                return true;
            }
        }

        return false;
    }

    public static boolean notContains(String string) {

        for (Sexo sexo : Sexo.values()) {
            if (sexo.name().equals(string)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isMASCULINO(Sexo sexo) {
        return sexo.equals(MASCULINO);
    }

    public static boolean notMASCULINO(Sexo sexo) {
        return !sexo.equals(MASCULINO);
    }

    public static boolean isFEMININO(Sexo sexo) {
        return sexo.equals(FEMININO);
    }

    public static boolean notFEMININO(Sexo sexo) {
        return !sexo.equals(FEMININO);
    }

    public String getSexo() {
        return sexo;
    }


}
