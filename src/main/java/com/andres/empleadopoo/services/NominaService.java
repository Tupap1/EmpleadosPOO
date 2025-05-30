package com.andres.empleadopoo.services;


import com.andres.empleadopoo.models.Empleado;
import java.util.ArrayList;
import java.util.List;

public class NominaService {
    private List<Empleado> listaEmpleados;

    public NominaService() {
        this.listaEmpleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        if (empleado != null) {
            listaEmpleados.add(empleado);
            System.out.println("Empleado " + empleado.getNombre() + " agregado.");
        }
    }

    public void generarNominaParaEmpleado(String idEmpleado) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getId().equals(idEmpleado)) {
                imprimirDetalleNomina(empleado);
                return;
            }
        }
        System.out.println("Empleado con ID " + idEmpleado + " no encontrado.");
    }
    // formateo para poder visualizar mejor los datos en la consola dado a que no hicimos una interfaz grafica
    public void generarNominaGeneral() {
        System.out.println("\n--- NÓMINA GENERAL ---");
        for (Empleado empleado : listaEmpleados) {
            imprimirDetalleNomina(empleado);
            System.out.println("--------------------");
        }
        System.out.println("--- FIN NÓMINA GENERAL ---\n");
    }

    private void imprimirDetalleNomina(Empleado empleado) {
        System.out.println("ID: " + empleado.getId());
        System.out.println("Nombre: " + empleado.getNombre());
        System.out.println("Tipo: " + empleado.getClass().getSimpleName());
        // Formateamos como se mostrara el string que devuelven nuestros metodos para una mejor visualizacion
        System.out.printf("Salario Bruto: $%,.2f%n", empleado.calcularSalarioBruto());
        System.out.printf("Deducciones Obligatorias: $%,.2f%n", empleado.calcularDeduccionesObligatorias());
        System.out.printf("Beneficios Adicionales: $%,.2f%n", empleado.calcularBeneficios());
        System.out.printf("Salario Neto: $%,.2f%n", empleado.calcularSalarioNeto());

    }

}