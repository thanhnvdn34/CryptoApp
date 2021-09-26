package com.thanhnv.cryptocurrency.domain.repository

import com.thanhnv.cryptocurrency.data.remote.CoinPaprikaApi
import com.thanhnv.cryptocurrency.data.remote.dto.CoinDTO
import com.thanhnv.cryptocurrency.data.remote.dto.CoinDetailDTO
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDTO> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDTO {
        return api.getCoinById(coinId)
    }
}