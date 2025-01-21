import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverter {

    private static final String API_KEY = "4e226d011af28dada32c14e7";
    private static final String API_URL = "https://open.er-api.com/v6/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al Conversor de Monedas");

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Convertir de una moneda a otra");
            System.out.println("2. Salir");
            int opcion = scanner.nextInt();

            if (opcion == 2) {
                System.out.println("¡Hasta luego!");
                break;
            }

            System.out.println("Ingrese el código de la moneda origen (USD, CLP, ARS, BOB, BRL, COP):");
            String monedaOrigen = scanner.next().toUpperCase();

            System.out.println("Ingrese el código de la moneda destino (USD, CLP, ARS, BOB, BRL, COP):");
            String monedaDestino = scanner.next().toUpperCase();

            System.out.println("Ingrese la cantidad a convertir:");
            double cantidad = scanner.nextDouble();

            try {
                double tasaConversion = obtenerTasaConversion(monedaOrigen, monedaDestino);
                double resultado = cantidad * tasaConversion;
                System.out.printf("%.2f %s equivale a %.2f %s\n", cantidad, monedaOrigen, resultado, monedaDestino);
            } catch (Exception e) {
                System.out.println("Error al realizar la conversión: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static double obtenerTasaConversion(String monedaOrigen, String monedaDestino) throws IOException, InterruptedException {
        String url = API_URL + monedaOrigen + "?apikey=" + API_KEY;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Error al conectarse a la API");
        }

        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject rates = jsonResponse.getAsJsonObject("rates");

        if (!rates.has(monedaDestino)) {
            throw new IllegalArgumentException("La moneda destino no está disponible.");
        }

        return rates.get(monedaDestino).getAsDouble();
    }
}
