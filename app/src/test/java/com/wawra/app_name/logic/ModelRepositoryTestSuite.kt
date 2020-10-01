package com.wawra.app_name.logic

import com.wawra.app_name.BaseTestSuite
import com.wawra.app_name.database.daos.ModelDao
import com.wawra.app_name.database.entities.Model
import com.wawra.app_name.network.ApiInterface
import com.wawra.app_name.network.models.ModelResponse
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ModelRepositoryTestSuite : BaseTestSuite() {

    private lateinit var modelDaoMock: ModelDao
    private lateinit var apiMock: ApiInterface

    private lateinit var objectUnderTest: ModelRepository

    @Before
    fun init() {
        modelDaoMock = mockk()
        apiMock = mockk()
        objectUnderTest = ModelRepository(modelDaoMock, apiMock)
    }

    @Test
    fun shouldGetModelsFromDb() {
        // given
        val models = listOf(
            Model(1L),
            Model(2L)
        )
        // when
        every { modelDaoMock.getAll() } returns Single.just(models)
        val result = objectUnderTest.getModelsFromDb().blockingGet()
        // then
        verify { modelDaoMock.getAll() }
        assertEquals(2, result.size)
        assertEquals(1L, result[0].modelId)
        assertEquals(2L, result[1].modelId)
    }

    @Test
    fun shouldGetModelsFromApi() {
        // given
        val models = listOf(
            ModelResponse(1L),
            ModelResponse(2L)
        )
        // when
        every { apiMock.getModels() } returns Single.just(models)
        val result = objectUnderTest.getModelsFromApi().blockingGet()
        // then
        verify { apiMock.getModels() }
        assertEquals(2, result.size)
        assertEquals(1L, result[0].modelId)
        assertEquals(2L, result[1].modelId)
    }

}