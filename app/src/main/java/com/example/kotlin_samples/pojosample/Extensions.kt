package com.example.kotlin_samples.pojosample

data class Item(val price: Int, val name: String)

data class Order(val items: List<Item>)

//extension function
fun Order.maxPrice(): Int = this.items.maxBy {it.price}?.price?:0
fun Order.maxPriceItem(): String {return this.items.maxBy { it.price }?.name?:"No Item"}
//extension properties
val Order.itemNames: String
get() = items.map { it.name }.joinToString()

class Product{
    init {
        val order = Order(listOf(Item(2, "A"), Item(3, "B")))
        println(order.maxPrice())
        println(order.maxPriceItem())
        println(order.itemNames)

        val mutableitems: MutableList<Item> = mutableListOf(Item(2, "A"))
        val immutableitems: List<Item> = listOf(Item(3, "B"))
        mutableitems.add(Item(4, "C"))
        // immutableitems.add() // compiler error

        //convert Mutable list into Immutable
        val placerefernce: List<Item> = mutableitems
        //placerefernce.add() // compiler error
        // but can be added items in mutable reference like
        mutableitems.add(Item(5, "D"))

        for (item in immutableitems) {
            println(item)
        }

        mutableitems.forEach {
            item-> println(item)
        }

        //Set
        val mutableItemsSet = mutableSetOf<Item>(Item(1,"A"))
        val immutableItemsSet = setOf<Item>(Item(2, "B"))
        val immutable_to_mutable : Set<Item> = mutableItemsSet

        //Map
        val mutableItemMap = mutableMapOf<Item, Int>(Item(1,"A") to 1,
            Item(2, "B") to 2)
        val immutableItemMap = mapOf<Item, Int>(Item(1,"A") to 1,
            Item(2, "B") to 2)
        val immutable_to_mutable_map:Map<Item, Int> =mutableItemMap
        println(mutableItemMap[Item(1,"A")])//give null if key not in map
        println(mutableItemMap.getValue(Item(1,"A")))//throw exception if key not in map

        val mapWithDefault = mutableItemMap.withDefault { k-> k.price }
        println(mapWithDefault.getValue(Item(10,"A"))) //return default value as price if key not in map

        //filter function
        val filteritems = immutableitems.filter { it.price>1 }
        //map function
        val doublePriceItems = immutableitems.map { it.price*3 }
        //any function predicate-> return type is boolean
        val anyItem = immutableitems.any { it.price>0 }//return boolean true
        //all function predicate -> return type is boolean
        val allitem = immutableitems.all { it.price>0 }// return true if all items having price >0
        // return true if no item satisfy the predicte
        val noneitem = immutableitems.all { it.price>0 }// return true if no item not having price >0

        val words = listOf("Lets", "find", "something", "in", "collection", "somehow")  // 1

        //find function return first item and findLast return last item in the list
        val first = words.find { it.startsWith("some") }  //something                              // 2
        val last = words.findLast { it.startsWith("some") } //somehow                            // 3
        val nothing = words.find { it.contains("nothing") } // null

        // first function return first item from collection, last function return last item
        //can be used with predicate
        //If a collection is empty or doesn't contain elements matching the predicate,
        // the functions throw NoSuchElementException.
        //firstOrNull(), lastOrNull() - return null instead of exception
        val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1

        val firstel = numbers.firstOrNull() //1 //return null if element not present                        // 2
        val lastel = numbers.last()  //-6                          // 3

        val firstEven = numbers.first { it % 2 == 0 } //-2       // 4
        val lastOdd = numbers.last { it % 2 != 0 }  //-5

        // count function with predicate
        val totalItem = numbers.count ()
        val countItem = numbers.count { it>0 }

        //min and max function give min and max value from the list, return null if list is empty
        println(numbers.min())
        println(numbers.max())

        //sorted number
        println(numbers.sorted())
        println(numbers.sortedBy { -it })//decreasing order of natural order

        //partition splits the collection into 2 part, one for true predicate and other for false one
        // it return Pair(first, second)
        val evenodd = numbers.partition { it%2 ==0 }
        println(evenodd.first)
        println(evenodd.second)

        // can return Pair vale directly in even and odd
        val (even, odd) = numbers.partition { it%2 ==0 }
        println(even)
        println(odd)


        //flatmap function combines the list of operation and return one final list
        val numbersMap = mapOf("123" to 1, "234" to 2, "23" to 3)                        // 1
        val keyList = numbersMap.flatMap { (key, _)-> key.toList() } // 1, 2,3,2,3,4,2,3
        val valueList = numbersMap.flatMap { (_, value)-> listOf(value) }

        val orders = listOf<Order>(Order(listOf(Item(2, "A"), Item(3, "B"))),
            Order(listOf(Item(4, "A"), Item(5, "B"))))

        println(orders.map { it.items }) // [[Item(2,A), item(3,B)], [Item(4,A), item(5,B)]]
        println(orders.flatMap { it.items }) // [Item(2,A), item(3,B), Item(4,A), item(5,B)]


        val A = listOf("a", "b", "c")                  // 1
        val B = listOf(1, 2, 3, 4)                     // 1

        val resultPairs = A zip B // A to B: [(a, 1), (b, 2), (c, 3)]
        resultPairs.forEach { println(it) }
        val resultReduce = A.zip(B) { a, b -> "$a$b" } // $A$B: [a1, b2, c3]

        val list = listOf(0, 10, 20)
        println(list.getOrElse(1) { 42 })    // 10// return index value
        println(list.getOrElse(10) { 42 })   // 42 // return fallback value as 42 since index is outofBound



    }

    fun updateMap(map: MutableMap<Item,Int>, item: Item):Unit{
        if(map.containsKey(item)){
            //getValue() throws exception or get() returns null if key value pair does not exist
            val value: Int? = map.getValue(item)
        }

        for (item in map){
            println("${item.key} = ${item.value}")
        }

    }
}

data class Person(val name: String, val city: String, val phone: String) // 1

val people = listOf(                                                     // 2
    Person("John", "Boston", "+1-888-123456"),
    Person("Sarah", "Munich", "+49-777-789123"),
    Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
    Person("Vasilisa", "Saint-Petersburg1", "+7-999-123456"))

//associatedBy() generates map for assigned key and value, if value not assigned then whole Object become value
//groupBy() generates map for assigned key and value as List, if value not assigned then whole Object become value

val phoneBook = people.associateBy { it.phone }                          // 3
val cityBook = people.associateBy(Person::phone, Person::city)           // 4
val peopleCities = people.groupBy(Person::city, Person::phone)

/* o/p:
People: [Person(name=John, city=Boston, phone=+1-888-123456), Person(name=Sarah, city=Munich, phone=+49-777-789123), Person(name=Svyatoslav, city=Saint-Petersburg, phone=+7-999-456789), Person(name=Vasilisa, city=Saint-Petersburg, phone=+7-999-456789)]
Phone book: {+1-888-123456=Person(name=John, city=Boston, phone=+1-888-123456), +49-777-789123=Person(name=Sarah, city=Munich, phone=+49-777-789123), +7-999-456789=Person(name=Vasilisa, city=Saint-Petersburg, phone=+7-999-456789)}
City book: {+1-888-123456=Boston, +49-777-789123=Munich, +7-999-456789=Saint-Petersburg}
People living in each city: {Boston=[+1-888-123456], Munich=[+49-777-789123], Saint-Petersburg=[+7-999-456789, +7-999-456789]}
*/




