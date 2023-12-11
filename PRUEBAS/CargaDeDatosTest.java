import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import modelo.Empresa;

class CargaDeDatosTest {

private Empresa empresa;
	

	@Test
	@DisplayName("Cargadedatos")
	public void test() throws FileNotFoundException, IOException {
		Empresa empresa = new Empresa();
		assertTimeout(Duration.ofMinutes(1), () -> empresa.loaderInventarioSedeNorte());
		assertTimeout(Duration.ofMinutes(1), () -> empresa.loaderInventarioSedeCentro());
		assertTimeout(Duration.ofMinutes(1), () -> empresa.loaderInventarioSedeSur());
		assertTimeout(Duration.ofMinutes(1), () -> empresa.loaderInventario());
		assertTimeout(Duration.ofMinutes(1), () -> empresa.CargarInformacionEmpresa());
	}
}
