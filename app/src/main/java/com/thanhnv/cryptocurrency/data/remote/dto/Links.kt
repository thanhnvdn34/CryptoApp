package com.thanhnv.cryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("explorer")
    val explorer: List<Any>,
    @SerializedName("facebook")
    val facebook: List<Any>,
    @SerializedName("medium")
    val medium: Any,
    @SerializedName("reddit")
    val reddit: List<Any>,
    @SerializedName("source_code")
    val sourceCode: List<Any>,
    @SerializedName("website")
    val website: List<Any>,
    @SerializedName("youtube")
    val youtube: List<Any>
)