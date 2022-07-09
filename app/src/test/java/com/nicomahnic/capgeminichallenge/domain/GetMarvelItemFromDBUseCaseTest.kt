package com.nicomahnic.capgeminichallenge.domain

import com.nicomahnic.capgeminichallenge.datasource.database.models.MarvelItemEntity
import com.nicomahnic.capgeminichallenge.datasource.database.models.MarvelThumbnailEntity
import com.nicomahnic.capgeminichallenge.models.MarvelItem
import com.nicomahnic.capgeminichallenge.models.MarvelThumbnail
import com.nicomahnic.capgeminichallenge.models.mapper.MarvelEntityItemMapper
import com.nicomahnic.capgeminichallenge.models.mapper.MarvelEntityThumbnailMapper
import com.nicomahnic.capgeminichallenge.repository.LocalRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetMarvelItemFromDBUseCaseTest {

    @RelaxedMockK
    private lateinit var localRepository: LocalRepository

    private lateinit var marvelEntityItemMapper: MarvelEntityItemMapper
    private lateinit var marvelEntityThumbnailMapper: MarvelEntityThumbnailMapper
    lateinit var getMarvelItemFromDBUseCase: GetMarvelItemFromDBUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        marvelEntityThumbnailMapper = MarvelEntityThumbnailMapper()
        marvelEntityItemMapper = MarvelEntityItemMapper(marvelEntityThumbnailMapper)
        getMarvelItemFromDBUseCase = GetMarvelItemFromDBUseCase(localRepository, marvelEntityItemMapper)
    }

    @Test
    fun `when VM doesnt pass any id then return null`() = runBlocking {
        //Given
        coEvery { localRepository.getMarvelItem() } returns null

        //When
        getMarvelItemFromDBUseCase()

        //Then
        assert ( marvelEntityItemMapper.mapFromEntity() == null )

    }

    @Test
    fun `when VM pass id 1 then return MarvelItem parsed`() = runBlocking {
        //Given
        val marvelThumbnailEntity = MarvelThumbnailEntity("Path", "jpg")
        val marvelItemEntity = MarvelItemEntity(1, "Test1","Test1", marvelThumbnailEntity)
        coEvery { localRepository.getMarvelItem() } returns marvelItemEntity

        //When
        getMarvelItemFromDBUseCase(1)

        //Then
        val marvelThumbnail = MarvelThumbnail("Path", "jpg")
        val marvelItem = MarvelItem(1, "Test1","Test1", marvelThumbnail)
        assert( marvelEntityItemMapper.mapFromEntity(marvelItemEntity) == marvelItem)

    }

    @Test
    fun `when VM pass id 1 then return incomplete MarvelItem parsed`() = runBlocking {
        //Given
        val marvelThumbnailEntity = MarvelThumbnailEntity("Path", "jpg")
        val marvelItemEntity = MarvelItemEntity(1, "Test1",null, marvelThumbnailEntity)
        coEvery { localRepository.getMarvelItem() } returns marvelItemEntity

        //When
        getMarvelItemFromDBUseCase(1)

        //Then
        val marvelThumbnail = MarvelThumbnail("Path", "jpg")
        val marvelItem = MarvelItem(1, "Test1",null, marvelThumbnail)
        assert( marvelEntityItemMapper.mapFromEntity(marvelItemEntity) == marvelItem)

    }

}