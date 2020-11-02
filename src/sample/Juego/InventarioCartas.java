package sample.Juego;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import sample.Juego.Cartas.Carta;
import sample.Juego.Cartas.Esbirro;
import sample.Juego.Cartas.Hechizos.*;
import sample.Juego.Cartas.Secretos.*;

import java.lang.reflect.Array;

public class InventarioCartas {
    public static InventarioCartas instance = null;
    private Carta head = null;
    private int size = 0;

    public static InventarioCartas getInstance(){
        if (instance == null){
            instance = new InventarioCartas();
        }
        return instance;
    }
    private InventarioCartas() {
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
            WyvernAlfa.setNext(Arma);
            Bendicion Bendicion = new Bendicion(20, "Hechizo/Bendicion.png");
            Arma.setNext(Bendicion);
            Calamidad Calamidad = new Calamidad(20, "Hechizo/Calamidad.png");
            Bendicion.setNext(Calamidad);
            CeroAbsoluto CeroAbsoluto = new CeroAbsoluto(40,"Hechizo/Cero.png");
            Calamidad.setNext(CeroAbsoluto);
            Codicia Codicia = new Codicia(0,"Hechizo/Codicia.png");
            CeroAbsoluto.setNext(Codicia);
            Curacion Curacion = new Curacion(10,"Hechizo/Curacion.png");
            Codicia.setNext(Curacion);
            EspadaMaldita EspadaMaldita = new EspadaMaldita(40,"Hechizo/Espada.png");
            Curacion.setNext(EspadaMaldita);
            Maldicion Maldicion = new Maldicion(40,"Hechizo/Maldicion.png");
            EspadaMaldita.setNext(Maldicion);
            PoderSupremo PoderSupremo = new PoderSupremo(50,"Hechizo/Poder.png");
            Maldicion.setNext(PoderSupremo);
            ReglasAntiguas ReglasAntiguas = new ReglasAntiguas(10,"Hechizo/Reglas.png");
            PoderSupremo.setNext(ReglasAntiguas);
            Relampago Relampago = new Relampago(10,"Hechizo/Relampago.png");
            ReglasAntiguas.setNext(Relampago);
            Robar Robar = new Robar(0,"Hechizo/Robar.png");
            Relampago.setNext(Robar);
            SacrificioSangre SacrificioSangre = new SacrificioSangre(0,"Hechizo/Sacrificio.png");
            Robar.setNext(SacrificioSangre);
            TratoJusto TratoJusto = new TratoJusto(50,"Hechizo/Trato.png");
            SacrificioSangre.setNext(TratoJusto);
            VaporGeiser VaporGeiser = new VaporGeiser(10,"Hechizo/Vapor.png");
            TratoJusto.setNext(VaporGeiser);
            Apaciguar Apaciguar = new Apaciguar(10,"Secreto/Apaciguar.png");
            VaporGeiser.setNext(Apaciguar);
            ArmasJorge ArmasJorge = new ArmasJorge(0,"Secreto/ArmasJorge.png");
            Apaciguar.setNext(ArmasJorge);
            BarreraDrenadora BarreraDrenadora = new BarreraDrenadora(30,"Secreto/BarreraD.png");
            ArmasJorge.setNext(BarreraDrenadora);
            Compasion Compasion = new Compasion(10,"Secreto/Compasion.png");
            BarreraDrenadora.setNext(Compasion);
            Contrataque Contrataque = new Contrataque(10,"Secreto/Contrataque.png");
            Compasion.setNext(Contrataque);
            Escudo Escudo = new Escudo(20,"Secreto/Escudo.png");
            Contrataque.setNext(Escudo);
            FuenteMana FuenteMana = new FuenteMana(10,"Secreto/Fuente.png");
            Escudo.setNext(FuenteMana);
            GranBarrera GranBarrera = new GranBarrera(40,"Secreto/GBarrera.png");
            FuenteMana.setNext(GranBarrera);
            Mimic Mimic = new Mimic(20,"Secreto/Mimic.png");
            GranBarrera.setNext(Mimic);
            Vacio Vacio = new Vacio(30,"Secreto/Vacio.png");
            Mimic.setNext(Vacio);
            Carta Incognita = new Carta(0,"Secretos/Secreto/Incognita.png");
            Vacio.setNext(Incognita);
            this.size = 41;
        }
    }
    public Carta buscar (int valor){
        Carta current = this.head;
        for(int i=0 ; i < this.size;i++){
            if (i == valor){
                break;
            }
            current = current.getNext();
        }
        return current;
    }

    }
