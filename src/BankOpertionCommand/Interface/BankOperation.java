package BankOpertionCommand.Interface;

public interface BankOperation {

    void transfer();        //przelew

    void withdraw();        //wypłata

    void payment();         //wpłata

    void closeAccount();    //zamkniecie konta

    void openDebit();       //otwarcie debetu

}
