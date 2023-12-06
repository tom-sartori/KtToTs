package org.kttots.generator.ts.generator

import java.util.*
import kotlin.properties.Delegates

class TestDto {
    lateinit var name: String
    lateinit var description: Date
    var age by Delegates.notNull<Int>()
}