import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RelatedProducts {

    Map<Integer, ArrayList<Long>> map = new HashMap<>();

    protected void registerPurchase(long customerID, int productId){
        if(!map.containsKey(productId)){
            map.put(productId, new ArrayList<Long>()); // create an arraylist in the hashmap if one doesn't exist
        }
        map.get(productId).add(customerID); // add customers to the arraylist
    }

    protected ArrayList<Integer> getRelatedProducts(long customerID, int productId, int numProducts){
        ArrayList<Integer> relatedProductList = new ArrayList<>();
        int size = 0; // keep relatedProductList under size numProducts
        for(Map.Entry<Integer, ArrayList<Long>> entry : map.entrySet()){ // loop to obtain products bought by 'customerID'
            if (entry.getValue().contains(customerID) && entry.getKey() != productId){
                relatedProductList.add(entry.getKey());
                size++;
                if(size == numProducts){
                    break;
                }
            }
        }
        return relatedProductList;
    }

    protected long getRelatedCustomer(long customerID, int productId){
        ArrayList<Long> alsoBoughtList = map.get(productId);
        long relatedCustomer = -1;

        if(alsoBoughtList.size() > 1){
            for(long i : alsoBoughtList){ // get first customer who also bought 'productId'
                if(i != customerID){
                    relatedCustomer = i;
                    break;
                }
            }
        }
        return relatedCustomer;
    }
}
