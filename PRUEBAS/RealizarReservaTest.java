import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import consola.RealizarReserva;
import modelo.Empresa;

class RealizarReservaTest {
	
	private Empresa empresa;
	
	

	@Test
	@DisplayName("Creación de una reserva")
	public void test() throws IOException {
		Empresa empresa = new Empresa();
		empresa.loaderInventario();
		empresa.loaderInventarioSedeCentro();
		empresa.loaderInventarioSedeNorte();
		empresa.loaderInventarioSedeSur();
		empresa.CargarInformacionEmpresa();

        

        // Verificar que se haya creado el archivo reservados.txt
        assertTrue(Files.exists(Paths.get("data/reservados.txt")));

      
        

        // Verificar el contenido del archivo reservados.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("data/reservados.txt"))) {
            String linea = reader.readLine();
            assertNotNull(linea);
            
        }
    }
	}
