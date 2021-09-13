package com.livecron.util.client;


import com.livecron.util.lib.StringFile;
import com.livecron.util.lib.Translator;
import com.livecron.util.lib.model.Cancion;

import java.io.IOException;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class TranslatorClient {


    public static void realizarLaboratorio12() throws IOException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        final String ARCHIVO_ORIGINAL = resourceBundle.getString("archivo_original");
        final String ARCHIVO_ESTROFAS_ORDEN_INVERSO = resourceBundle.getString("archivo_estrofas_orden_inverso");
        final String ARCHIVO_STATISTICS = resourceBundle.getString("archivo_statistics");
        final String ARCHIVO_FINAL_OUTPUT = resourceBundle.getString("archivo_final_output");


        Cancion cancion = Translator.songTxtToCancion(ARCHIVO_ORIGINAL);
        Translator.reversaEstrofasCancion(cancion);
        Translator.cancionToTxt(cancion,ARCHIVO_ESTROFAS_ORDEN_INVERSO);
        cancion = Translator.songTxtToCancion(ARCHIVO_ESTROFAS_ORDEN_INVERSO);
        int nroEstrofas = Translator.numeroEstrofas(cancion);
        String palabraMasRepetida = Translator.palabraMasRepetida(cancion);
        String textoStatistics = "Número de estrofas: "+nroEstrofas+"\nPalabra mas repetida: "+palabraMasRepetida;
        StringFile.stringToFile(textoStatistics,ARCHIVO_STATISTICS);
        Translator.remplazarPalabra(cancion,palabraMasRepetida,"you");
        Translator.cancionToTxt(cancion,ARCHIVO_FINAL_OUTPUT);
    }
}
