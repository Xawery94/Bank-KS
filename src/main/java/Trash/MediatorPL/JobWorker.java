package Trash.MediatorPL;

/**
 * Klasa definująca obiekt wysyłający komunikaty do mediatora
 * i odbirający komunikaty od mediatora
 */
class JobWorker{

    private String name;
    private Mediator mediator;

    public JobWorker(String name, Mediator mediator){
        this.name = name;
        this.mediator = mediator;
    }

    /**
     * Wysłanie komunikatu
     */
    public void sendMessage(){
        this.mediator.sendMessage(name + " Send msg");
    }

    /**
     * Odebranie komunikatu
     * @param message
     */
    public void receiveMessage(String message){
        System.out.println("Receive msg: '" + message + "' to: " + name);
    }
}
