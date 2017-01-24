package com.example.kotlin.controllers

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by camilo on 21/01/17.
 */


/**
 * Nesse exato momento, estamos abrind    }
o a classe EditText
 * e adicionando mais uma função, que nesse caso é um novo
 * comportamento sem muitos esforços.
 */
fun EditText.onTextChange() : Observable<String> {

    val subject = BehaviorSubject.create<String>()
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            subject.onNext(s.toString())
        }

    })
    return subject
}