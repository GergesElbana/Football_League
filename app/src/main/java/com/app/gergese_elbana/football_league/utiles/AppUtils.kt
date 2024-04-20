package com.app.gergese_elbana.football_league.utiles

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import java.util.Locale
import java.util.regex.Pattern

object AppUtils {
    private var toast: Toast? = null

    fun Activity.showToast(message: String) {
        toast?.cancel()
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast?.show()
    }
    fun navigateToDestination(context: Context, destinationActivity: Class<*>, data: Bundle? = null) {
        val intent = Intent(context, destinationActivity)
        data?.let {
            intent.putExtras(it)
        }
        context.startActivity(intent)
    }
    fun ImageView.loadImg(url: String?) {
        if (!url.isNullOrEmpty()) Glide.with(context).load(url)
            //.placeholder(R.drawable.placeholder)
            .into(this)
    }

    private val EMAIL_REGEX_PATTERN = Pattern.compile(
        "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@" +
                "((([0-9]{1}|[1-9]{1}[0-9]{1}|1[0-9]{2}|2[0-4]{2}|25[0-5]{2})\\.)" +
                "{3}([0-9]{1}|[1-9]{1}[0-9]{1}|1[0-9]{2}|2[0-4]{2}|25[0-5]{2})|" +
                "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
    )

    private const val PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+\$).{8,}$"

    fun isValidEmail(email: String): Boolean {
        return EMAIL_REGEX_PATTERN.matcher(email).matches()
    }

    fun isValidPassword(password: String): Boolean {
        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches()
    }
    fun getLocaleLanguage(): String {
        return Locale.getDefault().language
    }
}