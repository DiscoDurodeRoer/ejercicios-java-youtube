
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import testeando_aplicaciones_ddr_7.TablaTipoPokemon;
import testeando_aplicaciones_ddr_7.TipoPokemon;

public class TestTablaTipoPokemon {

    public TestTablaTipoPokemon() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testDebilidades() {

        TablaTipoPokemon tabla = new TablaTipoPokemon();

        ArrayList<TipoPokemon> tipos = tabla.debilidades(TipoPokemon.BICHO);

        ArrayList<TipoPokemon> tiposEsperados = new ArrayList<>();
        tiposEsperados.add(TipoPokemon.FUEGO);
        tiposEsperados.add(TipoPokemon.ROCA);
        tiposEsperados.add(TipoPokemon.VOLADOR);

        assertArrayEquals(tiposEsperados.toArray(), tipos.toArray());

        tipos = tabla.debilidades(TipoPokemon.DRAGÓN);
        tiposEsperados = new ArrayList<>();
        tiposEsperados.add(TipoPokemon.DRAGÓN);
        tiposEsperados.add(TipoPokemon.HADA);
        tiposEsperados.add(TipoPokemon.HIELO);

        assertArrayEquals(tiposEsperados.toArray(), tipos.toArray());

        tipos = tabla.debilidades(TipoPokemon.ELÉCTRICO, TipoPokemon.VOLADOR);
        tiposEsperados = new ArrayList<>();
        tiposEsperados.add(TipoPokemon.HIELO);
        tiposEsperados.add(TipoPokemon.ROCA);

        assertArrayEquals(tiposEsperados.toArray(), tipos.toArray());

    }

    @Test
    public void testEficacias() {

        TablaTipoPokemon tabla = new TablaTipoPokemon();

        ArrayList<TipoPokemon> tipos = tabla.eficacias(TipoPokemon.LUCHA);

        ArrayList<TipoPokemon> tiposEsperados = new ArrayList<>();
        tiposEsperados.add(TipoPokemon.ACERO);
        tiposEsperados.add(TipoPokemon.HIELO);
        tiposEsperados.add(TipoPokemon.NORMAL);
        tiposEsperados.add(TipoPokemon.ROCA);
        tiposEsperados.add(TipoPokemon.SINIESTRO);

        assertArrayEquals(tiposEsperados.toArray(), tipos.toArray());

    }

}
