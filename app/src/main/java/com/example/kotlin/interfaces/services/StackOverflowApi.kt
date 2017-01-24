package com.example.kotlin.interfaces.services

import com.example.kotlin.model.StackOverflowQuestions
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable


/**
 * Created by camilo on 21/01/17.
 */
interface StackOverflowApi {

    @GET("/2.2/questions?order=desc&sort=creation&stackoveflow")
    fun taggedQuestions(@Query("tagged") tags: String) : Observable<StackOverflowQuestions>
}


