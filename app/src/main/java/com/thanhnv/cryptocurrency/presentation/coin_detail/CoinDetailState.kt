package com.thanhnv.cryptocurrency.presentation.coin_detail

import com.thanhnv.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
