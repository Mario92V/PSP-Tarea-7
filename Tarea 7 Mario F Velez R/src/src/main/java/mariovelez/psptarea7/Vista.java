package mariovelez.psptarea7;

/**
 *
 * @author Mario F. Vélez R.
 */
public class Vista
{

    /**
     * Método que permite organizar los resultados obtenidos para visualizarlos en Heroku
     * 
     * @param r1 Arreglo con los resultados de la prueba1
     * @param r2 Arreglo con los resultados de la prueba2
     * @param r3 Arreglo con los resultados de la prueba3
     * @param r4 Arreglo con los resultados de la prueba4
     * @return   String con los datos para su envío a Heroku
     */
    public String mostrarResultados(double[] r1, double[] r2, double[] r3, double[] r4)
    {
        String resultado = "Test1: " + "<br/>" + "r(x,y): Valor esperado = 0.954496574; Valor obtenido = " + r1[0] + "<br/>" + "r^2: Valor esperado = 0.91106371; Valor obtenido = " + r1[1] + "<br/>" + "Significancia: Valor esperado = 1.77517E-05; Valor obtenido = " + r1[2] + "<br/>" + "B0: Valor esperado = -22.55253275; Valor obtenido = " + r1[3] + "<br/>" + "B1: Valor esperado = 1.727932426; Valor obtenido = " + r1[4] + "<br/>" + "y(k): Valor esperado = 644.4293838; Valor obtenido = " + r1[5] + "<br/>" + "Rango: Valor esperado = 230.0017197; Valor obtenido = " + r1[6] + "<br/>" + "UPI(70%)-: Valor esperado = 874.4311035; Valor obtenido = " + r1[7] + "<br/>" + "LPI(70%): Valor esperado = 414.427664; Valor obtenido = " + r1[8] + "<br/>" + "<br/>"
                + "Test2: " + "<br/>" + "r(x,y): Valor esperado = 0.933306898; Valor obtenido = " + r2[0] + "<br/>" + "r^2: Valor esperado = 0.871061766; Valor obtenido = " + r2[1] + "<br/>" + "Significancia: Valor esperado = 7.98203E-05; Valor obtenido = " + r2[2] + "<br/>" + "B0: Valor esperado = -4.038881575; Valor obtenido = " + r2[3] + "<br/>" + "B1: Valor esperado = 0.16812665; Valor obtenido = " + r2[4] + "<br/>" + "y(k): Valor esperado = 60.85800528; Valor obtenido = " + r2[5] + "<br/>" + "Rango: Valor esperado = 27.55764748; Valor obtenido = " + r2[6] + "<br/>" + "UPI(70%)-: Valor esperado = 88.41565276; Valor obtenido = " + r2[7] + "<br/>" + "LPI(70%): Valor esperado = 33.3003578; Valor obtenido = " + r2[8] + "<br/>" + "<br/>"
                + "Test3: " + "<br/>" + "r(x,y): Valor esperado = n/a; Valor obtenido = " + r3[0] + "<br/>" + "r^2: Valor esperado = n/a; Valor obtenido = " + r3[1] + "<br/>" + "Significancia: Valor esperado = n/a; Valor obtenido = " + r3[2] + "<br/>" + "B0: Valor esperado = -n/a; Valor obtenido = " + r3[3] + "<br/>" + "B1: Valor esperado = n/a; Valor obtenido = " + r3[4] + "<br/>" + "y(k): Valor esperado = n/a; Valor obtenido = " + r3[5] + "<br/>" + "Rango: Valor esperado = n/a; Valor obtenido = " + r3[6] + "<br/>" + "UPI(70%)-: Valor esperado = n/a; Valor obtenido = " + r3[7] + "<br/>" + "LPI(70%): Valor esperado = n/a; Valor obtenido = " + r3[8] + "<br/>" + "<br/>"
                + "Test4: " + "<br/>" + "r(x,y): Valor esperado = n/a; Valor obtenido = " + r4[0] + "<br/>" + "r^2: Valor esperado = n/a; Valor obtenido = " + r4[1] + "<br/>" + "Significancia: Valor esperado = n/a; Valor obtenido = " + r4[2] + "<br/>" + "B0: Valor esperado = -n/a; Valor obtenido = " + r4[3] + "<br/>" + "B1: Valor esperado = n/a; Valor obtenido = " + r4[4] + "<br/>" + "y(k): Valor esperado = n/a; Valor obtenido = " + r4[5] + "<br/>" + "Rango: Valor esperado = n/a; Valor obtenido = " + r4[6] + "<br/>" + "UPI(70%)-: Valor esperado = n/a; Valor obtenido = " + r4[7] + "<br/>" + "LPI(70%): Valor esperado = n/a; Valor obtenido = " + r4[8];
		return resultado;
    }
}