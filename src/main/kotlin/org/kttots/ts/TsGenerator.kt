package org.kttots.ts

import org.kttots.ts.classs.generator.TsClassGenerator
import kotlin.reflect.KClass

internal class TsGenerator {

    fun generateClass(ktClass: KClass<*>): String =
        TsClassGenerator(ktClass).generate()
}