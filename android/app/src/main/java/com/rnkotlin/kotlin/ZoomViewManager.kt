package com.rnkotlin.kotlin

/**
 * @since 2020
 * @author Anton Vlasov - whalemare
 */

import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.uimanager.events.RCTEventEmitter


/**
 * @author Anton Vlasov - whalemare
 * @since 2020
 */
open class ZoomViewManager @JvmOverloads constructor() : SimpleViewManager<SubsamplingScaleImageView>() {
    override fun createViewInstance(reactContext: ThemedReactContext): SubsamplingScaleImageView {
        val view = SubsamplingScaleImageView(reactContext)

        view.setOnClickListener {
            reactContext.getJSModule(RCTEventEmitter::class.java).receiveEvent(view.id, "onPress", null)
        }
        view.setOnLongClickListener {
            reactContext.getJSModule(RCTEventEmitter::class.java).receiveEvent(view.id, "onLongPress", null)
            true // TODO: maybe need check existing onLongPress property
        }
        view.setDebug(true)
        return view
    }

    override fun getName(): String {
        return "ZoomView"
    }

    override fun getExportedCustomDirectEventTypeConstants(): Map<String, Any>? {
        return mapOf(
            "onPress" to mapOf(
                "registrationName" to "onPress"
            ),
            "onLongPress" to mapOf(
                "registrationName" to "onLongPress"
            )
        )
    }


    @ReactProp(name = "image")
    fun setImage(view: SubsamplingScaleImageView, uri: String?) {
        if (uri == null || uri.isEmpty()) {
            throw IllegalArgumentException("Expected not null and not empty image path, but received: $uri")
        } else {
            view.setImage(ImageSource.asset(uri))
        }
    }

}