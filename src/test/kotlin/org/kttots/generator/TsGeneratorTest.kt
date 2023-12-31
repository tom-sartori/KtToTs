package org.kttots.generator

import org.kttots.internal.SampleDto
import kotlin.test.Test
import kotlin.test.assertEquals

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