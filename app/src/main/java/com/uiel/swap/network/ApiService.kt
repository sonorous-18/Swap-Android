package com.uiel.swap.network

import com.uiel.swap.model.BikeListResponse
import com.uiel.swap.model.BuyProductListResponse
import com.uiel.swap.model.BuyProductRequest
import com.uiel.swap.model.ChallengeListResponse
import com.uiel.swap.model.FilterRequest
import com.uiel.swap.model.FilterResponse
import com.uiel.swap.model.ReviewResponse
import com.uiel.swap.model.SaveBikeRequest
import com.uiel.swap.model.SubscribeDetailResponse
import com.uiel.swap.model.SubscribeProductListResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("sub/list")
    suspend fun subscribeProductList(): List<SubscribeProductListResponse>

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

    @POST("sub/filter")
    suspend fun filter(
        @Body filterRequest: FilterRequest
    ): List<FilterResponse>
}