package demo;

package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Pruebas unitarias para el reto CheckDOM de Coderbyte.
 * Basado en los requerimientos técnicos de la oferta de Odoo.
 */
public class CheckDOMTest {

    @Test
    public void testCaso1_Correcto() {
        // Escenario: Todo bien anidado
        String input = "<div><b><p>hola mundo</p></b></div>";
        assertEquals("true", Main.CodingChallenge(input));
    }

    @Test
    public void testCaso2_CasiCorrecto_DiferentesEtiquetas() {
        // Escenario: Cambiando la etiqueta de apertura se arregla
        
        // 1. Cambiar div por b
        assertEquals("div", Main.CodingChallenge("<div><i>hola</i></b>"));
        
        // 2. Cambiar em por b
        assertEquals("em", Main.CodingChallenge("<em><p>hola</p></b>"));
        
        // 3. Cambiar b por i
        assertEquals("b", Main.CodingChallenge("<div><b><p>hola world</p></i></div>"));
    }

    @Test
    public void testCaso2_CasiCorrecto_SinCierre() {
        // Escenario: Una etiqueta queda abierta al final
        assertEquals("p", Main.CodingChallenge("<em></em><em></em><p>"));
    }

    @Test
    public void testCaso3_Incorrecto() {
        // Escenario: Demasiados errores o mal orden inicial
        
        // Empieza con cierre
        assertEquals("false", Main.CodingChallenge("</b><p></p><b>"));
        
        // Múltiples desajustes
        assertEquals("false", Main.CodingChallenge("<div><p></b></em>"));
    }
    
    @Test
    public void testConEspaciosYTexto() {
        // Escenario: El programa debe ignorar el texto plano y manejar espacios
        String input = "  <div>  texto plano  <b> </b> </div> ";
        assertEquals("true", Main.CodingChallenge(input));
    }
}
