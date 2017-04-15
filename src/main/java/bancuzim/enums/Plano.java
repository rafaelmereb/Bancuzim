package bancuzim.enums;

public enum Plano {
    SILVER("SILVER"), GOLD("GOLD"), DIAMOND("DIAMOND");

    public String plano;

    Plano(String plano) {
        this.plano = plano;
    }

    public String getPlano() {
        return plano;
    }


    public static boolean contains(String string) {

        for (Plano plano : Plano.values()) {
            if (plano.name().equals(string)) {
                return true;
            }
        }

        return false;
    }

    public static boolean notContains(String string) {

        for (Plano plano : Plano.values()) {
            if (plano.name().equals(string)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSILVER(Plano plano){
        return plano.equals(Plano.SILVER);
    }

    public static boolean notSILVER(Plano plano){
        return !plano.equals(Plano.SILVER);
    }

    public static boolean isGOLD(Plano plano){
        return plano.equals(Plano.GOLD);
    }

    public static boolean notGOLD(Plano plano){
        return !plano.equals(Plano.GOLD);
    }

    public static boolean isDIAMOND(Plano plano){
        return plano.equals(Plano.DIAMOND);
    }

    public static boolean notDIAMOND(Plano plano){
        return !plano.equals(Plano.DIAMOND);
    }
}
