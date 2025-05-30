package com.andres.empleadopoo.models;


public class EmpleadoTemporal extends Empleado {
    private double salarioMensualContrato; // Asumimos un salario fijo por el contrato
    private String fechaFinContrato; // Podrías usar java.time.LocalDate

    public EmpleadoTemporal(String nombre, String id, int aniosEnEmpresa, double salarioMensualContrato, String fechaFinContrato) {
        super(nombre, id, aniosEnEmpresa);
        this.salarioMensualContrato = salarioMensualContrato;
        this.fechaFinContrato = fechaFinContrato;
    }

    @Override
    public double calcularSalarioBruto() {
        return this.salarioMensualContrato;
    }

    @Override
    public double calcularBeneficios() {
        return 0;
    }

    // Getters
    public double getSalarioMensualContrato() {
        return salarioMensualContrato;
    }

    public String getFechaFinContrato() {
        return fechaFinContrato;
    }
}