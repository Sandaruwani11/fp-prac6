object WarehouseInventory {

  case class Product(id: Int, name: String, quantity: Int, price: Double)

  type Inventory = Map[Int, Product]

  val inventory1: Inventory = Map(
    101 -> Product(101, "ProductA", 10, 15.50),
    102 -> Product(102, "ProductB", 5, 25.00),
    103 -> Product(103, "ProductC", 20, 5.75)
  )

  val inventory2: Inventory = Map(
    102 -> Product(102, "ProductB", 3, 30.00),
    104 -> Product(104, "ProductD", 15, 12.00)
  )

  def getProductNames(inventory: Inventory): List[String] = {
    inventory.values.map(_.name).toList
  }

  def calculateTotal(inventory: Inventory): Double = {
    inventory.values.map(p => p.quantity * p.price).sum
  }

  def isEmpty(inventory: Inventory): Boolean = {
    inventory.isEmpty
  }

  def mergeInventories(inv1: Inventory, inv2: Inventory): Inventory = {
    inv1 ++ inv2.map { case (id, product) =>
      id -> inv1.get(id).map { existingProduct =>
        Product(
          id,
          existingProduct.name,
          existingProduct.quantity + product.quantity,
          if (existingProduct.price > product.price) existingProduct.price else product.price
        )
      }.getOrElse(product)
    }
  }

  def printProductDetails(inventory: Inventory, id: Int): Unit = {
    inventory.get(id) match {
      case Some(product) => println(s"Product Details: $product")
      case None => println(s"Product with ID $id not found.")
    }
  }

  def main(args: Array[String]): Unit = {
    println("All products in inventory1")
    println(getProductNames(inventory1))

    println("\nTotal value of products in inventory1")
    println(calculateTotal(inventory1))

    println("\ninventory1 is empty or not")
    println(isEmpty(inventory1))

    println("\nMerging inventory1 and inventory2")
    val mergedInventory = mergeInventories(inventory1, inventory2)
    println(mergedInventory)

    println("\nCheck if a product with a specific ID exists and its details")
    printProductDetails(inventory1, 102)
  }
}
