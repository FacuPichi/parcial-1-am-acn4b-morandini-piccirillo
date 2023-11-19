package com.example.poke_organizer;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class JsonHandler {

    private static final String FILE_NAME = "user_data.json";

    // Método para guardar los datos en un archivo JSON
    public static void saveJsonData(Context context, UserData userData) {
        Gson gson = new Gson();
        String jsonData = gson.toJson(userData);

        try {
            FileOutputStream fileOutputStream = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fileOutputStream.write(jsonData.getBytes());
            fileOutputStream.close();
            Log.d("JsonHandler", "Datos guardados correctamente en " + FILE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para cargar los datos desde un archivo JSON
    public static UserData loadJsonData(Context context) {
        UserData userData = null;
        try {
            FileInputStream fileInputStream = context.openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            fileInputStream.close();

            Gson gson = new Gson();
            userData = gson.fromJson(stringBuilder.toString(), UserData.class);

            Log.d("JsonHandler", "Datos cargados correctamente desde " + FILE_NAME);
            Log.d("JsonHandler", "Nombre: " + userData.getNombre() +
                    ", Nivel: " + userData.getLvl() +
                    ", Experiencia: " + userData.getExp() +
                    ", Último Pokémon: " + userData.getLastPokemon());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userData;
    }

    // Método para actualizar los datos en el archivo JSON
    public static void updateJsonData(Context context, UserData userData) {
        saveJsonData(context, userData);
    }


}