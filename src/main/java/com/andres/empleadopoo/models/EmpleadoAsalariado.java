package com.andres.empleadopoo.models;


public class EmpleadoAsalariado extends Empleado {
    private double salarioFijoMensual;
    private static final double BONO_ALIMENTACION = 1_000_000.0; // 1.000.000/mes

    public EmpleadoAsalariado(String nombre, String id, int aniosEnEmpresa, double salarioFijoMensual) {
        super(nombre, id, aniosEnEmpresa);
        this.salarioFijoMensual = salarioFijoMensual;
    }

    @Override
    public double calcularSalarioBruto() {
        return this.salarioFijoMensual;
    }

    @Override
    public double calcularBeneficios() {
        double bonoAnual = 0;
        //Bono anual del 10% del salario si lleva más de 5 años en la empresa.
        if (this.getAnosEnEmpresa() > 5) {
            bonoAnual = this.salarioFijoMensual * 0.10;
        }
        // Bono Alimentación ($1.000.000/mes cubierto por la empresa)
        return bonoAnual + BONO_ALIMENTACION;
    }

    public double getSalarioFijoMensual() {
        return salarioFijoMensual;
    }
}