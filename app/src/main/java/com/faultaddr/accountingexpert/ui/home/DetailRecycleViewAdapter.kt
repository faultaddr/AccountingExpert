package com.faultaddr.accountingexpert.ui.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.faultaddr.accountingexpert.R
import com.faultaddr.accountingexpert.ui.home.model.DetailListContent

class DetailRecycleViewAdapter(val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TAG :String = "DetailRecycleViewAdapter:"
    private var detailInfoList: ArrayList<DetailListContent> = ArrayList()

    /**
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
     * an item.
     *
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     *
     *
     * The new ViewHolder will be used to display items of the adapter using
     * [.onBindViewHolder]. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary [View.findViewById] calls.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new ViewHolder that holds a View of the given view type.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.i(TAG, "onCreateViewHolder")
        val root = LayoutInflater.from(parent.context).inflate(R.layout.fragment_home_detail_info_list_item, null)
        return RecyclerViewHolder(root)

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        Log.i(TAG, "getItemCount: " + detailInfoList.size )
        return detailInfoList.size
    }

    fun updateDetailInfoList(list: List<DetailListContent>) {
        Log.i(TAG, "updateDetailInfoList")
        this.detailInfoList.clear()
        this.detailInfoList.addAll(list)
        this.notifyDataSetChanged()

    }
    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     *
     * Note that unlike [android.widget.ListView], RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
     * have the updated adapter position.
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder")
        val content :DetailListContent = detailInfoList[position]
        val viewHolder:RecyclerViewHolder = holder as RecyclerViewHolder;
        // find image by category name
        viewHolder.categoryImage.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_dashboard_black_24dp))
        viewHolder.categoryText.text = content.category
        viewHolder.itemAccount.text = content.account
        viewHolder.itemSummary.text = content.sumCount.toString()
    }
    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var categoryImage: ImageView = itemView.findViewById(R.id.item_category_iv)
        var categoryText: TextView = itemView.findViewById(R.id.item_category_tv)
        var itemSummary:TextView = itemView.findViewById(R.id.item_category_sum)
        var itemAccount: TextView = itemView.findViewById(R.id.item_category_account)
    }
}