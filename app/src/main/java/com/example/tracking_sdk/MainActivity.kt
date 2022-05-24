package com.example.tracking_sdk

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import tech.solutionarchitects.tracking_sdk.ECOptions
import tech.solutionarchitects.tracking_sdk.ECTracker
import tech.solutionarchitects.tracking_sdk.events.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val options = ECOptions(
            bundle = "com.example",
            partnerId = "1234",
            uid = "1234")

        val tracker = ECTracker.initialize(options)

        findViewById<Button>(R.id.button_add_to_cart).setOnClickListener {
            val event = ECAddToCart()
            event.page = "MainActivity"

            event.add("1", "box", 5.99, "RUB", "category", "subcategory")
            event.add("2", "pizza", 399.99, "RUB", "category", "subcategory")

            tracker.event(event)
        }

        findViewById<Button>(R.id.button_purchase).setOnClickListener {
            val event = ECPurchase()
            event.page = "MainActivity"

            event.add("1", "box", 5.99, "RUB", "category", "subcategory")
            event.add("2", "pizza", 399.99, "RUB", "category", "subcategory")

            tracker.event(event)
        }

        findViewById<Button>(R.id.button_start_view).setOnClickListener {
            val event = ECStartView("1", "Ads")
            event.page = "MainActivity"

            tracker.event(event)
        }

        findViewById<Button>(R.id.button_stop_view).setOnClickListener {
            val event = ECStopView("1", "Ads", 0.4, "category", "subcategory")
            event.page = "MainActivity"

            tracker.event(event)
        }

        findViewById<Button>(R.id.button_viewing).setOnClickListener {
            val event = ECViewing("1", "Ads", 0.4, "category", "subcategory")
            event.page = "MainActivity"

            tracker.event(event)
        }

        findViewById<Button>(R.id.button_search).setOnClickListener {
            val event = ECSearch("Search Value")
            event.page = "MainActivity"

            tracker.event(event)
        }

        findViewById<Button>(R.id.button_ad_imp).setOnClickListener {
            val event = ECAdImp("1234", 320, 240, "www.google.com", "category", "subcategory")
            event.page = "MainActivity"

            tracker.event(event)
        }

        findViewById<Button>(R.id.button_ad_click).setOnClickListener {
            val event = ECAdClick("1234", 320, 240, "www.google.com", "category", "subcategory")
            event.page = "MainActivity"

            tracker.event(event)
        }

        findViewById<Button>(R.id.button_click).setOnClickListener {
            val event = ECClick("Click Value")
            event.page = "MainActivity"

            tracker.event(event)
        }

        findViewById<Button>(R.id.button_scroll).setOnClickListener {
            val event = ECScroll(1.2, "category", "subcategory")
            event.page = "MainActivity"

            tracker.event(event)
        }
    }
}