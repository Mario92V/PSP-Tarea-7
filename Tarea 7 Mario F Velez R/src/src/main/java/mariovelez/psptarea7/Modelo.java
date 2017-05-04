package mariovelez.psptarea7;

/**
 *
 * @author Mario F. Vélez R.
 */
public class Modelo
{
    /**
     * Método que permite calcular la media aritmetica de un arreglo
     * 
     * @param arreglo Arreglo del que se desea obtener el promedio de sus elementos
     * @return        Valor promedio de los elementos del arreglo ingresado
     */
    public double calcularMedia(double[] arreglo)
    {
        double media=0.0;
        for(int i =0; i<arreglo.length; i++)
        {
            media=media+arreglo[i];
        }
        media=media/arreglo.length;
        return media;
    }
    
    /**
     * Método que calcula el parametro de regresión lineal B0
     * 
     * @param arreglo1 Conjunto de datos para hallar el valor B0
     * @param arreglo2 Conjunto de datos para hallar el valor B0
     * @return         Valor del parámetro B0
     */
    public double calcularB0(double[] arreglo1, double[] arreglo2)
    {
        double b0 = calcularMedia(arreglo2) - (calcularB1(arreglo1, arreglo2)*calcularMedia(arreglo1));
        return b0;
    }
    
    /**
     * Método que calcula el parámetro de regresión lineal B1
     * 
     * @param arreglo1 Conjunto de datos para hallar el valor B1
     * @param arreglo2 Conjunto de datos para hallar el valor B1
     * @return         Valor del parámetro B1
     */
    public double calcularB1(double[] arreglo1, double[] arreglo2)
    {
        int n = arreglo1.length;
        double parteArriba=0.0;
        double parteAbajo=0.0;
        for(int i =0; i<arreglo1.length;i++)
        {
            parteArriba += arreglo1[i]*arreglo2[i];
            parteAbajo += Math.pow(arreglo1[i], 2);
        }
        parteArriba = parteArriba-(n*calcularMedia(arreglo1)*calcularMedia(arreglo2));
        parteAbajo = parteAbajo - (n*Math.pow(calcularMedia(arreglo1), 2));
        double b1=parteArriba/parteAbajo;
        return b1;
    }
    
    /**
     * Método que calcula el valor del coeficiente de correlación r(x,y)
     * 
     * @param arreglo1 Conjunto de datos para hallar el valor r(x,y)
     * @param arreglo2 Conjunto de datos para hallar el valor r(x,y)
     * @return         Valor del parámetro r(x,y)
     */
    public double calcularRxy(double[] arreglo1, double[] arreglo2)
    {
        int n = arreglo1.length;
        double parteArriba1=0.0;
        double parteArriba2=0.0;
        double parteArriba3=0.0;
        double parteAbajo1=0.0;
        double parteAbajo2=0.0;
        for(int i =0; i<arreglo1.length;i++)
        {
            parteArriba1 +=  arreglo1[i]*arreglo2[i];
            parteArriba2 +=  arreglo1[i];
            parteArriba3 +=  arreglo2[i];
            parteAbajo1 += Math.pow(arreglo1[i], 2);
            parteAbajo2 += Math.pow(arreglo2[i], 2);
        }
        double parteArribaTotal = (n*parteArriba1)-(parteArriba2*parteArriba3);
        double parteAbajoTotal = Math.sqrt(((n*parteAbajo1)-Math.pow(parteArriba2, 2))*((n*parteAbajo2)-Math.pow(parteArriba3, 2)));
        double rXY = parteArribaTotal/parteAbajoTotal;
        return rXY;
    }
    
    /**
     * Método que calcula el coeficiente de correlación r^2
     * 
     * @param arreglo1 Conjunto de datos para hallar el valor r^2
     * @param arreglo2 Conjunto de datos para hallar el valor r^2
     * @return         Valor del parámetro r^2
     */
    public double calcularR2(double[] arreglo1, double[] arreglo2)
    {
        double r2 = Math.pow(calcularRxy(arreglo1, arreglo2), 2);
        return r2;
    }
    
    /**
     * Método que calcula la predicción mejorada Yk
     * 
     * @param b0 Resultado obtenido del método que calcula B0
     * @param b1 Resultado obtenido del método que calcula B1
     * @param xK Dato ingresado por el usuario
     * @return   Predicción mejorada Yk
     */
    public double calcularYk(double b0, double b1, double xK)
    {
        double yK = b0 + (b1*xK);
        return yK;
    }
    
