package com.example.foodreviewapp

/*
    Data class for storing restaurant information
 */
class RestaurantModel {
    var Name: String? = null
    private var Image: Int = 0
    var distance: String? = null
    var status: String? = null
    var diningType: String? = null
    var price: String? = null
    var rating: String? = null

    fun GetName(): String {
        return Name.toString()
    }

    fun SetName(Name: String) {
        this.Name = Name
    }

    fun GetRating(): String {
        return rating.toString()
    }

    fun SetRating(rating: String) {
        this.rating = rating
    }
    fun GetPrice(): String {
        return price.toString()
    }

    fun SetPrice(price: String) {
        this.price = price
    }
    fun GetDiningType(): String {
        return diningType.toString()
    }
    fun SetDiningType(diningType: String) {
        this.diningType = diningType
    }

    fun SetStatus(status: String) {
        this.status = status
    }
    fun GetStatus(): String {
        return status.toString()
    }


    fun GetImage(): Int {
        return Image
    }

    fun SetImage(Image: Int) {
        this.Image = Image
    }

    fun GetDistance(): String? {
        return distance
    }

    fun SetDistance(distance: String) {
        this.distance = distance
    }
}
