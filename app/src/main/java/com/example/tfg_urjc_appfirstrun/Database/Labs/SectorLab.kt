package com.example.tfg_urjc_appfirstrun.Database.Labs

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import com.example.tfg_urjc_appfirstrun.DAO.SectorDao
import com.example.tfg_urjc_appfirstrun.Database.TrainingDatabase
import com.example.tfg_urjc_appfirstrun.Entities.Sector

class SectorLab private constructor(context: Context?) {
    private val mSectorDao: SectorDao?
    fun getSector(): MutableList<Sector?>? {
        return mSectorDao?.getAll()
    }

    fun getSectorById(id: String?): Sector? {
        return mSectorDao?.getById(id)
    }

    fun addSector(sector: Sector?) {
        mSectorDao?.insertAll(sector)
    }

    /*public void updateTraining(Training training) {
        mNotaDao.updateNota(training);
    }*/
    fun deleteSector(sector: Sector?) {
        mSectorDao?.delete(sector)
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var sSectorLab: SectorLab? = null
        operator fun get(context: Context?): SectorLab? {
            if (sSectorLab == null) {
                sSectorLab = SectorLab(context)
            }
            return sSectorLab
        }
    }

    init {
        val appContext = context?.getApplicationContext()
        val db = appContext?.let {
            Room.databaseBuilder(it,
                TrainingDatabase::class.java, "tfg_database").build()
        }
        mSectorDao = db?.sectorDao()
    }
}