package cesur.examen.core.worker;

import java.util.Date;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 * <p>
 * Nombre del alumno: Gabriel Rincón López
 * Fecha:11/12/2023
 * <p>
 * No se permite escribir en consola desde las clases DAO, Service y Utils usando System.out.
 * En su lugar, usa log.info(), log.warning() y log.severe() para mostrar información interna
 * o para seguir la traza de ejecución.
 */

/**
 *  Services classes offers methods to our main application, and can
 *  use multiple methods from DAOs and Entities.
 *  It's a layer between Data Access Layer and Aplication Layer (where
 *  Main app and controllers lives)
 *  It helps to encapsulate multiple opperations with DAOs that can be
 *  reused in application layer.
 */
public class WorkerService {
    /*
    RenovateWorker() set "from" date of the worker with this dni to today's date.
    Remember Date().
    Returns the new updated worker, null if fails or dni doesn't exist.
    */
    public static Worker renovateWorker(String dni) {
        Worker out = null;

        /* Make implementation here ...  */
        var workerDAO = new WorkerDAO();
        Worker worker = workerDAO.getWorkerByDNI(dni);

        if (worker != null) {
            Date date = new Date();
            worker.setFrom(date);
            Worker workerUpdated = workerDAO.update(worker);
            if(workerUpdated!=null){
                out = workerUpdated;
            }
        }

        return out;
    }
}
