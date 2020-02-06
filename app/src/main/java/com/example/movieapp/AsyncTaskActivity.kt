package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.counter_fragment_layout.*
import java.lang.ref.WeakReference

open class AsyncTaskActivity : AppCompatActivity() {

    private lateinit var task: CounterAsyncTask

    private lateinit var counterFragment: CounterFragment

    private  lateinit var tV : WeakReference<TextView>
   // private var asyncTask: CounterAsyncTask? = null



    override protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.async_task_activity_layout)

        if (savedInstanceState == null){
            counterFragment = CounterFragment.newInstance()

            supportFragmentManager
                .beginTransaction()
                .add(R.id.async_task_activity_main_frame, counterFragment)
                .commit()
        }  else{
          counterFragment = CounterFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.async_task_activity_main_frame, counterFragment)
                .commit()

        }
    }

    fun OnCreateClick(view: View){
        tV = WeakReference(counter_tv)
        task = CounterAsyncTask(tV)

    }

    fun OnStartClick(view:View){
        if(::task.isInitialized && !task.isCancelled) {
            task.execute(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
        }else if(::tV.isInitialized) {
            tV.get()?.text = "Please Create Task First!"
        }

    }

    fun OnCancelClick(view:View){
        if(::task.isInitialized) {
            task.cancel(true)
        }

    }

    override fun onStop() {
        task.cancel(true)
        super.onStop()
    }
    override fun onDestroy() {
        task.cancel(true)
        super.onDestroy()
    }

/*
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(STATE_COUNTER, mCounter)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        mCounter = savedInstanceState.getInt(STATE_COUNTER)
        updateCounterValue(mCounter)
        super.onRestoreInstanceState(savedInstanceState)
    }
*/

}
