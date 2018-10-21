package com.boundless.datakicktest.testinfastructure

import com.boundless.datakicktest.common.entities.Book

class BookBuilder {

    companion object {
        val DEFAULT_ID = "id"
        val DEFAULT_NAME = "name"
        val DEFAULT_PUBLISHER = "publisher"
    }

    private var id = DEFAULT_ID
    private var name = DEFAULT_NAME
    private var publisher = DEFAULT_PUBLISHER

    fun withPublisher(publisher: String) = this.apply {
        this.publisher = publisher
    }

    fun build() = Book(
            id,
            name,
            publisher,
            "",
            0,
            ""
    )
}

fun aBookBuilder() = BookBuilder()
