public class Cat extends Animal {
    private boolean fullness;

    public Cat(String name) {
        super(name, 200, 0);
        this.fullness = false;
    }

    public boolean isFull() {
        return fullness;
    }

    public void eatFromBowl(Bowl bowl) {
        int foodRequired = 10;
        if (bowl.decreaseFood(foodRequired)) {
            fullness = true;
            System.out.println(name + " поел и теперь сыт.");
        } else {
            System.out.println(name + " не смог поесть, еды недостаточно.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }
}
