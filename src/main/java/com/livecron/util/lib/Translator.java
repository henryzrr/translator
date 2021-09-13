package com.livecron.util.lib;

import com.livecron.util.lib.model.Cancion;
import com.livecron.util.lib.model.Estrofa;
import lombok.SneakyThrows;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Translator {


    public static Cancion songTxtToCancion(String songFilePath){
        return CancionInitializer.nuevaCancion(songFilePath);
    }

    public static void reversaEstrofasCancion(Cancion cancion){
        List<Estrofa> estrofas = cancion.getEstrofas();
        Collections.reverse(estrofas);
    }

    @SneakyThrows
    public static  void cancionToTxt(Cancion cancion,String filePath){
        String cancionTextoPlano = cancion.toString();
        StringFile.stringToFile(cancionTextoPlano,filePath);
    }

    public static int numeroEstrofas(Cancion cancion){
        return cancion.numeroEstrofas();
    }

    public static String palabraMasRepetida(Cancion cancion){
        Map<String,Integer> repeticionPalabras = new HashMap<>();
        int nroRepetidoMayor  = 0;
        String palabraMasRepetida = null;

        String cancionTxt = cancion.toString();
        String [] palabras = cancionTxt.split("[\\s+,\\.;¿?!¡]");

        Integer repeticiones;
        for (String palabra: palabras
             ) {
            if(palabra.equals("")) continue;
            repeticiones = repeticionPalabras.get(palabra);
            if(repeticiones==null){
                repeticiones = 0;
            }
            repeticionPalabras.put(palabra,++repeticiones);
            if(nroRepetidoMayor<repeticiones){
                nroRepetidoMayor = repeticiones;
                palabraMasRepetida = palabra;
            }
        }

        return palabraMasRepetida;
    }

    public static void remplazarPalabra(Cancion cancion,String palabraAnterior, String nuevaPalabra){
        cancion.remplazarPalabraEnEstrofas(palabraAnterior,nuevaPalabra);
    }



}
