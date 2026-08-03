# Gastos — Control de gastos (estilo One UI)

App de control de gastos hecha en **Kotlin + Jetpack Compose**, con una estética inspirada
en el lenguaje visual de Samsung One UI: título grande en negrita, tarjetas muy redondeadas,
azul de acento estilo Samsung, y modo claro/oscuro automático (según el sistema).

## Funciones
- Cargar gastos con descripción, monto y categoría (con ícono).
- Ver el total gastado en una tarjeta destacada.
- Listado de gastos ordenado por fecha, con opción de eliminar.
- Los datos se guardan localmente en el dispositivo (Room / SQLite), no se pierden al cerrar la app.
- Tema claro y oscuro automático según la configuración del teléfono.

## Cómo subir esto a GitHub

1. Creá un repositorio nuevo en GitHub (puede estar vacío).
2. Desde esta carpeta, en una terminal:
   ```bash
   git init
   git add .
   git commit -m "Primera versión de la app de gastos"
   git branch -M main
   git remote add origin https://github.com/TU-USUARIO/TU-REPO.git
   git push -u origin main
   ```

## Cómo descargar el APK (sin instalar nada)

Al hacer `push` a la rama `main`, GitHub Actions compila automáticamente el APK:

1. Andá a la pestaña **Actions** de tu repositorio en GitHub.
2. Entrá al workflow **"Build APK"** que se ejecutó con tu último push.
3. Esperá a que termine (unos minutos).
4. Bajá hasta **Artifacts** y descargá **expense-tracker-apk** (es un .zip que contiene el `app-debug.apk`).
5. Pasá el APK a tu Samsung (por cable, Drive, etc.) y instalalo. Puede que tengas que habilitar
   "Instalar apps de orígenes desconocidos" la primera vez.

Si querés forzar una compilación sin hacer un push nuevo, también podés ir a **Actions → Build APK → Run workflow**.

## Compilar localmente (opcional, con Android Studio)

1. Abrí la carpeta del proyecto con Android Studio (versión reciente).
2. Dejá que sincronice Gradle (necesita conexión a internet la primera vez).
3. Ejecutá la app en un emulador o dispositivo, o generá el APK con
   **Build → Build Bundle(s) / APK(s) → Build APK(s)**.

## Estructura del proyecto
```
app/src/main/java/com/oneui/expensetracker/
  data/        -> Entidad, DAO y base de datos Room, categorías
  ui/theme/    -> Colores, tipografía y formas (estética One UI)
  ui/screens/  -> Pantallas (lista de gastos, agregar gasto)
  viewmodel/   -> Lógica de estado
  MainActivity.kt
```

## Nota sobre "One UI 8.5"
Samsung no publica una guía de diseño exacta por número de versión, así que la app sigue
los patrones visuales reconocibles de One UI (títulos grandes, esquinas muy redondeadas,
azul de acento, fondo negro puro en modo oscuro) en vez de una especificación oficial de
"8.5", que no existe como documento público.
