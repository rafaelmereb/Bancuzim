package bancuzim.util;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class ValidadorCNPJTest {


    @Test
    public void testStringCom14CaracteresIguaisIsNotCNPJ() {
        //Incluindo todas as possibilidades num ArrayList:
        ArrayList<String> stringsCom14CaracteresIguais = new ArrayList<>();
        // O valor "00000000000000" é válido.
        stringsCom14CaracteresIguais.add("11111111111111");
        stringsCom14CaracteresIguais.add("22222222222222");
        stringsCom14CaracteresIguais.add("33333333333444");
        stringsCom14CaracteresIguais.add("44444444444555");
        stringsCom14CaracteresIguais.add("55555555555555");
        stringsCom14CaracteresIguais.add("66666666666666");
        stringsCom14CaracteresIguais.add("77777777777777");
        stringsCom14CaracteresIguais.add("88888888888888");
        stringsCom14CaracteresIguais.add("99999999999999");

        boolean todosInvalidos = true;
        for (String stringCom14CaracteresIguais : stringsCom14CaracteresIguais) {
            //Se algum for validado, o teste falha:
            if (ValidadorCNPJ.isCNPJ(stringCom14CaracteresIguais)) {
                todosInvalidos = false;
            }
        }
        assertTrue(todosInvalidos);
    }

    @Test
    public void testStringCnpjValidoIsCNPJ() {

        //Incluindo 10 cnpjs válidos aleatórios:
        ArrayList<String> cnpjs = new ArrayList<>();
        cnpjs.add("03443201000151");
        cnpjs.add("21631575000182");
        cnpjs.add("72431745000116");
        cnpjs.add("63011264000160");
        cnpjs.add("12418741000176");
        cnpjs.add("32556418000176");
        cnpjs.add("75944768000112");
        cnpjs.add("14393679000130");
        cnpjs.add("72386296000131");
        cnpjs.add("34865120000173");

        boolean todosValidos = true;
        for (String cnpj : cnpjs) {
            //Se algum for invalidado, o teste falha:
            if (!ValidadorCNPJ.isCNPJ(cnpj)) {
                todosValidos = false;
            }
        }
        assertTrue(todosValidos);
    }
}
