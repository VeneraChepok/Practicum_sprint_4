package sprint.model;

public class Subtask extends Task {
    private Epic epic;


    public Subtask(String name, String status, String description, Epic epic) {
        super(name, status, description);
        this.epic = epic;
    }

    @Override
    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }
    
}
