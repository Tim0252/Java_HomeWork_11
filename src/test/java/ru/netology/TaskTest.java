package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void simpleTaskTest() {
        SimpleTask task = new SimpleTask(111, "Позвонить Домой");
        boolean expected = true;
        boolean actual = task.matches("Позвонить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notSimpleTaskTest() {
        SimpleTask task = new SimpleTask(112, "Позвонить Домой");
        boolean expected = false;
        boolean actual = task.matches("Отправить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicTaskTest() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(13, subtasks);
        boolean expected = true;
        boolean actual = epic.matches("Хлеб");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notEpicTaskTest() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(31, subtasks);
        boolean expected = false;
        boolean actual = epic.matches("Конфеты");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingTaskTest() {
        Meeting meeting = new Meeting(
                333,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingTaskProjectTest() {
        Meeting meeting = new Meeting(
                444,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Приложение");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notMeetingTaskTest() {
        Meeting meeting = new Meeting(
                222,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = false;
        boolean actual = meeting.matches("Отправить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void simpleTaskGetTitleTest() {
        SimpleTask task = new SimpleTask(111, "Позвонить Домой");
        String expected = "Позвонить Домой";
        String actual = task.getTitle();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TaskGetSubtasksTest() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(111, subtasks);
        String[] expected = {"Молоко", "Яйца", "Хлеб"};
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TaskGetTopicTest() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String expected = "Выкатка 3й версии приложения";
        String actual = meeting.getTopic();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TaskGetProjectTest() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String expected = "Приложение НетоБанка";
        String actual = meeting.getProject();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TaskGetStartTest() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String expected = "Во вторник после обеда";
        String actual = meeting.getStart();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TaskGetIdTest() {
        Task id = new Task(15);
        int expected = 15;
        int actual = id.getId();
        Assertions.assertEquals(expected, actual);
    }



}
