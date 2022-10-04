package com.example.tictactoeapp.Mode

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.tictactoeapp.R

class ModeFragment : Fragment() {

    companion object {
        fun newInstance() = ModeFragment()
    }

    private lateinit var viewModel: ModeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mode, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ModeViewModel::class.java)
        lateinit var firstName: String
        lateinit var secondName: String
        // TODO: Use the ViewModel
        view?.findViewById<Button>(R.id.button1)?.setOnClickListener {
            view?.findViewById<EditText>(R.id.name1)?.visibility = View.VISIBLE
            view?.findViewById<Button>(R.id.button_done)?.visibility = View.VISIBLE
            firstName = view?.findViewById<EditText>(R.id.name1)?.text.toString()
            secondName = view?.findViewById<EditText>(R.id.name2)?.text.toString()


        }
        view?.findViewById<Button>(R.id.button2)?.setOnClickListener {
            view?.findViewById<EditText>(R.id.name1)?.visibility = View.VISIBLE
            view?.findViewById<EditText>(R.id.name2)?.visibility = View.VISIBLE
            view?.findViewById<Button>(R.id.button_done)?.visibility = View.VISIBLE
            firstName = view?.findViewById<EditText>(R.id.name1)?.text.toString()
            secondName = view?.findViewById<EditText>(R.id.name2)?.text.toString()

        }

        view?.findViewById<Button>(R.id.button_done)?.setOnClickListener {
            view?.findNavController()?.navigate(ModeFragmentDirections.actionModeFragmentToGameFragment(firstName, secondName))
        }

    }

}