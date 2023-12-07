package org.kttots.writer

import org.junit.jupiter.api.io.TempDir
import org.kttots.internal.SampleDto
import java.io.File
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class FileWriterTest {

    @TempDir
    @JvmField
    var tempFolder: File? = null

    @Test
    fun `write typescript to file`() {
        val destinationFile = File(tempFolder, "output.d.ts")
        val classes = setOf(SampleDto::class)
        assertFalse(destinationFile.exists())

        FileWriter().write(mapOf(destinationFile to classes))

        assertTrue(destinationFile.exists())
    }
}