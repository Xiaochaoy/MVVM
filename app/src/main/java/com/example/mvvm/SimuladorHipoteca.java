package com.example.mvvm;

public class SimuladorHipoteca {

    public static class Solicitud {
        public double capital;
        public int plazo;

        public Solicitud(double capital, int plazo) {
            this.capital = capital;
            this.plazo = plazo;
        }
    }
    interface Callback {
        void cuandoEsteCalculadaLaCuota(double cuota);
        void cuandoHayaErrorDeCapital(double capitalMinimo);
        void cuandoHayaErrorDePlazo(int plazoMinimo);
        void cuandoEmpieceElCalculo();
        void cuandoFinaliceElCalculo();
    }

    public void calcular(Solicitud solicitud, Callback callback) {
        double fallo1 = 1;
        int fallo2 = 1;
        callback.cuandoEmpieceElCalculo();


        try {
            Thread.sleep(2000);   // simular operacion de larga duracion (2s)
        } catch (InterruptedException e) {}

        boolean error = false;
        if (!Comunes.isNumeric(solicitud.capital)) {
            callback.cuandoHayaErrorDeCapital(fallo1);
            error = true;
        }

        if (!Comunes.isNumeric(solicitud.plazo)) {
            callback.cuandoHayaErrorDePlazo(fallo2);
            error = true;
        }

        if(!error) {
            callback.cuandoEsteCalculadaLaCuota(solicitud.capital + solicitud.plazo);
        }
        callback.cuandoFinaliceElCalculo();
    }
}