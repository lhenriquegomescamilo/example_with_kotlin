package com.example.kotlin.controllers

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.EditText
import com.example.kotlin.R
import com.example.kotlin.R.id.toolbar
import com.example.kotlin.interfaces.services.StackOverflowApi
import io.reactivex.android.schedulers.AndroidSchedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by camilo on 21/01/17.
 */
class SearchActivity : AppCompatActivity() {
    /**
     * Lazy: Só executa essa expressão quando a variável for chamada
     */
    private val editSearchInput by lazy { findViewById(R.id.edit_search_input) as EditText }
    private val questionListRecyclerView by lazy {
        findViewById(R.id.question_list_recycler_view) as RecyclerView
    }
    private val toolbar by lazy { findViewById(R.id.toolbar) as Toolbar }

    val api: StackOverflowApi by lazy {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        retrofit.create(StackOverflowApi::class.java)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setSupportActionBar(toolbar)
        editSearchInput.onTextChange()
                .skip(3)
                .throttleLast(100, TimeUnit.MILLISECONDS)
                .debounce(200, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .filter { charSequence -> !charSequence.isNullOrBlank() }
                .map { charSequence -> charSequence.toString() }
    }

}