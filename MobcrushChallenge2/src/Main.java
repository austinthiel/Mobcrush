public class Main {

    public static void main(String[] args) {
        RelatedProducts rp = new RelatedProducts();

        // our customer base
        Customer c1 = new Customer(1);
        Customer c2 = new Customer(2);
        Customer c3 = new Customer(3);
        Customer c4 = new Customer(4);
        Customer c5 = new Customer(5);
        Customer c6 = new Customer(6);
        Customer c7 = new Customer(7);
        Customer c8 = new Customer(8);
        Customer c9 = new Customer(9);
        Customer c10 = new Customer(10);



        /////////////////////
        // Test Case 1
        /////////////////////
        Product p1 = new Product(111);
        Product p2 = new Product(222);

        rp.registerPurchase(c1.id, p1.id); // c1 purchased p1 and p2
        rp.registerPurchase(c1.id, p2.id);

        rp.registerPurchase(c2.id, p1.id);

        long id1 = rp.getRelatedCustomer(c2.id, p1.id); // store the id of customer C who also bought p1

        System.out.println(rp.getRelatedProducts(id1, p1.id, 3)); // returns the (up to 3) items that customer C also purchased
        //Solution = [222]


        /////////////////////
        // Test Case 2
        /////////////////////
        Product p3 = new Product(333);
        Product p4 = new Product(444);
        Product p5 = new Product(555);

        rp.registerPurchase(c1.id, p3.id);
        rp.registerPurchase(c1.id, p4.id);

        rp.registerPurchase(c2.id, p5.id);
        rp.registerPurchase(c2.id, p3.id);

        rp.registerPurchase(c3.id, p3.id);

        rp.registerPurchase(c4.id, p3.id);
        rp.registerPurchase(c4.id, p2.id);

        long id2 = rp.getRelatedCustomer(c1.id, p3.id); // store the id of customer C who also bought p1

        System.out.println(rp.getRelatedProducts(id2, p3.id, 2)); // returns the (up to 3) items that customer C also purchased
        //Solution = [555, 111]
    }
}
