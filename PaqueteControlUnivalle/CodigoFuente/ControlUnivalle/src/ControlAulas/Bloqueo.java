/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAulas;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

/**
 *
 * @author GermanV
 */
public class Bloqueo {

    private JFrame jframe = null;

    public Bloqueo(JFrame f) {
        this.jframe = f;
    }

    /**
     * ejecuta una tarea cada "n" tiempo Para evitar que el usuario utilice las
     * teclas (WINDOWS + D)(TAB) y asi perder el foco de la aplicación, cada 50
     * milisegundos se envia el JFrame al frente y se cambia su propiedad a
     * maximizado
     */

    public void Seguro() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        TraerAlFrente();
                    }
                }, 500, 50, TimeUnit.MILLISECONDS); //comienza dentro de 1/2 segundo y luego se repite cada N segundos
    }

    public void TraerAlFrente() {
        jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);//maximizado
        jframe.toFront();
        jframe.setAlwaysOnTop(true);
       
    }
}
