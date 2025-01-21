# Conversor de Divisas

Este proyecto es un **Conversor de Divisas** desarrollado en Java. Permite realizar conversiones entre diferentes monedas utilizando una API de tipo de cambio en tiempo real.

## Funcionalidades Principales
- Conversión entre las siguientes monedas:
  - USD (Dólar Estadounidense)
  - CLP (Peso Chileno)
  - ARS (Peso Argentino)
  - BOB (Boliviano)
  - BRL (Real Brasileño)
  - COP (Peso Colombiano)
- Interfaz basada en consola para una experiencia simple y directa.
- Uso de una API en tiempo real para obtener las tasas de conversión más actualizadas.

## Requisitos
- Java 11 o superior.
- Conexión a Internet.

## Configuración e Instalación
1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/benjabolomo/Conversor-de-Divisas.git
   ```
2. **Abre el proyecto en IntelliJ IDEA** (o tu IDE de preferencia).
3. Asegúrate de tener configurado correctamente el `API_KEY` dentro del código:
   ```java
   private static final String API_KEY = "TU_API_KEY_AQUÍ";
   ```
   Puedes obtener una API Key gratuita registrándote en [Open Exchange Rates](https://open.er-api.com/).
4. Ejecuta la clase `CurrencyConverter` desde tu IDE.

## Uso
1. Al iniciar el programa, se mostrará un menú interactivo en consola.
2. Selecciona la opción **Convertir de una moneda a otra**.
3. Introduce:
   - El código de la moneda de origen (ejemplo: `USD`).
   - El código de la moneda de destino (ejemplo: `CLP`).
   - La cantidad a convertir.
4. Obtendrás el resultado directamente en la consola.
5. Puedes realizar más conversiones o salir del programa seleccionando la opción correspondiente.

## Tecnologías Utilizadas
- Lenguaje de programación: Java
- API para tasas de cambio: [Open Exchange Rates](https://open.er-api.com/)
- Librería `java.net.http` para solicitudes HTTP.
- Gson para el manejo de datos en formato JSON.

## Capturas de Pantalla
_Ejemplo de uso en la consola:_
```
Bienvenido al Conversor de Monedas

Seleccione una opción:
1. Convertir de una moneda a otra
2. Salir

Ingrese el código de la moneda origen (USD, CLP, ARS, BOB, BRL, COP): USD
Ingrese el código de la moneda destino (USD, CLP, ARS, BOB, BRL, COP): CLP
Ingrese la cantidad a convertir: 100

100.00 USD equivale a 80000.00 CLP
```

## Notas
- Las tasas de cambio dependen de la disponibilidad y actualización de la API utilizada.
- Solo se admiten los códigos de moneda especificados en el menú.

## Contribuciones
Las contribuciones son bienvenidas. Si deseas mejorar el proyecto o agregar nuevas funcionalidades:
1. Haz un fork del repositorio.
2. Crea una rama para tu función (`git checkout -b nueva-funcionalidad`).
3. Realiza tus cambios y haz un commit (`git commit -m "Agrega nueva funcionalidad"`).
4. Haz un push a la rama (`git push origin nueva-funcionalidad`).
5. Abre un Pull Request.

## Autor
**[BenjaBolomo](https://github.com/benjabolomo)**

## Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más información.

