package bancuzim.enums;

public enum OpcaoMenu {
    A("A"), B("B"), C("C"), D("D"), E("E"), L("L"), I("I"), S("S"), V("V"), CONTINUE("CONTINUE");

    public String opcao;

    OpcaoMenu(String opcaoMenu) {
        this.opcao = opcaoMenu;
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

    public String getOpcao() {
        return opcao;
    }

}
