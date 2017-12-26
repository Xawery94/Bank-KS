package Trash.MediatorPL;

/**
 * Uruchomieniowa klasa testująca
 */
public class DesignPatternsMediator{
    public static void main(String[] args){

        //
        // Utworzenie obiektów oraz stworzenie dynamicznych powiązań
        //
        MediatorHub mediatorHub = new MediatorHub();

        JobWorker job1 = new JobWorker("Bank 1", mediatorHub);
        JobWorker job2 = new JobWorker("Bank 2", mediatorHub);
        JobWorker job3 = new JobWorker("Job3", mediatorHub);
        JobWorker job4 = new JobWorker("Job4", mediatorHub);

        mediatorHub.addJobWorker(job1);
        mediatorHub.addJobWorker(job2);
        mediatorHub.addJobWorker(job3);
        mediatorHub.addJobWorker(job4);

        //
        // Wysłanie komunikatu od obiektu1 do wszytkch obiektów roboczych
        //
        job1.sendMessage();

        //
        // Wysłanie komunikatu od obiektu2 do wszytkch obiektów roboczych
        // poza obiektem2
        //
        mediatorHub.removeJobWorker(job2);
        job2.sendMessage();
    }
}
