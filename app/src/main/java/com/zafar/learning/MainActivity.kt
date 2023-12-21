package com.zafar.learning

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainActivity : FragmentActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitty_main)

        findViewById<Button>(R.id.btnRun).setOnClickListener {
            MyIntentService.startActionFoo(this, "param1 >>> ", "param2 >>>")
            MyIntentService.startActionBaz(this, "param1 ### ", "param2 ### ")
        }

        GlobalScope.launch(Dispatchers.Main) {
//            val result = producer()
            val result = producer1()
            result.collect {
                    println("Practice1: item >> $it")
                }
        }

        GlobalScope.launch(Dispatchers.Main) {
//            val result = producer()
            val result = producer1()
            delay(2500)
            result.collect {
                    println("Practice2: item >> $it")
                }
        }
    }
}

//mutable shared flow (Hot flow)
private fun producer1(): Flow<Int>  {
    val mutableSharedFlow = MutableSharedFlow<Int>()
    val list = listOf<Int>(1,2,3,4,5,6)
    GlobalScope.launch {
        list.forEach {
            mutableSharedFlow.emit(it)
            delay(1000)
        }
    }
    return mutableSharedFlow
}

//flow (cold flow)
private fun producer(): Flow<Int> = flow {
    val list = listOf<Int>(1,2,3,4,5,6)
    list.forEach {
        delay(1000)
        emit(it)
    }
}