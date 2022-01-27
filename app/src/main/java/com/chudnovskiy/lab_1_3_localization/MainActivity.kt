package com.chudnovskiy.lab_1_3_localization

import android.graphics.Color
import android.graphics.Point
import android.hardware.display.DisplayManager
import android.os.Bundle
import android.view.Display
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import java.util.*

/**
 *  Locale.getDefault().getLanguage()       ---> en
Locale.getDefault().getISO3Language()   ---> eng
Locale.getDefault().getCountry()        ---> US
Locale.getDefault().getISO3Country()    ---> USA
Locale.getDefault().getDisplayCountry() ---> United States
Locale.getDefault().getDisplayName()    ---> English (United States)
Locale.getDefault().toString()          ---> en_US
Locale.getDefault().getDisplayLanguage()---> English
Locale.getDefault().toLanguageTag()     ---> en-US
 */

class MainActivity : AppCompatActivity() {
    private var width = 0
    private var height = 0
    private var localizationId: String? = null
    private var textViewTop: TextView? = null
    private var textViewMiddle: TextView? = null
    private var textViewButtom: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        getViewDimension()
        textViewInit()
        drawFLag()
    }

    private fun drawFLag() {
        getLocalization()
        when (localizationId) {
            "ru" -> drawRusFlag()
            "uk" -> drawUkrFlag()
            "pl" -> drawPlnFlag()
        }
    }

    private fun drawPlnFlag() {
        textViewMiddle?.visibility = View.GONE

        textViewTop?.height = height / 2 - 50
        textViewTop?.setBackgroundColor(Color.WHITE)

        textViewButtom?.height = height / 2 - 50
        textViewButtom?.setBackgroundColor(Color.RED)

        textViewTop?.text = Locale.getDefault().language


    }

    private fun drawRusFlag() {
        textViewMiddle?.visibility = View.VISIBLE

        textViewTop?.height = height / 3 - 50
        textViewTop?.setBackgroundColor(Color.WHITE)

        textViewMiddle?.height = height / 3 - 50
        textViewMiddle?.setBackgroundColor(Color.BLUE)

        textViewButtom?.height = height / 3 - 50
        textViewButtom?.setBackgroundColor(Color.RED)

        textViewTop?.text = Locale.getDefault().language
    }

    private fun drawUkrFlag() {
        textViewMiddle?.visibility = View.GONE

        textViewTop?.height = height / 2 - 50
        textViewTop?.setBackgroundColor(Color.YELLOW)


        textViewButtom?.height = height / 2 - 50
        textViewButtom?.setBackgroundColor(Color.BLUE)

        textViewTop?.text = Locale.getDefault().language
    }

    private fun getLocalization() {
        localizationId = Locale.getDefault().language
    }

    private fun textViewInit() {
        textViewTop = findViewById(R.id.text_view_top)
        textViewMiddle = findViewById(R.id.text_view_middle)
        textViewButtom = findViewById(R.id.text_view_bottom)
    }

    private fun getViewDimension() {
        val display = getSystemService<DisplayManager>()?.getDisplay(Display.DEFAULT_DISPLAY)
        val size = Point()
        display?.getSize(size)
        width = size.x
        height = size.y

        Toast.makeText(
            this,
            width.toString().plus(" ").plus(height.toString()),
            Toast.LENGTH_LONG
        ).show()
    }
}