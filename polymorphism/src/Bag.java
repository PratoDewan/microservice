public class Bag {
    private int currentWeight = 0;
    private int capacity;

    public Bag(int capacity) {
        this.capacity = capacity;
    }

    public boolean canAddItem(Item item) {
        return currentWeight + item.getWeight() <= capacity;
    }

    public void addItem(Item item) {
        currentWeight = currentWeight + item.getWeight();
    }

    public int getCurrentWeight() {
        return currentWeight;
    }
}
