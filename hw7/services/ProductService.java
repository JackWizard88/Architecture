@Component
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void addProduct(Product product) {
        productRepository.addNewProduct(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

}