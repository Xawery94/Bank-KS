package Trash.VisitorExample;

public class Tobacco implements TabacoServ,Visitable{

    private double price;

    public Tobacco(double item) {
        price = item;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public double getPrice() {
        return price;
    }
}
