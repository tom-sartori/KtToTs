package org.kttots.generator.ts.model

internal class TsConstructorField(
    private val name: String,
    private val type: String,
    private val privacy: String = "public"
) {

    override fun toString(): String {
        return "$privacy $name: $type"
    }
}