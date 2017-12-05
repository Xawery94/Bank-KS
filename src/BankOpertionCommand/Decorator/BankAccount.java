package BankOpertionCommand.Decorator;

import BankOpertionCommand.Command.Interface.BankOperation;

public interface BankAccount extends BankOperation{

    String getDescription();

}
