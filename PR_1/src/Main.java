import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Store store = new Store();

        store.addProduct(new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", new Category(1, "Електроніка")));
        store.addProduct(new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", new Category(1, "Смартфони")));
        store.addProduct(new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", new Category(1, "Аксесуари")));

        Cart cart = new Cart();
        OrderHistory orderHistory = new OrderHistory();
        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Пошук товарів по назві");
            System.out.println("3 - Пошук товарів по категорії");
            System.out.println("4 - Додати товар до кошика");
            System.out.println("5 - Видалити товар з кошика");
            System.out.println("6 - Переглянути кошик");
            System.out.println("7 - Зробити замовлення");
            System.out.println("8 - Переглянути історію замовлень");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(store);
                    break;
                case 2:
                    System.out.println("Введіть назву товару для додавання до кошика:");
                    String name = scanner.next();

                    List<Product> productsByName = store.findProductByName(name);
                    if(!productsByName.isEmpty()) {
                        System.out.println(productsByName);
                    } else {
                        System.out.println("Товар з таким імʼям не знайдено");
                    }
                    break;
                case 3:
                    System.out.println("Введіть категорію товару для додавання до кошика:");
                    String categoryName = scanner.next();

                    List<Product> productsByCategory = store.findProductByCategory(categoryName);
                    if(!productsByCategory.isEmpty()) {
                        System.out.println(productsByCategory);
                    } else {
                        System.out.println("Товар з таким імʼям не знайдено");
                    }
                    break;
                case 4:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int id = scanner.nextInt();

                    Product product = store.findProductById(id);
                    if(product != null) {
                        cart.addProduct(product);
                    } else {
                        System.out.println("Товар з таким ID не знайдено");
                    }
                    break;
                case 5:
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int idToRemove = scanner.nextInt();

                    Product productToRemove = cart.findProductById(idToRemove);
                    if(productToRemove != null) {
                        cart.removeProduct(productToRemove);
                    } else {
                        System.out.println("Товар з таким ID не знайдено у кошику");
                    }
                    break;
                case 6:
                    System.out.println(cart);
                    break;
                case 7:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        Order order = new Order(cart);
                        orderHistory.addOrder(order);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        cart.clear();
                    }
                    break;
                case 8:
                    System.out.println(orderHistory);
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;
            }
        }
    }
}