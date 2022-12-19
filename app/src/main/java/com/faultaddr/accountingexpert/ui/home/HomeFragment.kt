package com.faultaddr.accountingexpert.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.EditText
import android.widget.GridView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.afollestad.materialdialogs.LayoutMode
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.bottomsheets.BottomSheet
import com.afollestad.materialdialogs.bottomsheets.setPeekHeight
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.faultaddr.accountingexpert.App
import com.faultaddr.accountingexpert.R
import com.faultaddr.accountingexpert.databinding.FragmentHomeBinding
import com.faultaddr.greendaoapp.db.DaoSession
import com.faultaddr.greendaoapp.db.RecordDetail
import com.faultaddr.greendaoapp.db.RecordDetailDao
import com.haibin.calendarview.Calendar
import com.haibin.calendarview.CalendarView
import com.haibin.calendarview.CalendarView.OnCalendarLongClickListener
import org.greenrobot.greendao.query.Query
import org.json.JSONObject

class HomeFragment : Fragment(), CalendarView.OnCalendarSelectListener,
    CalendarView.OnYearChangeListener, View.OnClickListener,
    OnCalendarLongClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val TAG = "HomeFragment:"
    private var detailQuery: Query<RecordDetail>? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val calendarView: CalendarView = binding.calendarView
        calendarView.setOnCalendarSelectListener(this)
        calendarView.setOnYearChangeListener(this)
        calendarView.setOnCalendarLongClickListener(this)
        val application: App  = activity?.application as App
        val daoSession: DaoSession = application.daoSession
        val recordDetailDao = daoSession.recordDetailDao
        detailQuery = recordDetailDao.queryBuilder().orderAsc(RecordDetailDao.Properties.Date).build()
        var details: List<RecordDetail>  = detailQuery?.list() ?: ArrayList()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * 超出范围越界
     *
     * @param calendar calendar
     */
    override fun onCalendarOutOfRange(calendar: Calendar?) {
        Log.i(TAG,"onCalendarOutOfRange")
    }

    /**
     * 日期选择事件
     *
     * @param calendar calendar
     * @param isClick  isClick
     */
    override fun onCalendarSelect(calendar: Calendar?, isClick: Boolean) {
        if (isClick) {
            activity?.let {
                Navigation.findNavController(it, R.id.nav_host_fragment_activity_main)
                    .navigate(R.id.action_home_detail)
            };
        }
    }

    override fun onYearChange(year: Int) {
        TODO("Not yet implemented")
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    /**
     * 超出范围越界
     *
     * @param calendar calendar
     */
    override fun onCalendarLongClickOutOfRange(calendar: Calendar?) {
        TODO("Not yet implemented")
    }

    /**
     * 日期长按事件
     *
     * @param calendar calendar
     */
    override fun onCalendarLongClick(calendar: Calendar?) {
        val date = calendar.toString()
        Log.i(TAG, "onCalendarLongClick")
        val screenHeight = binding.root.height
        val materialDialog =
            MaterialDialog(this.requireContext(), BottomSheet()).show {
                setPeekHeight(literal = screenHeight)
                customView(
                    R.layout.custom_grid_dialog,
                    horizontalPadding = true,
                    noVerticalPadding = false
                )
            }
        var courseList: List<GridViewModal> = ArrayList()
        val gridView = materialDialog.getCustomView().findViewById<GridView>(R.id.grid_view)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        courseList = courseList + GridViewModal("午餐", R.drawable.ic_notifications_black_24dp)
        gridView.adapter = GridRVAdapter(courseList, this@HomeFragment.requireActivity())
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            // inside on click method we are simply displaying
            // a toast message with course name.
            val editorDialog = MaterialDialog(
                this.requireContext(),
                BottomSheet(LayoutMode.WRAP_CONTENT)
            ).show {
                customView(R.layout.custom_number_keyboard)
                positiveButton(R.string.agree) { dialog ->

                    val text = dialog.getCustomView().findViewById<EditText>(R.id.code).text
                    Log.i(TAG, "view: " + dialog.getCustomView() + text)
                    // TODO: save the result (account_book_id, category,associate_person, date, text, timestamp) -> sqlite db
                    Toast.makeText(
                        activity?.applicationContext ?: requireActivity().applicationContext,
                        date + text,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                negativeButton(R.string.disagree)
            }
            materialDialog.show()
        }
    }
}
