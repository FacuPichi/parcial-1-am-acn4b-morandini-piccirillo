package com.example.poke_organizer;

import android.os.Parcelable;

import java.util.ArrayList;

public class UserData  {

    private String nombre;
    private String mail;
    private int lvl;
    private int exp;
    private int lastPokemon;
    private ArrayList<String> pokedex;
    private ArrayList<String> tareas;

    public UserData(String nombre, String   mail) {
        this.nombre = nombre;
        this.mail = mail;
        this.pokedex = new ArrayList<String>();
        this.tareas = new ArrayList<String>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getMail() {
        return mail;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getExp() {
        return exp;
    }

    public int getLastPokemon() {
        return lastPokemon;
    }

    public void setLastPokemon(int lastPokemon) {
        this.lastPokemon = lastPokemon;
    }

    public ArrayList<String> getPokedex() {
        return pokedex;
    }

    public void addPokemon(String pokemon) {
        if (this.pokedex == null) {
            this.pokedex = new ArrayList<String>();
            this.pokedex.add(pokemon);
        }
        this.pokedex.add(pokemon);
    }

    public ArrayList<String> getTarea() {
        return tareas;
    }

    public void setTarea(ArrayList<String> tarea){
        this.tareas = tarea;
    }


    public void addTarea(String tarea) {
        if (this.tareas == null) {
            this.tareas = new ArrayList<String>();
            this.tareas.add(tarea);
        }
        this.tareas.add(tarea);
    }

}
