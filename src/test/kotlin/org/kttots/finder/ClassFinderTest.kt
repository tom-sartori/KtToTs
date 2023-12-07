package org.kttots.finder

import org.kttots.internal.FindMe
import org.kttots.internal.SampleDto
import java.io.File
import kotlin.test.Test
import kotlin.test.assertSame

internal class ClassFinderTest {

    private val classPath = "org/kttots"

    @Test
    fun `find annotated test class`() {
        val annotation = FindMe::class

        val sourceFiles = setOf(File(classPath))
        val finder = ClassFinder(sourceFiles)

        val expectedSet = finder.getAnnotatedClasses(annotation.qualifiedName!!)

        assertSame(expectedSet.first(), SampleDto::class)
    }
}
