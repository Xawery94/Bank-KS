package Trash.MediatorPL;
import java.util.ArrayList;

/**
 * Klasa implementująca interfejs mediatora,
 * jako jednyna zna wszystkie obiekty robocze
 */
class MediatorHub implements Mediator{


    private ArrayList<JobWorker> jobWorkers = new ArrayList <JobWorker> ();

    /**
     * Dodanie obiektu do obsługi komunikatów
     * @param jobWorker
     */
    public void addJobWorker(JobWorker jobWorker){
        jobWorkers.add(jobWorker);
    }

    /**
     * Usunięcie obiektu z obsługi komunikatów
     * @param jobWorker
     */
    public void removeJobWorker(JobWorker jobWorker){
        jobWorkers.remove(jobWorker);
    }

    /**
     * Wysłanie komunikatu do współpracujących obiektów
     * @param message
     */
    @Override
    public void sendMessage(String message){
        for (JobWorker jobWorker : jobWorkers){
            jobWorker.receiveMessage(message);
        }
    }
}