package com.livecron.util.lib.model;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Estrofa {
    private List<String> versos;

    public Estrofa(List<String> versos){
        this.versos = versos;
    }

    public void remplazarPalabraEnEstrofa(String palabraAnterior, String nuevaPalabra){
        List<String> nuevosVersos = new LinkedList<>();
        versos.forEach(versos ->{
            String verso = versos.replaceAll(palabraAnterior,nuevaPalabra);
            nuevosVersos.add(verso);
        } );
        this.versos = nuevosVersos;
    }

    public String toString() {
        return String.join("\n",this.versos);
    }
}
