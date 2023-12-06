package org.kttots.finder

import org.reflections.Reflections
import java.io.File
import java.net.URLClassLoader
import kotlin.reflect.KClass

/**
 * Class from [github.com/jensim/kt2ts-gradle-plugin](https://github.com/jensim/kt2ts-gradle-plugin/blob/master/src/main/kotlin/se/jensim/gradle/plugin/kt2ts/internal/Kt2TsClassFinderImpl.kt)
 */
internal class ClassFinder(
    private val sourceFiles: Collection<File>
) {

    private val classLoader: ClassLoader by lazy {
        if (sourceFiles.isEmpty()) {
            throw RuntimeException("Unable to find source files")
        }
        val classesURLs = sourceFiles
            .map { it.toURI().toURL() }
            .toTypedArray()

        URLClassLoader(classesURLs)
    }

    fun getAnnotatedClasses(annotationClassRef: String): Set<KClass<*>> {
        val annotation = try {
            @Suppress("UNCHECKED_CAST")
            classLoader.loadClass(annotationClassRef) as Class<Annotation>
        } catch (e: Exception) {
            throw RuntimeException("Bad choice of annotation", e)
        }

        val reflections = Reflections(classLoader)
        return reflections.getTypesAnnotatedWith(annotation)
            .map { it.kotlin }.toSet()
    }
}
