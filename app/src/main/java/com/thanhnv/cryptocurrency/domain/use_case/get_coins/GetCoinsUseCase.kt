package com.thanhnv.cryptocurrency.domain.use_case.get_coins

import com.thanhnv.cryptocurrency.common.Resource
import com.thanhnv.cryptocurrency.data.remote.dto.toCoin
import com.thanhnv.cryptocurrency.domain.model.Coin
import com.thanhnv.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coin = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Could reach server. Check your connection pls. "))
        }
    }


}