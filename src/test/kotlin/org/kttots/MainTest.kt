package org.kttots

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import org.kttots.finder.ClassFinder
import org.kttots.internal.FindMe
import org.kttots.writer.FileWriter
import java.io.File
import kotlin.test.assertTrue

internal class MainTest {

    private val classPath = "org/kttots"

    @TempDir
    @JvmField
    var tempFolder: File? = null

    @Test
    fun `test global`() {
        val sourceFiles = setOf(File(classPath))
        val classFinder = ClassFinder(sourceFiles)

        val classes = classFinder.getAnnotatedClasses(FindMe::class.qualifiedName!!)

        val fileClassMap = classes.map { File(tempFolder, "${it.simpleName!!}.d.ts") to listOf(it) }.toMap()
        FileWriter().write(fileClassMap)

        fileClassMap.forEach { (file, classes) -> assertTrue(file.exists()) }
    }
}