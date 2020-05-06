# Product Stock Manager Sample Application

### Database Configuration
In its default configuration, Petclinic uses an in-memory database (H2) which gets 
populated at startup with data. The h2 console is automatically exposed at 
http://localhost:8080/h2-console and it is possible to inspect the content of the 
database using the jdbc:h2:mem:productstockdb url.

### Methods
findAllProducts() - Returns a set with all products

findById(Long id) - Returns a product object with the specific id parameter

save(Product product) - Saves the product passed as a parameter in the database

getProducts (Model model) - Shows as an initial page an overview of all products 
including the stocks
                            
showProduct(@PathVariable Long productId) - Shows detailed information about the 
product addressed by ID and gives the possibility to replenish the stock or buy 
the product
                                            
initRefillStockForm(@PathVariable Long productId, Model model) - Initializes the form
to refill the stock

processRefillStockForm(@RequestParam("id") Long id, @RequestParam("addQuantity") Integer addQuantity) -
Processes the refill of the stock with the appropiate amount

initReduceStockForm(@PathVariable Long productId, Model model) - 
Initializes the form to buy the product

processReduceStockForm(@RequestParam("id") Long id, @RequestParam("boughtQuantity") Integer boughtQuantity) -
Processes the buy from the stock with the appropriate amount

showSuccess(@PathVariable Long productId) - Shows that the transaction was carried out successfully and 
gives the possibility to return to the overview or to access the product details 

showFailure(@PathVariable Long productId) - Shows that the transaction was not carried out successfully and 
gives the possibility to return to the overview or to access the product details

