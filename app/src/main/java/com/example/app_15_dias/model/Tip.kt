package com.example.app_15_dias.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
        @StringRes val dayResource : Int,
        @StringRes val nameResource : Int,
        @DrawableRes val imageResource : Int,
        @StringRes val textResource : Int
    )
