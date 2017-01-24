package com.example.kotlin.model

import com.google.gson.annotations.SerializedName

/**
 * Created by camilo on 21/01/17.
 */

/**
 * Classes que só carregam dados, que não fazem nenhum tipo de trabalho,
 * é aconselhável a utilizar a palavra reservada: data(com ele ganhamos, alguns
 * método como o toString, hasCode, equals, dentre outros)
 *
 * Recomendado para classes de modelos
 */
data class StackOverflowQuestions(
        @SerializedName("items") val items: List<StackOverflowQuestion> = emptyList()

)
