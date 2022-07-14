package br.com.kotlin.forum.domain.curso

interface CourseService {

    fun getCourses(): List<Course>
    fun getCourseById(id: Long): Course

}