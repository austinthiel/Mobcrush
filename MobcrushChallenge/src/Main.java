
public class Main {
    public static void main(String[] args) {
        ProductNotifier pn = new ProductNotifier();

        // our customer base
        Customer c1 = new Customer(1, false);
        Customer c2 = new Customer(2, true);
        Customer c3 = new Customer(3, false);
        Customer c4 = new Customer(4, false);
        Customer c5 = new Customer(5, true);
        Customer c6 = new Customer(6, false);
        Customer c7 = new Customer(7, false);
        Customer c8 = new Customer(8, true);
        Customer c9 = new Customer(9, true);
        Customer c10 = new Customer(10, false);

        /////////////////////
        // Test Case 1
        /////////////////////
        Product p1 = new Product(123, false); // a product with id 1234 is not in stock

        // 3 customers want to be notified when it is in stock
        pn.notifyMe(p1.id, c1);
        pn.notifyMe(p1.id, c2);
        pn.notifyMe(p1.id, c3);

        System.out.println("Test 1: " + pn.getCustomersToNotify(p1.id, 1, 3)); // notifies 3 customers, with prime members having priority
        //Solution: [2, 1, 3]


        /////////////////////
        // Test Case 2
        /////////////////////
        Product p2 = new Product(456, false); // a product with id 5678 is not in stock

        // 2 non-prime and 1 prime customer want to be notified when it is in stock
        pn.notifyMe(p2.id, c4);
        pn.notifyMe(p2.id, c5);
        pn.notifyMe(p2.id, c6);

        System.out.println("Test 2: " + pn.getCustomersToNotify(p2.id, 0, 2)); // notifies 2 customers, prime members DONT have priority
        //Solution: [4, 5]


        /////////////////////
        // Test Case 3
        /////////////////////
        Product p3 = new Product(789, false); // a product with id 5678 is not in stock

        pn.notifyMe(p3.id, c1);
        pn.notifyMe(p3.id, c2);
        pn.notifyMe(p3.id, c3);
        pn.notifyMe(p3.id, c4);
        pn.notifyMe(p3.id, c5);
        pn.notifyMe(p3.id, c6);
        pn.notifyMe(p3.id, c7);
        pn.notifyMe(p3.id, c8);
        pn.notifyMe(p3.id, c9);
        pn.notifyMe(p3.id, c10);

        System.out.println("Test 3: " + pn.getCustomersToNotify(p3.id, 1, 8)); // notifies 8 customers, with prime members having priority
        //Solution : [2, 5, 8, 9, 1, 3, 4, 6]
    }
}
