package sample.Juego;

import sample.Juego.Cartas.Carta;
import sample.Juego.Cartas.Esbirro;
import sample.Juego.Cartas.Hechizos.ArmaOculta;
import sample.Juego.Cartas.Hechizos.Bendicion;
import sample.Juego.Cartas.Hechizos.Calamidad;

import java.lang.reflect.Array;

public class InventarioCartas {
    private Carta head = null;
    private int size = 0;

    public InventarioCartas() {
        if (head == null){
            Esbirro Jorge = new Esbirro(60,"Esbirro/Jorge.png",0);
            this.head = Jorge;
            Esbirro Basilisco = new Esbirro(30,"Esbirro/Basilisco.png",20);
            Jorge.setNext(Basilisco);
            Esbirro Cuernohendido = new Esbirro(20,"Esbirro/Cuernohendido.png",20);
            Basilisco.setNext(Cuernohendido);
            Esbirro Elemental = new Esbirro(30,"Esbirro/Elemental.png",25);
            Cuernohendido.setNext(Elemental);
            Esbirro Espectro = new Esbirro(10,"Esbirro/Espectro.png",10);
            Elemental.setNext(Espectro);
            Esbirro Gallotriz = new Esbirro(20,"Esbirro/Gallotriz.png",15);
            Espectro.setNext(Gallotriz);
            Esbirro Ghul = new Esbirro(20,"Esbirro/Ghul.png",10);
            Gallotriz.setNext(Ghul);
            Esbirro Golem = new Esbirro(30,"Esbirro/Gólem.png",30);
            Ghul.setNext(Golem);
            Esbirro Katakans = new Esbirro(40,"Esbirro/Katakans.png",30);
            Golem.setNext(Katakans);
            Esbirro Lobo = new Esbirro(20,"Esbirro/Lobo.png",15);
            Katakans.setNext(Lobo);
            Esbirro LordSapo = new Esbirro(20,"Esbirro/LordSapo.png",15);
            Lobo.setNext(LordSapo);
            Esbirro Sabueso = new Esbirro(10,"Esbirro/Sabueso.png",15);
            LordSapo.setNext(Sabueso);
            Esbirro Sirena = new Esbirro(20,"Esbirro/Sirena.png",25);
            Sabueso.setNext(Sirena);
            Esbirro Wyvern = new Esbirro(20,"Esbirro/Wyvern.png",15);
            Sirena.setNext(Wyvern);
            Esbirro WyvernAlfa = new Esbirro(20,"Esbirro/WyvernAlfa.png",15);
            Wyvern.setNext(WyvernAlfa);
            ArmaOculta Arma = new ArmaOculta(30, "Hechizo/Arma.png");
            Wyvern.setNext(Arma);
            Bendicion Bendicion = new Bendicion(20, "Hechizo/Bendicion.png");
            Arma.setNext(Bendicion);
            Calamidad Calamidad = new Calamidad(20, "Hechizo/Calamidad.png");
            Bendicion.setNext(Calamidad);
            this.size = 41;

        }
    }
}
