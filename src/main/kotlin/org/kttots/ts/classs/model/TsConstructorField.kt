package org.kttots.ts.classs.model

class TsConstructorField(
    private val name: String,
    private val type: String,
    private val privacy: String = "public"
) {

    override fun toString(): String {
        return "$privacy $name: $type"
    }
}