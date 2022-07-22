package com.nicomahnic.capgeminichallenge.domain

import com.nicomahnic.capgeminichallenge.data.datasource.database.models.MarvelItemEntity
import com.nicomahnic.capgeminichallenge.data.datasource.database.models.MarvelThumbnailEntity
import com.nicomahnic.capgeminichallenge.domain.models.MarvelItem
import com.nicomahnic.capgeminichallenge.domain.models.MarvelThumbnail
import com.nicomahnic.capgeminichallenge.domain.models.mapper.MarvelEntityItemMapper
import com.nicomahnic.capgeminichallenge.domain.models.mapper.MarvelEntityThumbnailMapper
import com.nicomahnic.capgeminichallenge.data.repository.MarvelItemsRepositoryImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetMarvelItemFromDBUseCaseTest {

    @RelaxedMockK
    private lateinit var marvelItemsRepository: MarvelItemsRepositoryImpl

    private lateinit var marvelEntityItemMapper: MarvelEntityItemMapper
    private lateinit var marvelEntityThumbnailMapper: MarvelEntityThumbnailMapper
    lateinit var getMarvelItemFromDBUseCase: GetMarvelItemFromDBUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        marvelEntityThumbnailMapper = MarvelEntityThumbnailMapper()
        marvelEntityItemMapper = MarvelEntityItemMapper(marvelEntityThumbnailMapper)
        getMarvelItemFromDBUseCase = GetMarvelItemFromDBUseCase(marvelItemsRepository, marvelEntityItemMapper)
    }

    @Test
    fun `when VM doesnt pass any id then return null`() = runBlocking {
        //Given
        coEvery { marvelItemsRepository.getMarvelItem() } returns null

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
        coEvery { marvelItemsRepository.getMarvelItem() } returns marvelItemEntity

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
        coEvery { marvelItemsRepository.getMarvelItem() } returns marvelItemEntity

        //When
        getMarvelItemFromDBUseCase(1)

        //Then
        val marvelThumbnail = MarvelThumbnail("Path", "jpg")
        val marvelItem = MarvelItem(1, "Test1",null, marvelThumbnail)
        assert( marvelEntityItemMapper.mapFromEntity(marvelItemEntity) == marvelItem)

    }

}