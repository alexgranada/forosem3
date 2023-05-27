package AppCredito.clase.clase;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class SolicitudDeCredito {

    //declaramos las variables como privados
    private String fechaSolicitud;
    private String nombrePersona;
    private String fechaNacimiento;
    private String sexo;
    private String domicilio;
    private String municipio;
    private String estado;
    private String empleadoRecibe;
    private boolean documentosValidos;
    private int edad;

    public SolicitudDeCredito(String fechaSolicitud, String nombrePersona, String fechaNacimiento, String sexo,
                              String domicilio, String municipio, String estado) {
        //declaramos las variables con su balor básico
        this.fechaSolicitud = fechaSolicitud;
        this.nombrePersona = nombrePersona;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.domicilio = domicilio;
        this.municipio = municipio;
        this.estado = estado;
        this.documentosValidos = false;
        this.empleadoRecibe = "";
        this.edad = 0;
    }

    public void validarDocumentos() {
        //validamos los datos ingresados devolvemos true o false respectivamente
        if(nombrePersona == "" || fechaNacimiento == "" || sexo =="" || domicilio =="" || estado == ""){
            this.documentosValidos = false;
        }else {
            this.documentosValidos = true;
        }
    }

    public boolean verificarCandidatura() {
        //identificamos el pais de procedencia
        if (edad >= 30 && edad <= 64 && documentosValidos && estado.equals("Perú")) {
            return true;
        } else {
            return false;
        }
    }

    public void calcularEdad() {
        //encontré en internet un paquete que permite obtener el año de nacimiento usé esa
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Period periodo = Period.between(fechaNac, fechaActual);
        edad = periodo.getYears();
    }

    public double obtenerMontoCredito() {
        //calculamos el bono que le va a tocar al usuario
        double montoCredito = 0.0;

        if (edad >= 30 && edad <= 35) {
            montoCredito = 4500.00;
        } else if (edad >= 36 && edad <= 40) {

            montoCredito = 5000.00;
        } else if (edad >= 41 && edad <= 50) {
            montoCredito = 5500.00;
        } else if (edad >= 51 && edad <= 60) {
            montoCredito = 6000.00;
        } else if (edad >= 61 && edad <= 64) {
            montoCredito = 7000.00;
        }

        return montoCredito;
    }

    public void mostrarDatosSolicitante() {
        //devolvemos datos a mostrar al usuario

        System.out.println("Datos del solicitante:");
        System.out.println("Nombre: " + nombrePersona);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        System.out.println("Edad: " + edad);
        System.out.println("Monto del crédito a recibir: S/ " + obtenerMontoCredito());
        System.out.println("Fechas de pago: El primer pago le llegará dentro de tres meses y el resto en un plazo de un año después de la solicitud");
    }


}

