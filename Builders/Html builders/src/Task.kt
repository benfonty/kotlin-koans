fun renderProductTable(): String {
    return html {
        table {
            tr(getTitleColor()) {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            val products = getProducts()
            for ((line, product) in products.withIndex()) {
                tr {
                    td(getCellColor(line, 1)) {
                        text(product.description)
                    }
                    td(getCellColor(line, 2)) {
                        text(product.price)
                    }
                    td(getCellColor(line, 3)) {
                        text(product.popularity)
                    }
                }
            }
        }
    }.toString()
}

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, column: Int) = if ((index + column) % 2 == 0) "#dce4ff" else "#eff2ff"
