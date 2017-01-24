package com.example.kotlin.model

import com.google.gson.annotations.SerializedName

/**
 * Created by camilo on 21/01/17.
 */

data class StackOverflowQuestion(
        @SerializedName("title") val title : String,
        @SerializedName("link") val link : String,
        @SerializedName("view_count") val viewCount: Int,
        @SerializedName("answer_count") val answeCount : Int,
        @SerializedName("score") val score : Int,
        @SerializedName("creation_date") val creationDate : Int
){
    override fun toString() = title
}
