package com.example.movieapp

import android.os.AsyncTask
import android.widget.TextView
import java.lang.ref.WeakReference

class CounterAsyncTask(private val tV: WeakReference<TextView>) : AsyncTask<Int, Int, String>(){

    override fun onPreExecute() {
        tV.get()?.text = ""
    }

    override fun doInBackground(vararg numbers: Int?): String {
        for (number in numbers) {
            if (isCancelled) {
                break
            }
            publishProgress(number)
            Thread.sleep(1000)
        }
        return "Done!"
    }

    override fun onProgressUpdate(vararg numbers: Int?) {
        tV.get()?.text = numbers[0].toString()
    }
    override fun onPostExecute(result: String?) {
        tV.get()?.text = result
    }

    override fun onCancelled() {
        tV.get()?.text = "An error occurred, " +
                "please try again later :("
    }

}