    /**
     * Método que calcula el valor W a partir de dos valores
     * 
     * @param x      Valor hasta el cual se quiere hallar el area bajo la curva
     * @param numSeg Número de segmentos en los que se divide la función
     * @return       Valor W para las siguientes ecuaciones
     */
    public double calcularW(double x, double numSeg)
    {
        double w = x/numSeg;
        return w;
    }
    
    /**
     * Método que calcula la función Gamma de un valor dado
     * 
     * @param valor Valor para el cual se desea calcula la función Gamma
     * @return      Valor de la función Gamma
     */
    public double funcionGamma(double valor)
    {
        double resultado = valor-1.0;
        if(resultado > 1)
        {
            resultado = resultado*funcionGamma(resultado);
        }
        else if(resultado == 0.5)
        {
            resultado = resultado*Math.sqrt(Math.PI);
        }
        else if (resultado == 1 || resultado == 0)
        {
            resultado = 1;
        }
        return resultado;
    }
    
    /**
     * Método que calcula la distribución T para un valor dado con un dof dado
     * 
     * @param x   Valor para el cual se desea hallar la distribución T
     * @param dof Valor de los grados de libertad para el cálculo
     * @return    Valor de la distribución T
     */
    public double distribucionT(double x, double dof)
    {
        double resultado = (funcionGamma((dof+1.0)/2.0)/((Math.sqrt(dof*Math.PI))*funcionGamma(dof/2.0)))*(Math.pow(1.0+(Math.pow(x, 2)/dof), -(dof+1.0)/2.0));
        return resultado;
    }
    
    /**
     * Método que permite el cálculo de la sumatoria dado unos parametros
     * 
     * @param vInicial   Valor del que parte la sumatoria
     * @param vFinal     Valor en el que termina la sumatoria
     * @param incremento Valor del incremente para la sumatoria
     * @param constante  Valor que hace parte de la función en la sumatoria
     * @param w          Valor W hallado en el método calcularW
     * @param dof        Valor de grados de libertad para el método distribuciónT
     * @return           Valor de la sumatoria
     */
    public double sumatoria(int vInicial, int vFinal, int incremento, int constante, double w, double dof)
    {
        double resultado = 0.0;
        for(int i = vInicial; i < vFinal+1; i += incremento)
        {
            resultado = resultado + (constante*distribucionT(i*w, dof));
        }
        return resultado;
    }
    
    /**
     *  Método que permite calcular el valor de la integral
     * 
     * @param w      Valor W hallado en el método calcularW
     * @param x      Valor para el cual se debe hallar P
     * @param numSeg Valor del número de segmentos de la función
     * @param dof    Valor de grados de libertad
     * @param vFinal Valor para la sumatoria
     * @return       Valor de la integral o area bajo la curva
     */
    public double calcularP(double w, double x, double numSeg, double dof, int vFinal)
    {
        double p = (w/3)*(distribucionT(0, dof) + sumatoria(1, vFinal-1, 2, 4, w, dof) + sumatoria(2, vFinal-2, 2, 2, w, dof) + distribucionT(x, dof));
        return p;
    }
    
    /**
     * Método que permite el cálculo de la significancia para la correlación dada
     * 
     * @param rXY Valor de la correlación
     * @param n   Número de puntos de datos
     * @return    Valor de la significancia
     */
    public double calcularSignificancia(double rXY, double n)
    {
        double x = (Math.abs(rXY)*Math.sqrt(n-2.0))/(Math.sqrt(1.0-Math.pow(rXY, 2.0)));
        double dof = n-2;
        double w = calcularW(x, 50);
        double p = calcularP(w, x, 50, dof, 50);
        double resultado = 1.0 - 2.0*p;
        return resultado;
    }
    
    private double d = 0.5;
    private int contador = 10;
    double respuesta = 0.0;
        
    /**
     * Método que permite verificar si el valor obtenido es valido
     * 
     * @param valor1 Valor obtenido para una cantidad de segmentos de la función
     * @param valor2 Valor obtenido para una cantidad de segmentos de la función
     * @return       Valor booleano de la comparación de los valores obtenidos
     */
    public boolean compararResultados(double valor1, double valor2)
    {
        boolean resultado = false;
        double e = 0.00001;
        if(Math.abs(valor1-valor2) < e)
        {
            resultado = true;
        }
        return resultado;
    }
    
