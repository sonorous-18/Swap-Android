package com.uiel.swap.network

import com.uiel.swap.model.BikeListResponse
import com.uiel.swap.model.BuyProductListResponse
import com.uiel.swap.model.BuyProductRequest
import com.uiel.swap.model.ChallengeListResponse
import com.uiel.swap.model.Color
import com.uiel.swap.model.Emphysema
import com.uiel.swap.model.ReviewResponse
import com.uiel.swap.model.SaveBikeRequest
import com.uiel.swap.model.SubscribeDetailResponse
import com.uiel.swap.model.SubscribeProductListResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("sub/list")
    suspend fun subscribeProductList(
        @Query("colors") colors: String?,
        @Query("startMoney") startMoney: Int?,
        @Query("endMoney") endMoney: Int?,
        @Query("spaces") spaces: String?,
    ): List<SubscribeProductListResponse>

    @GET("sub/detail/{id}")
    suspend fun subscribeDetail(
        @Path("id") id: Long,
    ): SubscribeDetailResponse

    @GET("challenge/list")
    suspend fun challengeList(): List<ChallengeListResponse>

    @POST("buy")
    suspend fun buyProduct(
        @Body buyProductRequest: BuyProductRequest,
    )

    @GET("buy")
    suspend fun buyProductList(): List<BuyProductListResponse>

    @POST("bike/save")
    suspend fun saveBike(
        @Body saveBikeRequest: SaveBikeRequest
    )

    @GET("bike/list")
    suspend fun bikeList(): List<BikeListResponse>

    @GET("sub/review/{id}")
    suspend fun review(
        @Path("id") id: Long,
    ): List<ReviewResponse>
}