package org.kttots.internal

import java.util.*
import kotlin.properties.Delegates

internal annotation class FindMe

@FindMe
internal class SampleDto {
    lateinit var name: String
    lateinit var description: Date
    var age by Delegates.notNull<Int>()
}
