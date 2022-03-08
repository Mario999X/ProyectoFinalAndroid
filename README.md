# --- PROYECTO FINAL ANDROID ---

Se trata de una aplicación android compuesta únicamente de actividades y hecha en Java.

Usando Retrofit, realizamos una llamada a una API (https://fakestoreapi.com/) y obtenemos una serie de productos.

## Las características del programa son: 

    1. Una casi completa internacionalización (Español-Inglés) según el idioma que tenga el móvil.
    2. Una pantalla de login (falso).
    3. Un menú principal con dos botones.
        4. Btn "TABLA".
            5. Una actividad puramente de decoración intentado recrear una vista de tabla,
            bastante poco práctica para un móvil.
        6. Btn "PRODUCTOS".
            7. Una actividad que cuando comienza realiza la llamada a la API*, mostrando
            un RecyclerView con los productos.
            8. Pulsando encima de uno de esos productos, nos aparecera una nueva actividad,
            que nos ofrece una vista detallada del producto elegido.

*A veces saldrá un error de "timeout", esto se debe a la propia API, la única solución es intentarlo varias veces.
