package sample;

import java.util.ArrayDeque;

public class Operations {
    private StringBuilder oldTasks;
    private ArrayDeque<String> tasksQue;

    public Operations(){
        this.oldTasks =  new StringBuilder();
        this.tasksQue = new ArrayDeque<String>();
    }

    public void addTask(String text){
//        if( !(text.equals("Brak zadań"))&&!(text.equals("Brak historii!"))&&!(text.equals("Zadanie jest puste!")) ) {
//            if(!tasksQue.peek().equals(text)) {
//                tasksQue.add(text);
//            }
//        }
        if(text!=null)
            tasksQue.add(text);
    }

    public String getTask(){
        if(tasksQue.peek()!=null) {
            return tasksQue.peek();
        }else return "Brak zadań";
    }

    public String taskComplete(String text){
        if (tasksQue.peek()!=null) {
            oldTasks.append(tasksQue.poll() + " -> Wykonano.\n");
            return "";
        }else return text;
    }

    public String taskFailed(String text){
        if(tasksQue.peek()!=null) {
            oldTasks.append(tasksQue.poll() + " -> Nie wykonano.\n");
            return "";
        }else return text;
    }

    public String getTasksHisotry(){
        if(!oldTasks.toString().equals(""))
            return oldTasks.toString();
        else return "Brak historii!";
    }
}