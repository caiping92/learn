package pers.cabin.java.design.visitor;

public class Feeder implements Visitor {
    /**
     * 食物
     */
    private String food;

    public Feeder(String food) {
        this.food = food;
    }

    @Override
    public void visit(Dog dog) {
        dog.eat(this.food);
    }
}
