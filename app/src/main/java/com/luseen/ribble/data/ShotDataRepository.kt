package com.luseen.ribble.data

import com.luseen.ribble.data.mapper.ShotMapper
import com.luseen.ribble.data.pref.Preferences
import com.luseen.ribble.data.repository.data_store.ShotDataStore
import com.luseen.ribble.data.repository.factory.ShotDataStoreFactory
import com.luseen.ribble.domain.repository.ShotRepository
import com.luseen.ribble.presentation.model.Like
import com.luseen.ribble.presentation.model.Shot
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Chatikyan on 02.08.2017.
 */
@Singleton
class ShotDataRepository @Inject constructor(private var shotDataStoreFactory: ShotDataStoreFactory,
                                             private var preferences: Preferences,
                                             private var mapper: ShotMapper) : ShotRepository {

    override fun getShotList(shotType: String, count: Int): Flowable<List<Shot>> {
        val shotDataStore: ShotDataStore = shotDataStoreFactory.create()
        return shotDataStore.getShotList(shotType, count).map { mapper.translate(it) }
    }

    override fun getShotLikes(shotId: String): Flowable<List<Like>> {
        val shotDataStore: ShotDataStore = shotDataStoreFactory.createApiDataStore()
        return shotDataStore.getShotLikes(shotId).map { mapper.translate(it) }
    }

    override fun getSomeDataFromPref(): Boolean {
        return preferences.getSomeBool()
    }
}