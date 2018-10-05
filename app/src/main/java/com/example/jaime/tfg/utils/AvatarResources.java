package com.example.jaime.tfg.utils;


import com.example.jaime.tfg.R;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Jaime on 21/01/2018.
 */

public final class AvatarResources {
    public static final Hashtable<Integer, Integer> avatarResourcesList = new Hashtable<Integer, Integer>() {{
        put(1, R.drawable.avatar_uno);
        put(7, R.drawable.avatar_siete);
        put(8, R.drawable.avatar_ocho);
        put(9, R.drawable.avatar_nueve);
        put(10, R.drawable.avatar_cero);

        put(11, R.drawable.avatar_sumar);
    }};

    public static final ArrayList<String> avatarStrings = new ArrayList<String>() {{
        add("Parece que tienes pocos puntos, ¿Qué te parece hacer algunos problemas?");
        add("Parece que tienes pocos puntos, ¿Qué te parece hacer algunoas operaciones?");
        add("¡Sigue haciendo ejercicios para mejorar!");
    }};
}
