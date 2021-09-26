package com.thanhnv.cryptocurrency.domain.repository

import com.thanhnv.cryptocurrency.data.remote.dto.CoinDTO
import com.thanhnv.cryptocurrency.data.remote.dto.CoinDetailDTO

interface CoinRepository {
    suspend fun getCoins(): List<CoinDTO>
    suspend fun getCoinById(coinId:String): CoinDetailDTO
}