    /**
     * Método que permite la lógica de control de cálculo de todo el programa
     * 
     * @param x         Valor inicial para el cálculo de la integral
     * @param numSeg    Valor del número de segmentos para el cálculo de la integral
     * @param dof       Valor de grados de libertad para el cálculo de la integral
     * @param pEsperado Valor del cálculo de la integral que se desea obtener
     */
    public void calculador(double x, double numSeg, double dof, double pEsperado)
    {
        respuesta = x;
        double w = calcularW(x, numSeg);
        double p = calcularP(w, x, numSeg, dof, 10);
        if(compararResultados(p, pEsperado) == false)
            {
                if(p<pEsperado)
                    {
                       x = x+d;
                       contador = contador - 1;
                       if(contador == 0)
                        {
                            d = d/2;
                            contador = 10;
                        }
                       calculador(x, numSeg, dof, pEsperado);
                    }
                else if(p>pEsperado)
                    {
                        x=x-d;
                        contador = contador - 1;
                        if(contador == 0)
                        {
                            d = d/2;
                            contador = 10;
                        }
                        calculador(x, numSeg, dof, pEsperado);
                    }
            }
        contador = 10;
        d = 0.5;
    }
    
    /**
     * Método que permite el cálculo del rango para un intervalo del 70%
     * 
     * @param arreglo1 Conjunto de datos para hallar el valor del rango
     * @param arreglo2 Conjunto de datos para hallar el valor del rango
     * @param xK       Tamaño estimado del proxy
     * @param b0       Parámetro obtenido por el método calcularB0
     * @param b1       Parámetro obtenido por el método calcularB0
     * @param n        Número de puntos de datos
     * @return         Valor del rango
     */
    public double calcularRango(double[] arreglo1, double[] arreglo2, double xK, double b0, double b1, double n)
    {
        double auxDE = 0.0;
        double auxRang = 0.0;
        for(int i = 0; i<arreglo1.length; i++)
        {
            auxDE += Math.pow(arreglo2[i] - b0 - b1*arreglo1[i], 2);
            auxRang += Math.pow(arreglo1[i]-calcularMedia(arreglo1), 2);
        }
        double desvEst = Math.sqrt((1.0/(n-2.0))*auxDE);
        calculador(1.0, 10.0, n-2.0, 0.35);
        double t = respuesta;
        respuesta = 0.0;
        double resultado = t*desvEst*Math.sqrt(1.0+(1.0/n)+((Math.pow(xK - calcularMedia(arreglo1), 2))/(auxRang)));
        return resultado;
    }
    
    /**
     * Método que permite calcular el valor de UPI y LPI
     * 
     * @param yK    Valor obtenido por el método de calculo de yK
     * @param rango Valor obtenido por el método de cálculo del rango
     * @param tipo  Tipo de cálculo que se desea hacer 0 = UPI y 1 = LPI
     * @return      Valor de UPI o LPI según lo seleccionado
     */
    public double calcularUPIyLPI(double yK, double rango, int tipo)
    {
        double resultado =0;
        if(tipo==0)
        {
            resultado = yK + rango;
        }
        else if(tipo==1)
        {
            resultado = yK - rango;
        }
        return resultado;
    }
    
    /**
     * Método que toma los datos con los que se trabaja y realiza todo el procedimiento requerido
     * 
     * @param arreglo1 Conjunto de datos para trabajar
     * @param arreglo2 Conjunto de datos para trabajar
     * @param xK       Proxy estimado para cada caso
     * @return         Arreglo con todos los valores hallados para los conjuntos de datos
     */
    public double[] organizador(double[] arreglo1, double[] arreglo2, double xK)
    {
        double[] resultado = new double[9];
        resultado[0] = calcularRxy(arreglo1, arreglo2);
        resultado[1] = calcularR2(arreglo1, arreglo2);
        resultado[2] = calcularSignificancia(resultado[0], arreglo1.length);
        resultado[3] = calcularB0(arreglo1, arreglo2);
        resultado[4] = calcularB1(arreglo1, arreglo2);
        resultado[5] = calcularYk(resultado[3], resultado[4], xK);
        resultado[6] = calcularRango(arreglo1, arreglo2, xK, resultado[3], resultado[4], arreglo1.length);
        resultado[7] = calcularUPIyLPI(resultado[5], resultado[6], 0);
        resultado[8] = calcularUPIyLPI(resultado[5], resultado[6], 1);
        return resultado;
    }
}