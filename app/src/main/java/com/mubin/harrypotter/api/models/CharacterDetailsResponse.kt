package com.mubin.harrypotter.api.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
class CharacterDetailsResponse : ArrayList<CharacterDetailsResponse.CharacterDetailsResponseItem>(){
    @Keep
    data class CharacterDetailsResponseItem(
        @SerializedName("actor")
        var actor: String?,
        @SerializedName("alive")
        var alive: Boolean?,
        @SerializedName("alternate_actors")
        var alternateActors: List<Any?>?,
        @SerializedName("alternate_names")
        var alternateNames: List<String?>?,
        @SerializedName("ancestry")
        var ancestry: String?,
        @SerializedName("dateOfBirth")
        var dateOfBirth: Any?,
        @SerializedName("eyeColour")
        var eyeColour: String?,
        @SerializedName("gender")
        var gender: String?,
        @SerializedName("hairColour")
        var hairColour: String?,
        @SerializedName("hogwartsStaff")
        var hogwartsStaff: Boolean?,
        @SerializedName("hogwartsStudent")
        var hogwartsStudent: Boolean?,
        @SerializedName("house")
        var house: String?,
        @SerializedName("id")
        var id: String?,
        @SerializedName("image")
        var image: String?,
        @SerializedName("name")
        var name: String?,
        @SerializedName("patronus")
        var patronus: String?,
        @SerializedName("species")
        var species: String?,
        @SerializedName("wand")
        var wand: Wand?,
        @SerializedName("wizard")
        var wizard: Boolean?,
        @SerializedName("yearOfBirth")
        var yearOfBirth: Any?
    ) {
        @Keep
        data class Wand(
            @SerializedName("core")
            var core: String?,
            @SerializedName("length")
            var length: Any?,
            @SerializedName("wood")
            var wood: String?
        )
    }
}