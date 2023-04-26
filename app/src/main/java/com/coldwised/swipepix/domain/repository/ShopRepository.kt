package com.coldwised.swipepix.domain.repository

import com.coldwised.swipepix.data.remote.dto.CategoryDto
import com.coldwised.swipepix.util.Resource
import kotlinx.coroutines.flow.Flow

interface ShopRepository {
    fun getCatalogCategories(): Flow<Resource<List<CategoryDto>>>
}