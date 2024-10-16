package clases;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<Integer, Double> conversionFactors = new HashMap<>();

    static {
        conversionFactors.put(1, 9.461e15);      // Año luz
        conversionFactors.put(2, 5556.0);         // League (marítima)
        conversionFactors.put(3, 4828.032);       // Liga
        conversionFactors.put(4, 1609.344);       // Milla terrestre
        conversionFactors.put(5, 1609.34);        // Milla
        conversionFactors.put(6, 1852.0);         // Milla náutica
        conversionFactors.put(7, 1000.0);         // Kilómetro
        conversionFactors.put(8, 1067.0);         // Versta
        conversionFactors.put(9, 201.168);        // Furlong
        conversionFactors.put(10, 100.0);         // Hectómetro
        conversionFactors.put(11, 10.0);          // Decámetro
        conversionFactors.put(12, 1.0);           // Metro
        conversionFactors.put(13, 0.9144);        // Yarda
        conversionFactors.put(14, 2.4384);        // Braza
        conversionFactors.put(15, 0.3048);        // Pie
        conversionFactors.put(16, 0.1);           // Decímetro
        conversionFactors.put(17, 0.01);          // Centímetro
        conversionFactors.put(18, 0.001);         // Milímetro
        conversionFactors.put(19, 0.000001);      // Micrómetro
        conversionFactors.put(20, 0.000000001);   // Nanómetro
        conversionFactors.put(21, 0.0000254);     // Milha (mil)
        conversionFactors.put(22, 0.0254);        // Pulgada
        conversionFactors.put(23, 0.004217);      // Pica
        conversionFactors.put(24, 0.4572);        // Codo
        conversionFactors.put(25, 0.00001);       // Svara (métrica)
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("==================================================================================================================");
        System.out.println("______                          _____                                 \n"
                + "| ___ \\                        |  __ \\                                \n"
                + "| |_/ /_ __ _   _  __ _ _ __   | |  \\/_   _  _____   ____ _ _ __ __ _ \n"
                + "| ___ \\ '__| | | |/ _` | '_ \\  | | __| | | |/ _ \\ \\ / / _` | '__/ _` |\n"
                + "| |_/ / |  | |_| | (_| | | | | | |_\\ \\ |_| |  __/\\ V / (_| | | | (_| |\n"
                + "\\____/|_|   \\__, |\\__,_|_| |_|  \\____/\\__,_|\\___| \\_/ \\__,_|_|  \\__,_|\n"
                + "             __/ |                                                    \n"
                + "            |___/                                                     ");
        System.out.println("=================================================== <[Entrada]> ======================================================");

        System.out.print("Escriba el número de unidades: ");
        double cantidadOrigen = scan.nextDouble();

        mostrarUnidades();

        int unidadOrigen = obtenerUnidad(scan, "origen");
        int unidadDestino = obtenerUnidad(scan, "destino");

        double factorOrigen = conversionFactors.get(unidadOrigen);
        double factorDestino = conversionFactors.get(unidadDestino);
        double resultado = (cantidadOrigen * factorOrigen) / factorDestino;

        System.out.println("=================================================== <[" + obtenerNombreUnidad(unidadDestino) + "]> =============================================");
        System.out.println("Resultado: " + new DecimalFormat("#.##").format(resultado) + " " + obtenerAbreviaturasUnidad(unidadDestino));
        System.out.println("==================================================================================================================");
    }

    private static void mostrarUnidades() {
        System.out.println("1. Año luz (9.461 × 10^15 m)         2. Liga (4.828 × 10^6 m)             3. League (marítima) (5.556 × 10^6 m)");
        System.out.println("4. Milla terrestre (1.609 × 10^3 m)    5. Milla (1.609 × 10^3 m)           6. Milla náutica (1.852 × 10^3 m)");
        System.out.println("7. Kilómetro (1 × 10^3 m)              8. Versta (1.0668 × 10^3 m)          9. Furlong (201.168 m)");
        System.out.println("10. Hectómetro (100 m)                  11. Decámetro (10 m)                 12. Metro (1 m)");
        System.out.println("13. Yarda (0.9144 m)                    14. Braza (1.8288 m)                 15. Pie (0.3048 m)");
        System.out.println("16. Decímetro (0.1 m)                   17. Centímetro (0.01 m)              18. Milímetro (0.001 m)");
        System.out.println("19. Micrómetro (1 × 10^-6 m)            20. Nanómetro (1 × 10^-9 m)          21. Milha (mil) (1.609 × 10^3 m)");
        System.out.println("22. Pulgada (0.0254 m)                  23. Pica (0.004217 m)                24. Codo (0.4572 m)");
        System.out.println("25. Svara (métrica) (0.025 m)");
    }

    private static int obtenerUnidad(Scanner scan, String tipo) {
        System.out.print("Seleccione la unidad de " + tipo + ": ");
        int unidad = scan.nextInt();
        if (!conversionFactors.containsKey(unidad)) {
            System.err.println("Unidad de " + tipo + " no válida.");
            System.exit(1);
        }
        return unidad;
    }

    private static String obtenerNombreUnidad(int unidad) {
        switch (unidad) {
            case 1:
                return "Años luz";
            case 2:
                return "Ligas";
            case 3:
                return "Ligas (marítimas)";
            case 4:
                return "Millas terrestres";
            case 5:
                return "Millas";
            case 6:
                return "Millas náuticas";
            case 7:
                return "Kilómetros";
            case 8:
                return "Verstas";
            case 9:
                return "Furlongs";
            case 10:
                return "Hectómetros";
            case 11:
                return "Decámetros";
            case 12:
                return "Metros";
            case 13:
                return "Yardas";
            case 14:
                return "Brazas";
            case 15:
                return "Pies";
            case 16:
                return "Decímetros";
            case 17:
                return "Centímetros";
            case 18:
                return "Milímetros";
            case 19:
                return "Micrómetros";
            case 20:
                return "Nanómetros";
            case 21:
                return "Millas (miles)";
            case 22:
                return "Pulgadas";
            case 23:
                return "Picas";
            case 24:
                return "Codos";
            case 25:
                return "Svara (métricas)";
            default:
                return "Desconocidas";
        }
    }

    private static String obtenerAbreviaturasUnidad(int unidad) {
        switch (unidad) {
            case 1:
                return "ly"; // Años luz
            case 2:
                return "lg"; // Ligas
            case 3:
                return "nmi"; // Ligas (marítimas)
            case 4:
                return "mi"; // Millas terrestres
            case 5:
                return "mi"; // Millas
            case 6:
                return "nmi"; // Millas náuticas
            case 7:
                return "km"; // Kilómetros
            case 8:
                return "v"; // Verstas
            case 9:
                return "fur"; // Furlongs
            case 10:
                return "hm"; // Hectómetros
            case 11:
                return "dam"; // Decámetros
            case 12:
                return "m"; // Metros
            case 13:
                return "yd"; // Yardas
            case 14:
                return "br"; // Brazas
            case 15:
                return "ft"; // Pies
            case 16:
                return "dm"; // Decímetros
            case 17:
                return "cm"; // Centímetros
            case 18:
                return "mm"; // Milímetros
            case 19:
                return "μm"; // Micrómetros
            case 20:
                return "nm"; // Nanómetros
            case 21:
                return "mi"; // Millas (miles)
            case 22:
                return "in"; // Pulgadas
            case 23:
                return "p"; // Picas
            case 24:
                return "c"; // Codos
            case 25:
                return "s"; // Svara (métricas)
            default:
                return "Desconocida"; // Unidad no reconocida
        }
    }
}
