package com.zafar.learning

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.zafar.learning.Constants.WORK_DATA_KEY
import com.zafar.learning.Constants.WORK_MSG_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyWorkManager(context: Context, params: WorkerParameters) :
    CoroutineWorker(context,params) {
    override suspend fun doWork(): Result {
        println("MyWorkManager: doing some work >>>>> ")
        val data = withContext(Dispatchers.IO) {
            setProgress(workDataOf(WORK_MSG_KEY to "Doing some progress"))
            Thread.sleep(2000)
            setProgress(workDataOf(WORK_MSG_KEY to "Doing some more progress"))
            Thread.sleep(2000)
            setProgress(workDataOf(WORK_MSG_KEY to "Work is almost done"))
            Thread.sleep(2000)
            return@withContext /*workDataOf(WORK_DATA_KEY to "My WorkManager Data work finished")*/
        }
        val result = workDataOf(WORK_DATA_KEY to "Work is done")
        return Result.success(result)
    }
}