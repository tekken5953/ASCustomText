package com.aslib

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat

@SuppressLint("Recycle","CustomViewStyleable")
class AsTextView(context: Context, attrs: AttributeSet) : AppCompatTextView(context,attrs) {
    private var sortResult: Int

    init {
        val sort: TypedArray = context.obtainStyledAttributes(attrs,R.styleable.AsTextView)
        sortResult = sort.getInt(R.styleable.AsTextView_sort,0)
        // 데이터를 캐싱해두어 가비지컬렉션에서 제외시키도록 하는 함수
        // typedArray 사용 후 호출해야하나, 커스텀뷰가 반복 사용되는 것이 아니라면 호출하지 않아도 무방하다.
        sort.recycle()
    }

    fun setSort(sort: String) {
        when(sort.lowercase()) {
            "grade" -> {sortResult = 0}
            "pm" -> {sortResult = 1}
            "co" -> {sortResult = 2}
            "co2" -> {sortResult = 3}
            "tvoc" -> {sortResult = 4}
            "virus" -> {sortResult = 5}
            "cqi" -> {sortResult = 6}
        }
    }

    fun getSort(): String {
        when(sortResult) {
            0 -> {return "grade"}
            1 -> {return "pm"}
            2 -> {return "co"}
            3 -> {return "co2"}
            4 -> {return "tvoc"}
            5 -> {return "virus"}
            6 -> {return "cqi"}
        }
        return "nothing"
    }

    fun setIndexText(index: String) {
        this.visibility = VISIBLE
        val indexFloat = index.toFloat()
        val indexInt = index.toInt()
        Log.d("AsTextView","sortResult is " + sortResult)
        when(sortResult) {
            // PM
            1 -> {
                if (indexFloat in 0f..15f) {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressGood, null))
                }
                else if (indexFloat > 15f && indexFloat <= 35f) {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressNormal, null))
                }
                else if (indexFloat > 35f && indexFloat <= 75f) {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressBad, null))
                }
                else if (indexFloat > 75f && indexFloat <= 100f) {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressWorst, null))
                }
                else {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressError, null))
                }
            }
            // CO
            2 -> {
                if (indexFloat in 0f..4.5f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressGood, null))
                else if (indexFloat > 4.5f && indexFloat <= 9f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressNormal, null))
                else if (indexFloat > 9f && indexFloat <= 10.8f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressBad, null))
                else if (indexFloat > 10.8f && indexFloat <= 50f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressWorst, null))
                else
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressError, null))
            }
            // CO2
            3 -> {
                if (indexFloat in 0f..500f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressGood, null))
                else if (indexFloat > 500f && indexFloat <= 1000f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressNormal, null))
                else if (indexFloat > 1000f && indexFloat <= 1200f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressBad, null))
                else if (indexFloat > 1200f && indexFloat <= 2000f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressWorst, null))
                else
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressError, null))
            }
            // TVOC
            4 -> {
                if (indexFloat in 0f..0.25f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressGood, null))
                else if (indexFloat > 0.25f && indexFloat <= 0.5f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressNormal, null))
                else if (indexFloat > 0.5f && indexFloat <= 0.6f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressBad, null))
                else if (indexFloat > 0.6f && indexFloat <= 3f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressWorst, null))
                else
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressError, null))
            }
            // VIRUS
            5 -> {
                when (indexInt) {
                    in 0..3 -> this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressGood, null))
                    in 4..6 -> this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressNormal, null))
                    in 7..8 -> this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressBad, null))
                    in 9..10 -> this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressWorst, null))
                    else -> this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressError, null))
                }
            }
            // CQI
            6 -> {
                when (indexInt) {
                    in 0..50 -> this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressGood, null))
                    in 51..100 -> this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressNormal, null))
                    in 101..250 -> this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressBad, null))
                    in 251..500 -> this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressWorst, null))
                    else -> this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressError, null))
                }
            }
        }
        if (sortResult == 0) {
            this.text = "sort option is grade. fix it"
            this.setTextColor(ResourcesCompat.getColor(context.resources, android.R.color.holo_red_dark, null))
        }
        this.text = index
    }

    fun setGradeText(grade: String) {
        this.visibility = VISIBLE
        if (sortResult == 0) {
            when (grade) {
                "0" -> {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressGood, null))
                    this.setText(R.string.good)
                }
                "1" -> {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressNormal, null))
                    this.setText(R.string.normal)
                }
                "2" -> {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressBad, null))
                    this.setText(R.string.bad)
                }
                "3" -> {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressWorst, null))
                    this.setText(R.string.very_bad)
                }
                else -> {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressError, null))
                    this.setText(R.string.error)
                }
            }
        } else {
            this.text = "sort option is not grade"
            this.setTextColor(ResourcesCompat.getColor(context.resources, android.R.color.holo_red_dark, null))
        }
    }
}