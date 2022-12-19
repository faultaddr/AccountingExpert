package com.faultaddr.accountingexpert.ui.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faultaddr.accountingexpert.ui.home.model.DetailListContent

class HomeDetailViewModel: ViewModel() {
    var arrayList = ArrayList<DetailListContent>()
    private var _data = MutableLiveData<ArrayList<DetailListContent>>()

    public fun getDetailInfoLiveData(): MutableLiveData<ArrayList<DetailListContent>> {
        return _data
    }

    public fun init() {
        _data.value = arrayList
    }

    public fun addRecord(record: DetailListContent) {
        arrayList.add(record)
    }

    public fun insertIndexedRecord(record: DetailListContent, index:Int){
        arrayList.add(index, record)
    }

    public fun removeRecord(record: DetailListContent) {
        arrayList.remove(record)
    }

    public fun removeIndexedRecord(index: Int) {
        arrayList.removeAt(index)
    }

    public fun removeAll() {
        arrayList.clear()
    }
}