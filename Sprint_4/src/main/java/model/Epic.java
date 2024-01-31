package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Epic extends Task {
    private List<Subtask> subTasks=new ArrayList<>();
    private List<String> subTasksName=new ArrayList<>();

    public Epic(String name, String status, String description) {
        super(name, status, description);
    }

    public List<Subtask> getSubTasks() {
        return subTasks;
    }
    public List<String> getAllSubTasksByName(){
        subTasksName = subTasks.stream()
                .map(Subtask::getName)
                .collect(Collectors.toCollection(ArrayList::new));
        return subTasksName;
    }

    public void setSubTasks(List<Subtask> subTasks) {
        this.subTasks = subTasks;
    }

    public void addSubTask(Subtask subtask) {
        subTasks.add(subtask);
    }

    public void removeSubTask(Subtask subtask) {
        subTasks.remove(subtask);
    }
    public void calculateEpicStatus(){
        if (subTasks.stream()
                .allMatch(p -> p.getStatus().equals("NEW")) || subTasks.isEmpty()){
            super.setStatus("NEW");
        }else if (subTasks.stream()
                .allMatch(p -> p.getStatus().equals("DONE"))) {
            super.setStatus("DONE");
        }else {
            super.setStatus("IN_PROGRESS");
        }

    }

    @Override
    public String toString() {
        return super.toString()+" Epic{" +
                "subTasks=" + subTasks +
                '}'+"\n";
    }
}
