import java.util.*;

public class ProductNotifier {
    Map<Long, ArrayList<Customer>> map = new HashMap<>();

    public ProductNotifier(){
        final int SCHEME_FIFO = 0;
        final int SCHEME_PRIME_FIRST = 1;
    }

    protected ArrayList<Long> getCustomersToNotify(long productId, int scheme, int numCustomersToBeNotified){
        ArrayList<Long> customerIdList = new ArrayList<Long>();

        ArrayList<Customer> list = map.get(productId); // list of customers waiting to be notified for a specific product
        if(scheme == 0){ // SCHEME_FIFO
            for(int i = 0; i < list.size() && i < numCustomersToBeNotified; i++){
                customerIdList.add(list.get(i).id);
            }
        }else if(scheme == 1){ // SCHEME_PRIME_FIRST, separate prime customers from non-prime customers
            ArrayList<Long> primeCustomerIds = new ArrayList<Long>();
            ArrayList<Long> nonPrimeCustomerIds = new ArrayList<Long>();
            for (int i = 0; i < list.size(); i++){
                Customer c = list.get(i);
                if(c.isPrime){
                    primeCustomerIds.add(c.id);
                }else{
                    nonPrimeCustomerIds.add(c.id);
                }
            }
            // order primeMembers first, nonPrimeMembers second, and trim the list to numCustomersToBeNotified size
            customerIdList = new ArrayList<Long>(primeCustomerIds);
            customerIdList.addAll(nonPrimeCustomerIds);
            customerIdList = new ArrayList(customerIdList.subList(0, numCustomersToBeNotified));
        }
        return customerIdList;
    }

    protected void notifyMe(long productId, Customer customer){
        if(!map.containsKey(productId)){
            map.put(productId, new ArrayList<Customer>()); // create an arraylist in the hashmap if one doesn't exist
        }
        map.get(productId).add(customer); // add customers to the arraylist to be notified when the product is in stock
    }
}
