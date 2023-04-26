package com.coldwised.swipepix.data.repository

import com.coldwised.swipepix.R
import com.coldwised.swipepix.data.remote.ShopServiceApi
import com.coldwised.swipepix.data.remote.dto.CategoryDto
import com.coldwised.swipepix.domain.repository.ShopRepository
import com.coldwised.swipepix.util.Resource
import com.coldwised.swipepix.util.UiText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor(
    private val shopApi: ShopServiceApi
): ShopRepository {
    override fun getCatalogCategories(): Flow<Resource<List<CategoryDto>>> {
        return flow {
            emit(
                safeApiCall {
                    shopApi.getCatalogCategories()
                }
            )
        }
    }

    private inline fun <T> safeApiCall(apiCall: () -> T): Resource<T> {
        return try {
            val data = apiCall()
            Resource.Success(data = data)
        } catch(throwable: Throwable) {
            Resource.Error(handleThrowableException(throwable))
        }
    }

    private fun handleThrowableException(throwable: Throwable): UiText {
        return when(throwable) {
            is HttpException -> {
                val localizedMessage = throwable.localizedMessage
                if(localizedMessage.isNullOrEmpty()) {
                    UiText.StringResource(R.string.unknown_exception)
                }
                else {
                    UiText.DynamicString(localizedMessage)
                }
            }
            is IOException -> {
                UiText.StringResource(R.string.io_exception)
            }
            else -> UiText.StringResource(R.string.unknown_exception)
        }
    }

}