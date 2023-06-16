package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest{
    @Test
    fun getActiveAndCompletedStats_oneNotCompletedTask_returnsHundredZero(){
        //when
        val tasks = listOf<Task>(
                Task("Test", "test",  false)
        )
        //given
        val result = getActiveAndCompletedStats(tasks)
        //then
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompetedStats_oneCompletedTask_returnZeroHundred(){
        val tasks1 = listOf<Task>(
                Task("test", "test", false)
        )

        val result =  getActiveAndCompletedStats(tasks1)

        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_twoCompletedThreeActive_returnfourtysixty(){
        val tasks2 = listOf<Task>(
                Task("test", "test", true) , Task("test", "test", true), Task("test", "test", false), Task("test", "test", false), Task("test", "test", false)
        )

        val result = getActiveAndCompletedStats(tasks2)

        assertEquals(40f, result.completedTasksPercent)
        assertEquals(60f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_noTasks_returnZero(){
        val tasks3 = emptyList<Task>()

        val result = getActiveAndCompletedStats(tasks3)

        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_NullInput_Zero(){

        val result = getActiveAndCompletedStats(null)

        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }
}