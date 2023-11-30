package org.kttots.ts.classs.generator

import org.kttots.ts.classs.model.TsClass
import org.kttots.ts.classs.model.TsConstructor
import org.kttots.ts.classs.model.TsConstructorField
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.full.memberProperties

class TsClassGenerator<T : Any>(
    private val ktClass: KClass<T>
) {

    fun generate(): String {
        return ktClass.simpleName?.let {
            return@let TsClass(it, TsConstructor(getConstructorFields()))
        }.toString()
    }

    private fun getType(property: KProperty<*>): String {
        val type = property.returnType.toString().split(".").last()

        return when (type) {
            "String" -> "string"
            "Int" -> "number"
            "Date" -> "Date"
            else -> "any"
        }
    }

    private fun getConstructorFields(): List<TsConstructorField> =
        ktClass.memberProperties.reversed().map { TsConstructorField(it.name, getType(it)) }
}