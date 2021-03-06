package io.armcha.ribble.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Chatikyan on 30.07.2017.
 */
class ShotResponse {

    @SerializedName("id")
    @Expose
    val id: String? = null

    @SerializedName("title")
    @Expose
    val title: String? = null

    @SerializedName("description")
    @Expose
    val description: String? = null

    @SerializedName("user")
    @Expose
    val user: UserResponse? = null

    @SerializedName("images")
    @Expose
    val image: ImageResponse? = null

    @SerializedName("likes_count")
    @Expose
    val likesCount: Int? = null

    @SerializedName("views_count")
    @Expose
    val viewsCount: Int? = null

    @SerializedName("buckets_count")
    @Expose
    val bucketsCount: Int? = null
}