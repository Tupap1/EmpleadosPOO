package com.andres.empleadopoo.models;



public class EmpleadoPorHoras extends Empleado {
    private double tarifaPorHora;
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, String id, int aniosEnEmpresa, double tarifaPorHora, int horasTrabajadas) {
        super(nombre, id, aniosEnEmpresa);
        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = horasTrabajadas;
        validarHorasTrabajadas();
    }

    private void validarHorasTrabajadas() {
        if (this.horasTrabajadas < 0) {
            throw new IllegalArgumentException("Las horas trabajadas no pueden ser negativas.");
        }
    }

    @Override
    public double calcularSalarioBruto() {
        if (horasTrabajadas <= 40) {
            return horasTrabajadas * tarifaPorHora;
        } else {
            double salarioNormal = 40 * tarifaPorHora;
            double horasExtras = horasTrabajadas - 40;
            double pagoHorasExtras = horasExtras * tarifaPorHora * 1.5;
            return salarioNormal + pagoHorasExtras;
        }
    }

    @Override
    public double calcularBeneficios() {
        double fondoAhorro = 0;
        // Acceso a fondo de ahorro (2% del salario depositado mensualmente)
        // si Empleados por Horas con más de 1 año.
        if (this.getAnosEnEmpresa() >= 1) {
            fondoAhorro = calcularSalarioBruto() * 0.02;
        }
        return fondoAhorro;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
        validarHorasTrabajadas();
    }

    // Getters
    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }
}