public class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        this.foodAmount = initialFood;
    }

    public boolean decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("Добавлено " + amount + " единиц еды в миску. Теперь в миске " + foodAmount + " единиц еды.");
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
