@Component
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        this.productList = new ArrayList<>(Arrays.asList(
                new Product("Bread", 25),
                new Product("Milk", 80),
                new Product("Cheese", 900),
                new Product( "Eggs", 120),
                new Product("Coffee", 450)
        ));
        System.out.println("Trucks arrived and filled our shop with items");
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productList);
    }

    public Product findItemById(Long id) {
        for (Product i : productList) {
            if (i.getId() == id) {
                return i;
            }
        }
        throw new ProductNotFoundException("Item not found on our store");
    }

    public void addNewProduct(Product product) {
        productList.add(product);
    }

    public void deleteById(Long id) {
        productList.removeIf(b -> b.getId() == id);
    }
}