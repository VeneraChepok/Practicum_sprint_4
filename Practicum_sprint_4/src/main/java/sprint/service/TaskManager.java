package sprint.service;



import sprint.model.Epic;
import sprint.model.Subtask;
import sprint.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TaskManager {

    private HashMap<Integer, Task> tasks;
    private HashMap<Integer, Epic> epics;
    private HashMap<Integer, Subtask> subTasks;

    private int seq = 0;

    private int generateId() {
        return ++seq;
    }

    public TaskManager() {
        this.tasks = new HashMap<>();
        this.epics = new HashMap<>();
        this.subTasks = new HashMap<>();
    }

    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    public HashMap<Integer, Epic> getEpics() {
        return epics;
    }

    public HashMap<Integer, Subtask> getSubTasks() {
        return subTasks;
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public void deleteAllTasks() {
        tasks.clear();
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public Task createTask(Task task) {
        task.setId(generateId());
        tasks.put(task.getId(), task);
        return task;
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void deleteTaskById(int id) {
        tasks.remove(id);
    }

    public List<Subtask> getAllSubTask() {
        return new ArrayList<>(subTasks.values());
    }

    public void deleteAllSubTasks() {
        subTasks.clear();
        epics.replaceAll((key, value) -> {
            value.setSubTasks(new ArrayList<>());
            value.setStatus("NEW");
            return value;
        });
    }

    public Subtask getSubTaskById(int id) {
        return subTasks.get(id);
    }

    public Subtask createSubTask(Subtask subtask) {
        subtask.setId(generateId());
        subTasks.put(subtask.getId(), subtask);
        Epic oldEpic = epics.get(subtask.getEpic().getId());
        oldEpic.addSubTask(subtask);

        return subtask;
    }

    public void updateSubTask(Subtask subtask) {
        subTasks.put(subtask.getId(), subtask);
        Epic oldEpic = epics.get(subtask.getEpic().getId());
        List<Subtask> oldSubTask = oldEpic.getSubTasks();
        oldSubTask.replaceAll(p -> p.getId() == subtask.getId() ? subtask : p);
        oldEpic.calculateEpicStatus();
    }

    public void deleteSubTaskById(int id) {
        Subtask removeSubTask = subTasks.remove(id);
        Epic oldEpic = epics.get(removeSubTask.getEpic().getId());
        List<Subtask> oldSubTask = oldEpic.getSubTasks();
        oldSubTask.removeIf(p -> p.getId() == id);
    }


    public List<Epic> getAllEpic() {
        return new ArrayList<>(epics.values());
    }

    //€ предпологаю что удал€€ большую задачу все подзадачи соответственно тоже удал€ютс€, так как больше не нужны
    public void deleteAllEpic() {
        epics.clear();
        subTasks.clear();
    }

    public Epic getEpicById(int id) {
        return epics.get(id);
    }

    public Epic createEpic(Epic epic) {
        epic.setId(generateId());
        epics.put(epic.getId(), epic);
        return epic;
    }

    public void updateEpic(Epic epic) {

        Epic saved = epics.get(epic.getId());
        saved.setName(epic.getName());
        epics.put(epic.getId(), saved);

    }

    public void deleteEpicById(int id) {

        epics.entrySet().removeIf(entry -> entry.getKey().equals(id));
        subTasks.entrySet().removeIf(entry -> entry.getValue().getEpic().getId() == id);

    }


}


