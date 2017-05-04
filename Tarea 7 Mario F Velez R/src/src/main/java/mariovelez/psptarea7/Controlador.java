package mariovelez.psptarea7;

import static spark.Spark.*;
/**
 *
 * @author Mario F. Vélez R.
 */
public class Controlador
{
    private static final double[] ARREGLO1 = {130,650,99,150,128,302,95,945,368,961};
    private static final double[] ARREGLO2 = {186,699,132,272,291,331,199,1890,788,1601};
    private static final double[] ARREGLO3 = {15.0,69.9,6.5,22.4,28.4,65.9,19.4,198.7,38.8,138.2};
    private static final double[] ARREGLO4 = {99.7,89,97.8,33.3};
    private static final double[] ARREGLO5 = {128,103,69,43};
    private static final double[] ARREGLO6 = {8.28,5.68,7.97,2.63};
    
    /**
     * Método main que controla la ejecución de las otras clases y envia el resultado a Heroku
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");
        
        get("/", (request, response) -> {
        Vista controladorVista = new Vista();
        Modelo controladorModelo = new Modelo();
        double[] r1 = controladorModelo.organizador(ARREGLO1, ARREGLO2, 386);
        double[] r2 = controladorModelo.organizador(ARREGLO1, ARREGLO3, 386);
        double[] r3 = controladorModelo.organizador(ARREGLO4, ARREGLO5, 95.9);
        double[] r4 = controladorModelo.organizador(ARREGLO4, ARREGLO6, 95.9);
        return controladorVista.mostrarResultados(r1, r2, r3, r4);
    });
    }
}