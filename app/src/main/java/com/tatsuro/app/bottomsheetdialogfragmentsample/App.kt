package com.tatsuro.app.bottomsheetdialogfragmentsample

import android.app.Application
import androidx.annotation.StringRes
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.soloader.SoLoader

@Suppress("unused")
class App : Application() {

    init {
        instance = this
    }

    companion object {

        /** Appインスタンス */
        private lateinit var instance: App

        /**
         * Returns a localized string from the application's package's default string table.
         * @param resId Resource id for the string
         * @return The string data associated with the resource, stripped of styled text information.
         */
        fun getString(@StringRes resId: Int) = instance.getString(resId)
    }

    override fun onCreate() {
        super.onCreate()
        initFlipper()
    }

    /**
     * Flipperを初期化する。
     *
     * 有効にするプラグインは以下とする。
     * - InspectorFlipperPlugin
     */
    private fun initFlipper() {
        SoLoader.init(this,false)

        if (!BuildConfig.DEBUG || !FlipperUtils.shouldEnableFlipper(this)) {
            return
        }

        val client = AndroidFlipperClient.getInstance(this).apply {
            //////////////////////
            // pluginを追加する。
            //////////////////////
            // レイアウト
            val descriptorMapping = DescriptorMapping.withDefaults()
            addPlugin(InspectorFlipperPlugin(this@App, descriptorMapping))
        }
        client.start()
    }
}
