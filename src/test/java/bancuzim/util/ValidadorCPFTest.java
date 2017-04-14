package bancuzim.util;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class ValidadorCPFTest {

    @Test
    public void testStringCom11CaracteresIguaisIsNotCPF() {
        //Incluindo todas as possibilidades num ArrayList:
        ArrayList<String> stringsCom11CaracteresIguais = new ArrayList<>();
        stringsCom11CaracteresIguais.add("00000000000");
        stringsCom11CaracteresIguais.add("11111111111");
        stringsCom11CaracteresIguais.add("22222222222");
        stringsCom11CaracteresIguais.add("33333333333");
        stringsCom11CaracteresIguais.add("44444444444");
        stringsCom11CaracteresIguais.add("55555555555");
        stringsCom11CaracteresIguais.add("66666666666");
        stringsCom11CaracteresIguais.add("77777777777");
        stringsCom11CaracteresIguais.add("88888888888");
        stringsCom11CaracteresIguais.add("99999999999");

        boolean todosInvalidos = true;
        for (String stringCom11CaracteresIguais : stringsCom11CaracteresIguais) {
            //Se algum for validado, o teste falha:
            if (ValidadorCPF.isCPF(stringCom11CaracteresIguais)) {
                todosInvalidos = false;
            }
        }
        assertTrue(todosInvalidos);
    }

    @Test
    public void testStringCpfValidoIsCPF() {

        //Incluindo 10 cpfs válidos aleatórios:
        ArrayList<String> cpfs = new ArrayList<>();
        cpfs.add("88638629826");
        cpfs.add("42751838863");
        cpfs.add("17477652103");
        cpfs.add("18656024426");
        cpfs.add("47678800177");
        cpfs.add("00688659705");
        cpfs.add("03773221800");
        cpfs.add("68007088369");
        cpfs.add("83821185503");
        cpfs.add("74207349413");

        boolean todosValidos = true;
        for (String cpf : cpfs) {
            //Se algum for invalidado, o teste falha:
            if (!ValidadorCPF.isCPF(cpf)) {
                todosValidos = false;
            }
        }
        assertTrue(todosValidos);
    }
}
