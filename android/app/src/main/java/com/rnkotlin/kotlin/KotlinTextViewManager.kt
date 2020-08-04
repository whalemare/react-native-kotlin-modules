package com.rnkotlin.kotlin

import android.widget.TextView
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp


/**
 * @author Anton Vlasov - whalemare
 * @since 2020
 */
open class KotlinTextViewManager : SimpleViewManager<TextView>() {
    override fun createViewInstance(reactContext: ThemedReactContext): TextView {
        return TextView(reactContext)
    }

    override fun getName(): String {
        return "KotlinTextView"
    }

    @ReactProp(name = "text")
    fun setText(view: TextView, text: String?) {
        view.text = text
    }
}