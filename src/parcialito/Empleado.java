/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialito;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Salas
 */
public class Empleado {

    /*
    * NOMBRE
    SALARIO BASICO
    HORAS EXTRAS TRABAJADAS
    TOTAL DAS TRABAJADO
    
    
    
    
    * DATOS PERSONALES(NOMBRE_EMPLEADO -- SUELDO_BASICO(XXXXX)  --  DIAS_LABORADOS=30); PADRE
    * DEVENGADOS(BASICO -- HORAS_EXTRA_DIURNA -- VALOR_HORA_DIUARNA -- TOTAL ) 
    * DEDUCIDOS (PENSION  --  SALUD  -- TOTAL)
    * TOTAL A PAGAR( DEVENGADOS - DEDUCIDOS)
    * 
    
    
    //////DEVENGADOS/////
    BASICO = (SUELDO_BASICO/30) * DIAS LABORADOS
    HORAS_EXTRAS_DIURNAS = horas_trabajadas*(HORA*0.25)                          HORA = (SUELDO_BASICO/30)/8 = VALOR DE LA HORA              
    TOTAL_DEVENGADOS  = BASICO + VALOR_HORAS_EXTRAS_DIURNAS
    
    ////DEDUCIDOS////////
    PENSION = 4%*SUELDO_BASICO   (SUELDO_BASICO*0.04)
    SALUD = 4%*SUELDO_BASICO     (0.04)
    TOTAL_DEDUCIONES = PENSION+SALUD
    
    
    TOTAL_A_PAGAR = TOTAL_DEVENGADOS-TOTAL_DEDUCIDOS
    
    
    
     */
    Double salario_basico;
    String nombre;
    int dias_laborados;
    int horas_trabajadas;

    //
    double basico;
    double total_devengados;
    double horas_extras;
    double total_deducidos;
    double pension;
    double salud;
    double totalPaga;

    Map<Integer, Empleado> listaEmpleados = new HashMap<>();

    public Empleado() {

    }

    public Empleado(Double salario_basico, String nombre, int dias_laborados, int horas_trabajadas) {
        this.salario_basico = salario_basico;
        this.nombre = nombre;
        this.dias_laborados = dias_laborados;
        this.horas_trabajadas = horas_trabajadas;
    }

    public void sueldo_basico() {
        basico = (salario_basico / 30) * dias_laborados;
        System.out.println("Basico" + basico);
    }

    public void horas_extras() {

        horas_extras = (((salario_basico / 30) / 8) * 0.25) + ((salario_basico / 30) / 8) * horas_trabajadas;
        System.out.println("HorasExtras " + horas_extras);

    }

    public void devengados() {
        total_devengados = basico + horas_extras;
        System.out.println("Total vedengados" + total_devengados);
    }

    public void deducidos() {

        pension = salario_basico * 0.04;
        System.out.println("PENSION " + pension);

        salud = salario_basico * 0.04;
        System.out.println("SALUD " + salud);

        total_deducidos = pension + salud;
        System.out.println("TotalDeducidos" + total_deducidos);

    }

    public void total_pagar() {
        totalPaga = total_devengados - total_deducidos;
        System.out.println("Total Paga: " + totalPaga);
    }

    public void HashMap() {
        int key = 1;
        listaEmpleados.put(key, this);
        key += 1;

    }

    public void pintarTabla() {
        Parcialto p = new Parcialto();
        int ind = 0;
        DefaultTableModel model = (DefaultTableModel) p.getTable().getModel();
        model.insertRow(ind, new Object[]{nombre, salario_basico, dias_laborados, basico, horas_trabajadas, horas_extras, total_devengados, pension, salud, total_deducidos, totalPaga});
        ind += 1;
    }

    public void Salida() {
        for (Entry<Integer, Empleado> e : listaEmpleados.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }
    }

    @Override
    public String toString() {
        return "Empleado{" + "salario_basico=" + salario_basico + ", nombre=" + nombre + ", dias_laborados=" + dias_laborados + ", horas_trabajadas=" + horas_trabajadas + ", basico=" + basico + ", total_devengados=" + total_devengados + ", horas_extras=" + horas_extras + ", total_deducidos=" + total_deducidos + ", pension=" + pension + ", salud=" + salud + ", totalPaga=" + totalPaga + '}';
    }

}
