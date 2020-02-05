package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.movieapp.CounterFragment.Companion.FRAGMENT_TAG
import kotlinx.android.synthetic.main.counter_fragment_layout.*
import java.lang.ref.WeakReference

open class AsyncTaskActivity : AppCompatActivity() {

    private lateinit var task: CounterAsyncTask

    private lateinit var counterFragment: CounterFragment
   // private var asyncTask: CounterAsyncTask? = null



    override protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.async_task_activity_layout)


        counterFragment = CounterFragment()

        supportFragmentManager
           .beginTransaction()
           .add(R.id.async_task_activity_main_frame, counterFragment)
            .commit()
    }

    fun OnCreateClick(view: View){
        task = CounterAsyncTask(WeakReference(counter_tv))
        task.execute(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
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
