package com.faultaddr.accountingexpert.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.faultaddr.accountingexpert.R
import com.faultaddr.accountingexpert.databinding.FragmentHomeDetailBinding
import com.faultaddr.accountingexpert.ui.home.model.DetailListContent
import com.faultaddr.accountingexpert.ui.home.viewModel.HomeDetailViewModel
import com.haibin.calendarview.Calendar
import com.haibin.calendarview.CalendarView

class HomeDetailFragment : Fragment(), CalendarView.OnCalendarSelectListener,
    CalendarView.OnYearChangeListener {

    private var _binding: FragmentHomeDetailBinding? = null
    private val TAG = "HomeDetailFragment:"

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeDetailViewModel::class.java]
        homeViewModel.init()
        Log.i(TAG, "onCreateView: ")
        _binding = FragmentHomeDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val calendarView: CalendarView = binding.detailWeekCalendarView
        calendarView.monthViewPager.visibility = INVISIBLE
        calendarView.weekViewPager.visibility = VISIBLE
        calendarView.setOnCalendarSelectListener(this)
        calendarView.setOnYearChangeListener(this)

        val backButton: TextView = binding.homeFragmentDetailBack
        backButton.setOnClickListener {
            activity?.let {
                Navigation.findNavController(it, R.id.nav_host_fragment_activity_main)
                    .navigate(R.id.action_home)
            }
        }

        val detailRecyclerView: RecyclerView = binding.fragmentHomeDetailInfoList
        val adapter = DetailRecycleViewAdapter(requireContext())
        detailRecyclerView.adapter = adapter

        detailRecyclerView.layoutManager= LinearLayoutManager(activity)
        detailRecyclerView.addItemDecoration(DividerItemDecoration(activity,VERTICAL))
        homeViewModel.getDetailInfoLiveData().observe(viewLifecycleOwner) {
            Log.i(TAG, "detailInfoLiveData changed: $it")
            adapter.updateDetailInfoList(it) }
        homeViewModel.addRecord(DetailListContent("www", 100.00, "weixin"))
        homeViewModel.addRecord(DetailListContent("www", 100.00, "weixin"))

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onYearChange(year: Int) {
        TODO("Not yet implemented")
    }

    /**
     * 超出范围越界
     *
     * @param calendar calendar
     */
    override fun onCalendarOutOfRange(calendar: Calendar?) {
        TODO("Not yet implemented")
    }

    /**
     * 日期选择事件
     *
     * @param calendar calendar
     * @param isClick  isClick
     */
    override fun onCalendarSelect(calendar: Calendar?, isClick: Boolean) {
        // show the detail record
    }


}