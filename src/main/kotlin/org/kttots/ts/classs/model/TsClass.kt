package org.kttots.ts.classs.model

internal class TsClass(
    private val name: String,
    private val constructor: TsConstructor
) {

    override fun toString(): String {
        return "export class $name {\n" +
                "${constructor.toString().prependIndent()}\n" +
                "}"
    }
}