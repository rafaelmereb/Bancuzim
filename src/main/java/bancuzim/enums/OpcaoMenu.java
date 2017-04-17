package bancuzim.enums;

public enum OpcaoMenu {
    A("A"), B("B"), C("C"), D("D"), E("E"), L("L"), I("I"), S("S"), V("V"), CONTINUE("CONTINUE");

    private String opcao;

    OpcaoMenu(String opcaoMenu) {
        this.opcao = opcaoMenu;
    }

    public String getOpcao() {
        return opcao;
    }

    public static boolean contains(String string) {

        for (OpcaoMenu opcao : OpcaoMenu.values()) {
            if (opcao.name().equals(string)) {
                return true;
            }
        }

        return false;
    }

    public static boolean notContains(String string) {

        for (OpcaoMenu opcao : OpcaoMenu.values()) {
            if (opcao.name().equals(string)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isA(OpcaoMenu opcao){
        return opcao.equals(A);
    }

    public static boolean notA(OpcaoMenu opcao){
        return !opcao.equals(A);
    }

    public static boolean isB(OpcaoMenu opcao){
        return opcao.equals(B);
    }

    public static boolean notB(OpcaoMenu opcao){
        return !opcao.equals(B);
    }

    public static boolean isC(OpcaoMenu opcao){
        return opcao.equals(C);
    }

    public static boolean notC(OpcaoMenu opcao){
        return !opcao.equals(C);
    }

    public static boolean isD(OpcaoMenu opcao){
        return opcao.equals(D);
    }

    public static boolean notD(OpcaoMenu opcao){
        return !opcao.equals(D);
    }

    public static boolean isE(OpcaoMenu opcao){
        return opcao.equals(E);
    }

    public static boolean notE(OpcaoMenu opcao){
        return !opcao.equals(E);
    }

    public static boolean isL(OpcaoMenu opcao){
        return opcao.equals(L);
    }

    public static boolean notL(OpcaoMenu opcao){
        return !opcao.equals(L);
    }

    public static boolean isI(OpcaoMenu opcao){
        return opcao.equals(I);
    }

    public static boolean notI(OpcaoMenu opcao){
        return !opcao.equals(I);
    }

    public static boolean isVoltar(OpcaoMenu opcao){
        return opcao.equals(V);
    }

    public static boolean notVoltar(OpcaoMenu opcao){
        return !opcao.equals(V);
    }

    public static boolean isSair(OpcaoMenu opcao){
        return opcao.equals(S);
    }

    public static boolean notSair(OpcaoMenu opcao){
        return !opcao.equals(S);
    }

}
