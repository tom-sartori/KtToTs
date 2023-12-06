package org.kttots.finder

import org.kttots.internal.FindMe
import org.kttots.internal.SampleDto
import java.io.File
import kotlin.test.Test

internal class ClassFinderTest {

    private val classPath = "org/kttots"

    @Test
    fun `find annotated test class`() {
        val annotation = FindMe::class

        val sourceFiles = setOf(File(classPath))
        val finder = ClassFinder(sourceFiles)

        val expectedSet = finder.getAnnotatedClasses(annotation.qualifiedName!!)

        kotlin.test.assertSame(expectedSet.first(), SampleDto::class)
    }
}
