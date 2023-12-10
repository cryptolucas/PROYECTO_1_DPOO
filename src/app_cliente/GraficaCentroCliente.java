package app_cliente;


import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.File;



public class GraficaCentroCliente extends JPanel {

	private List<String> listaCentro;
    private List<String> listaNorte;
    private List<String> listaSur;
    
    private ClientePrincipal principal;

    public GraficaCentroCliente(ClientePrincipal p_principal) {
        principal = p_principal;
        procesarArchivo("data/reservados.txt");
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);

        // Ajustar el origen para tener espacio para los títulos y etiquetas
        int yOffset = 50;
        int xOffset = 50;
        int width = getWidth() - 2 * xOffset;
        int height = getHeight() - 2 * yOffset;

        // Dibujar ejes
        g2d.drawLine(xOffset, yOffset, xOffset, yOffset + height);
        g2d.drawLine(xOffset, yOffset + height, xOffset + width, yOffset + height);

        // Calcular la escala en el eje x
        int maxMes = 12;  // asumimos un año completo
        int barWidth = width / maxMes;

        // Mapa para contar la frecuencia de cada mes
        Map<String, Integer> conteoPorMes = new HashMap<>();

        // Analizar cada fecha en los datos
        for (String dato : listaCentro) {
            String[] elementos = dato.split(",");
            if (elementos.length >= 7) {
                String fechaStr = elementos[5];
                try {
                    Date fecha = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(fechaStr);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(fecha);

                    // Obtener el mes
                    int mes = calendar.get(Calendar.MONTH) + 1;  // Sumar 1 porque los meses en Calendar son de 0 a 11

                    // Contar en el mapa
                    conteoPorMes.put(String.valueOf(mes), conteoPorMes.getOrDefault(String.valueOf(mes), 0) + 1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        // Dibujar barras para cada mes
        for (int i = 1; i <= maxMes; i++) {
            int mesCount = conteoPorMes.getOrDefault(String.valueOf(i), 0);
            int barHeight = mesCount * 20;  // ajusta la altura de la barra según la cantidad
            int x = xOffset + (i - 1) * barWidth;
            int y = yOffset + height - barHeight;

            g2d.fillRect(x, y, barWidth, barHeight);

            // Agregar etiquetas en el eje x (meses)
            String nombreMes = obtenerNombreMes(i);  // función que obtiene el nombre del mes
            g2d.drawString(nombreMes, x + barWidth / 2 - 10, yOffset + height + 20);
        }

        // Agregar título
        g2d.setColor(Color.BLACK);
        g2d.drawString("Frecuencia de Fechas por Mes", getWidth() / 2 - 20, yOffset - 20);

        // Agregar etiquetas en el eje y
        g2d.drawString("Cantidad", xOffset - 50, yOffset + height / 2);
    }

    
    
    
    private String obtenerNombreMes(int numeroMes) {
        String[] nombresMeses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
        return nombresMeses[numeroMes - 1];
    }
    
    
    
    
    	
    	

    private void procesarArchivo(String archivo) {
       
    	listaCentro = new ArrayList<>();
        listaNorte = new ArrayList<>();
        listaSur = new ArrayList<>();

        try {
            leerArchivo(archivo, listaCentro, listaNorte, listaSur);
            ordenarPorFecha(listaCentro);
            ordenarPorFecha(listaNorte);
            ordenarPorFecha(listaSur);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void leerArchivo(String archivo, List<String> listaCentro, List<String> listaNorte, List<String> listaSur)
            throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(archivo));

        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            String[] datos = linea.split(",");

            switch (datos[4]) {
                case "centro":
                    listaCentro.add(linea);
                    break;
                case "norte":
                    listaNorte.add(linea);
                    break;
                case "sur":
                    listaSur.add(linea);
                    break;
            }
        }

        scanner.close();
    }

    private void ordenarPorFecha(List<String> lista) {
        Comparator<String> comparadorFecha = new Comparator<String>() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

            public int compare(String linea1, String linea2) {
                try {
                    Date fecha1 = sdf.parse(linea1.split(",")[5]);
                    Date fecha2 = sdf.parse(linea2.split(",")[5]);
                    return fecha1.compareTo(fecha2);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        };

        Collections.sort(lista, comparadorFecha);
    }
    
    
}
