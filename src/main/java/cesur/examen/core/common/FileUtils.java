package cesur.examen.core.common;

import cesur.examen.core.worker.Worker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Gabriel Rincón López
 * Fecha:11/12/2023
 *
 * No se permite escribir en consola desde las clases DAO, Service y Utils usando System.out.
 * En su lugar, usa log.info(), log.warning() y log.severe() para mostrar información interna
 * o para seguir la traza de ejecución.
 */


public class FileUtils {

    public static void toCSV(String fileName, List<Worker> workers) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Worker worker:workers) {
                bw.write(worker.getName()+","+worker.getDni()+","+worker.getFrom());
                bw.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
