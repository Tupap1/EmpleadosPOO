package com.andres.empleadopoo;


import com.andres.empleadopoo.models.*;
import com.andres.empleadopoo.services.NominaService;

public class Main {
    public static void main(String[] args) {
        NominaService nominaService = new NominaService();

        // Crear instancias de diferentes tipos de empleados apara demostracion del codigo
        EmpleadoAsalariado emp1 = new EmpleadoAsalariado("Andres Cantillo", "EMP001", 6, 3000000.0);
        EmpleadoPorHoras emp2 = new EmpleadoPorHoras("David Castro", "EMP002", 0, 10000.0, 45);
        EmpleadoPorHoras emp3 = new EmpleadoPorHoras("Daniel Arroyo", "EMP003", 2, 12000.0, 38);
        EmpleadoPorComision emp4 = new EmpleadoPorComision("Ana Ramirez", "EMP004", 3, 1500000.0, 0.03, 2500000.0);
        EmpleadoPorComision emp5 = new EmpleadoPorComision("Sofia Martinez", "EMP005", 1, 1000000.0, 0.02, 1500000.0);
        EmpleadoTemporal emp6 = new EmpleadoTemporal("Alejandra Marcela Lemus", "EMP006", 0, 800000.0, "2025-12-31");

        // Agregar empleados al servicio de nómina para que podamos verlos en la lista de nomina que generaremos mas adelante
        nominaService.agregarEmpleado(emp1);
        nominaService.agregarEmpleado(emp2);
        nominaService.agregarEmpleado(emp3);
        nominaService.agregarEmpleado(emp4);
        nominaService.agregarEmpleado(emp5);
        nominaService.agregarEmpleado(emp6);

        // Generar nómina general esta fue una funcion adicional que agrege para ver todos los empleados instaciados anteriormente
        nominaService.generarNominaGeneral();
        // Generar nómina para un empleado específico
        System.out.println("\n- NÓMINA EMPLEADO -");
        // aca ponemos el codigo del empleado para obtener solo su nomina
        nominaService.generarNominaParaEmpleado("EMP001");

        // validación usando un bloque try catch para poder que el programa siga corriendo si hay algun errror, (si obtendrmos el error dado a que estamos poniendo valores incorectos para probar la validacion de los datos)
        try {
            EmpleadoPorHoras empError = new EmpleadoPorHoras("Error Tester", "ERR001", 0, 10000.0, -5);
            nominaService.agregarEmpleado(empError);
        } catch (IllegalArgumentException e) {
            System.err.println("\nError al crear empleado: " + e.getMessage());
        }

        // otro ejemplo de validación
        try {
            EmpleadoPorComision empError2 = new EmpleadoPorComision("Error Tester 2", "ERR002", 0, 1000000.0, 0.02, -100);
            nominaService.agregarEmpleado(empError2);
        } catch (IllegalArgumentException e) {
            System.err.println("Error al crear empleado: " + e.getMessage());
        }
    }
}