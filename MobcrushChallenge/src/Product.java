
public class Product {
    long id;
    boolean inStock; // not used, but easily available for future scalability

    public Product(long m_id, boolean m_inStock){
        id = m_id;
        inStock = m_inStock;
    }
}