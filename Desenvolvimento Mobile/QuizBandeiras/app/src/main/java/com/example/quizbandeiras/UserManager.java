package com.example.quizbandeiras;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class UserManager {

    // Manipulação de preferências(dados de cache)
    private static final String PREFS_NAME = "UserPrefs";
    private static final String PREF_ID = "UserId";
    private static final String PREF_POINTS = "UserPoints";

    // Método para salvar o nome do usuário
    public static void saveUsername(Context context, String userId, String username) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(userId, username);
        editor.apply();
    }

    // Método para recuperar o nome do usuário
    public static String getUsername(Context context, String userId) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        return prefs.getString(userId, "");
    }

    //Método para salver o id do usuário
    public static void saveUserId(Context context, String id) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_ID, MODE_PRIVATE).edit();
        editor.putString(PREF_ID, id);
        editor.apply();
    }

    //Método para recuperar o id mais recente criado
    public static int loadId(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_ID, MODE_PRIVATE);
        return Integer.parseInt(prefs.getString(PREF_ID, "0"));// Retorna 0 se o valor não estiver definido
    }

    //Método para salvar os pontos do usuário
    public static void saveUserPoints(Context context, String id, int pontos){
        String stringPontos = String.valueOf(pontos);
        id += "_pontos";
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_POINTS, MODE_PRIVATE).edit();
        editor.putString(id, stringPontos);
        editor.apply();
    }

    //Método para recuperar os pontos feitos pelo usuário
    public static String loadUserPoints(Context context, String id){
        id += "_pontos";
        SharedPreferences prefs = context.getSharedPreferences(PREF_POINTS, MODE_PRIVATE);
        return prefs.getString(id,"0"); // Retorna 0 se o valor não estiver definido
    }

    //Método para juntar o usuário e os pontos e devolver todos juntos
    public static Map<String, Integer> getAllUsersWithPoints(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_POINTS, Context.MODE_PRIVATE);
        Map<String, Integer> usersWithPoints = new HashMap<>();

        // Percorre todas as preferências compartilhadas
        Map<String, ?> allEntries = prefs.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            String key = entry.getKey();
            String value = (String) entry.getValue();

            // Verifica se a chave é referente aos pontos de um usuário
            if (key.endsWith("_pontos")) {
                // Extrai o ID do usuário
                String userId = key.substring(0, key.indexOf("_pontos"));

                // Converte o valor para inteiro e o adiciona ao mapa
                int points = Integer.parseInt(value);
                usersWithPoints.put(userId, points);
            }
        }
        return usersWithPoints;
    }

    //MÉTODO DE ADMINISTRAÇÃO

    //Método para reiniciar todas as preferencias(essencialmente reiniciando o ranking)
    public static void clearAllPreferences(Context context) {
        SharedPreferences prefsName = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editorName = prefsName.edit();
        editorName.clear();
        editorName.apply();

        SharedPreferences prefsId = context.getSharedPreferences(PREF_ID, MODE_PRIVATE);
        SharedPreferences.Editor editorId = prefsId.edit();
        editorId.clear();
        editorId.apply();

        SharedPreferences prefsPoints = context.getSharedPreferences(PREF_POINTS, MODE_PRIVATE);
        SharedPreferences.Editor editorPoints = prefsPoints.edit();
        editorPoints.clear();
        editorPoints.apply();
    }
}
