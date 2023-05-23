package com.coldwised.swipepix.domain.use_case

import com.coldwised.swipepix.data.remote.dto.ProductDto
import com.coldwised.swipepix.domain.repository.ShopRepository
import com.coldwised.swipepix.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val repository: ShopRepository,
) {

    operator fun invoke(): Flow<Resource<List<ProductDto>>> {
        return repository.getFavoritesProducts()
    }
}