package AppCredito.clase;
import AppCredito.clase.clase.SolicitudDeCredito;

import java.util.Scanner;

public class AppCredito {
    //aplicamos como iniciador a esta clase
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la fecha de solicitud (dd/mm/yyyy): ");
        String fechaSolicitud = scanner.nextLine();

        System.out.println("Ingrese el nombre de la persona: ");
        String nombrePersona = scanner.nextLine();

        System.out.println("Ingrese la fecha de nacimiento de la persona (dd/mm/yyyy): ");
        String fechaNacimiento = scanner.nextLine();

        System.out.println("Ingrese el sexo de la persona: ");
        String sexo = scanner.nextLine();

        System.out.println("Ingrese el domicilio de la persona: ");
        String domicilio = scanner.nextLine();

        System.out.println("Ingrese el municipio de la persona: ");
        String municipio = scanner.nextLine();

        System.out.println("Ingrese el estado de la persona: ");
        String estado = scanner.nextLine();

        SolicitudDeCredito solicitud = new SolicitudDeCredito(fechaSolicitud, nombrePersona, fechaNacimiento, sexo,
                domicilio, municipio, estado);

        solicitud.calcularEdad();
        solicitud.validarDocumentos();

        if (solicitud.verificarCandidatura()) {
            solicitud.mostrarDatosSolicitante();
        } else {
            System.out.println("El solicitante no cumple con los requisitos para obtener el crédito.");
        }

        scanner.close();

    }
}

