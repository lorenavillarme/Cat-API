package com.example.catapi.Models


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatDataItem(
    @field:Json(name = "adaptability")
    val adaptability: Int?, // 5
    @field:Json(name = "affection_level")
    val affectionLevel: Int?, // 5
    @field:Json(name = "alt_names")
    val altNames: String?,
    @field:Json(name = "bidability")
    val bidability: Int?, // 3
    @field:Json(name = "cat_friendly")
    val catFriendly: Int?, // 4
    @field:Json(name = "cfa_url")
    val cfaUrl: String?, // http://cfa.org/Breeds/BreedsAB/Abyssinian.aspx
    @field:Json(name = "child_friendly")
    val childFriendly: Int?, // 3
    @field:Json(name = "country_code")
    val countryCode: String?, // EG
    @field:Json(name = "country_codes")
    val countryCodes: String?, // EG
    @field:Json(name = "description")
    val description: String?, // The Abyssinian is easy to care for, and a joy to have in your home. They’re affectionate cats and love both people and other animals.
    @field:Json(name = "dog_friendly")
    val dogFriendly: Int?, // 4
    @field:Json(name = "energy_level")
    val energyLevel: Int?, // 5
    @field:Json(name = "experimental")
    val experimental: Int?, // 0
    @field:Json(name = "grooming")
    val grooming: Int?, // 1
    @field:Json(name = "hairless")
    val hairless: Int?, // 0
    @field:Json(name = "health_issues")
    val healthIssues: Int?, // 2
    @field:Json(name = "hypoallergenic")
    val hypoallergenic: Int?, // 0
    @field:Json(name = "id")
    val id: String?, // abys
    @field:Json(name = "indoor")
    val indoor: Int?, // 0
    @field:Json(name = "intelligence")
    val intelligence: Int?, // 5
    @field:Json(name = "lap")
    val lap: Int?, // 1
    @field:Json(name = "life_span")
    val lifeSpan: String?, // 14 - 15
    @field:Json(name = "name")
    val name: String?, // Abyssinian
    @field:Json(name = "natural")
    val natural: Int?, // 1
    @field:Json(name = "origin")
    val origin: String?, // Egypt
    @field:Json(name = "rare")
    val rare: Int?, // 0
    @field:Json(name = "reference_image_id")
    val referenceImageId: String?, // 0XYvRd7oD
    @field:Json(name = "rex")
    val rex: Int?, // 0
    @field:Json(name = "shedding_level")
    val sheddingLevel: Int?, // 2
    @field:Json(name = "short_legs")
    val shortLegs: Int?, // 0
    @field:Json(name = "social_needs")
    val socialNeeds: Int?, // 5
    @field:Json(name = "stranger_friendly")
    val strangerFriendly: Int?, // 5
    @field:Json(name = "suppressed_tail")
    val suppressedTail: Int?, // 0
    @field:Json(name = "temperament")
    val temperament: String?, // Active, Energetic, Independent, Intelligent, Gentle
    @field:Json(name = "vcahospitals_url")
    val vcahospitalsUrl: String?, // https://vcahospitals.com/know-your-pet/cat-breeds/abyssinian
    @field:Json(name = "vetstreet_url")
    val vetstreetUrl: String?, // http://www.vetstreet.com/cats/abyssinian
    @field:Json(name = "vocalisation")
    val vocalisation: Int?, // 1
    @field:Json(name = "weight")
    val weight: Weight?,
    @field:Json(name = "wikipedia_url")
    val wikipediaUrl: String? // https://en.wikipedia.org/wiki/Abyssinian_(cat)
) : Parcelable