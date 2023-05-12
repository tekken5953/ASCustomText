package com.aslib

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import kotlin.math.roundToInt

@SuppressLint("Recycle","CustomViewStyleable")
class AsTextView(context: Context, attrs: AttributeSet) : AppCompatTextView(context,attrs) {
    private var sortResult: Int

    init {
        val sort: TypedArray = context.obtainStyledAttributes(attrs,R.styleable.AsTextView)
        sortResult = sort.getInt(R.styleable.AsTextView_sort,-1)
        // 데이터를 캐싱해두어 가비지컬렉션에서 제외시키도록 하는 함수
        // typedArray 사용 후 호출해야하나, 커스텀뷰가 반복 사용되는 것이 아니라면 호출하지 않아도 무방하다.
        sort.recycle()
    }

    fun setSort(sort: String) {
        when(sort.lowercase()) {
            "grade" -> {sortResult = 0}
            "pm2.5" -> {sortResult = 1}
            "co" -> {sortResult = 2}
            "co2" -> {sortResult = 3}
            "tvoc" -> {sortResult = 4}
            "virus" -> {sortResult = 5}
            "cqi" -> {sortResult = 6}
            "temp" -> {sortResult = 7}
            "humid" -> {sortResult = 8}
            "pm10" -> {sortResult = 9}
        }
    }

    fun getSort(): String {
        when(sortResult) {
            0 -> {return "grade"}
            1 -> {return "pm2.5"}
            2 -> {return "co"}
            3 -> {return "co2"}
            4 -> {return "tvoc"}
            5 -> {return "virus"}
            6 -> {return "cqi"}
            7 -> {return "temp"}
            8 -> {return "humid"}
            9 -> {return "pm10"}
        }
        return "nothing"
    }

    fun setIndexTextAsInt(mIndex: Float) {
        this.visibility = VISIBLE
        val indexInt = mIndex.toInt()

        indexMain(mIndex, indexInt)
        this.text = mIndex.roundToInt().toString()
    }

    fun setIndexTextAsFloat(index: Float) {
        this.visibility = VISIBLE
        val indexInt = index.toInt()

        indexMain(index,indexInt)
        this.text = index.toString()
    }

    fun setIndexTextAsDouble(mIndex: Float) {
        this.visibility = VISIBLE
        val indexInt = mIndex.toInt()
        indexMain(mIndex, indexInt)

        this.text = mIndex.toDouble().toString()
    }
    
    @SuppressLint("SetTextI18n")
    private fun indexMain(index: Float, indexInt: Int) {
        when(sortResult) {
            // PM2.5
            1 -> {
                if (index >= 0 && index < 15f) {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressGood, null))
                }
                else if (index >= 15f && index < 35f) {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressNormal, null))
                }
                else if (index >= 35f && index < 75f) {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressBad, null))
                }
                else if (index >= 75f) {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressWorst, null))
                }
                else {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressError, null))
                }
            }
            // CO
            2 -> {
                if (index >= 0 && index < 4.5f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressGood, null))
                else if (index >= 4.5f && index < 9f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressNormal, null))
                else if (index >= 9f && index < 10.8f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressBad, null))
                else if (index >= 10.8f && index < 50f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressWorst, null))
                else
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressError, null))
            }
            // CO2
            3 -> {
                if (index >= 0 && index < 500f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressGood, null))
                else if (index >= 500f && index < 1000f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressNormal, null))
                else if (index >= 1000f && index < 1200f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressBad, null))
                else if (index >= 1200f && index < 2000f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressWorst, null))
                else
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressError, null))
            }
            // TVOC
            4 -> {
                if (index >= 0 && index < 0.25f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressGood, null))
                else if (index >= 0.25f && index < 0.5f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressNormal, null))
                else if (index >= 0.5f && index < 0.6f)
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressBad, null))
                else if (index >= 0.6f && index < 3f)
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

            // TEMP
            7 -> {
                this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressGood, null))
            }

            // HUMID
            8 -> {
                this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressGood, null))
            }
            // PM10
            9 -> {
                if (index in 0.0..30.0) {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressGood, null))
                }
                else if (index > 30f && index <= 80f) {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressNormal, null))
                }
                else if (index > 80f && index <= 150f) {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressBad, null))
                }
                else if (index > 150f) {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressWorst, null))
                }
                else {
                    this.setTextColor(ResourcesCompat.getColor(context.resources, R.color.progressError, null))
                }
            }

        }
        if (sortResult !in 1..8) {
            this.text = "error"
            this.setTextColor(ResourcesCompat.getColor(context.resources, android.R.color.holo_red_light, null))
        }
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
            this.text = grade
            Log.e(javaClass.name,"sort option is not grade")
        }
    }
}