package com.nicomahnic.capgeminichallenge.domain

import com.nicomahnic.capgeminichallenge.datasource.database.models.MarvelItemEntity
import com.nicomahnic.capgeminichallenge.datasource.database.models.MarvelThumbnailEntity
import com.nicomahnic.capgeminichallenge.models.MarvelItem
import com.nicomahnic.capgeminichallenge.models.MarvelThumbnail
import com.nicomahnic.capgeminichallenge.models.mapper.MarvelEntityItemMapper
import com.nicomahnic.capgeminichallenge.models.mapper.MarvelEntityThumbnailMapper
import com.nicomahnic.capgeminichallenge.repository.LocalRepository
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class DeleteMarvelItemFromDBUseCaseTest{

    @RelaxedMockK
    private lateinit var localRepository: LocalRepository

    private lateinit var marvelEntityItemMapper: MarvelEntityItemMapper
    private lateinit var marvelEntityThumbnailMapper: MarvelEntityThumbnailMapper
    lateinit var deleteMarvelItemFromDBUseCaseTest: DeleteMarvelItemFromDBUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        marvelEntityThumbnailMapper = MarvelEntityThumbnailMapper()
        marvelEntityItemMapper = MarvelEntityItemMapper(marvelEntityThumbnailMapper)
        deleteMarvelItemFromDBUseCaseTest = DeleteMarvelItemFromDBUseCase(localRepository, marvelEntityItemMapper)
    }

    @Test
    fun `make sure that execute delete after parse is complete`() = runBlocking {
        //Given
        val marvelThumbnail = MarvelThumbnail("Path", "jpg")
        val marvelItem = MarvelItem(1, "Test1","Test1", marvelThumbnail)
        val marvelThumbnailEntity = MarvelThumbnailEntity("Path", "jpg")
        val marvelItemEntity = MarvelItemEntity(1, "Test1","Test1", marvelThumbnailEntity)

        //When
        deleteMarvelItemFromDBUseCaseTest(marvelItem)

        //Then
        coVerify { localRepository.deleteMarvelItem(marvelItemEntity) }
        assert ( marvelEntityItemMapper.mapToEntity(marvelItem) == marvelItemEntity)

    }

}