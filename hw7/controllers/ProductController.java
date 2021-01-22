@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product_page")
    public String showProductPage(Model model) {
        List<Product> list = productService.getAllProducts();
        model.addAttribute("products", list);
        return "products";
    }

    @PostMapping("/add_product")
    public String addNewProduct(@RequestParam String name, @RequestParam long price) {
        Product product = new Product(name, price);
        productService.addProduct(product);
        return "redirect:/products/product_page";
    }

    @GetMapping("/delete_product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products/product_page";
    }
}