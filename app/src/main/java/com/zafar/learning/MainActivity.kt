package com.zafar.learning

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.zafar.learning.Constants.WORK_DATA_KEY
import com.zafar.learning.Constants.WORK_MSG_KEY
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

    private lateinit var myService: MyService
    private val connection = object: ServiceConnection {

        override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
            println("Service Conneting >>>>> ")
            val binder = service as MyService.MyServiceBinder
            myService = binder.getService()
            println("Service Connected >>>>> ")

        }

        override fun onServiceDisconnected(p0: ComponentName?) {
        }

    }
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitty_main)

        findViewById<Button>(R.id.btnRun).setOnClickListener {
            //using intent service
//            useIntentService()

            // using work manager
//            useWorkManager()

            //using bound service
            useBindService()
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

    override fun onStart() {
        super.onStart()
        Intent(this, MyService::class.java).also {
            bindService(it, connection, BIND_AUTO_CREATE)
        }

        val intent = Intent(this,MyService::class.java)
        bindService(intent,connection, BIND_AUTO_CREATE)
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
    }

    private fun useBindService() {
        myService.doSomething()
    }

    private fun useIntentService() {
        MyIntentService.startActionFoo(this, "param1 >>> ", "param2 >>>")
        MyIntentService.startActionBaz(this, "param1 ### ", "param2 ### ")
    }

    private fun useWorkManager() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val workRequest = OneTimeWorkRequestBuilder<MyWorkManager>()
            .setConstraints(constraints)
            .build()
       val workManager =  WorkManager.getInstance(applicationContext)
            workManager.enqueue(workRequest)

        // getting the work info live data
        val workInfo = workManager.getWorkInfoByIdLiveData(workRequest.id)
        workInfo.observe(this) {
            when (it.state) {
                WorkInfo.State.SUCCEEDED -> {
                    val result = it.outputData.getString(WORK_DATA_KEY)
                    println("WorkManager: WorkInfo.SUCCEEDED and data is >> $result")
                }
                WorkInfo.State.RUNNING -> {
                    val progress = it.progress.getString(WORK_MSG_KEY)
                    if (progress != null)
                        println("WorkManager: WorkInfo.RUNNING $progress")

                }
                WorkInfo.State.FAILED -> {
                    println("WorkManager: WorkInfo.FAILED")

                }
                else -> {
                    println("WorkManager: WorkInfo.ELSE")
                }
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