package com.thanhnv.cryptocurrency.domain.use_case.get_coin

import com.thanhnv.cryptocurrency.common.Resource
import com.thanhnv.cryptocurrency.data.remote.dto.toCoinDetail
import com.thanhnv.cryptocurrency.domain.model.CoinDetail
import com.thanhnv.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coins = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Could reach server. Check your connection pls. "))
        }
    }


}