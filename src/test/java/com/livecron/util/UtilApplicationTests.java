package com.livecron.util;

import com.livecron.util.lib.StringFile;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//@SpringBootTest
class UtilApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test() throws IOException {

        String cadena = StringFile.fileToString("./src/test/resources/Original.txt");
        cadena = cadena.trim();
        cadena = cadena.replaceAll("\n\n+","\n\n");
        String [] parrafos = cadena.split("\\s+|,|\\.|;");
        String [] parrafos2 = StringUtils.tokenizeToStringArray(cadena,"\n",true,true);

    }

    @Test
    public void joinTest(){
        List<String> list = new LinkedList<>(Arrays.asList("hola mundo","mundial"));
        String result = String.join("",list);
    }


}
