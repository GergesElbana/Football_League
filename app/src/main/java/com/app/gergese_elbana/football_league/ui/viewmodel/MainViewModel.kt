package com.app.gergese_elbana.football_league.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.gergese_elbana.football_league.data.remote.model.CompetitionsResponse
import com.app.gergese_elbana.football_league.data.repository.MainRepository
import com.app.gergese_elbana.football_league.utiles.Resource
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    // mutableResponse
    private val _competitionResponse = MutableLiveData<Resource<CompetitionsResponse>>()

    //liveResponse
    val competitionResponse: LiveData<Resource<CompetitionsResponse>>
        get() = _competitionResponse

    fun getCompetition() {
        viewModelScope.launch {
         mainRepository.getCompetitions().let {
             if (it.data !=null){
            _competitionResponse.postValue(Resource.success(it.data))
             }else{
                 _competitionResponse.postValue(Resource.error("null data",null))
             }
         }
         }
        }
    }
