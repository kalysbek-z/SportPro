package com.example.sportprokg.ui.fragments.competitions.detailedcompetitions

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sportprokg.DataCommunicator
import com.example.sportprokg.R
import com.example.sportprokg.ui.Activities.DetailedCompetitionsActivity
import com.github.barteksc.pdfviewer.PDFView
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

var pdfViewRegulation: PDFView? = null

class RegulationsFragment : Fragment(),
    DataCommunicator {

    private var regulation: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_regulations, container, false)

        pdfViewRegulation = view.findViewById(R.id.comp_regulation_pdfview)

        return view
    }

    override fun onResume() {
        super.onResume()
//        RetrievePDFFromUrl().execute(regulation)
    }

    override fun sendData(data: String) {
        if (data != null) {
            regulation = data
            RetrievePDFFromUrl().execute(data)
            Log.d("tag", "regulation link : $data")
        }
    }

    class RetrievePDFFromUrl : AsyncTask<String, Void, InputStream>() {
        override fun doInBackground(vararg params: String?): InputStream? {
            var inputStream: InputStream? = null

            try {
                val url = URL(params[0])

                val httpURLConnection = url.openConnection() as HttpURLConnection
                if (httpURLConnection.responseCode == 200) {
                    Log.d("tag", "response is ${httpURLConnection.responseCode}")
                    inputStream = BufferedInputStream(httpURLConnection.inputStream)
                } else {
                    Log.d("tag", "response is ${httpURLConnection.responseCode}")
                }
            } catch (e: IOException) {
                e.printStackTrace()
                Log.d("tag", "input stream is null")
                return null
            }
            return inputStream
        }

        override fun onPostExecute(result: InputStream?) {
            pdfViewRegulation?.fromStream(result)
                ?.enableSwipe(true)
                ?.swipeHorizontal(false)
                ?.enableDoubletap(true)
                ?.load()
        }
    }
}
