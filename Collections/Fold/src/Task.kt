// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    return customers.flatMap { it.getOrderedProducts() }.fold(HashSet<Product>()) {
        partSet, element ->
            partSet.add(element)
            return partSet

    }
}

fun Customer.getOrderedProducts(): List<Product> =
        this.orders.flatMap { it.products }

// Return all products that were ordered by at least one customer
fun Shop.getOrderedProducts(): Set<Product> =
        customers.flatMap { it.getOrderedProducts() }.toSet()