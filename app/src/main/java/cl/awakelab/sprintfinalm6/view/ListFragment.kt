package cl.awakelab.sprintfinalm6.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import cl.awakelab.sprintfinalm6.R
import cl.awakelab.sprintfinalm6.databinding.FragmentListBinding

class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    private val phoneViewModel: PhoneViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        initAdapter()
        phoneViewModel.getPhones()
        return binding.root
    }
    private fun initAdapter() {
        val adapter = PhonesAdapter()

        binding.rvPhonesList.adapter = adapter
        phoneViewModel.phoneLiveData().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }
}

