# 🚌 Bus Tracking

**Bus Tracking** es una aplicación que permite realizar el seguimiento en tiempo real de autobuses, mostrando rutas, paradas y su ubicación actual. Está diseñada para ofrecer una experiencia clara, útil y accesible tanto para usuarios como para operadores.

---

## 📸 Vistas Previas

A continuación se muestran capturas reales de la interfaz de la aplicación:

### Vista 1 – Selección de líneas de autobuses
Permite elegir entre las diferentes líneas disponibles para ver su recorrido y estado actual.  
![Preview 1](preview_1.png)

### Vista 2 – Mapa con ruta y paradas
Muestra la ruta seleccionada con todas sus paradas, junto a la ubicación actual del autobús y un temporizador que indica el tiempo estimado hasta la próxima parada.  
![Preview 2](preview_2.png)

### Vista 3 – Registro de actividad reciente
Presenta las últimas 5 paradas realizadas por la línea seleccionada, con detalles como fecha, hora, posición GPS y velocidad media.  
![Preview 3](preview_3.png)

---

## 🚀 Funcionalidades principales

- Seguimiento en tiempo real de autobuses en el mapa.
- Visualización de rutas, paradas y horarios estimados.
- Consulta del historial de actividad reciente.
- Exportación automática de la última ubicación conocida de cada autobús en formato JSON.

---

## ℹ️ Detalles adicionales

En la primera vista, puedes seleccionar una línea específica para visualizar su ruta.  
En la segunda vista, se despliega el recorrido con sus paradas y el estado en tiempo real del autobús.  
Por último, en la tercera vista, se accede a un resumen de actividad con las últimas posiciones registradas.  

Además, el sistema genera automáticamente un archivo JSON con la última posición registrada del autobús, útil para integraciones o análisis posteriores.
