package sprint;


import sprint.model.Epic;
import sprint.model.Subtask;
import sprint.model.Task;
import sprint.service.TaskManager;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Task task = taskManager.createTask(new Task("Task1", "NEW", "descriptionTask1"));
        Task task2 = taskManager.createTask(new Task("Task2", "NEW", "descriptionTask2"));

//        System.out.println("HashMap tasks after create task: " + taskManager.getTasks());

        Task taskFromManager = taskManager.getTaskById(task.getId());
//        System.out.println("Get task: " + taskFromManager);
//        System.out.println("Get All tasks: " + taskManager.getAllTasks());

        taskFromManager.setName("UpdateTask");
        taskManager.updateTask(taskFromManager);
//        System.out.println("HashMap tasks after update task: " + taskManager.getTasks());

        taskManager.deleteTaskById(taskFromManager.getId());
//        System.out.println("HashMap tasks after deleteTaskById: " + taskManager.getTasks());

        taskManager.deleteAllTasks();
//        System.out.println("HashMap tasks after deleteAllTask: " + taskManager.getTasks());


        Epic epic1 = taskManager.createEpic(new Epic("Epic1", "New", "описаниеEpic1"));
        Epic epic2 = taskManager.createEpic(new Epic("Epic2", "New", "описаниеEpic2"));
//        System.out.println("HashMap epics after create epic: " + taskManager.getEpics());

        Subtask subtask1 = taskManager.createSubTask(new Subtask("Подзадача1", "NEW", "описание1", epic1));
        Subtask subtask2 = taskManager.createSubTask(new Subtask("Подзадача2", "NEW", "описание2", epic1));
        Subtask subtask3 = taskManager.createSubTask(new Subtask("Подзадача3", "NEW", "описание3", epic2));
        Subtask subtask4 = taskManager.createSubTask(new Subtask("Подзадача4", "NEW", "описание4", epic2));
//        taskManager.getEpics().forEach((key, value) -> System.out.println("HashMap epics: " + value.getName() + ", значение subtask : " + value.getAllSubTasksByName()));
//        taskManager.getSubTasks().forEach((key, value) -> System.out.println("HashMap subTasks: " + value.getName() + ", значение полей epic : " + value.getEpic().getName()));


//        System.out.println("HashMap epics getAllEpic: " + taskManager.getAllEpic());
//        System.out.println("HashMap epics getEpicById: " + taskManager.getEpicById(epic1.getId()));

//        System.out.println("HashMap supTasks getSubTasks: " + taskManager.getSubTasks());
//        System.out.println("HashMap epics getSubTaskById: " + taskManager.getSubTaskById(subtask4.getId()));

        Epic epicUpdate = taskManager.getEpicById(epic1.getId());
        epicUpdate.setName("Big_Epic1");
        taskManager.updateEpic(epicUpdate);
//        System.out.println("Epic after update: " + taskManager.getEpicById(epic1.getId()));
//        taskManager.getSubTasks().forEach((key, value) -> System.out.println("HashMap subTasks: " + value.getName() + ", значение полей epic : " + value.getEpic().getName()));


        Subtask subtaskById = taskManager.getSubTaskById(subtask4.getId());
        subtaskById.setStatus("DONE");
        taskManager.updateSubTask(subtaskById);
//        System.out.println("HashMap subTask after update: " + taskManager.getSubTaskById(subtask4.getId()));
//        System.out.println("Status epic after update subtask: " + taskManager.getEpicById(epic2.getId()));


        taskManager.deleteSubTaskById(subtask3.getId());
//        System.out.println("HashMap subTask3 after deleteSubTaskById: " + taskManager.getSubTaskById(subtask3.getId()));
//        System.out.println("Epic after update subtask deleteSubTaskById: " + taskManager.getEpicById(epic2.getId()));


        taskManager.deleteAllSubTasks();
//        System.out.println("HashMap subTask after deleteAllSubTask: " + taskManager.getSubTasks());
//        System.out.println("Epic after deleteAllSubTask subtask: " + taskManager.getEpics());


        taskManager.deleteEpicById(epic1.getId());
//        System.out.println("HashMap epics after deleteEpicById: " + taskManager.getEpics());
//        System.out.println("HashMap subTasks after deleteEpicById: " + taskManager.getSubTasks());


        taskManager.deleteAllEpic();
//        System.out.println("HashMap epics after deleteAllEpic: " + taskManager.getEpics());
//        System.out.println("HashMap subTasks after deleteAllEpic: " + taskManager.getSubTasks());


    }
}