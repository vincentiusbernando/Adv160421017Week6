package com.ubayadev.adv160421017week6.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubayadev.adv160421017week6.model.Student

class ListViewModel(application: Application): AndroidViewModel(application) {
    val studentsLiveData = MutableLiveData<ArrayList<Student>>()
    val studentLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null
    fun refresh() {
        loadingLD.value = true
        studentLoadErrorLD.value = false
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/students/students.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val result = Gson().fromJson<List<Student>>(it, object : TypeToken<List<Student>>() {}.type)
                studentsLiveData.value = result as ArrayList<Student>?
                loadingLD.value = false
                Log.d("showvoley", result.toString())
                Log.d("showvoley", it)
            },
            {
                Log.d("showvoley", it.toString())
                studentLoadErrorLD.value = false
                loadingLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)

        studentLoadErrorLD.value = false
        loadingLD.value = false
    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}