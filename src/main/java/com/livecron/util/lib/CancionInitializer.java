package com.livecron.util.lib;

import com.livecron.util.lib.exception.SongFileNotFoundException;
import com.livecron.util.lib.model.Cancion;
import com.livecron.util.lib.model.Estrofa;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class CancionInitializer {

    /**
     * Convierte un txt que contiene una cancion en un objeto de tipo Canción
     * @param songFilePath
     * @return
     */
    public static Cancion nuevaCancion(String songFilePath){
        String song = getFormatedSong(songFilePath);
        List<Estrofa> estrofas = getEstrofas(song);
        return new Cancion(estrofas);
    }


    /**
     * Formatea el string de la cancion quitando saltos de linea innecesarios
     * @param songFilePath
     * @return
     */
    private static String getFormatedSong(String songFilePath) {
        String song=null;
        try {
            song = StringFile.fileToString(songFilePath);
        } catch (IOException e) {
            throw new SongFileNotFoundException();
        }
        song = song.trim();
        song = song.replaceAll("\n\n+","\n\n");
        return song;
    }

    /**
     * Separa las estrofas de una cancion tomando como critero que una estrofa
     * tiene dos saltos de linea seguidos
     * @param song
     * @return
     */
    private static List<Estrofa> getEstrofas(String song) {
        String [] parrafos = song.split("\n\n");
        List<Estrofa> estrofas = new LinkedList<>();


        for (String parrafo: parrafos
        ) {
            String [] versosArray = parrafo.split("\n");
            List<String> versos = new LinkedList<>( Arrays.asList(versosArray));
            Estrofa estrofa = new Estrofa(versos);
            estrofas.add(estrofa);
        }

        return estrofas;
    }
}
