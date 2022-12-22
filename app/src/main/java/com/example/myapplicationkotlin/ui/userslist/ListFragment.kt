package com.example.myapplicationkotlin.ui.userslist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationkotlin.R
import com.example.myapplicationkotlin.databinding.FragmentListBinding
import com.example.myapplicationkotlin.model.entity.User
import com.example.myapplicationkotlin.ui.adaptor.OnListItemClick
import com.example.myapplicationkotlin.ui.adaptor.UserRecyclerView


class ListFragment : Fragment(), OnListItemClick {

    private lateinit var binding: FragmentListBinding

    private var userName: String? = null

    private val userRecyclerView: UserRecyclerView by lazy {
        UserRecyclerView()
    }

    private lateinit var viewModel: UsersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userName = arguments?.getString("userName")

        viewModel = ViewModelProvider(requireActivity()).get(UsersViewModel::class.java)

        // binding to access layout id's
        binding.edtRecycle.adapter = userRecyclerView

        getAllUsers()




        binding.btnAdd.setOnClickListener {
            viewModel.addUser(
                User(
                    id = 0,
                    userName.toString(),
                    binding.edtMessegeData.text.toString(),
                    R.drawable.login
                )
            )
            getAllUsers()
            binding.edtMessegeData.setText("")
        }



        userRecyclerView.onListItemClick = this

        viewModel.usersLiveData.observe(viewLifecycleOwner,
            Observer {
                if (!it.isNullOrEmpty()) {
                    userRecyclerView.setList(it)
                    binding.progressBar.visibility = View.GONE
                }
            })
    }

    private fun getAllUsers() {

        viewModel.getUsers()
        //binding.progressBar.visibility = View.VISIBLE
    }

    override fun onItemClick(user: User) {
        viewModel.deleteUser(user)

        Toast.makeText(
            context,
            "The user is deleted successfully",
            Toast.LENGTH_SHORT
        ).show()
        getAllUsers()
    }


}