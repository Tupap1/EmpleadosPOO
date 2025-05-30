package com.andres.empleadopoo.models;


public class EmpleadoPorComision extends Empleado {
    private double sueldoBase;
    private double porcentajeComision;
    private double ventasRealizadas;
    private static final double BONO_ALIMENTACION = 1_000_000.0; // 1.000.000/mes

    public EmpleadoPorComision(String nombre, String id, int anosEnEmpresa, double sueldoBase, double porcentajeComision, double ventasRealizadas) {
        super(nombre, id, anosEnEmpresa);
        this.sueldoBase = sueldoBase;
        this.porcentajeComision = porcentajeComision;
        this.ventasRealizadas = ventasRealizadas;
        validarVentasRealizadas(); // Validación al construir
    }

    private void validarVentasRealizadas() {
        if (this.ventasRealizadas < 0) {
            throw new IllegalArgumentException("Las ventas no pueden ser menores a 0.");
        }
    }

    @Override
    public double calcularSalarioBruto() {
        return sueldoBase + (ventasRealizadas * porcentajeComision);
    }

    @Override
    public double calcularBeneficios() {
        double bonoAdicionalPorVentas = 0;
        // Si las ventas superan $2.000.000, recibe un bono adicional del 5%.
        if (this.ventasRealizadas > 2_000_000.0) {
            bonoAdicionalPorVentas = this.calcularSalarioBruto() * 0.05; // 5% del salario bruto por ventas
        }
        return bonoAdicionalPorVentas + BONO_ALIMENTACION;
    }

    public void setVentasRealizadas(double ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
        validarVentasRealizadas();
    }

    // Getters
    public double getSueldoBase() {
        return sueldoBase;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public double getVentasRealizadas() {
        return ventasRealizadas;
    }
}