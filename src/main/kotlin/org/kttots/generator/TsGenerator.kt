package org.kttots.generator

import org.kttots.generator.ts.generator.TsClassGenerator
import kotlin.reflect.KClass

internal class TsGenerator {

    fun generateClass(ktClassSet: Collection<KClass<*>>): String =
        ktClassSet.joinToString(separator = "\n\n") { generateClass(it) }

    fun generateClass(ktClass: KClass<*>): String =
        TsClassGenerator(ktClass).generate()
}