package com.andres.empleadopoo.models;

public abstract class Empleado {
    protected String nombre; // nombre del empleado
    protected String id; // ID del empleado
    protected int anosEnEmpresa; // Antigüedad en años

    public Empleado(String nombre, String id, int anosEnEmpresa) {
        this.nombre = nombre;
        this.id = id;
        this.anosEnEmpresa = anosEnEmpresa;
    }

    // Métodos abstractos que cada tipo de empleado debe implementar dado a que son hijas de empleado
    public abstract double calcularSalarioBruto();
    public abstract double calcularBeneficios();

    public double calcularDeduccionesObligatorias() {
        return calcularSalarioBruto() * 0.04;
    }

    public double calcularSalarioNeto() {
        double salarioNeto = calcularSalarioBruto() - calcularDeduccionesObligatorias() + calcularBeneficios();
        if (salarioNeto < 0) {
            System.err.println("Advertencia: El salario neto de " + this.nombre + " es negativo. Estableciendo a 0.");
            return 0;
        }
        return salarioNeto;
    }
    // METODOS GETTERS Y SETTERS
    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public int getAnosEnEmpresa() {
        return anosEnEmpresa;
    }
}