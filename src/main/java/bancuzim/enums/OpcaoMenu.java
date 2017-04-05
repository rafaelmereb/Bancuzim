package bancuzim.enums;

public enum OpcaoMenu {
    A("A"), B("B"), C("C"), D("D"), E("E"), L("L"), I("I"), S("S"), V("V"), CONTINUE("CONTINUE");

    public String opcao;

    OpcaoMenu(String opcaoMenu) {
        this.opcao = opcaoMenu;
    }

    public String getOpcao() {
        return opcao;
    }
}
