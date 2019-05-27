package org.shadowrunrussia2020.android

import kotlinx.coroutines.Deferred
import org.shadowrunrussia2020.android.models.billing.AccountInfo
import org.shadowrunrussia2020.android.models.billing.Empty
import org.shadowrunrussia2020.android.models.billing.Transfer
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface BillingWebService {
    @POST("transfer")
    fun transfer(@Body request: Transfer): Deferred<Response<Empty>>

    @GET("account_info")
    fun accountInfo(): Deferred<Response<AccountInfo>>
}


