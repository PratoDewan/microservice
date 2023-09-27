public class Main {
    public static void main(String[] args) {
        Bag bag = new Bag(40);
        Crossbow crossbow = new Crossbow(20);
        Coin coin = new Coin(5);
        Key key = new Key(10);
        Map treasureMap = new Map(15);
        addToBag(bag, crossbow);
        addToBag(bag, coin);
        addToBag(bag, key);
        addToBag(bag, treasureMap);
    }

    private static void addToBag(Bag bag, Item item) {
        if (bag.canAddItem(item)) {
            bag.addItem(item);
            System.out.println(item.getName() + " added, current weight = " + bag.getCurrentWeight());
        } else {
            System.out.println("Bag is full! " + item.getName() + " can not be added!");
        }
    }
}