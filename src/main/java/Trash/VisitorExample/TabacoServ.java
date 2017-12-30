package Trash.VisitorExample;

public interface TabacoServ {

    double getPrice();

    double accept(Visitor visitor);

}
