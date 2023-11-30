package org.kttots.ts

import SampleDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TsGeneratorTest {

    @Test
    fun `should generate class with constructor`() {
        val generator = TsGenerator()
        val expected = """
            export class SampleDto {
                constructor(
                    public name: string,
                    public description: Date,
                    public age: number
                ) {
                }
            }
        """.trimIndent()

        assertEquals(expected, generator.generateClass(SampleDto::class))
    }
}