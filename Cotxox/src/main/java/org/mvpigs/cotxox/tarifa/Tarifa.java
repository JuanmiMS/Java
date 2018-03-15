package org.mvpigs.cotxox.tarifa;

import org.mvpigs.cotxox.carrera.Carrera;

public class Tarifa {
    final static private double costeMilla = 1.35;
    final static private double costeMinuto = 0.35;
    final static private double costeMinimo = 5;
    final static private double porcentajeComision = .2;


    public static double getCosteEsperado(Carrera carrera) {
        double total = getCosteDistancia(carrera.getDistancia()) +
                getCosteTiempo(carrera.getTiempoEsperado());
        if (total < costeMinimo) {
            return costeMinimo;
        } else {
            return total;
        }
    }

    public static double getCosteDistancia(double distancia) {
        return distancia * costeMilla;
    }

    public static double getCosteTiempo(double minutos) {
        return minutos * costeMinuto;
    }
}
