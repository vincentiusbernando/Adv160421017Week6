package com.ubayadev.adv160421017week6.viewmodel

import android.app.Application
import android.provider.Telephony.Mms.Addr
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubayadev.adv160421017week6.model.Address
import com.ubayadev.adv160421017week6.model.Student

class DetailViewModel(application: Application) :AndroidViewModel(application) {
    val studentLD = MutableLiveData<Student>()
    val TAG = "volleyTag"
    fun fetch(id: Int) {
        var queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/students/students.json"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val result = Gson().fromJson<List<Student>>(it, object : TypeToken<List<Student>>() {}.type)
                var listStudent = result as ArrayList<Student>?
                studentLD.value=listStudent?.get(id-1)
                Log.d("showvoley", result.toString())
                Log.d("showvoley", it)
            },
            {
                Log.d("showvoley", it.toString())
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

}