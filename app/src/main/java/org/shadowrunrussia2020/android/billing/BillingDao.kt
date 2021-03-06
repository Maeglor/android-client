package org.shadowrunrussia2020.android.billing

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.shadowrunrussia2020.android.billing.models.AccountOverview
import org.shadowrunrussia2020.android.billing.models.Transaction

@Dao
interface BillingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTransactions(transactions: List<Transaction>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setAccountOverview(overview: AccountOverview)

    @Query("SELECT * FROM `Transaction` ORDER BY created_at DESC")
    fun history(): LiveData<List<Transaction>>

    @Query("SELECT * FROM `AccountOverview`")
    fun accountOverview(): LiveData<AccountOverview>
}