package org.kttots.ts.classs.model

internal class TsConstructor(
    private val fields: List<TsConstructorField>
) {

    override fun toString(): String {
        return "constructor(\n" +
                "${fields.joinToString(",\n").prependIndent()}\n" +
                ") {\n" +
                "}"
    }
}