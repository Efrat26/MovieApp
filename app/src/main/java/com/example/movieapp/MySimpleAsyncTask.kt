package com.example.movieapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.counter_fragment_layout.*
import java.lang.ref.WeakReference

const val THREAD_NAME = "Handler_executor_thread"

class MySimpleAsyncTask: AppCompatActivity() {

    private var IsCancelled = false
    private lateinit var tV: WeakReference<TextView>

    override protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.async_task_activity_layout)

        val counterFragment = CounterFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.async_task_activity_main_frame, counterFragment)
            .commit()
    }

    fun OnCreateClick(view: View){
        tV = WeakReference(counter_tv)
       execute(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
    }


    override fun onStop() {
       // task.cancel(true)
        cancel()
        super.onStop()
    }
    override fun onDestroy() {
        //task.cancel(true)
        cancel()
        super.onDestroy()
    }


    fun onPreExecute(){

        tV.get()?.text = ""
    }


    fun doInBackground(vararg numbers: Int?){

        val thread = Thread(
            Runnable {
                    for (number in numbers) {
                        if (IsCancelled) {
                            break
                        }
                        publishProgress(number!!)
                        Thread.sleep(1000)
                    }
                onPostExecute("Done!")
                }

        )
        thread.start()
    }


    fun onPostExecute(result: String?){
        tV.get()?.text = result
    }


    fun execute(vararg numbers: Int?){

        onPreExecute()

        //execute thread
        doInBackground(*numbers)



    }

    fun publishProgress(progress: Int){
        onProgressUpdate(progress)
    }
    fun onProgressUpdate(vararg values: Int?){

        tV.get()?.text = values[0].toString()
    }


    fun cancel(){

        IsCancelled = true
    }

}
