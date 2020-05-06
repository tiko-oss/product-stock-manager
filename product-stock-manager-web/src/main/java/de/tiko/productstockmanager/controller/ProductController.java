package de.tiko.productstockmanager.controller;

import de.tiko.productstockmanager.models.Product;
import de.tiko.productstockmanager.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController {

    private static final String VIEWS_REFILL_STOCK_FORM = "products/refillStockForm";
    private static final String VIEWS_REDUCE_STOCK_FORM = "products/reduceStockForm";

    private static final Integer MAX_STOCK = 200;
    private static final Integer MIN_STOCK = 0;

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping({"", "/"})
    public String getProducts (Model model) {

        model.addAttribute("product", productService.findAllProducts());

        return "products/findProducts";
    }

    @GetMapping("/{productId}")
    public ModelAndView showProduct(@PathVariable Long productId) {
        ModelAndView mav = new ModelAndView("products/productDetails");

        mav.addObject(productService.findById(productId));

        return mav;
    }

    @GetMapping("/{productId}/refill")
    public String initRefillStockForm(@PathVariable Long productId, Model model) {

        model.addAttribute(productService.findById(productId));

        return VIEWS_REFILL_STOCK_FORM;
    }

    @PostMapping("/update_refill")
    public String processRefillStockForm(@RequestParam("id") Long id,
                                         @RequestParam("addQuantity") Integer addQuantity) {
        Product savedProduct = productService.findById(id);


        int sum = savedProduct.getQuantity() + addQuantity;

        if (sum <= MAX_STOCK) {

            savedProduct.setQuantity(sum);

            productService.save(savedProduct);

            return "redirect:/success/" + id;
        }
        else {
            return "redirect:/failure/" + id;

        }
    }

    @GetMapping("/{productId}/reduce")
    public String initReduceStockForm(@PathVariable Long productId, Model model) {

        model.addAttribute(productService.findById(productId));

        return VIEWS_REDUCE_STOCK_FORM;
    }

    @PostMapping("/update_bought")
    public String processReduceStockForm(@RequestParam("id") Long id,
                                         @RequestParam("boughtQuantity") Integer boughtQuantity) {
        Product savedProduct = productService.findById(id);

        int diff = savedProduct.getQuantity() - boughtQuantity;

        if (diff >= MIN_STOCK) {

            savedProduct.setQuantity(diff);

            productService.save(savedProduct);

            return "redirect:/success/" + id;
        }
        else {
            return "redirect:/failure/" + id;

        }
    }

    @GetMapping("/success/{productId}")
    public ModelAndView showSuccess(@PathVariable Long productId) {
        ModelAndView mav = new ModelAndView("success");

        mav.addObject(productService.findById(productId));

        return mav;
    }

    @GetMapping("/failure/{productId}")
    public ModelAndView showFailure(@PathVariable Long productId) {
        ModelAndView mav = new ModelAndView("failure");

        mav.addObject(productService.findById(productId));

        return mav;
    }

}
