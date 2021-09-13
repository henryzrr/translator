package com.livecron.util.lib.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Cancion {

    private List<Estrofa> estrofas;

    public Cancion(List<Estrofa> estrofas) {
        this.estrofas = estrofas;
    }

    public int numeroEstrofas(){
        return this.estrofas.size();
    }

    public void remplazarPalabraEnEstrofas(String palabraAnterior, String palabraNueva){
       estrofas.forEach(estrofa -> estrofa.remplazarPalabraEnEstrofa(palabraAnterior,palabraNueva));
    }

    public String toString() {
        String cancionTextoPlano="";
        for (Estrofa estrofa: this.estrofas
        ) {
            cancionTextoPlano =cancionTextoPlano+ estrofa.toString()+"\n\n";
        }
        return cancionTextoPlano.trim();
    }


}
