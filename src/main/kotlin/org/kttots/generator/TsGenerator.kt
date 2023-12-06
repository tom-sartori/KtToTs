package org.kttots.generator

import org.kttots.generator.ts.generator.TsClassGenerator
import kotlin.reflect.KClass

internal class TsGenerator {

    fun generateClass(ktClass: KClass<*>): String =
        TsClassGenerator(ktClass).generate()
}