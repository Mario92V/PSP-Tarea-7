package mariovelez.psptarea7;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mario F. Vélez R.
 */
public class ModeloTest {
    
    public ModeloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcularMedia method, of class Modelo.
     */
    @Test
    public void testCalcularMedia()
    {
        System.out.println("calcularMedia");
        double[] arreglo = {1,2,3,4,5,6,7,8,9,10};
        Modelo instance = new Modelo();
        double expResult = 5.5;
        double result = instance.calcularMedia(arreglo);
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of calcularB0 method, of class Modelo.
     */
    @Test
    public void testCalcularB0() {
        System.out.println("calcularB0");
        double[] arreglo1 = {130,650,99,150,128,302,95,945,368,961};
        double[] arreglo2 = {186,699,132,272,291,331,199,1890,788,1601};
        Modelo instance = new Modelo();
        double expResult = -22.55;
        double result = instance.calcularB0(arreglo1, arreglo2);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of calcularB1 method, of class Modelo.
     */
    @Test
    public void testCalcularB1() {
        System.out.println("calcularB1");
        double[] arreglo1 = {130,650,99,150,128,302,95,945,368,961};
        double[] arreglo2 = {186,699,132,272,291,331,199,1890,788,1601};
        Modelo instance = new Modelo();
        double expResult = 1.7279;
        double result = instance.calcularB1(arreglo1, arreglo2);
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of calcularRxy method, of class Modelo.
     */
    @Test
    public void testCalcularRxy() {
        System.out.println("calcularRxy");
        double[] arreglo1 = {130,650,99,150,128,302,95,945,368,961};
        double[] arreglo2 = {186,699,132,272,291,331,199,1890,788,1601};
        Modelo instance = new Modelo();
        double expResult = 0.9545;
        double result = instance.calcularRxy(arreglo1, arreglo2);
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of calcularR2 method, of class Modelo.
     */
    @Test
    public void testCalcularR2() {
        System.out.println("calcularR2");
        double[] arreglo1 = {130,650,99,150,128,302,95,945,368,961};
        double[] arreglo2 = {186,699,132,272,291,331,199,1890,788,1601};
        Modelo instance = new Modelo();
        double expResult = 0.9111;
        double result = instance.calcularR2(arreglo1, arreglo2);
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of calcularYk method, of class Modelo.
     */
    @Test
    public void testCalcularYk() {
        System.out.println("calcularYk");
        double b0 = -22.55;
        double b1 = 1.7279;
        double xK = 386;
        Modelo instance = new Modelo();
        double expResult = 644.429;
        double result = instance.calcularYk(b0, b1, xK);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of calcularW method, of class Modelo.
     */
    @Test
    public void testCalcularW()
    {
        System.out.println("calcularW");
        double x = 1.1;
        double numSeg = 10;
        Modelo instance = new Modelo();
        double expResult = 0.11;
        double result = instance.calcularW(x, numSeg);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of funcionGamma method, of class Modelo.
     */
    @Test
    public void testFuncionGamma()
    {
        System.out.println("funcionGamma");
        double valor = 4.5;
        Modelo instance = new Modelo();
        double expResult = 11.63173;
        double result = instance.funcionGamma(valor);
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of distribucionT method, of class Modelo.
     */
    @Test
    public void testDistribucionT()
    {
        System.out.println("distribucionT");
        double x = 1.1;
        double dof = 9;
        Modelo instance = new Modelo();
        double expResult = 0.20652;
        double result = instance.distribucionT(x, dof);
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of sumatoria method, of class Modelo.
     */
    @Test
    public void testSumatoria()
    {
        System.out.println("sumatoria");
        int vInicial = 1;
        int vFinal = 9;
        int incremento = 2;
        int constante = 4;
        double w = 0.11;
        double dof = 9;
        Modelo instance = new Modelo();
        double expResult = 6.37287849;
        double result = instance.sumatoria(vInicial, vFinal, incremento, constante, w, dof);
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of calcularP method, of class Modelo.
     */
    @Test
    public void testCalcularP()
    {
        System.out.println("calcularP");
        double w = 0.11;
        double x = 1.1;
        double numSeg = 10;
        double dof = 9;
        int vFinal = 10;
        Modelo instance = new Modelo();
        double expResult = 0.3500589;
        double result = instance.calcularP(w, x, numSeg, dof, vFinal);
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of calcularSignificancia method, of class Modelo.
     */
    @Test
    public void testCalcularSignificancia() {
        System.out.println("calcularSignificancia");
        double rXY = 0.771950811;
        double n = 4.0;
        Modelo instance = new Modelo();
        double expResult = 0.22804919288226222;
        double result = instance.calcularSignificancia(rXY, n);
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of compararResultados method, of class Modelo.
     */
    @Test
    public void testCompararResultados() {
        System.out.println("compararResultados");
        double valor1 = 0.3500589;
        double valor2 = 0.35005864;
        Modelo instance = new Modelo();
        boolean expResult = true;
        boolean result = instance.compararResultados(valor1, valor2);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculador method, of class Modelo.
     */
    @Test
    public void testCalculador() {
        System.out.println("calculador");
        double x = 1.0;
        double numSeg = 10.0;
        double dof = 15.0;
        double pEsperado = 0.45;
        Modelo instance = new Modelo();
        instance.calculador(x, numSeg, dof, pEsperado);
    }

    /**
     * Test of calcularRango method, of class Modelo.
     */
    @Test
    public void testCalcularRango() {
        System.out.println("calcularRango");
        double[] arreglo1 = {130,650,99,150,128,302,95,945,368,961};
        double[] arreglo2 = {15.0,69.9,6.5,22.4,28.4,65.9,19.4,198.7,38.8,138.2};
        double xK = 386;
        double b0 = -4.038881575;
        double b1 = 0.16812665;
        double n = 10;
        Modelo instance = new Modelo();
        double expResult = 27.55764748;
        double result = instance.calcularRango(arreglo1, arreglo2, xK, b0, b1, n);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of calcularUPIyLPI method, of class Modelo.
     */
    @Test
    public void testCalcularUPIyLPI() {
        System.out.println("calcularUPIyLPI");
        double yK = 60.85800528;
        double rango = 27.55764748;
        int tipo = 0;
        Modelo instance = new Modelo();
        double expResult = 88.41565276;
        double result = instance.calcularUPIyLPI(yK, rango, tipo);
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of organizador method, of class Modelo.
     */
    @Test
    public void testOrganizador() {
        System.out.println("organizador");
        double[] arreglo1 = {130,650,99,150,128,302,95,945,368,961};
        double[] arreglo2 = {186,699,132,272,291,331,199,1890,788,1601};
        double xK = 386;
        Modelo instance = new Modelo();
        double[] expResult = {0.954496574,0.91106371,1.77517E-05,-22.55253275,1.727932426,644.4293838,230.0017197,874.4311035,414.427664};
        double[] result = instance.organizador(arreglo1, arreglo2, xK);
        assertArrayEquals(expResult, result,0.01);
    }
    
}
