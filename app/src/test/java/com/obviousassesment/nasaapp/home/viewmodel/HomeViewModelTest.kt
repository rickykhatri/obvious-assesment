package com.obviousassesment.nasaapp.home.viewmodel

import com.obviousassesment.nasaapp.home.repository.ImageRepository
import org.junit.Assert.assertNotNull
import org.junit.Test

class HomeViewModelTest {


    /**
     * Input values tested for:
     * fileName: test the test is getting failed
     * file: test.json the test is getting success
     */
    @Test
    fun `validate json file`() {
        assertNotNull(ImageRepository.validateJsonFile("test.json"))
    }
}