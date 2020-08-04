package com.rnkotlin.kotlin.textview

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.rnkotlin.kotlin.textview.KotlinTextViewManager

/**
 * It is works correctly
 */
class KotlinTextViewPackage : ReactPackage {
    override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
        return emptyList()
    }

    override fun createViewManagers(reactContext: ReactApplicationContext) = listOf(KotlinTextViewManager())
}