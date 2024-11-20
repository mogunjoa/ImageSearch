package com.mogun.mediasearchapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mogun.mediasearchapp.model.ImageItem
import com.mogun.mediasearchapp.model.ListItem
import com.mogun.mediasearchapp.model.VideoItem
import com.mogun.mediasearchapp.repository.SearchRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable

class SearchViewModel(private val searchRepository: SearchRepository): ViewModel() {

    private val _listLiveData = MutableLiveData<List<ListItem>>()
    val listLiveData: MutableLiveData<List<ListItem>>
        get() = _listLiveData

    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading: MutableLiveData<Boolean>
        get() = _showLoading

    private var disposable: CompositeDisposable? = CompositeDisposable()

    fun search(query: String) {
        disposable?.add(searchRepository.search(query)
            .doOnSubscribe { _showLoading.value = true }
            .doOnTerminate { _showLoading.value = false }
            .subscribe ({ list ->
                list.let { _listLiveData.value = it }
            },  {
                _listLiveData.value = emptyList()
            })
        )
    }

    fun toggleFavorite(item: ListItem) {
        _listLiveData.value = _listLiveData.value?.map {
            if (it == item) {
                when(it) {
                    is ImageItem -> it.copy(isFavorite = !it.isFavorite)
                    is VideoItem -> it.copy(isFavorite = !it.isFavorite)
                    else -> it
                }.also {
                    if(Common.favoriteList.contains(item)) {
                        Common.favoriteList.remove(item)
                    } else {
                        Common.favoriteList.add(it)
                    }
                }
            } else {
                it
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
        disposable = null
    }

    class SearchViewModelFactory(private val searchRepository: SearchRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SearchViewModel(searchRepository) as T
        }
    }
}