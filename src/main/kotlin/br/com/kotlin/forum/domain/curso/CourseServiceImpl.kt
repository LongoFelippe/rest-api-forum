package br.com.kotlin.forum.domain.curso

import br.com.kotlin.forum.application.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class CourseServiceImpl : CourseService {

    private val courses = buildCourses()

    private fun buildCourses(): List<Course> {
        return mutableListOf(
            Course(
                id = 1,
                name = "Kotlin Course",
                category = "Programming"
            ),
            Course(
                id = 2,
                name = "Java Course",
                category = "Programming"
            )
        )
    }

    override fun getCourses(): List<Course> {
        return courses
    }

    override fun getCourseById(id: Long): Course {
        return courses.stream()
            .filter { course -> course.id == id }
            .findFirst()
            .orElseThrow { NotFoundException("Curso não encontrado") }
    }

}