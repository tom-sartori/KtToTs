package org.kttots.writer

import org.kttots.generator.TsGenerator
import java.io.File
import kotlin.reflect.KClass

internal class FileWriter {

    fun write(classes: Map<File, Collection<KClass<*>>>) {
        classes.forEach { (t, u) -> write(t, u) }
    }

    private fun write(destinationFile: File, classes: Collection<KClass<*>>) {
        val ts = TsGenerator().generateClass(classes)

        val dir = destinationFile.parentFile
        dir.mkdirs()
        destinationFile.writeText(ts)
    }
}