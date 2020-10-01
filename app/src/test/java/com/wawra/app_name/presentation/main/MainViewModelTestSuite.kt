package com.wawra.app_name.presentation.main

import com.wawra.app_name.BaseTestSuite
import com.wawra.app_name.R
import com.wawra.app_name.database.entities.Model
import com.wawra.app_name.logic.ModelRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MainViewModelTestSuite : BaseTestSuite() {

    private lateinit var modelRepositoryMock: ModelRepository
    private lateinit var objectUnderTest: MainViewModel

    @Before
    fun prepare() {
        modelRepositoryMock = mockk()
        objectUnderTest = MainViewModel(modelRepositoryMock)
    }

    @After
    fun cleanUp() {
        objectUnderTest.cancelActions()
    }

    @Test
    fun shouldGetModels() {
        // given
        val models = listOf(
            Model(1L),
            Model(2L)
        )
        // when
        every { modelRepositoryMock.getModelsFromDb() } returns Single.just(models)
        objectUnderTest.getModels()
        // then
        verify { modelRepositoryMock.getModelsFromDb() }
        val result = objectUnderTest.models.value
        val error = objectUnderTest.error.value
        assertNull(error)
        assertNotNull(result)
        result!!
        assertEquals(2, result.size)
        assertEquals(1L, result[0].modelId)
        assertEquals(2L, result[1].modelId)
    }

    @Test
    fun shouldNotGetModels() {
        // when
        every { modelRepositoryMock.getModelsFromDb() } returns Single.error(Exception())
        objectUnderTest.getModels()
        // then
        verify { modelRepositoryMock.getModelsFromDb() }
        val result = objectUnderTest.models.value
        val error = objectUnderTest.error.value
        assertNull(result)
        assertNotNull(error)
        assertEquals(R.string.unknown_error, error)
    }

}