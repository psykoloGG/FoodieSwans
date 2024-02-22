package com.PsykoloGG.foodieswans

/*
    Data class for storing restaurant information
 */
class AccountReviewModel {
    var Name: String? = null
    var Review: String? = null

    fun GetName(): String {
        return Name.toString()
    }

    fun SetName(Name: String) {
        this.Name = Name
    }

    fun GetReview(): String {
        return Review.toString()
    }

    fun SetReview(rating: String) {
        this.Review = rating
    }
}
