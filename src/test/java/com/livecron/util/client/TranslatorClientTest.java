package com.livecron.util.client;

import com.livecron.util.lib.StringFile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TranslatorClientTest {

    @Value("${archivo_statistics}")
    private String archivoStatistics;
    @Value("${archivo_estrofas_orden_inverso}")
    private String archivoEstrofasRevertidas;
    @Value("${archivo_final_output}")
    private String archivoFinal;


    private String textoStatisticsEsperado ="Número de estrofas: 2\n" +
            "Palabra mas repetida: Y";

    private String textoEstrofasOrdenInversoEsperado ="se despidió\n" +
            "Y decidió batirse en duelo con el mar\n" +
            "Y recorrer el mundo en su velero\n" +
            "Y navegar, nai-na-nai\n" +
            "Navegar\n" +
            "\n" +
            "Ayer se fue\n" +
            "Tomó sus cosas y se puso a navegar\n" +
            "Una camisa, un pantalón vaquero\n" +
            "Y una canción, ¿dónde irá?\n" +
            "¿Dónde irá?";

    private String textoFinalEsperado ="se despidió\n" +
            "you decidió batirse en duelo con el mar\n" +
            "you recorrer el mundo en su velero\n" +
            "you navegar, nai-na-nai\n" +
            "Navegar\n" +
            "\n" +
            "Ayer se fue\n" +
            "Tomó sus cosas y se puso a navegar\n" +
            "Una camisa, un pantalón vaquero\n" +
            "you una canción, ¿dónde irá?\n" +
            "¿Dónde irá?";

    @Test
    void realizarLaboratorio12() throws IOException {
        TranslatorClient.realizarLaboratorio12();
        assertTrue(new File(archivoStatistics).exists());
        assertTrue(new File(archivoFinal).exists());
        assertTrue(new File(archivoEstrofasRevertidas).exists());

        String txtStatisticsObtenido = StringFile.fileToString(archivoStatistics);
        String txtRevertidoObtenido = StringFile.fileToString(archivoEstrofasRevertidas);
        String txtFinalObtenido = StringFile.fileToString(archivoFinal);

        assertEquals(txtStatisticsObtenido, textoStatisticsEsperado);
        assertEquals(txtRevertidoObtenido, textoEstrofasOrdenInversoEsperado);
        assertEquals(txtFinalObtenido, textoFinalEsperado);
    }
}