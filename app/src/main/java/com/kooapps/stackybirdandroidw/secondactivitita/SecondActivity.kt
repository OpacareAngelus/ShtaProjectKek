package com.kooapps.stackybirdandroidw.secondactivitita

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kooapps.stackybirdandroidw.R
import com.kooapps.stackybirdandroidw.helperititka.Helper
import com.kooapps.stackybirdandroidw.mainactivitydsfklsdjfk.MainActivity
import com.kooapps.stackybirdandroidw.mamitaclasita.MamaClass
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class SecondActivity : AppCompatActivity() {
    private var mCompositeDisposableeqwehqwejkqwhekqwjeqwe: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        mCompositeDisposableeqwehqwejkqwhekqwjeqwe = CompositeDisposable()


        val reqTwoweqeqweqweqweqweqw = Retrofit.Builder()
            .baseUrl("http://pro.ip-api.com/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(Helper.RequestAwlkejqwlekqwjelqwe::class.java)


        mCompositeDisposableeqwehqwejkqwhekqwjeqwe?.add(
            reqTwoweqeqweqweqweqweqw.getDataAweklqjeqwklejqwelkqwjqklejqw()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ response -> onResponseeqwewjkeqwhejkqwheqwkejqw(response) }, { t -> onFailureewqejkwhqjkqwehwq(t) })
        )
    }

    private fun onFailureewqejkwhqjkqwehwq(t: Throwable) {
        Toast.makeText(this,t.message, Toast.LENGTH_SHORT).show()
    }

    private fun onResponseeqwewjkeqwhejkqwheqwkejqw(response: Helper.RetroArwejkrhwekrjwehr) {
        MamaClass.pampampapapapapapapapa.put("GEO", response.countryCode)
        startActivity(Intent(this, MainActivity::class.java))
    }


}